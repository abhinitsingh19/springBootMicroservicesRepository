package springboot.microservices.moviecatalogservices;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController 
{
	
	private List<MovieCatalog> movies = Arrays.asList(new MovieCatalog("Avengers", "Action", 5),
			new MovieCatalog("Transformers", "Thriller", 4),
			new MovieCatalog("Inception", "scifi", 3));
	
	@RequestMapping("/catalog")
	public List<MovieCatalog> getMovies()
	{
		return movies;
		
	}
	
	@RequestMapping("{name}")
	public List<MovieCatalog> getMoviesByUser(@PathVariable String name)
	{
		List<RatingData> ratings = Arrays.asList(new RatingData("Avengers", 5),
				new RatingData("Transformers", 4),
				new RatingData("Inception", 3));
		
		RestTemplate restTemplate = new RestTemplate();
		
		for(RatingData rating : ratings)
		{
		MovieItem movie1=restTemplate.getForObject("http://localhost:8082/movies/" + rating.getmovieName(), MovieItem.class);
		}
		return ratings.stream().map(rating ->{
		MovieItem movie=restTemplate.getForObject("http://localhost:8082/movies/" + rating.getmovieName(), MovieItem.class);
		return new MovieCatalog(movie.getName(), movie.getDescription(), rating.getRating());
		}).collect(Collectors.toList());
				
//				.filter(m-> m.getName().equals(name)).findFirst().get();
		
	}
}
