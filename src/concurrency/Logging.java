package concurrency;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Logging {
    static ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(100);

    public static void info(String message) {
        while(true) {
            try {
                if (queue.offer(message, 30, TimeUnit.SECONDS)) break;
            } catch (InterruptedException e) {
            }

        }
    }

    private static Runnable consumerThread() {
        return () -> {
            try {
                File file = new File("./app.log");
                FileWriter writer = new FileWriter(file);
                while(true) {
                    String message = queue.poll(30, TimeUnit.SECONDS);
                    String logLine = String.format("%s %s\n", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME), message);
                    writer.write(logLine);
                    writer.flush();
                }
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
    }

    private static Runnable buildThread(String threadName) {
        return new Runnable() {
            int counter = 0;
            @Override
            public void run() {
                while(true) {
                    Logging.info(threadName + " " + counter++);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }

    public static void main(String[] args) {
        Executors.defaultThreadFactory().newThread(consumerThread()).start();
        Executors.defaultThreadFactory().newThread(buildThread("Thread 1")).start();
        Executors.defaultThreadFactory().newThread(buildThread("Thread 2")).start();
        Executors.defaultThreadFactory().newThread(buildThread("Thread 3")).start();
    }
}
