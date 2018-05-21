package com.foodtruck.fest.CustService;

import com.foodtruck.fest.dao.FestCustDAO;
import com.foodtruck.util.ServiceInterface;

public class CustDeleteService implements ServiceInterface {

	private FestCustDAO custDAO;

	@Override
	public void setDAO(Object obj) {
		// TODO Auto-generated method stub
		this.custDAO = (FestCustDAO) obj;
	}

	public Integer execute(Object custno) {
		System.out.println("CustDeleteService.excute()");

		custDAO.delete((int) custno);
		return 1;
	}

}
