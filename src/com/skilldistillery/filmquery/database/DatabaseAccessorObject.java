package com.skilldistillery.filmquery.database;

import java.sql.*;
import java.util.*;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {

	private static final String URL = "jdbc:mysql://localhost/sdvid?useSSL=false";
	private static final String USER = "student";
	private static final String PASSWORD = "student";

	@Override
	public Film findFilmById(int filmId) {
		Film film = null;

		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
			String sql = "SELECT film.movieTitle, film.movieDescription, film.id, film.releaseYear,"
					+ "lang.name, film.length, film.specialFeatures, film. movieRating, film.replacementCost "
					+ " FROM film join language lang " + "on film.language_id = lang.id " + "where film.id = ?";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, filmId);
			ResultSet filmResult = statement.executeQuery();
			if (filmResult.next()) {
				film = new Film();
				film.setId(filmResult.getInt("film.id"));
				film.setMovieTitle(filmResult.getString("film.movieTitle"));
				film.setMovieDescription(filmResult.getString("film.movieDescription"));
				film.setReleaseYear(filmResult.getInt("film.release_year"));
				film.setMovieLanguage(filmResult.getString("lang.name"));
				film.setRentalDuration(filmResult.getInt("film.rental_duration"));
				film.setLength(filmResult.getInt("film.length"));
				film.setRentalRate(filmResult.getDouble("film.rental_rate"));
				film.setReplacementCost(filmResult.getDouble("film.replacement_cost"));
				film.setMovieRating(filmResult.getString("film.rating"));
				film.setSpecialFeatures(filmResult.getString("film.special_features"));
				film.setActors(findActorsByFilmId(film.getId()));
			}
			filmResult.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}

	@Override
	public Actor findActorById(int actorId) {
		Actor actor = null;

		try (Connection connection = DriverManager.getConnection(URL, USER, PASS);) {
			String sql = "SELECT id, first_name, last_name " + "FROM actor " + "WHERE id = ? ";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, actorId);
			ResultSet actorResult = statement.executeQuery();
			if (actorResult.next()) {
				actor = new Actor();
				actor.setId(actorResult.getInt("id"));
				actor.setFirstName(actorResult.getString("first_name"));
				actor.setLastName(actorResult.getString("last_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actor;
	}

	@Override
	public List<Film> findFilmByUserKeyword(String userKeyword) {
		List<Film> films = new ArrayList<>();

		try (Connection connection = DriverManager.getConnection(URL, USER, PASS);) {
			String sql = "SELECT film.id, film.title, film.description, film.release_year, lang.name,"
					+ "film.rental_duration, film.length, film.rental_rate, film.replacement_cost,"
					+ "film.rating, film.special_features " + "FROM film JOIN language lang "
					+ "ON film.language_id = lang.id " + "WHERE film.title LIKE ? " + "OR film.description LIKE ? ";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, "%" + userKeyword + "%");
			statement.setString(2, "%" + userKeyword + "%");
			ResultSet filmResult = statement.executeQuery();
			while (filmResult.next()) {
				Film film = new Film();

				film.setId(filmResult.getInt("film.id"));
				film.setMovieTitle(filmResult.getString("film.title"));
				film.setMovieDescription(filmResult.getString("film.description"));
				film.setReleaseYear(filmResult.getInt("film.release_year"));
				film.setMovieLanguage(filmResult.getString("lang.name"));
				film.setRentalDuration(filmResult.getInt("film.rental_duration"));
				film.setLength(filmResult.getInt("film.length"));
				film.setRentalRate(filmResult.getDouble("film.rental_rate"));
				film.setReplacementCost(filmResult.getDouble("film.replacement_cost"));
				film.setMovieRating(filmResult.getString("film.rating"));
				film.setSpecialFeatures(filmResult.getString("film.special_features"));
				film.setActors(findActorsByFilmId(film.getId()));
				films.add(film);
			}
			filmResult.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();
		Actor actor = null;

		try (Connection connection = DriverManager.getConnection(URL, USER, PASS);) {
			String sql = "SELECT actor.id, actor.first_name, actor.last_name " + "FROM actor "
					+ "JOIN film_actor ON actor.id = film_actor.actor_id "
					+ "JOIN film ON film_actor.film_id = film.id " + "WHERE film.id = ? ";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, filmId);
			ResultSet actorResult = statement.executeQuery();
			while (actorResult.next()) {
				actor = new Actor();
				actor.setId(actorResult.getInt("actor.id"));
				actor.setFirstName(actorResult.getString("actor.first_name"));
				actor.setLastName(actorResult.getString("actor.last_name"));
				actors.add(actor);
			}
			actorResult.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actors;
	}
}
