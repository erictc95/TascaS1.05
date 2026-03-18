package level3.exercise1;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileEncryptor {


    private static final String AES = "AES";
    private static final String AES_ECB = "AES/ECB/PKCS5Padding";
    private static final String AES_CBC = "AES/CBC/PKCS5Padding";


    public SecretKey generateAESKey() throws Exception {


        KeyGenerator keyGen = KeyGenerator.getInstance(AES);


        keyGen.init(256);


        return keyGen.generateKey();
    }


    public void encryptedFileECB(SecretKey key, File input, File output) throws Exception {
        Cipher cipher = Cipher.getInstance(AES_ECB);
        cipher.init(Cipher.ENCRYPT_MODE, key);


        try (FileInputStream fis = new FileInputStream(input); FileOutputStream fos = new FileOutputStream(output)) {

            byte[] fileBytes = new byte[fis.available()];
            fis.read(fileBytes);

            byte[] encryptedBytes = cipher.doFinal(fileBytes);

            fos.write(encryptedBytes);
        }
    }


    public void decryptedFileECB(SecretKey key, File input, File output) throws Exception {
        Cipher cipher = Cipher.getInstance(AES_ECB);
        cipher.init(Cipher.DECRYPT_MODE, key);


        try (FileInputStream fis = new FileInputStream(input); ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            byte[] filesBytes = baos.toByteArray();
            byte[] decryptedBytes = cipher.doFinal(filesBytes);

            try (FileOutputStream fos = new FileOutputStream(output)) {
                fos.write(decryptedBytes);
            }
        }
    }

    public void encryptedFileCBC(SecretKey key, File input, File output) throws Exception {
        Cipher cipher = Cipher.getInstance(AES_CBC);
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] iv = cipher.getIV();

        try (FileInputStream fis = new FileInputStream(input);
             FileOutputStream fos = new FileOutputStream(output)) {

            fos.write(iv);

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                byte[] encryptedBytes = cipher.update(buffer, 0, bytesRead);
                if (encryptedBytes != null) fos.write(encryptedBytes);
            }

            byte[] finalBytes = cipher.doFinal();
            if (finalBytes != null) fos.write(finalBytes);
        }
    }

    public void decryptedFileCBC(SecretKey key, File input, File output) throws Exception {
        Cipher cipher = Cipher.getInstance(AES_CBC);

        try (FileInputStream fis = new FileInputStream(input);
             FileOutputStream fos = new FileOutputStream(output)) {

            byte[] iv = new byte[16];
            fis.read(iv);

            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                byte[] decryptedBytes = cipher.update(buffer, 0, bytesRead);
                if (decryptedBytes != null) fos.write(decryptedBytes);
            }

            byte[] finalBytes = cipher.doFinal();
            if (finalBytes != null) fos.write(finalBytes);
        }
    }
}


