

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.Pokemon;
import utility.UtilDB;

/**
 * Servlet implementation class PokemonList
 */
@WebServlet("/PokemonList")
public class PokemonList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PokemonList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		retrieveDisplayData(response.getWriter());
	}
	
	void retrieveDisplayData(PrintWriter out) {
	      String title = "Pokemon List";
	      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
	            "transitional//en\">\n"; //
	      out.println(docType + //
	            "<html>\n" + //
	            "<head><title>" + title + "</title></head>\n" + //
	            "<body bgcolor=\"#f0f0f0\">\n" + //
	            "<h1 align=\"center\">" + title + "</h1>\n");
	      out.println("<ul>");
	      List<Pokemon> listPokemon = UtilDB.listPokemon();
	      for (Pokemon pokemon : listPokemon) {
	         System.out.println("[DBG] " + pokemon.getPokemonName() + ", " //
	               + pokemon.getNickname() + ", "
	               + pokemon.getFavDescription() + ", "
	               + pokemon.getEmailAddress());

	         out.println("<li>" + pokemon.getNickname() + "\'s favourite pokemon is " + pokemon.getPokemonName() 
	         			+ " because " + pokemon.getFavDescription() + "!</li>");
	      }
	      out.println("</ul>");
	      out.println("<a href=\"index.html\">Submit Another!</a><br>");
	      out.println("<a href=\"PokemonMostPopular\">View the most popular Pokemon!</a>");
	      out.println("</body></html>");
	   }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
