package movieList;

public class MovieListVO {
	public String movieTitle;
	public int moviePrice;
	public int movieTime;
	public String genre;
	
	public MovieListVO() {
		
	}
	
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieName(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public int getMoviePrice() {
		return moviePrice;
	}
	public void setMoviePrice(int moviePrice) {
		this.moviePrice = moviePrice;
	}
	public int getMovieTime() {
		return movieTime;
	}
	public void setMovieTime(int movieTime) {
		this.movieTime = movieTime;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
}


