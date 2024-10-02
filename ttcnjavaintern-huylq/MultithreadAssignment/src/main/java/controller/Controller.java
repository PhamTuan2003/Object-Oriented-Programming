package controller;

import service.FileService;
import service.impl.FileServiceImpl;
import utils.GenCSVFileUtils;

import static utils.Constants.FILENAME_RESULT;
import static utils.Constants.FILENAME_STUDENT;

public class Controller {
    private static final FileService fileService = new FileServiceImpl();

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        GenCSVFileUtils.genCSVFiles();
        fileService.filterRecords(FILENAME_STUDENT, FILENAME_RESULT, record -> getStudentAge(record) == 20);
        System.out.println("Total time: " + (System.currentTimeMillis() - start) + " milliseconds");
    }

    private static int getStudentAge(String studentRecord) {
        return Integer.parseInt(studentRecord.split(",")[2]);
    }
}
