package level2.exercise1;

import java.io.IOException;

public class DirectoryOrderMain {


    public static void main(String[] args) throws IOException {


        DirectoryOrder directoryOrder = new DirectoryOrder();
        directoryOrder.alphabeticDirectoryList();

        /*
        Para ejecutar el programa por consola se necesita estos comandos
        javac -d out src/main/java/level2/exercise1/DirectoryOrder.java src/main/java/level2/exercise1/DirectoryOrderMain.java
        java -cp out level2.exercise1.DirectoryOrderMain C:\Users\maxer\Desktop
         */
    }
}
