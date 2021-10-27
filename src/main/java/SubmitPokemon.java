

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.UtilDB;

/**
 * Servlet implementation class SubmitPokemon
 */
@WebServlet("/SubmitPokemon")
public class SubmitPokemon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitPokemon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    String pokemonName = request.getParameter("pokemonName");
	    String nickname = request.getParameter("nickname");
	    String favDescription = request.getParameter("favDescription");
	    String emailAddress = request.getParameter("emailAddress");

	    UtilDB.createPokemon(pokemonName, nickname, favDescription, emailAddress);
	    
	    response.sendRedirect(request.getContextPath() + "/PokemonList");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
