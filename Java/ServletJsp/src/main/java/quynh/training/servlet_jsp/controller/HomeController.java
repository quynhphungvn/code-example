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
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HomeService homeService = new HomeServiceImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Department> listDepartment = homeService.getAllDepartment();
		request.setAttribute("departments", listDepartment);
		List<Employee> employees = homeService.getAllEmployee(listDepartment.get(0));
		List<Role> rolesOfFirstEmp = homeService.getAllRole(employees.get(0));
		System.out.print(rolesOfFirstEmp.size());
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/home/index.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
