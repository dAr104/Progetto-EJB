package progettoejb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import progettoejb.service.LibreriaService;

@WebServlet("/HelloWorld")                                           
public class HelloWorldServlet extends HttpServlet {

	@Inject
	private LibreriaService service;


	@Override
	protected void doGet(HttpServletRequest req,
			HttpServletResponse resp)
					throws ServletException, IOException {
		resp.setContentType("text/plain");
		//resp.setStatus(500);
		String parametri = req.getParameter("id");
		PrintWriter writer = resp.getWriter();
		writer.println(service.createHelloAutore(Integer.parseInt(parametri)) );
		writer.close();
	}

}
