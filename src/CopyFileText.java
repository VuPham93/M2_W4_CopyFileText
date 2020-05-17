import java.io.*;
import java.util.Scanner;

public class CopyFileText {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the path of file you want to copy: ");
        String originalFilePath = scanner.nextLine();


        System.out.print("Please enter the path to create a copy: ");
        String copyFilePath = scanner.nextLine();

        copyFile(originalFilePath, copyFilePath);
    }

    public static void copyFile(String originalFilePath, String copyFilePath) {
        try {
            File originalFile = new File(originalFilePath);

            if (!originalFile.exists()) {
                throw new FileNotFoundException();
            }

            File copyFile = new File(copyFilePath);
            if (copyFile.createNewFile()) {
                System.out.println("File created: " + copyFile.getName());
            } else {
                System.out.println("File already exists.");
            }

            FileReader fileReader = new FileReader(originalFile);
            BufferedReader reader = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter(copyFile);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            String line = "";

            while ((line = reader.readLine()) != null) {
                fileWriter.write(line);
            }

            reader.close();
            writer.close();
            System.out.println("Successfully copy the file.");
        }
        catch (IOException e) {
            System.out.println("An error occurred while copy.");
        }
        catch (Exception e) {
            System.err.println("File not found or can't read file!");
        }
    }
}
