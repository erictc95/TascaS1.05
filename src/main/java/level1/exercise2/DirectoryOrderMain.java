package level1.exercise2;

public class DirectoryOrderMain {


    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Error: You must provide a directory path as argument.");
            return;
        }

        String path = args[0];

        DirectoryOrder directoryOrder = new DirectoryOrder(path);
        directoryOrder.alphabeticDirectoryList();

        /*
        Para ejecutar el programa por consola se necesita estos comandos
        javac -d out src/main/java/level1/exercise2/DirectoryOrder.java src/main/java/level1/exercise2/DirectoryOrderMain.java
        java -cp out level1.exercise2.DirectoryOrderMain C:\Users\maxer\Desktop
         */
    }
}
