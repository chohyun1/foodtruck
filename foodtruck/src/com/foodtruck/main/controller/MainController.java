package com.foodtruck.main.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodtruck.util.Beans;

/**
 * Servlet implementation class MainController
 */
// @WebServlet("/MainController")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response) get방식url과 post방식url을 둘 다 잡아서 처리한다.
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(getClass().getName() + ".service()");
		// Beans에 저장된 URI request 객체를 출력한다
		String command = Beans.getURI(request);
		String viewJSP = "";
		System.out.println(command);
		switch (command) {
		// main
		case "/main/main.do":
			// jsp 이름을 만들어 내고 밑에서 forward 시킨다.
			viewJSP = Beans.getJsp(command);
			System.out.println(viewJSP);
			break;

		default:
			System.out.println("존재하지 않는 자원을 요청");
			viewJSP = "/WEB-INF/views/error/404.jsp";
			break;
		}
		// jsp쪽으로 이동한다.
		request.getRequestDispatcher(viewJSP).forward(request, response);
	}
}
