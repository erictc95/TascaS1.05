package level1.exercise3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

public class DirectoryOrder {
    private final String directoryPath;
    private static final String resultPath = System.getProperty("user.dir") + File.separator + "result.txt";

    public DirectoryOrder(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public void alphabeticDirectoryList() throws IOException {
        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("The Path doesn't exist or isn't a directory");
            return;
        }

        File outputDir = new File("output");
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }


        File resultFilePath = new File(outputDir, "result.txt");

        try (BufferedWriter resultFile = new BufferedWriter(new FileWriter(resultFilePath))) {
            listDirectoryRecursive(directory, 0, resultFile);
        }
        System.out.println("Directory contents, saved to " + resultFilePath);
    }

    private void listDirectoryRecursive(File file, int level, BufferedWriter resultFile) throws IOException {
        File[] archiveList = file.listFiles();

        if (archiveList == null) {
            return;
        }
        Arrays.sort(archiveList, (f1, f2) -> f1.getName().compareToIgnoreCase(f2.getName()));

        for (File file1 : archiveList) {

            String indent = "  ".repeat(level);
            String type = file1.isDirectory() ? "[D] " : "[F] ";
            Date date = new Date(file1.lastModified());
            resultFile.write(indent + type + " - " + file1.getName() + " - " + date + "\n");

            if (file1.isDirectory()) {
                listDirectoryRecursive(file1, level + 1, resultFile);
            }
        }
    }
}
