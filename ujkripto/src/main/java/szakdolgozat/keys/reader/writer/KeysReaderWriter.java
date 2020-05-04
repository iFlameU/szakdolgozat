package szakdolgozat.keys.reader.writer;

import com.fasterxml.jackson.databind.ObjectMapper;
import szakdolgozat.config.Config;
import szakdolgozat.key.NamedKeyPair;
import szakdolgozat.keys.Keys;
import szakdolgozat.keys.add.exception.KeysAddException;
import szakdolgozat.keys.read.exception.KeysReadException;
import szakdolgozat.property.loader.PropertyLoader;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

public class KeysReaderWriter {

    private ReentrantLock lock = new ReentrantLock();
    private ObjectMapper mapper = new ObjectMapper();
    private String keysJson = PropertyLoader.load(Config.PATH).getProperty(Config.Properties.KEYS);

    public Keys read() {
        lock.lock();
        try {
            return mapper.readValue(new File(keysJson), Keys.class);
        } catch (IOException e) {
            throw new KeysReadException();
        }finally {
            lock.unlock();
        }
    }

    public void add(final NamedKeyPair namedKeyPair) {
        lock.lock();
        try {
            Keys keys = mapper.readValue(new File(keysJson), Keys.class);
            keys.add(namedKeyPair);
            mapper.writeValue(new File(keysJson), keys);
        } catch (IOException e) {
            throw new KeysAddException();
        }finally {
            lock.unlock();
        }
    }
}
