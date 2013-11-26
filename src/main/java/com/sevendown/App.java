package com.sevendown;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;

import java.net.UnknownHostException;

import javax.net.ssl.SSLEngineResult.Status;

import org.bson.types.ObjectId;

import spark.Request;
import spark.Response;
import spark.Route;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;
public class App 
{
    public static void main( String[] args ) throws UnknownHostException
    {
        MongoClient mongoClient = new MongoClient( "localhost" );
        final DB db = mongoClient.getDB( "toodo" );

        get(new Route("/") {
        	@Override
        	public Object handle(Request request, Response response) {
        		//TO-DO this should return the html and js needed for the app.
        		return null;
        	}
        });
        
        
        post(new Route("/lists") {
            @Override
            public Object handle(Request request, Response response) {
            	//TO-DO validate input
            	return saveOrUpdate(db, request);
            }
         });
        
        get(new Route("/lists") {
        	@Override
        	public Object handle(Request request, Response response) {
        		return com.mongodb.util.JSON.serialize(db.getCollection("lists").find());
        	}
        });
        
        put(new Route("/lists/*") {
        	@Override
        	public Object handle(Request request, Response response) {
        		//TO-DO validate input
        		return saveOrUpdate(db, request);
        	}

        });

        delete(new Route("/lists/*") {
        	@Override
        	public Object handle(Request request, Response response) {
        		//TO-DO validate input?
        		db.getCollection("lists").remove(new BasicDBObject().append("_id", new ObjectId(request.splat()[0])));
        		return Status.OK;
        	}
        	
        });
        
    }
    
    private static Object saveOrUpdate(final DB db, Request request) {
    	return db.getCollection("lists").save((DBObject)JSON.parse(request.body()));
    }
}
