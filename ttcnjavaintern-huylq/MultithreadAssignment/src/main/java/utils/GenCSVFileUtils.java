package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static utils.Constants.*;

public class GenCSVFileUtils {
    private static int studentID = 1;
    private static int schoolID = 1;

    public static void genCSVFiles() {
        try {
            genStudentFile();
            genSchoolFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void genStudentFile() throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILENAME_STUDENT))) {
            StringBuilder randomStudentRecord = new StringBuilder();
            for (int i = 0; i < AMOUNT_OF_STUDENT_RECORDS; i++) {
                bufferedWriter.write(genRandomRecordForStudentFile(randomStudentRecord));
                bufferedWriter.newLine();
                randomStudentRecord.delete(0, randomStudentRecord.length());
            }
        }
    }

    private static void genSchoolFile() throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILENAME_SCHOOL))) {
            StringBuilder randomSchoolRecord = new StringBuilder();
            for (int i = 0; i < AMOUNT_OF_SCHOOL_RECORDS; i++) {
                bufferedWriter.write(genRandomRecordForSchoolFile(randomSchoolRecord));
                bufferedWriter.newLine();
                randomSchoolRecord.delete(0, randomSchoolRecord.length());
            }
        }
    }

    private static String genRandomRecordForStudentFile(StringBuilder randomStudentRecord) {
        randomStudentRecord.append(studentID++).append(",");
        randomStudentRecord.append(DEFAULT_STUDENT_NAMES[(int) (Math.random() * DEFAULT_STUDENT_NAMES.length)]).append(",");
        randomStudentRecord.append(DEFAULT_STUDENT_AGES[(int) (Math.random() * DEFAULT_STUDENT_AGES.length)]).append(",");
        randomStudentRecord.append((int) (Math.random() * DEFAULT_STUDENT_SCHOOL_IDS + 1));
        return randomStudentRecord.toString();
    }

    private static String genRandomRecordForSchoolFile(StringBuilder randomSchoolRecord) {
        randomSchoolRecord.append(schoolID++).append(",");
        randomSchoolRecord.append(DEFAULT_SCHOOL_NAMES[(int) (Math.random() * DEFAULT_SCHOOL_NAMES.length)]).append(",");
        randomSchoolRecord.append(DEFAULT_SCHOOL_LOCATIONS[(int) (Math.random() * DEFAULT_SCHOOL_LOCATIONS.length)]).append(",");
        randomSchoolRecord.append(DEFAULT_SCHOOL_ESTABLISHED_YEARS[(int) (Math.random() * DEFAULT_SCHOOL_ESTABLISHED_YEARS.length)]);
        return randomSchoolRecord.toString();
    }
}
