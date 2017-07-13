package login;

import java.io.IOException;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Backend.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		if(session.getAttribute("users") == null){
			session.setAttribute("users", new HashMap<String,User>());
		}

		
		//lowercase name and email for simplicity
		String email = request.getParameter("username").toLowerCase();
		String pass = request.getParameter("pass");

		String name = email.split("@")[0];
		String message = "Failed to login. Incorrect username or password.\n";
		
		
		
		
		//counter for number of login attempts?
		
		if(pass.equals("password")){
			
			
			User temp = new User(name, email);
			HashMap<String,User> users = (HashMap<String,User>) session.getAttribute("users");
			
			//email is key, since emails are unique
			if(!users.containsKey(email)){
				users.put(email, temp);
			}
			else{
				User inDB = users.get(email);
				//password will be encrypted/hashed
				if(!inDB.validateUser(name, email, "password")){
					request.setAttribute("message", message);
					request.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
					return;
				}
			
			}
			session.setAttribute("users",users);
			session.setAttribute("user",temp);
			
			
			request.getServletContext().getRequestDispatcher("/output.jsp").forward(request, response);
		
		}
		else{
			request.setAttribute("message", message);
			request.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}
	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
