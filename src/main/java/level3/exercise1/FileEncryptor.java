package level3.exercise1;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileEncryptor {

    // Constants per a l'algorisme
    private static final String AES = "AES";
    private static final String AES_ECB = "AES/ECB/PKCS5Padding";
    private static final String AES_CBC = "AES/CBC/PKCS5Padding";

    // Mètode per generar la clau AES
    public SecretKey generateAESKey() throws Exception {

        // 1. Obtener instancia de KeyGenerator para AES
        KeyGenerator keyGen = KeyGenerator.getInstance(AES);

        // 2. Inicializar con tamaño de clave (128, 192 o 256 bits)
        keyGen.init(256);

        // 3. Generar la llave secreta en una variable nueva
        // SecretKey secretKey = keyGen.generateKey();

        //  Retornamos la clave para usarla en encriptación/desencriptación directamente sin guardar en otra variable.
        return keyGen.generateKey();
    }

    // Mètode per encriptar un fitxer
    public void encryptedFile(SecretKey key, File input, File output) throws Exception {
        Cipher cipher = Cipher.getInstance(AES_ECB);
        cipher.init(Cipher.ENCRYPT_MODE, key);


        try (FileInputStream fis = new FileInputStream(input); FileOutputStream fos = new FileOutputStream(output)) {

            byte[] fileBytes = new byte[fis.available()];
            fis.read(fileBytes);

            byte[] encryptedBytes = cipher.doFinal(fileBytes);

            fos.write(encryptedBytes);
        }
    }

    // Mètode per desencriptar un fitxer
    public void decryptedFile(SecretKey key, File input, File output) throws Exception {
        Cipher cipher = Cipher.getInstance(AES_ECB);
        cipher.init(Cipher.ENCRYPT_MODE, key);


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
}

    /*
    // Mètode per desencriptar un fitxer amb arxius de poc tamany.
    public void decryptedFile(SecretKey key, File input, File output) throws Exception {
    Cipher cipher = Cipher.getInstance(AES_ECB); cipher.init(Cipher.DECRYPT_MODE, key);
    try (FileInputStream fis = new FileInputStream(input);
    FileOutputStream fos = new FileOutputStream(output)) {
    byte[] encryptedBytes = new byte[fis.available()];
    fis.read(encryptedBytes);
    byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
    fos.write(decryptedBytes); } }
     */

    //Si fas CBC, pots afegir un mètode auxiliar per generar l'IV

