package com.foodtruck.fest.TruckService;

import com.foodtruck.fest.dao.FestTruckDAO;
import com.foodtruck.fest.dto.FestTruckDTO;
import com.foodtruck.util.ServiceInterface;

public class TruckUpdateService implements ServiceInterface {

	private FestTruckDAO truckDAO;

	@Override
	public void setDAO(Object obj) {
		// TODO Auto-generated method stub
		this.truckDAO = (FestTruckDAO) obj;
	}

	@Override
	public Integer execute(Object truckDTO) throws Exception {
		System.out.println("FestUpdateService.excute()");
		// 객체 생성하고 호출
		truckDAO.update((FestTruckDTO) truckDTO);
		return 1;
	}
}
