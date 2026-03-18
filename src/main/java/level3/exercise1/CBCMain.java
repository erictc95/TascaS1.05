package level3.exercise1;

import javax.crypto.SecretKey;
import java.io.File;
import java.util.Base64;

public class CBCMain {
    public static void main(String[] args) {
        try {
            FileEncryptor fileEncryptor = new FileEncryptor();
            SecretKey secretKey = fileEncryptor.generateAESKey();

            System.out.println("Generated AES Key: " + Base64.getEncoder().encodeToString(secretKey.getEncoded()));

            File inputFile = new File("C:/Users/maxer/IdeaProjects/TascaS1.05/src/main/java/level2/exercise1/result.txt");
            File encryptedFile = new File("C:/Users/maxer/IdeaProjects/TascaS1.05/src/main/java/level3/exercise1/filestxt/encrypted_cbc.txt");
            File decryptedFile = new File("C:/Users/maxer/IdeaProjects/TascaS1.05/src/main/java/level3/exercise1/filestxt/decrypted_cbc.txt");

            fileEncryptor.encryptedFileCBC(secretKey, inputFile, encryptedFile);
            System.out.println("File Encrypted (CBC)!");

            fileEncryptor.decryptedFileCBC(secretKey, encryptedFile, decryptedFile);
            System.out.println("File Decrypted (CBC)!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
