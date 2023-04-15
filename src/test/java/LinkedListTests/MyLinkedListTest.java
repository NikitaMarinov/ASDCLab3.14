package LinkedListTests;
import MyLinkedList.MyLinkedList;
import dataBase.Manager;
import dataBase.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public class MyLinkedListTest {
    private MyLinkedList myLinkedList;
    private List<Student> list;

    @BeforeEach
    public void newList() throws IOException {
        myLinkedList = new MyLinkedList();
        list = Manager.readFromFIle("1");

    }

    @Test
    public void linkedListShouldAddValues(){
        Assertions.assertSame(0,myLinkedList.getSize());

        myLinkedList.add(new Student());
        Assertions.assertSame(1,myLinkedList.getSize());
    }

    @Test
    public void methodInsertionFromDataBaseMustFillListFromDB() throws IOException {
        List<Student> list = Manager.readFromFIle("1");
        myLinkedList.insertionFromDataBase(list);
        Assertions.assertNotSame(0,myLinkedList.getSize());

    }

    @Test
    public void methodPrintShouldOutputValues() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); // создаем объект для перенаправления вывода
        PrintStream printStream = new PrintStream(outputStream); // устанавливаем printStream как стандарный вывод
        System.setOut(printStream);                              // используя System.setOut()


        myLinkedList.insertionFromDataBase(list);
        myLinkedList.print();

        String output = outputStream.toString();

        Assertions.assertNotEquals("",output);
    }

    @Test
    public void methodsGetGetTailGetHeadShouldReturnVlue(){
        myLinkedList.insertionFromDataBase(list);
        Student student = new Student();
        student = myLinkedList.get(1);
        Assertions.assertNotEquals(new Student(),student);

        Student student1 = new Student();
        student1 = myLinkedList.getHead().getValue();
        Assertions.assertNotEquals(new Student(),student1);

        Student student2 = new Student();
        student2 = myLinkedList.getTail().getValue();
        Assertions.assertNotEquals(new Student(),student2);
    }

    @Test
    public void methodRemoveShouldRemoveValues(){
        myLinkedList.insertionFromDataBase(list);
        int initialSize = myLinkedList.getSize();
        myLinkedList.remove(2);

        Assertions.assertSame(initialSize-1,myLinkedList.getSize());
    }

    @Test
    public void methodSearchShouldReturnCorrectStudent(){
        myLinkedList.insertionFromDataBase(list);

        Student student = list.get(1);
        int ID = student.getId();

        Assertions.assertEquals(student,myLinkedList.search(ID));

    }

}
