package MyLinkedList;

import dataBase.Student;

import java.util.List;


public class MyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        head=null;
        tail=null;
        size=0;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void add(Student value) {
        if (head == null) {
            this.head = new Node(value);
            this.tail = this.head;
        } else {
            Node temp = this.head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new Node(value));
            Node newNode = temp.getNext();
            newNode.setPrevious(temp);
            this.tail = newNode;
        }
        this.size++;
    }

    public void print() {
        Student[] result = new Student[this.size];
        Node temp = this.head;
        int index = 0;

        while (temp != null) {
            result[index++] = temp.getValue();
            temp = temp.getNext();
        }

        for (Student student : result) {
            System.out.println(student.toString());
        }
    }


    public Student get(int index) {
        if(index < size/2) {
            int currentIndex = 0;
            Node temp = head;
            while (temp != null) {
                if (currentIndex == index) {
                    return temp.getValue();
                } else {
                    temp = temp.getNext();
                    currentIndex++;
                }
            }
        } else {
            int currentIndex = size - 1;
            Node temp = tail;
            while (temp != null) {
                if (currentIndex == index) {
                    return temp.getValue();
                } else {
                    temp = temp.getPrevious();
                    currentIndex--;
                }
            }
        }

        throw new IllegalArgumentException();
    }

    public void remove(int index) {
        int currentIndex = 0;
        Node temp = head;

        while (temp != null) {
            if (index == 0) {
                head = head.getNext();
                head.setPrevious(null);
                size--;
                return;
            }
            if (currentIndex == index - 1) {
                temp.setNext(temp.getNext().getNext());
                if(temp.getNext() != null) {
                    Node newNext = temp.getNext();
                    newNext.setPrevious(temp);
                    this.tail = temp.getNext();
                } else{
                    tail = temp;
                }
                this.size--;
                return;
            } else {
                temp = temp.getNext();
                currentIndex++;
            }
        }
    }

    public Student search(int id){
        Node current = head;

        while (current!=null){
            if (current.getValue().getId() == id){
                return current.getValue();
            } else {
                current = current.getNext();
            }
        }
        return null;
    }

    public void insertionFromDataBase(List<Student> list){
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i));
        }
    }

    public int getSize() {
        return size;
    }
}