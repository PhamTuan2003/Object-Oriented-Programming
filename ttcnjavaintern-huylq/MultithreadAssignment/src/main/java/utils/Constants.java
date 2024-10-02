package utils;

public class Constants {
    public static final String FILENAME_STUDENT = "students.csv";
    public static final String FILENAME_SCHOOL = "schools.csv";
    public static final String FILENAME_RESULT = "results.csv";

    public static final int AMOUNT_OF_STUDENT_RECORDS = 10_000_000;
    public static final int AMOUNT_OF_SCHOOL_RECORDS = 500_000;

    public static final String[] DEFAULT_STUDENT_NAMES = {"Huy", "Hung", "Toan", "Duc", "Hoang", "Duy"};
    public static final int[] DEFAULT_STUDENT_AGES = {18, 19, 20, 21, 22, 23, 24, 25};
    public static final int DEFAULT_STUDENT_SCHOOL_IDS = AMOUNT_OF_SCHOOL_RECORDS;

    public static final String[] DEFAULT_SCHOOL_NAMES = {"PTIT", "HUST", "UET", "FPT", "HAUI"};
    public static final String[] DEFAULT_SCHOOL_LOCATIONS = {"HaDong", "BacTuLiem", "NamTuLiem", "HoangMai", "DuyTan"};
    public static final int[] DEFAULT_SCHOOL_ESTABLISHED_YEARS = {1996, 2000, 1995, 1992};
}
