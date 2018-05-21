package com.foodtruck.member.service;

import com.foodtruck.member.dao.MemberDAO;
import com.foodtruck.member.dto.MemberDTO;
import com.foodtruck.util.ServiceInterface;

public class MemberUpdateService implements ServiceInterface{

	private MemberDAO memberDAO;
	
	@Override
	public void setDAO(Object obj) {
		this.memberDAO = (MemberDAO) obj;
	}
	
	@Override
	public Integer execute(Object memberDTO) throws Exception{
		System.out.println("MemberUpdateService.process()");
		// 호출
		memberDAO.update((MemberDTO) memberDTO);
		return 1;
	}
}
