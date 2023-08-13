package hw3.Task2;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();
        while (true) {
            try {
                menu.menu();
            } catch (IOException e) {
                System.out.println(e.getClass() + ": " + e.getMessage());
            }

        }

    }
}

class FileManager {
    UserInput userInput = new UserInput();

    private static boolean isFileExists(File file) {
        return file.exists() && !file.isDirectory();
    }

    private void writer() throws IOException {
        String path = userInput.getPathInput();
        File file = new File(path);
        if (isFileExists(file))
            throw new IOException("A file with that name already exists");

        try (FileWriter writer = new FileWriter(path)) {
            writer.write(userInput.getWriterInput());

            writer.flush();
        } catch (IOException e) {
            throw new IOException("The system cannot find the specified path, check path");

        }

    }

    private void reader() throws IOException {
        StringBuilder sb = new StringBuilder();
        Path path = Paths.get(userInput.getPathInput());
        Scanner scanFile = new Scanner(path);
        scanFile.useDelimiter(System.getProperty("line.separator"));

        File file = new File(path.toString());
        if (!file.exists())
            throw new IOException("The specified file cannot be found, check path");

        while (scanFile.hasNext()) {
            sb.append(scanFile.next());
        }
        scanFile.close();
        System.out.println(sb);

    }

    private void copier() throws IOException {
        System.out.println("The file to be copied");
        String pathRead = userInput.getPathInput();
        System.out.println("The file to be copied to");
        String pathWrite = userInput.getPathInput();

        File file = new File(pathWrite);
        if (isFileExists(file))
            throw new IOException("A file with that name already exists");

        try (FileReader reader = new FileReader(pathRead); FileWriter writer = new FileWriter(pathWrite)) {
            int c;

            while ((c = reader.read()) != -1) {
                writer.write((char) c);

                writer.flush();
            }

        } catch (IOException e) {
            throw new IOException(e);

        }
    }

    public void getWriter() throws IOException {
        writer();
    }

    public void getReader() throws IOException {
        reader();
    }

    public void getCopier() throws IOException {
        copier();
    }
}

class UserInput {
    Scanner input = new Scanner(System.in);

    private String pathInput() {
        System.out.print("\nEnter the absolute path to file: ");
        String absolutePath = input.next();

        System.out.print("\nEnter the file name (without the extension): ");
        String fileName = input.next() + ".txt";

        String path = absolutePath + "/" + fileName;

        return path;
    }

    private int menuInput() {
        int choice;
        while (true) {
            choice = input.nextInt();

            if (!(choice >= 1 && choice <= 4))
                throw new InputMismatchException("Input mismatch, enter a number in range 1 - 5");

            break;

        }
        return choice;
    }

    private String writerInput() {
        System.out.print("Enter the text of the document (without a line break): ");
        input.nextLine();
        String text = input.nextLine();

        return text;

    }

    public String getPathInput() {
        return pathInput();
    }

    public int getMenuInput() {
        return menuInput();
    }

    public String getWriterInput() {
        return writerInput();
    }
}

class Menu {
    public void menu() throws IOException {
        System.out.print(
                "\n1. Create new file \n2. Read file \n3. Copy file \n4. Exit \n\nSelect an action: ");

        UserInput userInput = new UserInput();
        int choice = userInput.getMenuInput();

        FileManager fileManager = new FileManager();
        switch (choice) {
            case 1:
                fileManager.getWriter();
                break;
            case 2:
                fileManager.getReader();
                break;
            case 3:
                fileManager.getCopier();
                break;
            case 4:
                System.exit(choice);
                break;
            default:
                break;
        }

    }
}
