package com.foodtruck.fest.FestService;

import com.foodtruck.fest.dao.FestDAO;
import com.foodtruck.util.ServiceInterface;

public class FestDeleteService implements ServiceInterface {

	private FestDAO festDAO;

	@Override
	public void setDAO(Object obj) {
		// TODO Auto-generated method stub
		this.festDAO = (FestDAO) obj;
	}

	public Integer execute(Object festno) {
		System.out.println("FestDeleteService.excute()");

		festDAO.delete((int) festno);
		return 1;
	}

}
