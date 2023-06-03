/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.gregl.dal;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author albert
 */
public final class RepositoryFactory {

    private static final Properties properties = new Properties();
    private static final String PATH = "/config/repository.properties";
    private static final String UserRepository="UserRepository";
    private static final String MovieRepository="MovieRepository";
    private static final String ActorRepository="ActorRepository";
    private static final String DirectorRepository="DirectorRepository";
    private static final String MovieActorDirectorRepository="MovieActorDirectorRepository";


    private static UserRepository userRepository;
    private static MovieRepository movieRepository;
    private static ActorRepository actorRepository;
    private static DirectorRepository directorRepository;
    private static MovieActorDirectorRepository movieActorDirectorRepository;

    static {
        try (InputStream is = RepositoryFactory.class.getResourceAsStream(PATH)) {
            properties.load(is);

            userRepository = (UserRepository) Class
                    .forName(properties.getProperty(UserRepository))
                    .getDeclaredConstructor()
                    .newInstance();

            movieRepository = (MovieRepository) Class
                    .forName(properties.getProperty(MovieRepository))
                    .getDeclaredConstructor()
                    .newInstance();

            actorRepository = (ActorRepository) Class
                    .forName(properties.getProperty(ActorRepository))
                    .getDeclaredConstructor()
                    .newInstance();

            directorRepository = (DirectorRepository) Class
                    .forName(properties.getProperty(DirectorRepository))
                    .getDeclaredConstructor()
                    .newInstance();

            movieActorDirectorRepository = (MovieActorDirectorRepository) Class
                    .forName(properties.getProperty(MovieActorDirectorRepository))
                    .getDeclaredConstructor()
                    .newInstance();

        } catch (Exception ex) {
            Logger.getLogger(RepositoryFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static UserRepository getUserRepository() {
        return userRepository;
    }

    public static MovieRepository getMovieRepository() {
        return movieRepository;
    }

    public static ActorRepository getActorRepository() {
        return actorRepository;
    }

    public static DirectorRepository getDirectorRepository() {
        return directorRepository;
    }

    public static MovieActorDirectorRepository getMovieActorDirectorRepository() {
        return movieActorDirectorRepository;
    }
}
