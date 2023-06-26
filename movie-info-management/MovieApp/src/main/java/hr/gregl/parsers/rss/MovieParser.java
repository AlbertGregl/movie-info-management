/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.gregl.parsers.rss;

import hr.gregl.dal.ActorRepository;
import hr.gregl.dal.DirectorRepository;
import hr.gregl.dal.MovieActorDirectorRepository;
import hr.gregl.dal.MovieRepository;
import hr.gregl.dal.RepositoryFactory;
import hr.gregl.factory.UrlConnectionFactory;
import hr.gregl.model.Actor;
import hr.gregl.model.Director;
import hr.gregl.model.Movie;
import hr.gregl.model.MovieActorDirector;
import hr.gregl.parsers.rss.model.MovieRss;
import hr.gregl.parsers.rss.model.MoviesRss;
import hr.gregl.utilities.FileUtils;
import hr.gregl.utilities.JAXBUtils;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import static javax.swing.text.html.HTML.Attribute.DIR;
import javax.xml.bind.JAXBException;

/**
 *
 * @author albert
 */
public class MovieParser {

    private static final String RSS_URL = "https://www.blitz-cinestar-bh.ba/rss.aspx?id=2682";
    private static final LocalDate DEFAULT_DOB = LocalDate.of(1111, 11, 11);

    private MovieRepository movieRepository;
    private ActorRepository actorRepository;
    private DirectorRepository directorRepository;
    private MovieActorDirectorRepository movieActorDirectorRepository;

    public MovieParser() {
        this.movieRepository = RepositoryFactory.getMovieRepository();
        this.actorRepository = RepositoryFactory.getActorRepository();
        this.directorRepository = RepositoryFactory.getDirectorRepository();
        this.movieActorDirectorRepository = RepositoryFactory.getMovieActorDirectorRepository();
    }

    public void parseAndSaveDataFromRSS() throws JAXBException, IOException {
        // "UrlConnectionFactory" is best the Utility North of the Rio Grande for RSS access... thanks prof.  Daniel
        HttpURLConnection con = UrlConnectionFactory.getHttpUrlConnection(RSS_URL);
        try {
            MoviesRss moviesRss = (MoviesRss) JAXBUtils.load(MoviesRss.class, con.getInputStream());

            List<MovieRss> movies = moviesRss.getChannel().getMovies();

            for (MovieRss movieRss : movies) {
                Movie movie = new Movie();
                movie.setTitle(movieRss.getTitle());
                movie.setGenre(movieRss.getGenre());
                movie.setReleaseYear(movieRss.getReleaseYear());
                //movie.setImagePath(movieRss.getImagePath());
                String localImagePath = saveImageLocally(movieRss.getImagePath());
                movie.setImagePath(localImagePath);

                int movieId = movieRepository.addAndGetId(movie);

                Director director = new Director();
                director.setName(movieRss.getDirectorName());
                director.setDob(DEFAULT_DOB); // setting default dob

                int directorId = directorRepository.addAndGetId(director);

                String[] actorNames = movieRss.getActorsNames().split(",");
                for (String actorName : actorNames) {
                    Actor actor = new Actor();
                    actor.setName(actorName.trim());
                    actor.setDob(DEFAULT_DOB); // setting default dob

                    int actorId = actorRepository.addAndGetId(actor);

                    MovieActorDirector movieActorDirector = new MovieActorDirector();
                    movieActorDirector.setMovieID(movieId);
                    movieActorDirector.setActorID(actorId);
                    movieActorDirector.setDirectorID(directorId);

                    movieActorDirectorRepository.add(movieActorDirector);
                }
            }
        } finally {
            con.disconnect();
        }
    }

    // Downloads an image from a given URL and saves it in a local directory
    private String saveImageLocally(String imageUrl) throws IOException {
        String ext = imageUrl.substring(imageUrl.lastIndexOf("."));
        String pictureName = UUID.randomUUID() + ext;
        String localImagePath = DIR + File.separator + pictureName;

        FileUtils.copyFromUrl(imageUrl, localImagePath);

        return localImagePath;
    }
}
