package com.foodtruck.fest.TruckService;

import com.foodtruck.fest.dao.FestTruckDAO;
import com.foodtruck.fest.dto.FestTruckDTO;
import com.foodtruck.util.ServiceInterface;

public class TruckWriteService implements ServiceInterface {

	private FestTruckDAO truckDAO;

	@Override
	public void setDAO(Object obj) {
		// TODO Auto-generated method stub
		this.truckDAO = (FestTruckDAO) obj;
	}

	@Override
	public Integer execute(Object truckDTO) {
		System.out.println("TruckWriteService.excute()");
		truckDAO.write((FestTruckDTO) truckDTO);
		return 1;
	}

}
