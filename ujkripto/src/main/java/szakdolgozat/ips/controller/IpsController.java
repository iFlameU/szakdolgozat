package szakdolgozat.ips.controller;

import szakdolgozat.ips.Ips;
import szakdolgozat.ips.reader.writer.IpsReaderWriter;

public class IpsController {

    private static final IpsController instance = new IpsController();
    private IpsReaderWriter ipsReaderWriter = new IpsReaderWriter();

    private IpsController(){}

    public static IpsController getInstance() {
        return instance;
    }

    public Ips getIps() {
        return ipsReaderWriter.read();
    }

    public void add(final String ip) {
        if(!ipsReaderWriter.read().contains(ip)) ipsReaderWriter.add(ip);
    }
}
