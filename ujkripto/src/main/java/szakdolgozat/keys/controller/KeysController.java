package szakdolgozat.keys.controller;

import szakdolgozat.key.NamedKeyPair;
import szakdolgozat.keys.Keys;
import szakdolgozat.keys.reader.writer.KeysReaderWriter;

import java.security.KeyPair;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

public class KeysController {

    private static KeysController instance = new KeysController();
    private KeysReaderWriter keysReaderWriter = new KeysReaderWriter();

    private KeysController(){}

    public static KeysController getInstance() {
        return instance;
    }

    public void save(final String keyName, final KeyPair keyPair) {
        NamedKeyPair namedKeyPair = new NamedKeyPair();
        namedKeyPair.setName(keyName);
        namedKeyPair.setPublicKey(Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded()));
        namedKeyPair.setPrivateKey(Base64.getEncoder().encodeToString(keyPair.getPrivate().getEncoded()));
        keysReaderWriter.add(namedKeyPair);
    }

    public boolean contains(final String keyName) {
        return keysReaderWriter.read().stream().map(NamedKeyPair::getName).anyMatch(keyName::equals);
    }

    public NamedKeyPair get(final String keyName) {
        return keysReaderWriter.read().stream().filter(namedKeyPair -> namedKeyPair.getName().equals(keyName))
                .collect(Collectors.toList()).get(0);
    }

    public List<String> getAllKeyNames() {
        return keysReaderWriter.read().stream().map(NamedKeyPair::getName).collect(Collectors.toList());
    }
}
