package movieUsecase;

import java.util.ArrayList;
import java.util.List;

public class MovieFinderImpl implements MovieFinder{
    
    @Override
    public List<Movie> findAll() {
    	List<Movie> movies = new ArrayList<Movie>();    	    
        movies.add(new Movie("Schindler's List", "Steven Spielberg"));
   	    movies.add(new Movie("Taxi Driver", "Martin Scorsese"));
   	    
    	return movies;
    }
    
    public static void main(String[] args) {
    	MovieFinderImpl m = new MovieFinderImpl();
		System.out.println(m.getClass().getName());
	}
}