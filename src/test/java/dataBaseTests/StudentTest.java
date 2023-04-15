package dataBaseTests;

import dataBase.Faculties;
import dataBase.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StudentTest {

    @Test
    public  void studentsCreatedByCopyConstructorMustBeEqual(){
        Student student1 = new Student();
        Student student2 = new Student(student1);
        Assertions.assertEquals(student1,student2);
    }

    @Test
    public  void clonedStudentsMustBeEqual(){
        Student student1 = new Student(1,"Nick","Lok", Faculties.FACULTY_OF_BIOENGENERY.ordinal(),2001,2018);
        Student student2;
        try {
            student2 = (Student) student1.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals(student1,student2);
    }

    @Test
    public void shouldReturnTrueWhenTheStudentsAreTheSame(){
        Student student1 = new Student(1,"Nick","Lok", Faculties.FACULTY_OF_BIOENGENERY.ordinal(),2001,2018);
        Student student2 = new Student(student1);

        Assertions.assertTrue(student1.equals(student2));
    }

}

