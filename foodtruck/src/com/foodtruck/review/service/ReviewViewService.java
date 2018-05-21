package com.foodtruck.review.service;

import java.util.ArrayList;

import com.foodtruck.review.dao.ReviewDAO;
import com.foodtruck.review.dto.ReviewDTO;
import com.foodtruck.util.ServiceInterface;

public class ReviewViewService implements ServiceInterface {

	private ReviewDAO reviewDAO;

	@Override
	public void setDAO(Object obj) {
		// TODO Auto-generated method stub
		this.reviewDAO = (ReviewDAO) obj;
	}

	@Override
	public ReviewDTO execute(Object objs) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(getClass().getName() + ".execute()");

		// 담아온 객체를 캐스팅해준다.
		@SuppressWarnings("unchecked")
		ArrayList<Object> list = (ArrayList<Object>) objs;
		System.out.println(list);
		System.out.println(list);
		System.out.println(list);
		System.out.println(list);
		System.out.println(list);
		// 담아온 no isView를 꺼내준다.
		// reviewDTO 객체를 만든다.
		int rno =(int) list.get(0);
		boolean isView = (boolean) list.get(1);
		ReviewDTO reviewDTO = null;
		System.out.println(isView);
		// view로 들어왔을 때는 hit를 1 올린다. update인 경우에는 안 올린다.
		if(isView) { reviewDAO.increase(rno);}
	
		// dao에서 담아온다.
		reviewDTO = reviewDAO.view(rno);

		return reviewDTO;
	}
}
