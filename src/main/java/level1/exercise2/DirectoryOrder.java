package level1.exercise2;

import java.io.File;
import java.util.Arrays;
import java.util.Date;

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

        System.out.println("Contents of " + directoryPath);
        listDirectory(directory, 0);
    }

    private void listDirectory(File directory, int level) {
        File[] archiveList = directory.listFiles();

        if (archiveList == null) {
            System.out.println("The directory is empty or there was an error reading it!");
            return;
        }

        Arrays.sort(archiveList, (f1, f2) -> f1.getName().compareToIgnoreCase(f2.getName()));

        for (File file : archiveList) {
            String indent = " ".repeat(level * 2);
            String type = file.isDirectory() ? "[D] " : "[F] ";
            Date date = new Date(file.lastModified());

            System.out.println(indent + type + " - " + file.getName() + " - " + date);

            if (file.isDirectory()) {
                listDirectory(file, level + 1);
            }
        }
    }
}
