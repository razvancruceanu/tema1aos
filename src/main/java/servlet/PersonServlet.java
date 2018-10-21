package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import DAL.PersonDAL;
import model.Person;

public class PersonServlet extends HttpServlet {

		public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String name = request.getParameter("first_name");
			String email = request.getParameter("email");

			Person person = new Person();
			person.setName(name);
			person.setEmail(email);

			PersonDAL repo = new PersonDAL("tema1aos");

			person = repo.createOrUpdate(person);

			response.getWriter().write("<html>" + "<body>" + "Id: " + person.getId() + "</body>" + "</html>");
			response.getWriter().flush();
			
			
			request.setAttribute("id_it_test", person.getId());
		}

		public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}
}
