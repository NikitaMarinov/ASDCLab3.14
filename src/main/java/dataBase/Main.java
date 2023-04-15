package dataBase;

import MyLinkedList.MyLinkedList;
import tree.Tree;

import java.io.IOException;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        List<Student> list = Manager.readFromFIle("1");  //1 - sort , 2 - unsort
        System.out.println("Our list:");
        // Manager.showStudentArrayList(list);

        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.insertionFromDataBase(list);
        myLinkedList.print();

        System.out.println("Поиск:");
        System.out.println(myLinkedList.search(2));
        System.out.println("Удаление:");
        myLinkedList.remove(2); // по индексу,не айди
        myLinkedList.print();

        Tree tree = new Tree();
        tree.insertionFromDataBase(list);

        System.out.println("\nНаше дерево:");
        Tree.printTree(tree.getRootNode());
        System.out.println("\nПоиск:");
        System.out.println(tree.findNodeByID(1));
        System.out.println("Удаление:");
        tree.remove(1);
        Tree.printTree(tree.getRootNode());




        System.out.print("\n\nPre-order traversal: ");
        tree.printPreOrder(tree.getRootNode());

        System.out.print("\nPost-order traversal: ");
        tree.printPostOrder(tree.getRootNode());

        System.out.print("\nIn-order traversal: ");
        tree.printInOrder(tree.getRootNode());


    };

}

