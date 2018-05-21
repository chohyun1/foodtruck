package com.foodtruck.data.service;

import java.util.List;

import com.foodtruck.data.dao.DataDAO;
import com.foodtruck.util.ServiceInterface;

public class getValues implements ServiceInterface{

private DataDAO dataDAO;

	
	@Override
	public void setDAO(Object obj) {
		// TODO Auto-generated method stub
		this.dataDAO = (DataDAO) obj;
	}

	@Override
	public List<Object> execute(Object obj) throws Exception {
		// TODO Auto-generated method stub
		List<Object> value = null;
		
		value = dataDAO.MongodbGetValues();
		
		return value;
	}

}
