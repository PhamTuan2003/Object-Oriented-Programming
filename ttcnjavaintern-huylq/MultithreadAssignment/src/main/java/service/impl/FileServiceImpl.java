package service.impl;

import service.FileService;

import java.io.*;
import java.util.function.Predicate;

public class FileServiceImpl implements FileService {

    @Override
    public void filterRecords(String sourceFile, String targetFile, Predicate<String> predicate) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(targetFile))) {
            String record;
            while ((record = bufferedReader.readLine()) != null) {
                if (predicate.test(record)) {
                    writeRecordToFile(record, bufferedWriter);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeRecordToFile(String record, BufferedWriter bufferedWriter) {
        try {
            bufferedWriter.write(record);
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
