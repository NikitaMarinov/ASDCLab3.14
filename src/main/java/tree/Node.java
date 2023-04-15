package tree;

import dataBase.Student;

public class Node {
    private Student student ;
    private Node leftChild;
    private Node rightChild;

    public void printNode() {
        System.out.println(" Выбранный узел имеет значение :" + student.toString());
    }

    public Student getValue() {
        return this.student;
    }

    public void setValue(final Student student) {
        this.student = student;
    }

    public Node getLeftChild() {
        return this.leftChild;
    }

    public void setLeftChild(final Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return this.rightChild;
    }

    public void setRightChild(final Node rightChild) {
        this.rightChild = rightChild;
    }


}