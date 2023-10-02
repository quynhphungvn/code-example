package quynh.training.servlet_jsp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quynh.training.servlet_jsp.model.Department;
import quynh.training.servlet_jsp.model.Role;
import quynh.training.servlet_jsp.model.Employee;
import quynh.training.servlet_jsp.service.HomeService;
import quynh.training.servlet_jsp.service.impl.HomeServiceImpl;

/**
 * Servlet implementation class HomeController
 */
public class JspTestingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HomeService homeService = new HomeServiceImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JspTestingController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRequestURI();
		if (path.contains("/jsp-testing/home")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/jsp-testing/index.jsp");
			rd.forward(request, response);
		} else if (path.contains("/jsp-testing/scriplet")) {
			List<Department> listDepartment = homeService.getAllDepartment();
			request.setAttribute("departments", listDepartment);
			List<Employee> employees = homeService.getAllEmployee(listDepartment.get(0));
			request.setAttribute("employees", employees);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/jsp-testing/scriplet.jsp");
			rd.forward(request, response);
		} else if (path.contains("/jsp-testing/jstl")) {
				List<Department> listDepartment = homeService.getAllDepartment();
				request.setAttribute("departments", listDepartment);
				List<Employee> employees = homeService.getAllEmployee(listDepartment.get(0));
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/jsp-testing/jstl.jsp");
				rd.forward(request, response);
		} else if (path.contains("/jsp-testing/escape-character")) {
			String sXml = "<b></b> is used to bold text"; 
			String convXml = "&lt;b&gt;&lt;/b&gt;"; 
			request.setAttribute("sXml", sXml);
			request.setAttribute("convXml", convXml);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/jsp-testing/escapeXml.jsp");
			rd.forward(request, response);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
