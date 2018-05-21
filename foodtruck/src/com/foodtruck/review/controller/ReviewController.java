package com.foodtruck.review.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.foodtruck.review.dto.ReviewDTO;
import com.foodtruck.util.Beans;
import com.foodtruck.util.DBUtil;
import com.foodtruck.util.ServiceInterface;
import com.webjjang.util.PageObject2;

/**
 * Servlet implementation class DataController
 */
public class ReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String command = Beans.getURI(request);
		String jsp = "";
		ServiceInterface service = null;
		System.out.println(command);
		try {
			switch (command) {
			case "/review/reviewlist.do":
				// 리스트에 뿌릴 데이터를 가져오자. - BoardListService가 필요하다.
				service = Beans.getService(command);
				int page = 1;
				int rowPerPage = 10;
				String pageStr = request.getParameter("page");
				String rowPerPageStr = request.getParameter("rowPerPage");
				// 검색 데이터를 받는다.
				String searchKey = request.getParameter("searchKey");
				String searchWord = request.getParameter("searchWord");
				// 처음에는 페이지, rowPerPage 데이터가 넘어오지 않아 null이다. null이면 page=1, rowPerPage=10
				if(pageStr != null && pageStr !="")
					page = Integer.parseInt(pageStr);
				if(rowPerPageStr != null && rowPerPageStr != "")
					rowPerPage = Integer.parseInt(rowPerPageStr);
				// 페이지 처리를 하기 위한 객체 생성  -> 다른 데이터는 자동 계산 된다.
				PageObject2 pageObject 	= new PageObject2(DBUtil.getConnection(), "reviewboard",
						page, rowPerPage, 10, searchKey, searchWord);		
				// 처리를해서 DB에 있는 데이터를 받아와서 request에 담아 둔다.
				request.setAttribute("list", service.execute(pageObject));
				request.setAttribute("pageObject", pageObject);
				// jsp 이름을 만들어 내고 밑에서 forward 시킨다.
				jsp = Beans.getJsp(command);				
				break;
				
			// 글쓰기 폼 - get
			case "/review/reviewwrite.do":
				// jsp 이름을 만들어 내고 밑에서 forward 시킨다.
				jsp = Beans.getJsp(command);
				break;

			// 글보기 - get
			case "/review/reviewview.do":
				int rno = Integer.parseInt(request.getParameter("rno").trim());
				System.out.println("콘트롤러뷰에들어왔어요");
				service = Beans.getService(command); // BoardViewService
				// service를 실행해서 DB에서 BoardDTO를 가져와서 request에 담는다.
				// 넘길 때 ArrayList로 캐스팅해서 사용하므로 0: (int)no, 1: (boolean)isViews
				ArrayList<Object> list = new ArrayList<Object>();
				list.add(rno);
				list.add(true); // 조회수 1증가를 시킨다.
				// list를 매개변수로 넘겨 처리한다.
				request.setAttribute("reviewDTO", service.execute(list));
				// jsp 이름을 만들어 내고 밑에서 forward 시킨다.
				jsp = Beans.getJsp(command);
				break;

			// 글수정 폼
			case "/review/reviewupdate.do":
				System.out.println("여기가 슬수정폼이래와우와우와우");
				// viewService에서
				int no2 = Integer.parseInt(request.getParameter("rno"));
				service = Beans.getService("/review/reviewview.do"); // BoardViewService
				ArrayList<Object> list2 = new ArrayList<>();
				list2.add(no2);
				list2.add(false);
				request.setAttribute("reviewDTO", service.execute(list2));
				
				
				
				jsp = Beans.getJsp(command);
				System.out.println(jsp);
				break;

			// 리스트
			case "/review/reviewdelete.do":
				// 삭제 처리할 서비스를 가져오자. - BoardDeleteService가 필요하다.
				service = Beans.getService(command);
				// 처리를해서 DB에 있는 데이터를 받아와서 request에 담아 둔다.
				service.execute(Integer.parseInt(request.getParameter("rno")));
				// jsp 이름을 만들어 내고 밑에서 forward 시킨다.
				jsp = "redirect:reviewlist.do";
				break;

			default:
				System.out.println("존재하지 않는 자원을 요청");
				jsp = "/WEB-INF/views/error/404.jsp";
				break;
			}
			if (jsp.indexOf("redirect:") == -1) { // redirect: 존재하지 않는다.
//				System.out.println("forward Process :" + jsp);
				// jsp쪽으로 이동한다.
				request.getRequestDispatcher(jsp).forward(request, response);
			}
			else {// redirect: 존재한다.
				jsp = jsp.substring("redirect:".length());
				// uri쪽으로 이동한다.
				response.sendRedirect(jsp);
			} // end of if-else;
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServletException(e);
		} // end of try-catch
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

		// 처리해야할 서비스 선언
		ServiceInterface service;
		System.out.println(command);
		try {
			switch (command) {
			// 글쓰기 처리
			case "/review/reviewwrite.do":
				// 넘어오는 데이터를 BoardDTO에 담는다.
				ReviewDTO reviewDTO = new ReviewDTO(
						0, request.getParameter("content"),
						request.getParameter("starscore"),
						request.getParameter("id"),
						Integer.parseInt(request.getParameter("score1")));

//						request.getParameter("id"));
				// 처리할 서비스를 받아온다. - BoardWriteService
				service = Beans.getService(command);
				service.execute(reviewDTO);
				jsp = "reviewwrite.do"; // 현재위치이므로 /board/list.do 가 아니다.
				break;
			// 글수정
			case "/review/reviewupdate.do":
				
				
				ReviewDTO reviewDTO2 = new ReviewDTO(
//						0,
						Integer.parseInt(request.getParameter("rno")),
						request.getParameter("content"),
						request.getParameter("starscore"),
						request.getParameter("id"),
						Integer.parseInt(request.getParameter("score1")));
				service = Beans.getService(command);
				System.out.println(reviewDTO2);
				System.out.println(reviewDTO2);
				System.out.println(reviewDTO2);
				System.out.println(reviewDTO2);
				System.out.println(reviewDTO2);
				System.out.println(reviewDTO2);
				System.out.println(reviewDTO2);
				System.out.println(service);
				System.out.println(service);
				System.out.println(service);
				System.out.println(service);
				System.out.println(service);
				// 실행해서 수정처리
				service.execute(reviewDTO2);
				// 글보기로 이동시키는데 글번호와 함께 이동시킨다.
				jsp = "reviewview.do?rno=" + reviewDTO2.getRno();
//				+ "$page=" + request.getParameter("page")
//				+ "$rowPerPage=" + request.getParameter("rowPerPage");
				System.out.println(jsp);
				break;

			default:
				System.out.println("존재하지 않는 자원을 요청");
				jsp = "/WEB-INF/views/error/404.jsp";
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServletException(e);
		}
		// uri쪽으로 이동한다.
		response.sendRedirect(jsp);
	}// end of doPost()

}
