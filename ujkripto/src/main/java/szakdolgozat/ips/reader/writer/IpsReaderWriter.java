package szakdolgozat.ips.reader.writer;

import com.fasterxml.jackson.databind.ObjectMapper;
import szakdolgozat.config.Config;
import szakdolgozat.ips.Ips;
import szakdolgozat.ips.add.exception.IpsAddException;
import szakdolgozat.ips.read.exception.IpsReadException;
import szakdolgozat.property.loader.PropertyLoader;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

public class IpsReaderWriter {


    private ReentrantLock lock = new ReentrantLock();
    private ObjectMapper mapper = new ObjectMapper();
    private String ipsJson = PropertyLoader.load(Config.PATH).getProperty(Config.Properties.IPS);

    public Ips read() {
        lock.lock();
        try {
            return mapper.readValue(new File(ipsJson), Ips.class);
        } catch (IOException e) {
            throw new IpsReadException();
        }finally {
            lock.unlock();
        }
    }

    public void add(final String ip) {
        lock.lock();
        try {
            Ips ips = mapper.readValue(new File(ipsJson), Ips.class);
            ips.add(ip);
            mapper.writeValue(new File(ipsJson), ips);
        } catch (IOException e) {
            throw new IpsAddException();
        }finally {
            lock.unlock();
        }
    }
}
