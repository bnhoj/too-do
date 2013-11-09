package com.sevendown;

import java.net.UnknownHostException;
import java.util.Set;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class App 
{
    public static void main( String[] args ) throws UnknownHostException
    {
        MongoClient mongoClient = new MongoClient( "localhost" );
        DB db = mongoClient.getDB( "toodo" );
        Set<String> colls = db.getCollectionNames();

        for (String s : colls) {
            System.out.println(s);
        }
    }
}
