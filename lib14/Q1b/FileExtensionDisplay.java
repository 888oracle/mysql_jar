import java.io.File;
import java.util.Scanner;

public class FileExtensionDisplay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the directory path from the user
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        // Get the file extension from the user
        System.out.print("Enter the file extension (e.g., txt, pdf, etc.): ");
        String fileExtension = scanner.nextLine();

        // Create a File object for the specified directory
        File directory = new File(directoryPath);

        // Check if the directory exists
        if (directory.exists() && directory.isDirectory()) {
            // Get a list of files in the directory
            File[] files = directory.listFiles();

            if (files != null) {
                System.out.println("Files with extension ." + fileExtension + " in directory " + directoryPath + ":");

                // Iterate through the files and display those with the specified extension
                for (File file : files) {
                    if (file.isFile() && file.getName().toLowerCase().endsWith("." + fileExtension.toLowerCase())) {
                        System.out.println(file.getName());
                    }
                }
            } else {
                System.out.println("No files found in the specified directory.");
            }
        } else {
            System.out.println("Invalid directory path or directory does not exist.");
        }

        scanner.close();
    }
}