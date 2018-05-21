package com.foodtruck.fest.FestService;

import com.foodtruck.fest.dao.FestDAO;
import com.foodtruck.fest.dto.FestDTO;
import com.foodtruck.util.ServiceInterface;

public class FestWriteService implements ServiceInterface {

	private FestDAO festDAO;

	@Override
	public void setDAO(Object obj) {
		// TODO Auto-generated method stub
		this.festDAO = (FestDAO) obj;
	}

	@Override
	public Integer execute(Object festDTO) {
		System.out.println("FestWriteService.excute()");
		festDAO.write((FestDTO) festDTO);
		return 1;
	}

}
