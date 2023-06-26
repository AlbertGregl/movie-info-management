/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.gregl.dal.sql;

import hr.gregl.dal.MovieActorDirectorRepository;
import hr.gregl.model.MovieActorDirector;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author albert
 */
public class MovieActorDirectorRepositoryImpl implements MovieActorDirectorRepository {

    private static final String MOVIE_ID = "MovieID";
    private static final String ACTOR_ID = "ActorID";
    private static final String DIRECTOR_ID = "DirectorID";

    private static final String ADD_MAD = "{ CALL addMovieActorDirector (?,?,?) }";
    private static final String DELETE_MAD = "{ CALL deleteMovieActorDirector (?,?,?) }";
    private static final String SELECT_MAD = "{ CALL selectMovieActorDirector (?,?,?) }";
    private static final String SELECT_ALL_MADS = "{ CALL selectAllMovieActorDirectors }";

    @Override
    public void add(MovieActorDirector mad) {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(ADD_MAD)) {

            stmt.setInt(MOVIE_ID, mad.getMovieID());
            stmt.setInt(ACTOR_ID, mad.getActorID());
            stmt.setInt(DIRECTOR_ID, mad.getDirectorID());

            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int movieId, int actorId, int directorId) {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(DELETE_MAD)) {

            stmt.setInt(MOVIE_ID, movieId);
            stmt.setInt(ACTOR_ID, actorId);
            stmt.setInt(DIRECTOR_ID, directorId);

            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public MovieActorDirector selectById(int movieId, int actorId, int directorId) {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(SELECT_MAD)) {

            stmt.setInt(MOVIE_ID, movieId);
            stmt.setInt(ACTOR_ID, actorId);
            stmt.setInt(DIRECTOR_ID, directorId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new MovieActorDirector(
                            rs.getInt(MOVIE_ID),
                            rs.getInt(ACTOR_ID),
                            rs.getInt(DIRECTOR_ID));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<MovieActorDirector> selectAll() {
        List<MovieActorDirector> mads = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(SELECT_ALL_MADS); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                mads.add(new MovieActorDirector(
                        rs.getInt(MOVIE_ID),
                        rs.getInt(ACTOR_ID),
                        rs.getInt(DIRECTOR_ID)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mads;
    }
}
