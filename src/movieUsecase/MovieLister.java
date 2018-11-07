package movieUsecase;


import java.util.Iterator;
import java.util.List;

public class MovieLister
{
	private MovieFinder finder;
	public MovieLister(Object finder) {
      this.finder = (MovieFinder) finder;       
	}

    public Movie[] moviesDirectedBy(String arg) {
        List allMovies = finder.findAll();
        for (Iterator it = allMovies.iterator(); it.hasNext();) {
            Movie movie = (Movie) it.next();
            if (!movie.getDirector().equals(arg)) it.remove();
        }
        return (Movie[]) allMovies.toArray(new Movie[allMovies.size()]);
    }
}