package hust.soict.hespi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) {
        String filename = "test.exe"; 
        long startTime, endTime;
        byte[] inputBytes = {0};

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
            startTime = System.currentTimeMillis();
            
            String outputString = "";
            for (byte b : inputBytes) {
                outputString += (char)b;
            }
            
            endTime = System.currentTimeMillis();
            System.out.println("Processing time with + operator: " + (endTime - startTime) + " ms");
            
        } catch (IOException e) {
            System.out.println("Khong doc duoc file " + filename);
        }
    }
}