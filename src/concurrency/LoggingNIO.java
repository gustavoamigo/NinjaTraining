package concurrency;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;

import static java.nio.file.StandardOpenOption.*;

public class LoggingNIO {

    static Path path = FileSystems.getDefault().getPath("./app_nio.log");
    static BufferedWriter bufferedWriter;

    static {
        try {
            bufferedWriter = Files.newBufferedWriter(path, StandardCharsets.UTF_8, WRITE, APPEND, CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void info(String message) {
        String logLine = String.format("%s %s\n", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME), message);
        try {
            bufferedWriter.write(logLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Runnable buildThread(String threadName) {
        return new Runnable() {
            int counter = 0;
            @Override
            public void run() {
                while(true) {
                    LoggingNIO.info(threadName + " " + counter++);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }

    private static Runnable flushBuffer() {
        return () -> {
            while(true) {
                try {
                    Thread.sleep(1000);
                    bufferedWriter.flush();
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public static void main(String[] args) {
        Executors.defaultThreadFactory().newThread(flushBuffer() ).start();
        Executors.defaultThreadFactory().newThread(buildThread("Thread 1")).start();
        Executors.defaultThreadFactory().newThread(buildThread("Thread 2")).start();
        Executors.defaultThreadFactory().newThread(buildThread("Thread 3")).start();
    }
}
