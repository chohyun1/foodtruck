package com.foodtruck.fest.TruckService;

import java.util.ArrayList;

import com.foodtruck.fest.dao.FestTruckDAO;
import com.foodtruck.fest.dto.FestTruckDTO;
import com.foodtruck.util.ServiceInterface;

public class FestTruckViewService implements ServiceInterface {

	private FestTruckDAO truckDAO;

	@Override
	public void setDAO(Object obj) {
		// TODO Auto-generated method stub
		this.truckDAO = (FestTruckDAO) obj;
	}

	@Override
	public FestTruckDTO execute(Object objs) {
		// TODO Auto-generated method stub
		System.out.println("FestViewService.excute()");
		// 원래는 excute()에 타입을 선언하였으나, ServInt에는 하나만 받을 수 있게 하였다
		// 따라서 두개인 타입을 ArrayList<>에 넣어서 꺼내 사용한다.
		@SuppressWarnings("unchecked")
		ArrayList<Object> executeObj = (ArrayList<Object>) objs;
		int truckno = (int) executeObj.get(0);
		boolean isView = (boolean) executeObj.get(1);

		FestTruckDTO truckDTO = null;
		// list에 데이터를 가져와서 채우는 프로그램 작성
		// 객체 생성하고 호출
		if (isView)
			truckDAO.increase(truckno); // 글보기일 때만 조회수 1증가
		truckDTO = truckDAO.view(truckno);
		return truckDTO;
	}
}
