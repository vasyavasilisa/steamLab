package framework.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by USER on 10.05.2017.
 */
public class CommonFunctions {

    private static final String BROWSER_PROPERTIES_PATH="brouser.properties";


    public Properties readProperties(){
        File ff = new File(getClass().getClassLoader().getResource(BROWSER_PROPERTIES_PATH).getFile());
        FileInputStream fis= null;
        Properties property = new Properties();
        try {
            fis = new FileInputStream(ff);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            property.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return property;
    }


}
