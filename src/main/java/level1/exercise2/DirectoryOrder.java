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

        File[] archiveList = directory.listFiles();

        if (archiveList != null) {
            Arrays.sort(archiveList, (f1, f2) -> f1.getName().compareToIgnoreCase(f2.getName()));

            System.out.println("Contents of " + directoryPath);
            for (File file : archiveList) {

                String indent = " ".repeat(0);
                String type = file.isDirectory() ? "[D] " : "[F] ";
                Date date = new Date(file.lastModified());
                System.out.println(indent + type + " - " + file.getName() + " - " + date);

                if (file.isDirectory()) {
                    listDirectoryRecursive(file, 1);
                }
            }
        } else {
            System.out.println("The directory is empty or there was an error reading it!");
        }
    }

    private void listDirectoryRecursive(File file, int level) {
        File[] archiveList = file.listFiles();

        if (archiveList == null) {
            return;
        }
        Arrays.sort(archiveList, (f1, f2) -> f1.getName().compareToIgnoreCase(f2.getName()));

        for (File file1 : archiveList) {

            String indent = " ".repeat(level);
            String type = file1.isDirectory() ? "[D] " : "[F] ";
            Date date = new Date(file1.lastModified());
            System.out.println(indent + type + " - " + file1.getName() + " - " + date);

            if (file1.isDirectory()) {
                listDirectoryRecursive(file1, level + 1);
            }
        }
    }
}
