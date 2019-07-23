package props;

import database.MongoConnect;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Properties;

/**
 * A generic class that can be used to append or create a new .properties file
 * With one public method and a constructor.
 * @author Parias Lunkamba
 */
public class CreateProperty  {
    OutputStream file = null;
    Properties props = new Properties();

    /**
     * A constructor that accept a Map argument and set it to the properties
     * @param property of type{@code Map<String, String>}
     */
    public CreateProperty(Map<String, String> property) {
        for(Map.Entry<String, String> entry :property.entrySet()){
            props.setProperty(entry.getKey(), entry.getValue());
        }

    }

    /**
     * A public method that create a.properties file
      * @param path the string path or name of the file to be created example: createFile("src/main/resources/config.properties
     * @param append this is a boolean argument if true if append the properties to the existing file
     * crateFile("src/main/resources/config.properties", true);
     */
    public void createFile(String path, boolean append) {
        try {


            file = new FileOutputStream(path, append);
            props.store(file, "Dynamic property file");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
