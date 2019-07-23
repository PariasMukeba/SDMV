package DAO;

/**
 * <h1>ProjectCollectionFactory</h1>
 * a factory class which encapsulate the access to the database's collection
 * the method getdbcollection is of the return type interface dbcollections
 * and it create an instance of every collection DAO
 * can be used as in the following example
 *{@code
 * BasicDBObject obj =  new BasicDBObject("name ", "Christian bokele");
 * dbcollections coll  = ProjectCollectionFactory.getdbcollections("tickets");
 * coll.getACollection("tickets").insert(obj);
 * System.out.println("Inserted chris");
 * }
 * @author Parias Lunkamba
 */
public class ProjectCollectionFactory {
    /**
     *
     * @param name the name of the the collection to be accessed
     * @return an instance of the collection DAO supplied in it is name
     * dbcollections coll  = ProjectCollectionFactory.getdbcollections("tickets");
     * the  for each collection need to create a collection DAO class and return it in this class as
     * {@code if(name.equalsIgnoreCase(myCollectionName) {
     *     return myCollectionName
     * }}
     */
    public static dbcollections getdbcollections(String name) {
        if(name.equalsIgnoreCase("tickets")){
            return new ticketsDAO();
        }
        else if(name.equalsIgnoreCase("infraction")){
            return new InfractionsDAO();
        }
        else if(name.equalsIgnoreCase("vehicle")) {
            return new VehicleDAO();
        }
        else if(name.equalsIgnoreCase("permis")) {
            return new PermisDAO();
        }
        return null;
    }
}
