package com.foodtruck.data.dao;


import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
//import org.math.R.RserveSession;
//import org.math.R.Rsession;
//import org.math.R.Rsession.RException;

import com.foodtruck.util.MongoDBUtil;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class DataDAO {
	
//	public List<String> MongodbGetkey() {
//		
//		MongoDatabase mongoDatabase = MongoDBUtil.getConnection("seoulpopulation");
//		MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("salesData");
////		List<Document> list = null;
//		List<String> key = new ArrayList<String>();
//		List<Double> value = new ArrayList<Double>();
//		//mongodb에서 데이터를 가져오기
//		
//		//1. mongodb에서 데이터 가져오기.
//		MongoIterable<Document> mongoIterable = mongoCollection.find();
//		MongoCursor<Document> mongoCursor = mongoIterable.iterator();
//		while(mongoCursor.hasNext()) {
//			Document doc = mongoCursor.next();
//			//key, value를 분리
//			String instance1 = (String) doc.get("_id");
//			Double instance2 = doc.getDouble("value");
//			key.add(instance1);
//			value.add(instance2);
//			System.out.println(instance1);
//		}// end of while;
//		 
//		/*	데이터 확인 완료	*/
////		//데이터가 담긴것을 확인
////		for(String a: key) {
////			System.out.println(a);
////		}
////		for(Object b: value) {
////			System.out.println(b);
////		}
//		
//		double[] values = new double[value.size()];
//		for(int i = 0; i < value.size(); i++) {
//			values[i]=value.get(i);
////			System.out.println(values[i]);
//		}
//		
//		String[] keys = new String[key.size()];
//		for(int i = 0; i < key.size(); i++) {
//			keys[i]=key.get(i);
////			System.out.println(keys[i]);
//		}
//		
//		return key;
//		
//		
//	}// end of Mongodb()
	
	public List<Object> MongodbGetValues() throws Exception{
		//mongodb에서 데이터를 가져오기
		MongoDatabase mongoDatabase = MongoDBUtil.getConnection("seoulpopulation");
		MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("salesData");
		List<String> key = new ArrayList<String>();
		List<Double> value = new ArrayList<Double>();
		List<Object> values = new ArrayList<Object>();
		
		//1. mongodb에서 데이터 가져오기.
		MongoIterable<Document> mongoIterable = mongoCollection.find();
		MongoCursor<Document> mongoCursor = mongoIterable.iterator();
		while(mongoCursor.hasNext()) {
			Document doc = mongoCursor.next();
			//key, value를 분리
			String instance1 = (String) doc.get("_id");
			Double instance2 = doc.getDouble("value");
			key.add(instance1);
			value.add(instance2);
		}// end of while;
		
		/*	데이터 확인 완료	*/
//		//데이터가 담긴것을 확인
//		for(String a: key) {
//			System.out.println(a);
//		}
//		for(Object b: value) {
//			System.out.println(b);
//		}
		
		//생성한 값을 넣어주기
		values.add(key);
		values.add(value);
		
		return values;
		
		
	}// end of Mongodb()
	
//	public static void main(String args[]) throws RException {
//		//객체 생성
//		Rsession rsession = RserveSession.newInstanceTry(System.out, null);
//		MongoDatabase mongoDatabase = MongoDBUtil.getConnection("seoulpopulation");
//		MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("salesData");
////		List<Document> list = null;
//		List<String> key = new ArrayList<String>();
//		List<Double> value = new ArrayList<Double>();
//		//mongodb에서 데이터를 가져와서 저장하고 그걸 R라이브러리를 이용해서 해결
//		
////		String[] date = {"201611","201612","201701","201702","201703","201704","201705","201706","201707","201708"};
//		
//		//1. mongodb에서 데이터 가져오기.
//		MongoIterable<Document> mongoIterable = mongoCollection.find();
//		MongoCursor<Document> mongoCursor = mongoIterable.iterator();
//		while(mongoCursor.hasNext()) {
//			Document doc = mongoCursor.next();
//			//key, value를 분리
//			String instance1 = (String) doc.get("_id");
//			Double instance2 = doc.getDouble("value");
//			key.add(instance1);
//			value.add(instance2);
//			System.out.println(instance1);
//		}// end of while;
//		 
//		/*	데이터 확인 완료	*/
////		//데이터가 담긴것을 확인
////		for(String a: key) {
////			System.out.println(a);
////		}
////		for(Object b: value) {
////			System.out.println(b);
////		}
//		
//		double[] values = new double[value.size()];
//		for(int i = 0; i < value.size(); i++) {
//			values[i]=value.get(i);
////			System.out.println(values[i]);
//		}
//		
//		String[] keys = new String[key.size()];
//		for(int i = 0; i < key.size(); i++) {
//			keys[i]=key.get(i);
////			System.out.println(keys[i]);
//		}
//		
//		//2. 가져온 데이터 R로 처리하기
//		
//		// R라이브러리 등록
////		rsession.installPackage("ggplot2", true);
//		rsession.set("df_values", values);
//		rsession.set("df_keys", keys);
//		rsession.eval("df <- cbind.data.frame(df_keys,df_values)");
//		rsession.eval("plot(df)");
//		
//		//Rsession 닫기
//		rsession.end();
//		
//	}
}
