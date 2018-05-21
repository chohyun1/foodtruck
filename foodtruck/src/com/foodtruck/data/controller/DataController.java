package com.foodtruck.data.controller;

import java.io.IOException;
//import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodtruck.util.Beans;
//import com.foodtruck.util.ServiceInterface;

/**
 * Servlet implementation class DataController
 */
public class DataController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DataController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
//	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(getClass().getName() + ".doGet()");
		String command = Beans.getURI(request);
		System.out.println("1");
		// 기본으로는 forward 시킨 jsp 파일명을 저장한다. 앞에 redirect:이라고 붙이면 redirect 시킨 uri를 저장한다.
		String jsp = "";
		// 실행할 Service를 담는 객체 선언
//		ServiceInterface service = null;
//		List<Object> list = null;
		System.out.println(command);

		
		switch (command) {

		case "/data/MongodbDataPrint.do":
			//데이터를 가져오기 위한 service 객체 
			
//			service = Beans.getService(command);
//			try {
//				list = (List<Object>) service.execute(null);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			// 가져온 데이터를 꺼낸다.
//			List<String> key = (List<String>) list.get(0);
//			List<Double> vale = (List<Double>) list.get(1);
//			
//			request.setAttribute("key", key);
//			request.setAttribute("value", vale);
			
			jsp = Beans.getJsp(command);
			System.out.println(jsp);
			break;
		case "/data/admin.do":
			jsp = Beans.getJsp(command);
			System.out.println(jsp);
			break;
		case "/data/HuffGravityModelPrint.do":
			jsp = Beans.getJsp(command);
			System.out.println(jsp);
			break;
		case "/data/daylm.do":
			jsp = Beans.getJsp(command);
			System.out.println(jsp);
			break;
		case "/data/timelm.do":
			jsp = Beans.getJsp(command);
			System.out.println(jsp);
			break;
		case "/data/agelm.do":
			jsp = Beans.getJsp(command);
			System.out.println(jsp);
			break;
		case "/data/MapPrint.do":
			jsp = Beans.getJsp(command);
			System.out.println(jsp);
			break;
		default:
			System.out.println("존재하지 않는 자원을 요청");
			jsp = "/WEB-INF/views/error/404.jsp";
			break;
		}
		// jsp쪽으로 이동한다.
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(getClass().getName() + ".doPost()");
		String command = Beans.getURI(request);
		String jsp = "";
		System.out.println(command);

		switch (command) {

		case "/data/admin.do":
			jsp = Beans.getJsp(command);
			System.out.println(jsp);
			break;
		default:
			System.out.println("존재하지 않는 자원을 요청");
			jsp = "/WEB-INF/views/error/404.jsp";
			break;
		}
		// jsp쪽으로 이동한다.
		response.sendRedirect(jsp);
	}

}
