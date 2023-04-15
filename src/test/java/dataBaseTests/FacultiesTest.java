package dataBaseTests;

import dataBase.Faculties;
import dataBase.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FacultiesTest {
    @Test
    public void getFacultyShouldReturnCorrectValue(){
        Assertions.assertSame(Faculties.FACULTY_OF_INFORMATICS,Faculties.getFaculty(1));
    }

    @Test
    public void getIndexShouldReturnCorrectValue(){
        Student student1 = new Student(1,"Nick","Lok",1,2001,2018);
        Assertions.assertSame(Faculties.getIndex(student1),1);
    }
}
