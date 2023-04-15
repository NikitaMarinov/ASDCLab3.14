package dataBaseTests;

import dataBase.Manager;
import dataBase.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;


public class ManagerTest {

    @Test
    public void methodReadFromFIleShouldReturnNotEmptyList() throws IOException {
            List<Student> list = Manager.readFromFIle("1");

            Assertions.assertNotEquals(0, list.size());
        }

    @Test
    public void showStudentArrayListShouldOutputValues() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); // создаем объект для перенаправления вывода
        PrintStream printStream = new PrintStream(outputStream); // устанавливаем printStream как стандарный вывод
        System.setOut(printStream);                              // используя System.setOut()

        List<Student> list = Manager.readFromFIle("1");
        Manager.showStudentArrayList(list);

        String output = outputStream.toString();

        Assertions.assertNotEquals("",output);
    }

}

