package level1.exercise1;

import java.io.File;
import java.util.Arrays;

public class DirectoryOrder {

    private String directoryPath;

    public DirectoryOrder(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public void alphabeticDirectoryList() {
        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("The Path doesn't exist or isn't a directory");
            return;
        }
        String[] directoryContent = directory.list();

        if (directoryContent != null) {
            Arrays.sort(directoryContent);

            System.out.println("Contains of " + directoryPath);
            for (String name : directoryContent) {
                System.out.println(name);
            }
        } else {
            System.out.println("The directory is empty or there was an error reading it!");
        }

    }

}
