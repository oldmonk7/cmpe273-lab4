package edu.sjsu.cmpe.library.ui.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.sjsu.cmpe.library.repository.BookRepositoryInterface;
import edu.sjsu.cmpe.library.ui.views.HomeView;
import edu.sjsu.cmpe.library.ui.views.IndexView;

@Path("/")
@Produces(MediaType.TEXT_HTML)
public class HomeResource {
    private final BookRepositoryInterface bookRepository;

    public HomeResource(BookRepositoryInterface bookRepository) {
	this.bookRepository = bookRepository;
    }

    @Path("/login")
    @GET
    public IndexView getIndex() {

        return new IndexView();


    }

    @Path("/home")
    @GET
    public HomeView getHome() {
	return new HomeView(bookRepository.getAllBooks());
    }
}
