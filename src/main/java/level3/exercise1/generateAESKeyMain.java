package level3.exercise1;

import javax.crypto.SecretKey;
import java.io.File;
import java.util.Base64;

public class generateAESKeyMain {
    public static void main(String[] args) {
        try {
            FileEncryptor fileEncryptor = new FileEncryptor();
            SecretKey key = fileEncryptor.generateAESKey();

            System.out.println("Generated AES Key: " + Base64.getEncoder().encodeToString(key.getEncoded()));

            File inputFile = new File("C:/Users/maxer/IdeaProjects/TascaS1.05/src/main/java/level2/exercise1/result.txt");
            File encryptedFile = new File("C:/Users/maxer/IdeaProjects/TascaS1.05/src/main/java/level3/exercise1/filestxt/encrypted_file.txt");
            File decryptedFile = new File("C:/Users/maxer/IdeaProjects/TascaS1.05/src/main/java/level3/exercise1/filestxt/decrypted_file.txt");

            fileEncryptor.encryptedFile(key, inputFile, encryptedFile);
            System.out.println("File Encrypted Correctly!");

            fileEncryptor.decryptedFile(key, inputFile, decryptedFile);
            System.out.println("File Decrypted correctly!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
