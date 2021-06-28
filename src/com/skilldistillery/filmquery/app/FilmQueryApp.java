package com.skilldistillery.filmquery.app;

import java.awt.List;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.*;

public class FilmQueryApp {

	private DatabaseAccessor dao = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
		app.launch();
	}

	private void launch() {
		Scanner keyboard = new Scanner(System.in);

		userMenu(keyboard);

		keyboard.close();
	}

	private void userMenu(Scanner keyboard) {
		System.out.println("Welcome to Film Query!");
		System.out.println("\nPlease make a selection: ");
		System.out.println("\n1.) Look up film by id.");
		System.out.println("\n2.) Look up a film by keyword.");
		System.out.println("\n3.) Quit.");
		System.out.println("");

		int userChoice = 0;

		try {
			userChoice = keyboard.nextInt();
		} catch (Exception e) {
		} finally {
			keyboard.nextLine();
		}

		switch (userChoice) {
		case 1:
			findFilmByID(keyboard);
			break;

		case 2:
			keywordSearch(keyboard);
			break;

		case 3:
			System.out.println("\nGoodbye!");
			break;

		default:
			System.err.println("\nPlease enter a valid selection.");
			System.out.println("");
			userMenu(keyboard);
			break;
		}
	}

//	private void findFilmById(Scanner keyboard) {
//		System.out.print("\nEnter the film ID: ");
//		int filmId = 0;
//
//		try {
//			filmId = keyboard.nextInt();
//		} catch (Exception e) {
//			keyboard.nextLine();
//			System.err.println("\nPlease enter a valid selection.");
//			System.out.println("");
//			userMenu(keyboard);
//		} finally {
//			keyboard.nextLine();
//			System.out.println("\nThe film ID is " + filmId + ", is that correct? ");
//			System.out.println("\nPress 1 for yes.");
//			System.out.println("\nPress 2 for no.");
//			System.out.println("");
//			
//			int response = 0;
//			response = keyboard.nextInt();
//			
//			switch (response) {
//			case 1:
//				System.out.println("\nSearching for film ID " + filmId + "...");
//				findFilmById(response);
//				break;
//				
//			case 2:
//				findFilmById(keyboard);
//				break;
//			
//			default:
//				System.err.println("\nPlease enter a valid selection.");
//				System.out.println("");
//				findFilmById(keyboard);
//				break;
//			}
//			}
//	}
	private void findFilmByID(Scanner keyboard) {
		System.out.print("\nEnter a Film ID: ");
		int filmID = 0;
		try {
			filmID = keyboard.nextInt();
		} catch (Exception e) {
			keyboard.nextLine();
			System.err.println("\nPlease enter a valid ID.");
			System.out.println();
			userMenu(keyboard);
		} finally {
			keyboard.nextLine();
		}
		Film film = dao.findFilmById(filmID);
		if (film == null) {
			System.out.println("The film ID " + filmID + " has no associated films.");
		} else {
			System.out.println(film.getMovieTitle());
			System.out.println(film.getReleaseYear());
			System.out.println(film.getMovieRating());
			System.out.println(film.getMovieDescription());
//			System.out.println(film.getLanguageId());
			System.out.println(film.getMovieLanguage());
			System.out.println(film.getActors().toString());
		}
		System.out.println();
		userMenu(keyboard);
	}

	private void keywordSearch(Scanner keyboard) {
		System.out.print("\nEnter a keyword: ");
		String userKeyword = keyboard.nextLine();
		System.out.println();

		java.util.List<Film> films = dao.findFilmByUserKeyword(userKeyword);
		if (films.size() == 0) {
			System.out.println("\nThe keyword " + userKeyword + " has no associated films.");
		} else {
			for (Film userKeywordFilms : films) {
				System.out.println(userKeywordFilms.getMovieTitle());
				System.out.println(userKeywordFilms.getReleaseYear());
				System.out.println(userKeywordFilms.getMovieRating());
				System.out.println(userKeywordFilms.getMovieDescription());
//				System.out.println(userKeywordFilms.getLanguageId());
				System.out.println(userKeywordFilms.getMovieLanguage());
				System.out.println(userKeywordFilms.getActors().toString());
			}
			System.out.println();
		}
		System.out.println();
		userMenu(keyboard);
	}
}