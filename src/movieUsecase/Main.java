package movieUsecase;

import iocContainer.HomemadeContextFromFile;
import iocContainer.api.IocContainer;

public class Main {

	/*
	private MutablePicoContainer configureContainer() {
	    MutablePicoContainer pico = new DefaultPicoContainer();
	    Parameter[] finderParams =  {new ConstantParameter("movies1.txt")};
	    pico.registerComponentImplementation(MovieFinder.class, ColonMovieFinder.class, finderParams);
	    pico.registerComponentImplementation(MovieLister.class);
	    return pico;
	}
	
	public void testWithPico() {
	    MutablePicoContainer pico = configureContainer();
	    MovieLister lister = (MovieLister) pico.getComponentInstance(MovieLister.class);
	    Movie[] movies = lister.moviesDirectedBy("Sergio Leone");
	    assertEquals("Once Upon a Time in the West", movies[0].getTitle());
	}
	*/
	
	public static void main(String[] arg) {
		HomemadeContextFromFile ctx = new HomemadeContextFromFile("src/movieUsecase/appContext.xml");
		
		IocContainer iocContainer = ctx.getIocContainer();
		System.out.println("Context properties:\n" + iocContainer.getRegisteredProperties());
		
		try {
			MovieLister lister = (MovieLister) iocContainer.resolve(MovieLister.class);
			Movie[] movies = lister.moviesDirectedBy("Steven Spielberg");
			System.out.println(movies[0].getDirector());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
