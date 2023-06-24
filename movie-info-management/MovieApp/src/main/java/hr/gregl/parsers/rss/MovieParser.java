/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.gregl.parsers.rss;

import hr.gregl.dal.MovieRepository;
import hr.gregl.dal.RepositoryFactory;
import hr.gregl.factory.ParserFactory;
import hr.gregl.factory.UrlConnectionFactory;
import hr.gregl.model.Movie;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Optional;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

/**
 *
 * @author albert
 */
public class MovieParser {

    private static final String RSS_URL = "https://www.blitz-cinestar-bh.ba/rss.aspx?id=2682";

    private static final String TAG_MOVIE = "item";
    private static final String TAG_TITLE = "title";
    private static final String TAG_GENRE = "zanr";
    private static final String TAG_RELEASE_YEAR = "godina";
    private static final String TAG_IMAGE_PATH = "plakat";

    private MovieRepository movieRepository;

    public MovieParser() {
        this.movieRepository = RepositoryFactory.getMovieRepository();
    }

    public void parseAndSaveDataFromRSS() throws IOException, XMLStreamException {
        HttpURLConnection con = UrlConnectionFactory.getHttpUrlConnection(RSS_URL);
        try (InputStream is = con.getInputStream()) {
            XMLEventReader reader = ParserFactory.createStaxParser(is);

            Optional<TagType> tagType = Optional.empty();
            Movie movie = null;
            while (reader.hasNext()) {
                XMLEvent event = reader.nextEvent();
                switch (event.getEventType()) {
                    case XMLStreamConstants.START_ELEMENT:
                        String qName = event.asStartElement().getName().getLocalPart();
                        tagType = TagType.from(qName);
                        if (tagType.isPresent() && tagType.get().equals(TagType.MOVIE)) {
                            movie = new Movie();
                        }
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        if (tagType.isPresent() && movie != null) {
                            String data = event.asCharacters().getData().trim();
                            switch (tagType.get()) {
                                case TITLE:
                                    movie.setTitle(data);
                                    break;
                                case GENRE:
                                    movie.setGenre(data);
                                    break;
                                case RELEASE_YEAR:
                                    movie.setReleaseYear(Integer.parseInt(data));
                                    break;
                                case IMAGE_PATH:
                                    movie.setImagePath(data);
                                    break;
                            }
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        qName = event.asEndElement().getName().getLocalPart();
                        tagType = TagType.from(qName);
                        if (tagType.isPresent() && tagType.get().equals(TagType.MOVIE)) {
                            movieRepository.add(movie);
                        }
                        break;
                }
            }
        }
    }

    private enum TagType {
        MOVIE(TAG_MOVIE),
        TITLE(TAG_TITLE),
        GENRE(TAG_GENRE),
        RELEASE_YEAR(TAG_RELEASE_YEAR),
        IMAGE_PATH(TAG_IMAGE_PATH);

        private final String name;

        TagType(String name) {
            this.name = name;
        }

        public static Optional<TagType> from(String name) {
            for (TagType value : values()) {
                if (value.name.equals(name)) {
                    return Optional.of(value);
                }
            }
            return Optional.empty();

        }
    }
}
