package level3.exercise1;

import javax.crypto.SecretKey;
import java.io.File;
import java.util.Base64;

public class ECBMain {
    public static void main(String[] args) {
        try {
            FileEncryptor fileEncryptor = new FileEncryptor();
            SecretKey key = fileEncryptor.generateAESKey();

            System.out.println("Generated AES Key: " + Base64.getEncoder().encodeToString(key.getEncoded()));

            File inputFile = new File("C:/Users/maxer/IdeaProjects/TascaS1.05/src/main/java/level2/exercise1/result.txt");
            File encryptedFile = new File("C:/Users/maxer/IdeaProjects/TascaS1.05/src/main/java/level3/exercise1/filestxt/encrypted_ecb.txt");
            File decryptedFile = new File("C:/Users/maxer/IdeaProjects/TascaS1.05/src/main/java/level3/exercise1/filestxt/decrypted_ecb.txt");

            fileEncryptor.encryptedFileECB(key, inputFile, encryptedFile);
            System.out.println("File Encrypted (ECB)!");

            fileEncryptor.decryptedFileECB(key, encryptedFile, decryptedFile);
            System.out.println("File Decrypted (ECB)!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
