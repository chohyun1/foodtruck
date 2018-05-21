package com.foodtruck.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodtruck.member.dto.MemberDTO;
import com.foodtruck.util.Beans;
import com.foodtruck.util.ServiceInterface;

/**
 * Servlet implementation class MemberController
 */
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(getClass().getName()+".doGet()");
		String command = Beans.getURI(request);
		String jsp = "";
		System.out.println(command);
		ServiceInterface service;
		switch (command) {
		// 회원가입 폼
		case "/member/join.do":
			// jsp 이름을 만들어 내고 밑에서 forward 시킨다.
			jsp = Beans.getJsp(command);
			System.out.println(jsp);
			break;
		// 아이디 중복 체크한다. Ajax로 요청된다.
		case "/member/checkId.do":
			String id = request.getParameter("id");
			PrintWriter out = response.getWriter();
			try {
				if((boolean) Beans.getService(command).execute(id)) {
					out.print("<span style=\"color:blue\">사용가능한 아이디 입니다.</span>");
				}else {
					out.print("<span style=\"color:red\">중복된 아이디 입니다.<span>");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				throw new ServletException(e);
			}
			return;
			//비밀번호 변경시 확인 Ajax
		case "/member/checkpw.do":
			System.out.println("비밀번호중복체크 ajax");
            HttpSession session = request.getSession();
            // 아이디에 맞는 비밀번호를 확인해야 한다.
            String id1 = (String)session.getAttribute("id");
            String pw = request.getParameter("pw");
            System.out.println("세션에 저장된 id:" + id1);
            System.out.println("changepw.jsp에서 받은 현재비밀번호: "+pw);
            try {                  
               if((boolean) Beans.getService(command).execute(new MemberDTO(id1, pw))) {
            	   
                  response.getWriter().print(1);
               }else {
                  response.getWriter().print(0);
               }
            } 
               catch (Exception e) {
               // TODO Auto-generated catch block
//               e.printStackTrace();
               throw new ServletException(e);
            }
            return;
			
		// 로그인 폼
		case "/member/login.do":
			// jsp 이름을 만들어 내고 밑에서 forward 시킨다.
			jsp = Beans.getJsp(command);
			System.out.println(jsp);
			break;
		// 로그아웃
		case "/member/logout.do":
			// 로그아웃 처리
			request.getSession().invalidate();
			// jsp 이름을 만들어 내고 밑에서 forward 시킨다.
			jsp = "redirect:"+request.getContextPath()+"/main/main.do";
			System.out.println(jsp);
			break;
		case "/member/view.do":
			// 회원정보 보기
			HttpSession httpSession1 = request.getSession();
			String id3 = (String)httpSession1.getAttribute("id");
			try {
			MemberDTO memberDTO1=(MemberDTO)Beans.getService(command).execute(id3);
			request.setAttribute("memberDTO", memberDTO1);
			System.out.println("컨트롤러에서" +memberDTO1);
			} catch (Exception e) {
				// TODO: handle exception
			}
			jsp = Beans.getJsp(command);
			System.out.println(jsp);
			break;
			// 비밀번호 변경
		case "/member/changepw.do":
			HttpSession httpSession2 = request.getSession();
			String id4 = (String)httpSession2.getAttribute("id");
			System.out.println("왔나?"+httpSession2);
			try {
				MemberDTO memberDTO2=(MemberDTO)Beans.getService(command).execute(id4);
				System.out.println(id4);
				request.setAttribute("memberDTO", memberDTO2);
				System.out.println(memberDTO2);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			jsp = Beans.getJsp(command);
			System.out.println(jsp);
			// jsp 이름을 만들어 내고 밑에서 forward 시킨다.
//			jsp = Beans.getJsp(command);
//			System.out.println(jsp);
			//post 방식으로 변경 쿼리를 보낼 것
			break;
//		case "/member/withdraw.do" :
//			System.out.println("멤버 컨트롤러 /member/withdraw.do");
//			HttpSession httpSession3 = request.getSession();
//			// 로그인 할 때 세션에 저장한 id를 꺼낸다.
//			String id5 = (String) httpSession3.getAttribute("id");
//			String pw1 = request.getParameter("password");
//			MemberDTO memberDTO3 = new MemberDTO(id5, pw1);
//			service=Beans.getService(command);
//			System.out.println(service);
//			try {
//				service.execute(memberDTO3);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			request.getSession().invalidate();
//			jsp=request.getContextPath()+"/main/main.do";
//			System.out.println(jsp);
//			break;
//			삭제시에 비밀번호를 묻는다. 아니면 바로 삭제 한다. 
			
		default:
			System.out.println("존재하지 않는 자원을 요청");
			jsp="/WEB-INF/views/error/404.jsp";
			break;
		}
		if(jsp.indexOf("redirect:") == -1) // redirect: 존재하지 않는다.
			// jsp쪽으로 이동한다.
			request.getRequestDispatcher(jsp).forward(request, response);
		else {// redirect: 존재한다.
			jsp = jsp.substring("redirect:".length());
			// uri쪽으로 이동한다.
			response.sendRedirect(jsp);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(getClass().getName()+".doPost()");
		String command = Beans.getURI(request);
		String jsp = "";
		// 처리해야할 서비스 선언
		ServiceInterface service;
		System.out.println(command);
		try {
			switch (command) {
			// 회원가입처리
			case "/member/join.do":
				// 넘어오는 데이터를 MemberDTO에 담는다.
				MemberDTO memberDTO = new MemberDTO(
						request.getParameter("id"),
						request.getParameter("pw"),
						request.getParameter("name"),
						request.getParameter("birthDate"),
						request.getParameter("gender"),
						request.getParameter("mobile"),
						request.getParameter("email"),
						request.getParameter("address"),
						request.getParameter("add2"),
						null, null, 1);
				service = Beans.getService(command);
				System.out.println(service);
				service.execute(memberDTO);
				jsp = request.getContextPath()+"/main/main.do";
				System.out.println(jsp);
				break;
				
			// 로그인 처리
			case "/member/login.do":
				service = Beans.getService(command);
				System.out.println(service);
				// 넘어오는 데이터를 MemberDTO에 담고 서비스를 실행한다.
				MemberDTO memberDTO2 = (MemberDTO) service.execute(new MemberDTO(
						request.getParameter("id"),
						request.getParameter("pw"),
						null,null,null,null,null,null,null,null,null,0));
				// application -> session -> request -> page
				HttpSession session = request.getSession();
				if(memberDTO2 != null) { // 정상적인 아이디와 암호를 입력한 경우
					// id, name -> session : 로그인 처리
					session.setAttribute("id", memberDTO2.getId());
					session.setAttribute("name", memberDTO2.getName());
					session.setAttribute("gradeno", memberDTO2.getGradeno());
					String reqURI = (String) session.getAttribute("reqURI");
					if(reqURI != null) { // 요청한 자원이 있는 경우 로그인으로 들어 왔으면 그쪽으로 이동
						jsp = request.getContextPath()+reqURI;
						session.removeAttribute("reqURI");
					}else {jsp = request.getContextPath()+"/main/main.do";}
				}else { // 아이디나 암호가 틀린 경우.
					jsp = request.getContextPath()+"/error/loginError.do";
				}
				System.out.println(jsp);
				break;
			
			// 회원 정보 수정
			case "/member/update.do":
//				HttpSession httpSession = request.getSession();
//				String id = (String)httpSession.getAttribute("id");
				MemberDTO memberDTO1 = new MemberDTO(
						request.getParameter("id"),
						null,
						request.getParameter("name"),
						request.getParameter("birthDate"),
						null,
						request.getParameter("mobile"),
						request.getParameter("email"),
						request.getParameter("address"),
						request.getParameter("add2"),
						null, null, 1);
				System.out.println(request);
				System.out.println("memberDTO1: " +memberDTO1);
				service = Beans.getService(command);
				System.out.println(service);
				service.execute(memberDTO1);
				jsp = request.getContextPath()+"/main/main.do";
				System.out.println(jsp);
				
				break;
				
			case "/member/changepw.do":
//				HttpSession httpSession = request.getSession();
//				String id = (String)httpSession.getAttribute("id");
				MemberDTO memberDTO3 = new MemberDTO(
						request.getParameter("id"),
						request.getParameter("pw"),
						null, null, null, null, null, null, null, null, null, 1);
				System.out.println(request);
				System.out.println("memberDTO3: " +memberDTO3);
				service = Beans.getService(command);
				System.out.println(service);
				service.execute(memberDTO3);
				jsp = request.getContextPath()+"/main/main.do";
				System.out.println(jsp);
				
				break;
				
				
			default:
				System.out.println("존재하지 않는 자원을 요청");
				jsp="/WEB-INF/views/error/404.jsp";
				break;
			}
			// uri쪽으로 이동한다.
			response.sendRedirect(jsp);
		}catch (Exception e) {
			// TODO: handle exception
			throw new ServletException(e);
		}
	}

}
