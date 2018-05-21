package com.foodtruck.member.service;

import com.foodtruck.member.dao.MemberDAO;
import com.foodtruck.member.dto.MemberDTO;
import com.foodtruck.util.ServiceInterface;

/*
 * MemberJoinService 객체를 한번만 생성하기 위해서 Beans안에서 생성해서 넣어 놨다. -> 싱글톤
 */
public class MemberJoinService implements ServiceInterface {

	//  MemberJoinService가 한번만 생성이 되므로 MemberDAO객체도 한번만 생성이 된다.
	// 1. 변수 선언 -> 2. 기본 초기값으로 셋팅한다. -> 3. 명시된 초기값셋팅 -> 4.초기화 블록 -> 5. servlet init()
	private MemberDAO memberDAO;
//	= (MemberDAO) Beans.getDAO("memberDAO");
	public void setDAO(Object memberDAO) {this.memberDAO=(MemberDAO) memberDAO;}
	
	@Override
	public Object execute(Object obj) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(getClass().getName()+".excute()");
		// 전달받은 데이터의 Type을 MemberDTO입니다. 그래서 Object->MemberDTO 캐스팅해서 사용한다.
		MemberDTO memberDTO = (MemberDTO) obj;
		//중복체크 를 한번더 해서 사용자에게 아이디가 중복됨을 알려주기위해 중복체크 처리를 한번 더 한다.(추후 개발)
		memberDAO.insert(memberDTO);
		
		return null; // 처리하고 나면 데이터가 나오지 않아 전달할수 없으므로 의미없는 null을 전달
	}

}
