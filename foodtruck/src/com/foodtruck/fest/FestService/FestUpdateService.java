package com.foodtruck.fest.FestService;

import com.foodtruck.fest.dao.FestDAO;
import com.foodtruck.fest.dto.FestDTO;
import com.foodtruck.util.ServiceInterface;

public class FestUpdateService implements ServiceInterface {

	private FestDAO festDAO;

	@Override
	public void setDAO(Object obj) {
		// TODO Auto-generated method stub
		this.festDAO = (FestDAO) obj;
	}

	@Override
	public Integer execute(Object festDTO) throws Exception {
		System.out.println("FestUpdateService.excute()");
		// 객체 생성하고 호출
		festDAO.update((FestDTO) festDTO);
		return 1;
	}
}
