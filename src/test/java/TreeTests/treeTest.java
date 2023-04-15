package TreeTests;

import dataBase.Manager;
import dataBase.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tree.Tree;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public class treeTest {
    private Tree tree;
    private List<Student> list;


    @BeforeEach
    public void newTree() throws IOException {
        tree = new Tree();
        list = Manager.readFromFIle("1");
    }
    @Test
    public void methodInsertNodeShouldAddStudentInTree(){
        Student student = list.get(1);
        Assertions.assertNull(tree.getRootNode());

        tree.insertNode(student);
        Assertions.assertEquals(student,tree.getRootNode().getValue());
    }

    @Test
    public void methodInsertionFromDataBaseShouldAddAllDB(){
        tree.insertionFromDataBase(list);
        int listSize = list.size();
        Assertions.assertEquals(listSize, tree.getNumberOfNodes());

    }

    @Test
    public void methodFindNodeByIdShouldReturnValueIfExists(){
        tree.insertNode(list.get(1));
        tree.insertNode(list.get(2));
        tree.insertNode(list.get(3));
        int searchID = list.get(2).getId();
        Assertions.assertEquals(list.get(2),tree.findNodeByID(searchID));
    }


    @Test
    public void methodRemoveShouldDeleteNode(){
        tree.insertNode(list.get(1));
        tree.insertNode(list.get(2));
        tree.insertNode(list.get(3));
        int searchID = list.get(2).getId();

        Assertions.assertEquals(list.get(2),tree.findNodeByID(searchID));
        tree.remove(searchID);

        Assertions.assertNull(tree.findNodeByID(searchID));
    }

    @Test
    public void methodPrintTreeOutputValues(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); // создаем объект для перенаправления вывода
        PrintStream printStream = new PrintStream(outputStream); // устанавливаем printStream как стандарный вывод
        System.setOut(printStream);                              // используя System.setOut()


        tree.insertionFromDataBase(list);
        Tree.printTree(tree.getRootNode());

        String output = outputStream.toString();

        Assertions.assertNotEquals("",output);
    }
}
