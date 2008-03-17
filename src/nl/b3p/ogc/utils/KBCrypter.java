/*
 * KBCrypter.java
 *
 * Created on 7 maart 2008, 10:07
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package nl.b3p.ogc.utils;

import java.net.URLDecoder;
import java.net.URLEncoder;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Chris
 */
public class KBCrypter {
    
    private static final Log log = LogFactory.getLog(KBCrypter.class);
    /**
     * Key waarmee de url wordt encrypt/decrypt.
     */
    protected final static String CHARSET = "US-ASCII";
    protected final static String encryptionAlgorithm = "DES";
    protected final static String encryptionMode = "ECB";
    protected final static String encryptionPadding = "PKCS5Padding";
    protected static SecretKey secretKey;
    protected static String cipherParameters;
    static {
        try {
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(encryptionAlgorithm);
            DESKeySpec desKeySpec = new DESKeySpec(KBConfiguration.KB_ENCRYPT_KEY.getBytes(CHARSET));
            secretKey = keyFactory.generateSecret(desKeySpec);
        } catch (Exception e) {
            log.error("error: ", e);
        }
        cipherParameters = encryptionAlgorithm + "/" + encryptionMode + "/" + encryptionPadding;
    }
    
    /**
     * Encrypt a string.
     *
     * @param clearText
     * @return clearText, encrypted
     */
    public static String encryptText(String clearText) throws Exception {
        if (clearText==null)
            throw new Exception("text to encrypt may not be null!");
        Base64 encoder = new Base64();
        Cipher c1 = Cipher.getInstance(cipherParameters);
        c1.init(c1.ENCRYPT_MODE, secretKey);
        byte clearTextBytes[];
        clearTextBytes = clearText.getBytes();
        byte encryptedText[] = c1.doFinal(clearTextBytes);
        String encryptedEncodedText = new String(encoder.encode(encryptedText), CHARSET);
        return URLEncoder.encode(encryptedEncodedText, "utf-8");
    }
    
    /**
     * Decrypt a string.
     *
     * @param encryptedText
     * @return encryptedText, decrypted
     */
    public static String decryptText(String encryptedText) throws Exception {
        if (encryptedText==null)
            return null;
        String et = URLDecoder.decode(encryptedText, "utf-8");
        Base64 decoder = new Base64();
        byte decodedEncryptedText[] = decoder.decode(et.getBytes(CHARSET));
        Cipher c1 = Cipher.getInstance(cipherParameters);
        c1.init(c1.DECRYPT_MODE, secretKey);
        byte[] decryptedText = c1.doFinal(decodedEncryptedText);
        String decryptedTextString = new String(decryptedText);
        return decryptedTextString;
    }
 }
