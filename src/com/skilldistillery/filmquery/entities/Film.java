package com.skilldistillery.filmquery.entities;

import java.util.List;

public class Film {

	private int id;
	private String movieTitle;
	private int releaseYear;
	private String movieDescription;
	private int languageId;
	private double rentalDuration;
	private double rentalRate;
	private double replacementCost;
	private int length;
	private String movieRating;
	private String movieLanguage;
	private String specialFeatures;
	public List<Actor> actors;

	public Film() {
		super();
	}

	public Film(int id, String movieTitle, int releaseYear, String movieDescription, int languageId,
			double rentalDuration, double rentalRate, double replacementCost, int length, String movieRating,
			String movieLanguage, String specialFeatures, List<Actor> actors) {
		super();
		this.id = id;
		this.movieTitle = movieTitle;
		this.releaseYear = releaseYear;
		this.movieDescription = movieDescription;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.replacementCost = replacementCost;
		this.length = length;
		this.movieRating = movieRating;
		this.movieLanguage = movieLanguage;
		this.specialFeatures = specialFeatures;
		this.actors = actors;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getMovieDescription() {
		return movieDescription;
	}

	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public double getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(double rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(String movieRating) {
		this.movieRating = movieRating;
	}

	public String getMovieLanguage() {
		return movieLanguage;
	}

	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		double result = 1;
		result = prime * result + ((actors == null) ? 0 : actors.hashCode());
		result = prime * result + id;
		result = prime * result + languageId;
		result = prime * result + length;
		result = prime * result + ((movieDescription == null) ? 0 : movieDescription.hashCode());
		result = prime * result + ((movieLanguage == null) ? 0 : movieLanguage.hashCode());
		result = prime * result + ((movieRating == null) ? 0 : movieRating.hashCode());
		result = prime * result + ((movieTitle == null) ? 0 : movieTitle.hashCode());
		result = prime * result + releaseYear;
		long temp;
		temp = Double.doubleToLongBits(rentalDuration);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + rentalRate;
		temp = Double.doubleToLongBits(replacementCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((specialFeatures == null) ? 0 : specialFeatures.hashCode());
		return (int) result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (actors == null) {
			if (other.actors != null)
				return false;
		} else if (!actors.equals(other.actors))
			return false;
		if (id != other.id)
			return false;
		if (languageId != other.languageId)
			return false;
		if (length != other.length)
			return false;
		if (movieDescription == null) {
			if (other.movieDescription != null)
				return false;
		} else if (!movieDescription.equals(other.movieDescription))
			return false;
		if (movieLanguage == null) {
			if (other.movieLanguage != null)
				return false;
		} else if (!movieLanguage.equals(other.movieLanguage))
			return false;
		if (movieRating == null) {
			if (other.movieRating != null)
				return false;
		} else if (!movieRating.equals(other.movieRating))
			return false;
		if (movieTitle == null) {
			if (other.movieTitle != null)
				return false;
		} else if (!movieTitle.equals(other.movieTitle))
			return false;
		if (releaseYear != other.releaseYear)
			return false;
		if (Double.doubleToLongBits(rentalDuration) != Double.doubleToLongBits(other.rentalDuration))
			return false;
		if (rentalRate != other.rentalRate)
			return false;
		if (Double.doubleToLongBits(replacementCost) != Double.doubleToLongBits(other.replacementCost))
			return false;
		if (specialFeatures == null) {
			if (other.specialFeatures != null)
				return false;
		} else if (!specialFeatures.equals(other.specialFeatures))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Film [id=");
		builder.append(id);
		builder.append(", movieTitle=");
		builder.append(movieTitle);
		builder.append(", releaseYear=");
		builder.append(releaseYear);
		builder.append(", movieDescription=");
		builder.append(movieDescription);
		builder.append(", languageId=");
		builder.append(languageId);
		builder.append(", rentalDuration=");
		builder.append(rentalDuration);
		builder.append(", rentalRate=");
		builder.append(rentalRate);
		builder.append(", replacementCost=");
		builder.append(replacementCost);
		builder.append(", length=");
		builder.append(length);
		builder.append(", movieRating=");
		builder.append(movieRating);
		builder.append(", movieLanguage=");
		builder.append(movieLanguage);
		builder.append(", specialFeatures=");
		builder.append(specialFeatures);
		builder.append(", actors=");
		builder.append(actors);
		builder.append("]");
		return builder.toString();
	}
}
