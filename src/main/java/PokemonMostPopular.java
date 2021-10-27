

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.Pokemon;
import utility.UtilDB;

/**
 * Servlet implementation class PokemonTopFive
 */
@WebServlet("/PokemonMostPopular")
public class PokemonMostPopular extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PokemonMostPopular() {
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
	      String title = "Pokemon Most Popular!";
	      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
	            "transitional//en\">\n"; //
	      out.println(docType + //
	            "<html>\n" + //
	            "<head><title>" + title + "</title></head>\n" + //
	            "<body bgcolor=\"#f0f0f0\">\n" + //
	            "<h1 align=\"center\">" + title + "</h1>\n");
	      out.println("<ul>");
	      // Store all of the Pokemon into a HashMap
	      List<Pokemon> listPokemon = UtilDB.listPokemon();
	      HashMap<String, Integer> map = new HashMap<String, Integer>();
	      
	      for (Pokemon pokemon : listPokemon) {
	    	  Integer val = map.get(pokemon.getPokemonName());

	    	  if (val == null) {
	    		  map.put(pokemon.getPokemonName(), 1);
	    	  }
	    	  else {
	    		  map.put(pokemon.getPokemonName(), val + 1);
	    	  }
	    	  
	      }
	      
	      // Get the top value
	      HashMap.Entry<String, Integer> maxInstance = null;
	      for (HashMap.Entry<String, Integer> entry : map.entrySet())
	      {
	          if (maxInstance == null || (entry.getValue().compareTo(maxInstance.getValue()) > 0))
	          {
	              maxInstance = entry;
	          }
	      }
	      
	      String mostPopular = maxInstance.getKey();
	      
	      out.println("The most popular Pokemon is " + mostPopular + "!");
	      out.println("</ul>");
	      out.println("<a href=\"index.html\">Submit Another!</a><br>");
	      out.println("<a href=\"PokemonList\">View all of the entries!</a>");
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
