package dataBase;


import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Manager {

    private static File file;
    private static Scanner sc = new Scanner(System.in);

    public static List<Student> readFromFIle(String s) throws IOException {
        List<Student> list = new LinkedList<>();


        if(s.equals("1")){
            file = new File(".\\src\\main\\resources\\DataBaseSorted.txt");

        } else {
            file = new File(".\\src\\main\\resources\\DataBaseNonSorted.txt");
        }

        try (Reader bufferedReader = new BufferedReader(new FileReader(new File(file.toURI())));) {
            String headerOfFile = ((BufferedReader) bufferedReader).readLine();
            String line = ((BufferedReader) bufferedReader).readLine();
            String[] lineArray = new String[6];
            while (line != null) {
                lineArray = line.split(",");
                list.add(new Student(
                                Integer.parseInt(lineArray[0]),
                                lineArray[1],
                                lineArray[2],
                                Integer.parseInt(lineArray[3]),
                                Integer.parseInt(lineArray[4]),
                                Integer.parseInt(lineArray[5])
                        )
                );
                line = ((BufferedReader) bufferedReader).readLine();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return list;
    }

    public static void showStudentArrayList(@NotNull List<Student> list) {
        for (Student st: list) {
            System.out.println(st.toString());
        }
    }
}
