package level1.exercise3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

public class DirectoryOrder {
    private String directoryPath;
    private static final String resultPath = "result.txt";

    public DirectoryOrder(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public void alphabeticDirectoryList() throws IOException {
        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("The Path doesn't exist or isn't a directory");
            return;
        }

        File[] archiveList = directory.listFiles();

        if (archiveList != null) {
            Arrays.sort(archiveList, (f1, f2) -> f1.getName().compareToIgnoreCase(f2.getName()));

            BufferedWriter resultFile = new BufferedWriter(new FileWriter(resultPath));

            System.out.println("Contents of " + directoryPath);
            for (File file : archiveList) {

                String indent = " ".repeat(0);
                String type = file.isDirectory() ? "[D] " : "[F] ";
                Date date = new Date(file.lastModified());


                resultFile.write(indent + type + " - " + file.getName() + " - " + date + "\n");

                if (file.isDirectory()) {
                    listDirectoryRecursive(file, 1, resultFile);
                }
            }

            resultFile.close();

        } else {
            System.out.println("The directory is empty or there was an error reading it!");
        }
    }

    private void listDirectoryRecursive(File file, int level, BufferedWriter resultFile) throws IOException {
        File[] archiveList = file.listFiles();

        if (archiveList == null) {
            return;
        }
        Arrays.sort(archiveList, (f1, f2) -> f1.getName().compareToIgnoreCase(f2.getName()));

        for (File file1 : archiveList) {

            String indent = " ".repeat(level);
            String type = file1.isDirectory() ? "[D] " : "[F] ";
            Date date = new Date(file1.lastModified());
            resultFile.write(indent + type + " - " + file1.getName() + " - " + date + "\n");

            if (file1.isDirectory()) {
                listDirectoryRecursive(file1, level + 1, resultFile);
            }
        }
    }
}
