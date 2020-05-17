import java.io.*;

public class CopyFileText {
    public static void main(String[] args) {
        try {
            File originalFile = new File("OriginalFile.txt");

            if (!originalFile.exists()) {
                throw new FileNotFoundException();
            }

            File copyFile = new File("CopyFile.txt");
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
