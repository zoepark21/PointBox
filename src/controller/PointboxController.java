package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.PointboxDTO;
import service.PointboxService;

/**
 * Servlet implementation class PointboxController
 */
@WebServlet({"/AddStu","/getAllInfo"})
public class PointboxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PointboxController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		PointboxService pService = new PointboxService();
		
		switch(request.getServletPath()) {
		
		case"/AddStu":
			System.out.println("/AddStu");
            System.out.println(request.getParameter("Stclass"));
            System.out.println(request.getParameter("Stname"));
            System.out.println(request.getParameter("Score"));
            
			PointboxDTO pDto = new PointboxDTO();
			pDto.setStclass(request.getParameter("Stclass"));
			pDto.setStname(request.getParameter("Stname"));
			pDto.setScore(Integer.parseInt(request.getParameter("Score")));
			
			pService.AddStu(pDto);
			
			response.sendRedirect("Main.jsp");
		    break;
		case"/getAllInfo":
			System.out.println("/getAllInfo");
			
			ArrayList<PointboxDTO> allListDto = pService.getAllInfo();
			request.setAttribute("List", allListDto);
			RequestDispatcher dispatcher;
			dispatcher = request.getRequestDispatcher("scoreList.jsp");
			dispatcher.forward(request, response);
			break;
		}

	}
    
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		doProcess(request, response);

	}

}
