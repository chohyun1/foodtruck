package com.foodtruck.fest.TruckService;

import com.foodtruck.fest.dao.FestTruckDAO;
import com.foodtruck.util.ServiceInterface;

public class TruckDeleteService implements ServiceInterface {

	private FestTruckDAO truckDAO;

	@Override
	public void setDAO(Object obj) {
		// TODO Auto-generated method stub
		this.truckDAO = (FestTruckDAO) obj;
	}

	public Integer execute(Object truckno) {
		System.out.println("TruckDeleteService.excute()");

		truckDAO.delete((int) truckno);
		return 1;
	}

}
