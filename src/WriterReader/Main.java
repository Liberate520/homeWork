package WriterReader;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        File f = new File("C://text.txt");
        FileHandler fileHandler = new FileHandler("текст");
        fileHandler.WriteAndReadFile(fileHandler, f);
    }
}
