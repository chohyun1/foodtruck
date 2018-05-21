package com.foodtruck.util;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.foodtruck.data.dao.DataDAO;
import com.foodtruck.fest.dao.FestCustDAO;
import com.foodtruck.fest.dao.FestDAO;
import com.foodtruck.fest.dao.FestTruckDAO;
import com.foodtruck.member.controller.Auth;
import com.foodtruck.member.dao.MemberDAO;
import com.foodtruck.notice.dao.NoticeDAO;
import com.foodtruck.review.dao.ReviewDAO;

/**
 * Servlet implementation class Beans
 */
public class Beans extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 실행해야할 모든 서비스 객체를 저장해 놓는 Map
	public static Map<String, ServiceInterface> beans = new HashMap<>();

	// 실행해야할 모든 DAO 객체를 저장해 놓는 Map
	public static Map<String, Object> daoBeans = new HashMap<>();

	// 실행한 서비스를 받아가는 메서드
	public static ServiceInterface getService(String uri) {
		return beans.get(uri);
	}

	// 실행할 DAO를 받아가는 메서드
	public static Object getDAO(String uri) {
		return daoBeans.get(uri);
	}

	// request를 받아서 URI를 리턴하는 프로그램 작성.
	// 모든 Controller에서는 따로 작성하지 않고 받아가서 처리한다.
	public static String requestUri;

	public static String getURI(HttpServletRequest request) {
		String uri = request.getRequestURI();
		return uri.substring(uri.indexOf(request.getServletPath()));
	}

	public static String pre = "/WEB-INF/views/";
	public static String suf = ".jsp";

	// 정제된 URI를 넣으면 forward할 jsp로 만들어주는 메서드
	public static String getJsp(String uri) {
		return pre + uri.substring(1, uri.lastIndexOf(".")) + suf;
	}

	/**
	 * @see Servlet#init(ServletConfig) 여기가 제일 먼저 실행이 되서 모든 객체를 생성한다.
	 */
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		// =====dao 생성해서 저장하는 처리문. - 모든 DAO 프로그램을 다 생성해 놓는다. =====
		// daoBeans.put("memberDAO", new MemberDAO());
		daoBeans.put("dataDAO", new DataDAO());
		daoBeans.put("noticeDAO", new NoticeDAO());
		// 행사 일정에 대한 DAO 생성 및 저장 처리문 - 홍다운 - 20180426
		// 행사일정 메인 게시판DAO
		daoBeans.put("festDAO", new FestDAO());
		// 행사 일정에 대한 DAO 생성 및 저장 처리문 - 홍다운 - 20180420
		daoBeans.put("reviewDAO", new ReviewDAO());
		// 소비자 신청 DAO
		daoBeans.put("festCustDAO", new FestCustDAO());
		// 푸드트럭 신청 DAO
		daoBeans.put("festTruckDAO", new FestTruckDAO());
		// 회원관리 DAO
		daoBeans.put("memberDAO", new MemberDAO());
		// >>>>>>> branch 'master' of https://github.com/iesilder/project.git
		// ========= service를 생성해서 저장하는 프로그램 작성 ==========
		/* 설정된 파일을 불러오자 */
		// web.xml에 init-param tag로 정의되어 있는 값을 받아 온다.
		String configFile = getInitParameter("configFile");
		// 컴퓨터 하드에 위치하는 실제적인 위치가 필요하다.
		String configFilePath = getServletContext().getRealPath(configFile);
		/* 실제적인 위치의 파일을 Properties 객체에서 읽어오자. */
		// key = value 값을 받아올 수 있는 객체 Properties를 이용해서 문자열로 받아낸다.
		Properties prop = new Properties();
		// try(자원선언) -> close()를 생략할 수 있다. 자동 닫힘. 버전 1.5이상부터
		try (FileReader fis = new FileReader(configFilePath)) {
			// properties 파일에서부터 key : value 형식으로 저장된 모든 정보를 읽어온다.
			// key : String, value : String -> 지네릭스를 안한다.
			prop.load(fis);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("읽기 오류");
		} // end of try-catch
		/* Properties에 있는 내용으로 객체를 자동생성하게 하자. */
		// prop객체에서 키 -> set -> iterator : 선언된 모든 객체 생성
		Iterator<Object> keyIter = prop.keySet().iterator();
		// prop에 키를 입력해서 생성해야할 객체이름을 꺼낸다.
		while (keyIter.hasNext()) {
			String command = (String) keyIter.next();
			String handlerClassName[] = ((String) prop.get(command)).split(":");
			// 클래스 이름을 알아내면 자동으로 객체를 생성할 수 있다.
			try {
				// 클래스 이름을 확인하는 명령문: forName
				// 클래스 객체로 저장이 가능
				// 따라서 command.properties에 저장되어있지 않는 서비스들은 실행이 불가능.
				// [0]은 command.properties의 value 첫번째 값을 부르는 것
				Class<?> handlerClass = Class.forName(handlerClassName[0]);
				// 자동으로 객체를 생성해서 저장한다.
				ServiceInterface handlerInstance = (ServiceInterface) handlerClass.newInstance();
				// key:command, value:handlerInstance-생성된 객체
				// Map에 저장
				beans.put(command, handlerInstance);
				// 의존성 주입 - 사용하는 프로그램을 넣어준다.(setter, 생성자)
				// 생성이 된 service(handlerInstance)에 필요한 DAO를 가져와서 넣는다.
				handlerInstance.setDAO(daoBeans.get(handlerClassName[1]));
				// 권한 filter에 관련되어서 command.properties의 권한 번호로 구분하는 선언문
				Auth.addAuth(command, Integer.parseInt(handlerClassName[2]));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // end of try - catch;;
		} // end of while;
		System.out.println("객체생성과 연결, 권한 자료 로딩 완료!");
	}// end of init()

}// end of class Beans{}
