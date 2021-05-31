package automateIt.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public final class ReadPropertyFile {

    private ReadPropertyFile(){}

    public static String getProperty(String key){
        Properties prop=null;
        try {
            FileInputStream fis = new FileInputStream(new File
                    (System.getProperty("user.dir")+"/resources/automation.properties"));
             prop= new Properties();
            prop.load(fis);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }
}