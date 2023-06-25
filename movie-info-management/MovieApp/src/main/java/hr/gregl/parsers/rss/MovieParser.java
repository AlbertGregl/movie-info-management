/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.gregl.parsers.rss;

import hr.gregl.dal.MovieRepository;
import hr.gregl.dal.RepositoryFactory;
import hr.gregl.factory.UrlConnectionFactory;
import hr.gregl.model.Movie;
import hr.gregl.parsers.rss.model.MovieRss;
import hr.gregl.parsers.rss.model.MoviesRss;
import hr.gregl.utilities.JAXBUtils;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import javax.xml.bind.JAXBException;

/**
 *
 * @author albert
 */
public class MovieParser {

    private static final String RSS_URL = "https://www.blitz-cinestar-bh.ba/rss.aspx?id=2682";
    private MovieRepository movieRepository;

    public MovieParser() {
        this.movieRepository = RepositoryFactory.getMovieRepository();
    }

    public void parseAndSaveDataFromRSS() throws JAXBException, IOException {
        HttpURLConnection con = UrlConnectionFactory.getHttpUrlConnection(RSS_URL);
        try {
            // Read XML from the connection
            MoviesRss moviesRss = (MoviesRss) JAXBUtils.load(MoviesRss.class, con.getInputStream());

            // Get the list of movies from the channel
            List<MovieRss> movies = moviesRss.getChannel().getMovies();

            // Process each movie
            for (MovieRss movieRss : movies) {
                Movie movie = new Movie();
                movie.setTitle(movieRss.getTitle());
                movie.setGenre(movieRss.getGenre());
                movie.setReleaseYear(movieRss.getReleaseYear());
                movie.setImagePath(movieRss.getImagePath());

                // Save the movie to the repository
                //movieRepository.add(movie);
                System.out.println(movie); //debug mode
            }
        } finally {
            con.disconnect();
        }
    }
}
