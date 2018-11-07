package movieUsecase;

import java.util.ArrayList;
import java.util.List;

public class ColonMovieFinder implements MovieFinder{
	
	private String filename;
	
	public ColonMovieFinder() {
		
	}
	
	public ColonMovieFinder(String filename) {
	      this.filename = filename;
	  }

	@Override
	public List<Movie> findAll() {
		List<Movie> movies = new ArrayList<Movie>();    	    
        movies.add(new Movie("Schindler's List", "Steven Spielberg"));
   	    movies.add(new Movie("Taxi Driver", "Martin Scorsese"));
   	    
    	return movies;
	}
}
