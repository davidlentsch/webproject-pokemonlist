

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
	      List<Pokemon> listPokemon = UtilDB.listPokemon();
	      HashMap<Pokemon, Integer> map = new HashMap<Pokemon, Integer>();
	      
	      for (Pokemon pokemon : listPokemon) {
	    	  if (map.containsKey(pokemon)) {
	    		  map.replace(pokemon, map.get(pokemon) + 1);
	    	  }
	    	  else {
	    		  map.putIfAbsent(pokemon, 1);
	    	  }
	      }
	      
	      // Get the top value
	      HashMap.Entry<Pokemon, Integer> maxInstance = null;
	      for (HashMap.Entry<Pokemon, Integer> entry : map.entrySet())
	      {
	          if (maxInstance == null || entry.getValue().compareTo(maxInstance.getValue()) > 0)
	          {
	              maxInstance = entry;
	          }
	      }
	      
	      String mostPopular = maxInstance.getKey().getPokemonName();
	      
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
