package com.foodtruck.util;

public interface ServiceInterface {
	public void setDAO(Object obj);

	public Object execute(Object obj) throws Exception;
}
