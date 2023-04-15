package tree;

import dataBase.Student;

import java.util.List;
import java.util.Objects;

public class Tree {
    private Node rootNode;

    private int numberOfNodes;
    public Tree() {
        rootNode = null;
    }

    public Node getRootNode() {
        return rootNode;
    }

    public void insertNode(Student student) {
        Node newNode = new Node();
        newNode.setValue(student);

        if (rootNode == null) {
            rootNode = newNode;
            numberOfNodes++;
        }
        else {

            Node currentNode = rootNode;
            Node parentNode;
            while (true)
            {
                parentNode = currentNode;

                if(Objects.equals(student.getId(),currentNode.getValue().getId())) { // элемент существует
                    return;
                } else  if (student.getId() < currentNode.getValue().getId()) {   // <-
                    currentNode = currentNode.getLeftChild();
                    if (currentNode == null){
                        parentNode.setLeftChild(newNode);
                        numberOfNodes++;
                        return;
                    }
                } else { // ->
                    currentNode = currentNode.getRightChild();
                    if (currentNode == null) {
                        parentNode.setRightChild(newNode);
                        numberOfNodes++;
                        return;
                    }
                }
            }
        }
    }


    public Student findNodeByID(int ID) {
        Node currentNode = rootNode;
        while (currentNode.getValue().getId() != ID) {

            if (ID < currentNode.getValue().getId()) {
                currentNode = currentNode.getLeftChild();
            } else {
                currentNode = currentNode.getRightChild();
            }
            if (currentNode == null) {
                return null;
            }
        }
        return currentNode.getValue();
    }


    // Метод для удаления узла из дерева
    public boolean remove(int value) {
        Node parent = null;
        Node current = rootNode;
        boolean isLeftChild = false; // флак, если true - левая нода, false - правая или корень.

        while (current != null) { // ищем элемент для удаления
            if (current.getValue().getId() == value) {
                break;
            }
            parent = current;
            if (value < current.getValue().getId()) {
                current = current.getLeftChild();
                isLeftChild = true;
            } else {
                current = current.getRightChild();
                isLeftChild = false;
            }
        }


        if (current == null) {
            return false;
        }


        if (current.getLeftChild() == null && current.getRightChild() == null) {
            if (current == rootNode) { // если нода у нас корень
                rootNode = null;
            } else if (isLeftChild) {
                parent.setLeftChild(null);
            } else {
                parent.setRightChild(null);
            }
        } else if (current.getLeftChild() == null) { // если нет левой ноды у удаляемого элемента
            if (current == rootNode) {
                rootNode = current.getRightChild();
            } else if (isLeftChild) {
                parent.setLeftChild(current.getRightChild());
            } else {
                parent.setRightChild(current.getRightChild());
            }
        } else if (current.getRightChild() == null) { //если нет правой ноды
            if (current == rootNode) {
                rootNode = current.getLeftChild();
            } else if (isLeftChild) {
                parent.setLeftChild(current.getLeftChild());
            } else {
                parent.setRightChild(current.getLeftChild());
            }
        } else { //если есть и правая и левая
            Node successor = getSuccessor(current);
            if (current == rootNode) {
                rootNode = successor;
            } else if (isLeftChild) {
                parent.setLeftChild(successor);
            } else {
                parent.setRightChild(successor);
            }
            successor.setLeftChild(current.getLeftChild());
        }
        return true;
    }

    // Метод для поиска преемника узла
    private Node getSuccessor(Node deleteNode) {
        Node successorParent = deleteNode;
        Node successor = deleteNode;
        Node current = deleteNode.getRightChild();
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }
        if (successor != deleteNode.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(deleteNode.getRightChild());
        }
        return successor;
    }


    public static void printTree(Node node) { // так как у нас каждое поддерево являеться деревом,
        if (node == null) {                   // так мы сможем вывести не все дерево целиком.
            return;
        }
        System.out.print(node.getValue().getId() + " ");
        printTree(node.getLeftChild());
        printTree(node.getRightChild());
    }


    public void insertionFromDataBase(List<Student> list){
        for (int i = 0; i < list.size(); i++) {
            insertNode(list.get(i));
        }
    }

    public int getNumberOfNodes() {
        return numberOfNodes;
    }

    // Прямой порядок
    public void printPreOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getValue().getId() + " ");
        printPreOrder(node.getLeftChild());
        printPreOrder(node.getRightChild());
    }

    // Обратный порядок
    public  void printPostOrder(Node node) {
        if (node == null) {
            return;
        }
        printPostOrder(node.getLeftChild());
        printPostOrder(node.getRightChild());
        System.out.print(node.getValue().getId() + " ");
    }

    // Центрированный порядок
    public  void printInOrder(Node node) {
        if (node == null) {
            return;
        }
        printInOrder(node.getLeftChild());
        System.out.print(node.getValue().getId() + " ");
        printInOrder(node.getRightChild());
    }



}