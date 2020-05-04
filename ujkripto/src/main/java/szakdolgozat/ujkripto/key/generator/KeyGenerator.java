package szakdolgozat.ujkripto.key.generator;

import szakdolgozat.ujkripto.key.generator.exception.KeyGeneratorException;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class KeyGenerator {
    public KeyPair generateKey() {
        try {
            return tryGenerateKey();
        } catch (NoSuchAlgorithmException exception) {
            throw new KeyGeneratorException();
        }
    }

    private KeyPair tryGenerateKey() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(1024);
        return keyGen.generateKeyPair();
    }
}
