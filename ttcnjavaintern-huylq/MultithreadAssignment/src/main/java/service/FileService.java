package service;

import java.io.BufferedWriter;
import java.util.function.Predicate;

public interface FileService {
    void filterRecords(String sourceFile, String targetFile, Predicate<String> predicate);
    void writeRecordToFile(String record, BufferedWriter bufferedWriter);
}
