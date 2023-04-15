package MyLinkedList;

import dataBase.Student;

public class Node{
    private Student value;
    private Node next;
    private Node previous;

    public Node(Student value) {
        this.value = value;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getPrevious() {
        return previous;
    }

    public Student getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}