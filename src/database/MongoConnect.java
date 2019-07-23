package database;

import com.mongodb.DB;
import com.mongodb.MongoClient;

import java.io.InputStream;
import java.util.Properties;

/**
 * <h1>MongoConnect</h1>
 * is a singleton class that provide a single instance of the MongoClient that can be used everywhere in the app
 * in the private constructor it initialize the MongoClient as well as giving an instance to the Database
 * the database name and all others configuration should be accessed through th config.properties
 * @author Parias Lunkamba
 * @version 1.0.0
 * @since 2019
 */

public class MongoConnect {
    //intialise the instance to null so that the program can check it to know if it had already connected to the client
    private static MongoConnect mongoConnect = null;
    private MongoClient mongoClient = null;
    private DB mongoDatabase= null;




    public static MongoConnect getInstance() {
        if(mongoConnect == null) {
            mongoConnect= new MongoConnect();
        }
        return mongoConnect;
    }

    /**
     * private constructor that load the properties and initialize the MongoClient
     */
    private MongoConnect() {
        try {
            // load the config.properties file frok the ressource
            InputStream input = MongoConnect.class.getClassLoader().getResourceAsStream("config.properties");
            //instance of the properties class

            Properties prop = new Properties();
            if(input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            //load the file config.properties
            prop.load(input);

            //crate an empty instance of the MongoClient() it can be passed MongoClientURI as per java driver docs
            mongoClient = new MongoClient();

            // get the database used in the app
            mongoDatabase = mongoClient.getDB(prop.getProperty("db"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     *  public method that can be called outside of the class that return a connection to the database
     * @return mongoDatabase which is the Database used in the project
     */

    public DB getDB() {
        return mongoDatabase;
    }


}
