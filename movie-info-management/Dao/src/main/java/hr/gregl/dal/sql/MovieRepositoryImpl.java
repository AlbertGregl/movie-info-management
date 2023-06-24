/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.gregl.dal.sql;

import hr.gregl.dal.MovieRepository;
import hr.gregl.model.Movie;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author albert
 */
public class MovieRepositoryImpl implements MovieRepository {

    private static final String MOVIE_ID = "MovieID";
    private static final String TITLE = "Title";
    private static final String GENRE = "Genre";
    private static final String RELEASE_YEAR = "ReleaseYear";
    private static final String IMAGE_PATH = "ImagePath";

    private static final String ADD_MOVIE = "{ CALL addMovie (?,?,?,?) }";
    private static final String DELETE_MOVIE = "{ CALL deleteMovie (?) }";
    private static final String UPDATE_MOVIE = "{ CALL updateMovie (?,?,?,?,?) }";
    private static final String SELECT_MOVIE = "{ CALL selectMovie (?) }";
    private static final String SELECT_ALL_MOVIES = "{ CALL selectAllMovies }";

    @Override
    public void add(Movie item) {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(ADD_MOVIE)) {
            stmt.setString(1, item.getTitle());
            stmt.setString(2, item.getGenre());
            stmt.setInt(3, item.getReleaseYear());
            stmt.setString(4, item.getImagePath());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(DELETE_MOVIE)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Movie item) {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(UPDATE_MOVIE)) {
            stmt.setInt(1, item.getMovieID());
            stmt.setString(2, item.getTitle());
            stmt.setString(3, item.getGenre());
            stmt.setInt(4, item.getReleaseYear());
            stmt.setString(5, item.getImagePath());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Movie selectById(int id) {
        Movie movie = null;
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(SELECT_MOVIE)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    movie = new Movie(
                            rs.getInt(MOVIE_ID),
                            rs.getString(TITLE),
                            rs.getString(GENRE),
                            rs.getInt(RELEASE_YEAR),
                            rs.getString(IMAGE_PATH));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return movie;
    }

    @Override
    public List<Movie> selectAll() {
        List<Movie> movies = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(SELECT_ALL_MOVIES); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                movies.add(new Movie(
                        rs.getInt(MOVIE_ID),
                        rs.getString(TITLE),
                        rs.getString(GENRE),
                        rs.getInt(RELEASE_YEAR),
                        rs.getString(IMAGE_PATH)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return movies;
    }
}
