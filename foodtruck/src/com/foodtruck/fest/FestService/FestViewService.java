package com.foodtruck.fest.FestService;

import java.util.ArrayList;

import com.foodtruck.fest.dao.FestDAO;
import com.foodtruck.fest.dto.FestDTO;
import com.foodtruck.util.ServiceInterface;

public class FestViewService implements ServiceInterface {

	private FestDAO festDAO;

	@Override
	public void setDAO(Object obj) {
		// TODO Auto-generated method stub
		this.festDAO = (FestDAO) obj;
	}

	// ArrayList에 넣어서 아래 int와 boolean 객체를 받는다. get(0) - no, get(1) - isView
	// update Form으로 갈 때 실행해서 데이터를 가져간다. view할 때 사용한다.
	@Override
	public FestDTO execute(Object objs) {
		System.out.println("FestViewService.excute()");
		// 원래는 excute()에 타입을 선언하였으나, ServInt에는 하나만 받을 수 있게 하였다
		// 따라서 두개인 타입을 ArrayList<>에 넣어서 꺼내 사용한다.
		@SuppressWarnings("unchecked")
		ArrayList<Object> executeObj = (ArrayList<Object>) objs;
		int festno = (int) executeObj.get(0);
		boolean isView = (boolean) executeObj.get(1);

		FestDTO festDTO = null;
		// list에 데이터를 가져와서 채우는 프로그램 작성
		// 객체 생성하고 호출
		if (isView)
			festDAO.increase(festno); // 글보기일 때만 조회수 1증가
		festDTO = festDAO.view(festno);
		return festDTO;
	}

}
