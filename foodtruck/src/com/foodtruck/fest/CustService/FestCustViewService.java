package com.foodtruck.fest.CustService;

import java.util.ArrayList;

import com.foodtruck.fest.dao.FestCustDAO;
import com.foodtruck.fest.dto.FestCustDTO;
import com.foodtruck.util.ServiceInterface;

public class FestCustViewService implements ServiceInterface {

	private FestCustDAO custDAO;

	@Override
	public void setDAO(Object obj) {
		// TODO Auto-generated method stub
		this.custDAO = (FestCustDAO) obj;
	}

	@Override
	public FestCustDTO execute(Object objs) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("FestViewService.excute()");
		// 원래는 excute()에 타입을 선언하였으나, ServInt에는 하나만 받을 수 있게 하였다
		// 따라서 두개인 타입을 ArrayList<>에 넣어서 꺼내 사용한다.
		@SuppressWarnings("unchecked")
		ArrayList<Object> excuteObj = (ArrayList<Object>) objs;
		int custno = (int) excuteObj.get(0);
		boolean isView = (boolean) excuteObj.get(1);

		FestCustDTO custDTO = null;
		// list에 데이터를 가져와서 채우는 프로그램 작성
		// 객체 생성하고 호출
		if (isView)
			custDAO.increase(custno); // 글보기일 때만 조회수 1증가
		custDTO = custDAO.view(custno);
		return custDTO;
	}
}
