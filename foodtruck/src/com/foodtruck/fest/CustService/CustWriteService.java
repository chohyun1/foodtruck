package com.foodtruck.fest.CustService;

import com.foodtruck.fest.dao.FestCustDAO;
import com.foodtruck.fest.dto.FestCustDTO;
import com.foodtruck.util.ServiceInterface;

public class CustWriteService implements ServiceInterface {

	private FestCustDAO custDAO;

	@Override
	public void setDAO(Object obj) {
		// TODO Auto-generated method stub
		this.custDAO = (FestCustDAO) obj;
	}

	@Override
	public Integer execute(Object custDTO) {
		System.out.println("CustWriteService.execute()");
		custDAO.write((FestCustDTO) custDTO);
		return 1;
	}

}
