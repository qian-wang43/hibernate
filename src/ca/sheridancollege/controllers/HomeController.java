package ca.sheridancollege.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.sheridancollege.beans.Person;
import ca.sheridancollege.dao.DAO;


/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DAO dao = new DAO();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
  //      dao.populate();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		List<Student> studentList = dao.queryStudent();
/*		List<Person> studentList = dao.queryStudentByName("Student 8");


		System.out.println("Size of list returned is: " + studentList.size());

		response.getWriter().append("<h1>It worked!!!</h1>");
		
		for (Person s : studentList) {
			response.getWriter().append("<h3>" + s.getName() + "</h3>");
		}
		
*/
		response.getWriter().append("<h1>It worked!!!</h1>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String query = request.getParameter("query");
		List<Person> personList=null ;
		String mode="";
		if(query==null||query==""){
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			Person temp = new Person(email,firstName,lastName,phone);
			dao.populate(temp);
			personList =dao.queryAllPerson();
			mode="create";
			
		}
		else {
			String firstName = request.getParameter("firstName1");
			String lastName = request.getParameter("lastName1");
			personList=dao.queryPersonByName(firstName,lastName);
			mode="query";
		
			
		}
		
		System.out.println(personList.size());
		request.setAttribute("personList", personList);
		request.setAttribute("mode", mode);
		request.getRequestDispatcher("view.jsp").forward(request,response);
	}

}
