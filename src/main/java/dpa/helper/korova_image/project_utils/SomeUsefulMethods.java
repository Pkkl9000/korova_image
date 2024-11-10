package dpa.helper.korova_image.project_utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class SomeUsefulMethods {

    static void createFile(String fileName, String extension, String path) {
        String fullFileName = path + fileName + extension;
        File file = new File(fullFileName);

        try {
            if (!file.createNewFile()) {
                System.out.println("File " + fileName + " already exists.");;
            }
        } catch (IOException e) {
            System.out.println("something went wrong during file creation");
            e.printStackTrace();
        }
    }

    static void writeToFile(String fileName, String path, String whatToWriteDown) {
        String fullFileName = path + fileName + ".txt";
        File file = new File(fullFileName);
        if (file.exists()) {
            try {
                FileWriter fw = new FileWriter(fullFileName); // Set true for append mode
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(whatToWriteDown);
                bw.newLine();
                bw.close();
            } catch (IOException e) {
                System.out.println("something went wrong while writing to the file.");
                e.printStackTrace();
            }
        } else {
            System.out.println("The file does not exist");
        }
    }

    //    filename with extension
    public static boolean checkIfFileExist(String fileName) {
        File file = new File(fileName);
        return file.exists();
    }

    //    char[] charArray0
    static void checkCharset(char[] charArray) {
        Charset charset = Charset.defaultCharset(); // Get the default charset

        // Convert the char array to a byte array using the specified charset
        byte[] byteArray = new String(charArray).getBytes(charset);

        System.out.println("Charset of char array: " + charset.displayName());
    }

    public static String getRelativePathToMyResources() {
        File projectDirectory = new File("");
        String projectPath = projectDirectory.getAbsolutePath();
        return projectPath.concat("\\src\\main\\resources\\");
    }

    public static String getRelativePathToFolderInResources(String folderName) {
        File projectDirectory = new File("");
        String projectPath = projectDirectory.getAbsolutePath();
        return projectPath.concat("\\src\\main\\resources\\".concat(folderName).concat("\\"));
    }

    static void makeTxtFileEmpty(String filePath) {
        File file = new File(filePath);

        if (file.length() == 0) {
            System.out.println("File is empty already.");
        } else {
            try (FileWriter fw = new FileWriter(file)) {
                fw.write("");
//                System.out.println("File is now empty.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

//    public static void renameFile(String oldName, String newName) {
//        oldName = new File("old_filename.txt");
//        newName = new File("new_filename.txt");
//
//        boolean isRenamed = oldName.renameTo(newName);
//
//        if (isRenamed) {
//            System.out.println("File renamed successfully.");
//        } else {
//            System.out.println("Could not rename the file.");
//        }
//    }

//    static void runCmd() {
//        try {
//            String[] command = {"cmd.exe", "/c", "start"};
//            Process process = Runtime.getRuntime().exec(command);
//            process.waitFor();
//        } catch (Exception e) {
//            System.out.println("something went wrong with CMD");
//            e.printStackTrace();
//        }
//    }



}

