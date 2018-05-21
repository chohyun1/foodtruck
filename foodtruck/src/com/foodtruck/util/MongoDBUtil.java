package com.foodtruck.util;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions.Builder;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class MongoDBUtil {
	// 객체 생성시 필요한 정보
	// 기본 로컬 접속 시

	// 커넥션 풀을 만들기 위한 기본 설정
	static Builder options = new Builder();
	// 옵션 설정을 위한 메서드 설정
	static Builder options() {
		options.connectionsPerHost(30); // 시작 시 30개의 풀을 만들고 시작
		options.minConnectionsPerHost(10); // 최소 10개를 유지
		return options;
	}

	// maxPoolSize를 통해 최대 유지 가능한 커넥션 객체 갯수를 설정
	static MongoClientURI uri = new MongoClientURI("mongodb://localhost:27017/seoulpopulation?maxPoolSize=500",
			options());
	// 로컬 접속 시 사용할 MongoClient 객체
	public static MongoClient mongoClient = new MongoClient(uri);
	// // mLab을 이용하여 접속 할 때 이용할 uri와 MongoClient 객체

	// 접속 시 필요한 자료
	// 접속 시 databaseName을 파라메터로 넘겨서 접속한다.
	public static MongoDatabase getConnection(String databaseName) {
		return mongoClient.getDatabase(databaseName);
	}// end of getConnection()

}