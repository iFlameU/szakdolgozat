package szakdolgozat.property.loader;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertyLoader {

    public static Properties load(final String path) {
        final Properties properties = new Properties();
        try (InputStream inputStream = new FileInputStream(path)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static void store(final String path, final Properties properties) {
        try (OutputStream outputStream = new FileOutputStream(path)) {
            properties.store(outputStream, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
