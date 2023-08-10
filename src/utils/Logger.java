package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class Logger {
    private static final String FILE_PATH = "log.txt";

    public void log(String message) {
        String timestampedMessage = "[" + LocalDateTime.now() + "] " + message;

        System.out.println(timestampedMessage);

        try (PrintWriter out = new PrintWriter(new FileWriter(FILE_PATH, true))) {
            out.println(timestampedMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
