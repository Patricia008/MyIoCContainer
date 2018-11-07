package movieUsecase;

import java.util.List;

import iocContainer.HomemadeContextFromFile;
import iocContainer.api.IocContainer;

public class Main {

//	private MutablePicoContainer configureContainer() {
//	    MutablePicoContainer pico = new DefaultPicoContainer();
//	    Parameter[] finderParams =  {new ConstantParameter("movies1.txt")};
//	    pico.registerComponentImplementation(MovieFinder.class, ColonMovieFinder.class, finderParams);
//	    pico.registerComponentImplementation(MovieLister.class);
//	    return pico;
//	}
	
//	public void testWithPico() {
//	    MutablePicoContainer pico = configureContainer();
//	    MovieLister lister = (MovieLister) pico.getComponentInstance(MovieLister.class);
//	    Movie[] movies = lister.moviesDirectedBy("Sergio Leone");
//	    assertEquals("Once Upon a Time in the West", movies[0].getTitle());
//	}
//	
	
	public static void main(String[] arg) {
		HomemadeContextFromFile ctx = new HomemadeContextFromFile("src/movieUsecase/appContext.xml");
		
		IocContainer iocContainer = ctx.getIocContainer();
		System.out.println("Context properties:\n" + iocContainer.getRegisteredProperties());
		
		try {
			MovieFinder finder = (MovieFinder) iocContainer.resolve(MovieFinder.class);
			List<Movie> movies = finder.findAll();
			System.out.println(movies.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
