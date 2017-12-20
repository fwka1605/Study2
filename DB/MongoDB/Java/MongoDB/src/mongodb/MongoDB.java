/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongodb;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


import java.util.Set;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author NVLCLT13
 */
public class MongoDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String hostName = "localhost";
        String databaseName = "study";
        String collectionName = "user";
        
        // 利用するマシンに接続
        MongoClient mongoClient = new MongoClient(hostName, 27017);

        // 利用するDBに接続
        MongoDatabase mongoDb = mongoClient.getDatabase(databaseName );
        
        // 利用するコレクションに接続
        MongoCollection<Document> coll = mongoDb.getCollection(collectionName);

        // コレクション内のドキュメント件数を取得する
        long count = coll.count();
        System.out.println(count);
        
        String doc = "";
        FindIterable<Document> iterator = coll.find();
        MongoCursor cursor = iterator.iterator();

        /*
            Documetの一覧の取得
        */
        doc = "";
        iterator = coll.find();
        cursor = iterator.iterator();
        while(cursor.hasNext()){
            doc += cursor.next();
            doc += System.getProperty("line.separator");
        }
        System.out.println(doc); 
        
        /*
            Documetの取得（条件：name=mr.b）
        */
        Document query = new Document("name", "mr.b");

        iterator = coll.find(query);
        cursor = iterator.iterator();

        doc="";
        while(cursor.hasNext()){
            doc += cursor.next();
            doc += System.getProperty("line.separator");
        }
        System.out.println(doc);

        /*
            Documetの取得（複数条件：name=mr.b,age=20）
        */
        Map<String, Object> map = new HashMap<String, Object>(){
            {put("name", "mr.b");}
            {put("age", 20);}
        };
        query = new Document(map);        

        iterator = coll.find(query);
        cursor = iterator.iterator();

        doc="";
        while(cursor.hasNext()){
            doc += cursor.next();
            doc += System.getProperty("line.separator");
        }
        
        System.out.println(doc);
       
        /*
            データの新規登録
        */
        List<String> hobbyList = new LinkedList<String>();
        hobbyList.add("vi");
        hobbyList.add("programming");
                
        Document newDocument = new Document();
        
        newDocument.append("name", "mr.d");
        newDocument.append("age", "40.0");
        newDocument.append("gender", "y");
        newDocument.append("hobbies", hobbyList);

        coll.insertOne(newDocument);
        
        /*
            データの更新
        */        
        Document updateDocument = new Document("gender","z");
        coll.updateOne(Filters.eq("name", "mr.b"), new Document("$set", updateDocument));


        /*
            データの削除
        */        
        coll.deleteOne(Filters.eq("_id", new ObjectId("58afc1b612d22a1894bb36c0")));

        
        
        mongoClient.close();
    }
    
}
