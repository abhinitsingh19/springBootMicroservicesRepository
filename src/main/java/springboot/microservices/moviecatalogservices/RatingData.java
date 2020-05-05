package springboot.microservices.moviecatalogservices;


public class RatingData 
{

	private String movieName;
	private int rating;
	public RatingData(String movieName, int rating) {
		super();
		this.movieName = movieName;
		this.rating = rating;
	}
	public String getmovieName() {
		return movieName;
	}
	public void setmovieName(String movieName) {
		this.movieName = movieName;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}


}


