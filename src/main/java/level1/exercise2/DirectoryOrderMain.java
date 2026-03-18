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

    }
}
