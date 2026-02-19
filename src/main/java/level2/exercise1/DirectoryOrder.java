package level2.exercise1;

import java.io.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class DirectoryOrder {
    private final String directoryPath;
    private final String resultPath;

    public DirectoryOrder() throws FileNotFoundException {

        Properties properties = new Properties();
        try {
            /*
            El ejercicio pide hacerlo con FileInputStream pero entonces tienes que tener el config.properties
            en la raiz del programa o poner esta ruta tan larga para encontrarlo, pero para proyectos grandes
            no se recomienda porque la ruta es "Hardcoded"
            */
            properties.load(new FileInputStream("src/main/resources/config.properties"));

            /*
            Mejora ya que el archivo config.properties esta guardado en la carpeta Resources.
            properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
            */

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        directoryPath = properties.getProperty("directory.path");
        resultPath = properties.getProperty("result.file");
    }


    public void alphabeticDirectoryList() throws IOException {


        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("The Path doesn't exist or isn't a directory");
            return;
        }

        try (BufferedWriter resultFile = new BufferedWriter(new FileWriter(resultPath))) {
            listDirectoryRecursive(directory, 0, resultFile);
        }
        System.out.println("Directory contents, saved to " + resultPath);
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
