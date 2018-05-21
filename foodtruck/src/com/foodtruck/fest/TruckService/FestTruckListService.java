package com.foodtruck.fest.TruckService;

import java.util.List;

import com.foodtruck.fest.dao.FestTruckDAO;
import com.foodtruck.fest.dto.FestTruckDTO;
import com.foodtruck.util.ServiceInterface;
import com.webjjang.util.PageObject2;

public class FestTruckListService implements ServiceInterface {

	private FestTruckDAO truckDAO;

	@Override
	public void setDAO(Object obj) {
		// TODO Auto-generated method stub
		this.truckDAO = (FestTruckDAO) obj;
	}

	@Override
	public List<FestTruckDTO> execute(Object obj) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("FestListService.excute()");
		List<FestTruckDTO> list = null;
		// list에 데이터를 가져와서 채우는 프로그램 작성
		// 호출만
		list = truckDAO.list((PageObject2) obj);
		return list;
	}
}
