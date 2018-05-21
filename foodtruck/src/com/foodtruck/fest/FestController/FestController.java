package com.foodtruck.fest.FestController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodtruck.fest.dto.FestDTO;
import com.foodtruck.util.Beans;
import com.foodtruck.util.DBUtil;
import com.foodtruck.util.ServiceInterface;
import com.webjjang.util.PageObject2;

/*
 * 20180426 - 홍다운 행사일정 관련 폼 등록, 수정, 삭제 처리 컨트롤러
 * */

/**
 * Servlet implementation class BoardController
 */
// @WebServlet("/BoardController")
public class FestController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(getClass().getName() + ".doGet()");
		// Beans에 저장된 URI request 객체를 출력한다
		String command = Beans.getURI(request);
		// 기본으로는 forward 시킨 jsp파일명을 저장하는 변수. 앞에 redirect: 이라고 붙이면 redirect 시킨 uri를 젖앟나다.
		String viewJSP = "";
		// 실행할 service를 담는 객체 선언만 해주기
		ServiceInterface service = null;
		System.out.println(command);
		try {

			switch (command) {
			// [행사일정 ]리스트
			case "/fest/FestMngr/FestList.do":
				// list에 뿌릴 데이터를 가져와야 한다. - BoardListService 필요함
				// 이미 생성해서 저장해 놓은 곳에서 가져오기. getService() in Beans -> BoardListService에 있는
				// execute가져오게 됨
				service = Beans.getService(command);
				// 페이지 처리를 하기 위한 객체 생성
				int page = 1;
				int rowPerPage = 10;
				String pageStr = request.getParameter("page");
				String rowPerPageStr = request.getParameter("rowPerPage");
				String searchKey = request.getParameter("searchKey");
				String searchWord = request.getParameter("searchWord");
				// 처음에는 페이지가 안 넘어온다.
				// 따라서 , rowPerPage 데이터가 넘어오지 않아서 null이다. null이면, page = 1, rowPerPage = 10으로 선언
				if (pageStr != null && pageStr != "")
					page = Integer.parseInt(pageStr);
				if (rowPerPageStr != null && rowPerPageStr != "")
					rowPerPage = Integer.parseInt(rowPerPageStr);
				// 페이지 처리 객체 생성 -> 다른 데이터는 자동 계산 된다.
				// PageObject.jar을 library에 넣음.
				PageObject2 pageObject = new PageObject2(DBUtil.getConnection(), "festboard", page, rowPerPage, 10,
						searchKey, searchWord);
				System.out.println(pageObject);
				// 처리를 해서 DB에 있는 데이터를 받아와서 request에 담아둔다.
				// service를 실행하고 request에 바로 담기
				// 페이징 처리 안해서 null로 선언
				request.setAttribute("list", service.execute(pageObject)); // 위에 만든 페이지 객체를 execute에 넣어서 실행한다.
				request.setAttribute("pageObject", pageObject); // 위에 만든 페이지 객체를 execute에 넣어서 실행한다.
				// jsp 이름을 만들어 내고, 밑에서 forward 시킨다.
				viewJSP = Beans.getJsp(command);
				System.out.println(viewJSP);
				break;

			// [행사일정]글쓰기 폼 - get방식으로 데이터가 들어온다.
			case "/fest/FestMngr/FestWrite.do":
				// jsp 이름을 만들어 내고, 밑에서 forward 시킨다.
				viewJSP = Beans.getJsp(command);
				System.out.println(viewJSP);
				break;

			// [행사일정] 글보기 - get방식으로 데이터가 들어온다.
			case "/fest/FestMngr/FestView.do":
				// 글번호로 넘어오기 때문에 int festno를 받는다.

				int festno = Integer.parseInt(request.getParameter("festno"));

				// command.properties의 BoardViewService 필요함
				service = Beans.getService(command);
				// service를 실행해서 DB에서 FestDTO를 가져와서 request에 담기
				// 번호로 넘어오니까 festno로 선언
				// 넘길 때 ArrayList<>로 캐스팅해서 사용함으로 0번째:festno[int], 1번째:isView[boolean]를 넣는다.
				ArrayList<Object> executeObj = new ArrayList<>();
				executeObj.add(festno);
				executeObj.add(true); // 조회수를 1 증가 시킨다!
				request.setAttribute("FestDTO", service.execute(executeObj));
				// jsp 이름을 만들어 내고, 밑에서 forward 시킨다.
				viewJSP = Beans.getJsp(command);
				System.out.println(viewJSP);
				break;

			// [행사일정]글수정 폼 - get방식으로 데이터가 들어온다.
			case "/fest/FestMngr/FestUpdate.do":
				// 글번호로 넘어오기 때문에 int festno를 받는다.
				int festno2 = Integer.parseInt(request.getParameter("festno"));
				// command.properties의 BoardViewService 필요함
				service = Beans.getService("/fest/FestMngr/FestView.do");
				// service를 실행해서 DB에서 FestDTO를 가져와서 request에 담기
				// 번호로 넘어오니까 festno로 선언s
				// 넘길 때 ArrayList<>로 캐스팅해서 사용함으로 0번째:festno[int], 1번째:isView[boolean]를 넣는다.
				ArrayList<Object> executeObj2 = new ArrayList<>();
				executeObj2.add(festno2);
				executeObj2.add(false); // 조회수 1증가를 시키지 않는다.
				request.setAttribute("FestDTO", service.execute(executeObj2));
				// jsp 이름을 만들어 내고, 밑에서 forward 시킨다.
				viewJSP = Beans.getJsp(command);
				System.out.println(viewJSP);
				break;

			// 글삭제 - get방식으로 데이터가 들어온다.
			case "/fest/FestMngr/FestDelete.do":
				// 삭제처리 할 서비스를 가져오자. BoardDeleteService가 필요함
				service = Beans.getService(command);
				// 글번호를 받아서 삭제 처리한다.
				service.execute(Integer.parseInt(request.getParameter("festno")));
				// jsp 이름을 만들어 내고, 밑에서 forward 시킨다.
				viewJSP = "redirect:/project/fest/FestMngr/FestList.do";
				System.out.println(viewJSP);
				break;

			// 오류를 자세히 보기 위해 추가 - 유태선
			default:
				System.out.println("존재하지 않는 URI(자원)를 요청하였습니다");
				viewJSP = "/project/WEB-INF/views/error/404.jsp";
				break;

			}
			if (viewJSP.indexOf("redirect:") == -1) // redirect:이 존재하지 않는다.
				// jsp쪽으로 이동한다.
				request.getRequestDispatcher(viewJSP).forward(request, response);
			else {// redirect: 가 앞에 존재한다.
					// 앞에 붙은 redirect를 없앤다.
				viewJSP = viewJSP.substring("redirect:".length());
				// jsp에 있느 uri쪽으로 이동한다.
				response.sendRedirect(viewJSP);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(getClass().getName() + ".doPost()");
		// Beans에 저장된 URI request 객체를 출력한다
		String command = Beans.getURI(request);
		String viewJSP = "";
		// 처리해야할 서비스 선언
		ServiceInterface service;
		System.out.println(command);
		try {
			switch (command) {
			// 글쓰기 처리
			case "/fest/FestMngr/FestWrite.do":
				// 넘어오는 데이터를 festDTO에 담는다
				// 넘어오는 데이터 name과 동일하게 작성해야한다.
				FestDTO festDTO = new FestDTO(request.getParameter("festcomp"), request.getParameter("festname"),
						request.getParameter("festdate"), request.getParameter("festloc"),
						request.getParameter("festtime"));
				// 담은 데이터를 처리할 서비스를 받아온다. - BoardWriteService in command.properties
				service = Beans.getService(command);
				System.out.println(service);
				service.execute(festDTO);
				// 현재위치에 있는 리스트: 상대주소
				viewJSP = "FestList.do";
				System.out.println(viewJSP);
				break;

			// 글수정 처리
			case "/fest/FestMngr/FestUpdate.do":
				// 넘어오는 데이터를 festDTO에 담는다
				// 넘어오는 데이터 name과 동일하게 작성해야한다.
				FestDTO festDTO2 = new FestDTO(Integer.parseInt(request.getParameter("festno")),
						request.getParameter("festcomp"), request.getParameter("festname"),
						request.getParameter("festdate"), request.getParameter("festloc"),
						request.getParameter("festtime"));
				// 담은 데이터를 처리할 서비스를 받아온다. - BoardUpdateService in command.properties
				service = Beans.getService(command);
				System.out.println(service);
				// 실행해서 수정처리
				service.execute(festDTO2);
				// 현재위치에 있는 리스트: 상대주소
				// 끝나면 글보기로 자동 이동한다.
				viewJSP = "FestView.do?festno=" + festDTO2.getFestno() + "&page=" + request.getParameter("page")
						+ "&rowPerPage=" + request.getParameter("rowPerPage");
				System.out.println(viewJSP);
				break;

			default:
				System.out.println("존재하지 않는 URI(자원)를 요청하였습니다");
				viewJSP = "/project/WEB-INF/views/error/404.jsp";
				break;
			}
			// jsp에 있느 uri쪽으로 이동한다.
			response.sendRedirect(viewJSP);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
