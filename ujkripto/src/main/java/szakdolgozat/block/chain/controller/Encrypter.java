package szakdolgozat.block.chain.controller;

import szakdolgozat.key.NamedKeyPair;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class Encrypter {
    public String encrypt(final String textToEncrypt, final NamedKeyPair namedKeyPair) {
        try {
            return tryEncrypt(textToEncrypt, namedKeyPair);
        } catch (NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | BadPaddingException |
                IllegalBlockSizeException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String tryEncrypt(final String textToEncrypt, final NamedKeyPair namedKeyPair)
            throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException,
            InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, KeyFactory.getInstance("RSA").generatePrivate(
                new PKCS8EncodedKeySpec(Base64.getDecoder().decode(namedKeyPair.getPrivateKey().getBytes()))));
        return Base64.getEncoder().encodeToString(cipher.doFinal(textToEncrypt.getBytes()));
    }
}
