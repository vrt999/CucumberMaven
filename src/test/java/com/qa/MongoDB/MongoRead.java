package com.qa.MongoDB;

import java.util.Arrays;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoRead {
	
	public void getMongoData() {
		MongoClient mongodb = new MongoClient("127.0.0.1",27017);
		System.out.println("Mongo DB connected successfully");
		MongoDatabase db = mongodb.getDatabase("jarvis");
		AggregateIterable<Document> referencedata =  db.getCollection("referencedata").
						aggregate(Arrays.asList(new Document("$match",new Document("company.title","YURTURE").append("company.email","aureliagonzales@yurture.com")),
						new Document("$project",new Document("lastname",1).append("company", 1))));
		MongoCursor<Document> cursor = referencedata.cursor();
		boolean isDataPresent = cursor.hasNext(); 		
		System.out.println("isDataPresent: " + isDataPresent);	
		if(isDataPresent) {
			Document doc = cursor.next();
			System.out.println("Mongo Document: \n " + doc.toJson());
			String companyTitle = doc.getEmbedded(Arrays.asList("company", "location","country"), String.class);
			String lastname = doc.get("lastname",String.class);
			System.out.println("Company location country: " + companyTitle + ", Last name: " + lastname);
		}
		mongodb.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MongoRead mongoreader = new MongoRead();
		mongoreader.getMongoData();
	}

}
