package szakdolgozat.decrypter;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Decrypter {
    public String decrypt(final String encryptedText, final String publicKeyAsString) {
        try {
            return tryDecrypt(encryptedText, publicKeyAsString);
        } catch (NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | BadPaddingException |
                IllegalBlockSizeException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String tryDecrypt(final String encryptedText, final String namedKeyPair)
            throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException,
            IllegalBlockSizeException, BadPaddingException {

        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, KeyFactory.getInstance("RSA").generatePublic(
                new X509EncodedKeySpec(Base64.getDecoder().decode(namedKeyPair.getBytes()))));
        return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedText)));
    }
}
