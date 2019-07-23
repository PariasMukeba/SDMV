package DAO;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import database.MongoConnect;

/**
 * <h1>dbcollection interface</h1>
 * this interface is the beginning of our polymorphism
 * used to create a factory to the Data access object DAO classes
 * as an abstract method that should be overridden by every class that implements it
 * it define and declare and get an get the database
 * @author Parias Lunkamba
 */

public interface dbcollections {
    DB database = MongoConnect.getInstance().getDB();

    /**
     * public abstract method that return the connection to the database colletion
     * this collection can be used for insert, any operation on the collection can be performed
     * @param name the string name of the collection to be returned
     * @return DBCollection which mongo instance to the Database's collection
     */
    public DBCollection getACollection(String name);
}
