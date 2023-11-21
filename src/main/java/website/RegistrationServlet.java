package website;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/registrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String URL = "jdbc:postgresql://localhost:5433/gg";
	private static String USERNAME = "postgres";
	private static String PASSWORD = "admin";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
//    public RegistrationServlet() {
//        super();
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.getSession().setAttribute("error", "HEEELLLLOOOOOOO");
		
		response.getWriter().append("Served at: ");//.append(request.getContextPath());
//		RequestDispatcher view = request.getRequestDispatcher("Registration.html");
		request.getRequestDispatcher("Registration.jsp").forward(request, response);
//		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		System.out.println("In DO POST");
//		RequestDispatcher view = request.getRequestDispatcher("Registration.html");
//		view.forward(request, response);
//		System.out.println(hashPassword("123"));
//		System.out.println(verifyPassword("123", hashPassword("123")));

//		response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
		request.getSession().setAttribute("error", "HEEELLLLOOOOOOO");

		String username = request.getParameter("Username");
		String nickname = request.getParameter("Nickname");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String repass = request.getParameter("repass");
		
		if (!pass.equalsIgnoreCase(repass)) {
			System.err.print("");
		}

		System.out.println(username + nickname + gender + phone + email + pass + repass);
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println(connection.toString());
			PreparedStatement ps = connection.prepareStatement("insert into usrs(user_name,nick_name,gender,phone,email,password) values(?,?,?,?,?,?)");

			ps.setString(1, username);
			ps.setString(2, nickname);
			ps.setString(3, gender);
			ps.setString(4, phone);
			ps.setString(5, email);
			ps.setString(6, hashPassword(pass));
			
			int i = ps.executeUpdate();

			if (i > 0) {
				System.out.println("You are successfully registered");
				
			}
			response.sendRedirect("Registrations.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Hash the password
    private static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    // Verify the entered password
    private static boolean verifyPassword(String enteredPassword, String hashedPassword) {
        return BCrypt.checkpw(enteredPassword, hashedPassword);
    }

}
