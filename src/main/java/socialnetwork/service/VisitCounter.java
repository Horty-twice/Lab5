package socialnetwork.service;

import java.io.*;

public class VisitCounter {
    private final String filePath = "counter.txt";
    private int count;

    public VisitCounter() {
        count = readCounter();
    }

    public int getCount() {
        return count;
    }

    public void increment() {
        count++;
        saveCounter(count);
    }

    private int readCounter() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            return 0; // Если файл не существует или ошибка чтения
        }
    }

    private void saveCounter(int count) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(String.valueOf(count));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}