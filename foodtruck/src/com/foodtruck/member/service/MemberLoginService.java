package com.foodtruck.member.service;

import com.foodtruck.member.dao.MemberDAO;
import com.foodtruck.member.dto.MemberDTO;
import com.foodtruck.util.ServiceInterface;

public class MemberLoginService implements ServiceInterface {

	private MemberDAO memberDAO;
	// 오류를 유태선님께서 찾으셨습니다.
	@Override
	public void setDAO(Object obj) {this.memberDAO=(MemberDAO) obj;}
	
	@Override
	public Object execute(Object obj) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(getClass().getName()+".excute().memberDAO:"+memberDAO);
		MemberDTO memberDTO = memberDAO.login((MemberDTO) obj);
		System.out.println("MemberLoginService.excute().memberDTO:"+memberDTO);
		return memberDTO;
	}

}
