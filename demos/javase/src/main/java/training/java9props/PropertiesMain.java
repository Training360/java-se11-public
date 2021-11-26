package training.java9props;

import java.io.IOException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class PropertiesMain {

    @Deprecated()
    public static void main(String[] args) {
        try {
            ResourceBundle resourceBundle = new PropertyResourceBundle(
                    PropertiesMain.class.getResourceAsStream("/messages.properties")
            );

            System.out.println(resourceBundle.getString("test"));
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read properties file", ioe);
        }
    }


}
