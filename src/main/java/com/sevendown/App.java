package com.sevendown;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import static spark.Spark.*;
import spark.*;
import com.mongodb.util.JSON;
public class App 
{
    public static void main( String[] args ) throws UnknownHostException
    {
        MongoClient mongoClient = new MongoClient( "localhost" );
        final DB db = mongoClient.getDB( "toodo" );

        post(new Route("/lists") {
            @Override
            public Object handle(Request request, Response response) {
            	//TO-DO validate input
            	return db.getCollection("lists").insert((DBObject)JSON.parse(request.body()));
            }
         });


    }
}
