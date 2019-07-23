package DAO;

import com.mongodb.DBCollection;

/**
 * <h1>INFRACTIONS DATA ACESS OBJECT</h1>
 * <h2>VehicleDAO class</h2>
 * <p>This the Infraction collection data access object class
 * this class give access only to the infractions collections of our database</p>
 * @author Parias Lunkamba
 */

public class VehicleDAO implements dbcollections{
    private DBCollection collection = null;
    /**
     * override the getACollection method of the interface
     * @param name which is the name of the collection to be accessed
     * @return DBCollection collection which is a collection in our database
     */
    public DBCollection  getACollection(String name) {
        collection = database.getCollection(name);
        return collection;
    }
}
