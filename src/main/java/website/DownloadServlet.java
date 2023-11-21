package website;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class DownloadServlet
 */
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.setContentType("text/plain;charset=UTF-8");
//		response.setContentType("image/jpg");
//		response.getWriter().append("Served at: ");//.append(request.getContextPath());
//		response.getWriter().append("\n<h1> Downloading </h1>");//.append(request.getContextPath());
		response.getWriter().append("\n<h1> Downloading </h1>");
		
//		RequestDispatcher view = request.getRequestDispatcher("Registration.html");
//		view.forward(request, response);
	}

}

///**
// * @see HttpServlet#HttpServlet()
// */
//public DownloadServlet() {
//    super();
//    // TODO Auto-generated constructor stub
//}
//
///**
// * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
// */
//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	// TODO Auto-generated method stub
//	response.getWriter().append("Served at: ").append(request.getContextPath());
//}
//
///**
// * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
// */
//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	// TODO Auto-generated method stub
//	doGet(request, response);
//}