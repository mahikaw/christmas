import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by tgit on 31/08/17.
 */
public class bst<T extends Comparable<T>> {
    Node root;
    T rootdata;
    T sum;
    ArrayList<T> inOrderPattern;


    Node<T> insert(Node<T> root, T a) {
        Node<T> temp=new Node<T>(a);
       if (root == null) {
            root = temp;
        }

        if (a.compareTo(root.data) <= 0)
            root.left = insert(root.left, a);
        else if (a.compareTo(root.data)>0)
            root.right = insert(root.right, a);
        return root;
    }

    Node<T> returnRoot(){
        return this.root;
    }

    void Insert(T a){
        root=insert(root,a);
    }

    void inOrder(Node node){
        if (node == null) {
            return;
        }
        inOrder(node.left);
        inOrderPattern.add((T) node.data);
        inOrder(node.right);
    }


    public static void main(String str[]) throws IOException {
        System.out.println("Enter number of trees and number of students");
        Scanner read = new Scanner(System.in);
        int treeCount = read.nextInt();
        int studentCount = read.nextInt();
        for (int i = 0; i < treeCount; i++) {
            FileInputStream fin = new FileInputStream("/Users/tgit/Downloads/lab5/TEST_CASES/T1/input/1.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fin));
            String type[]=br.readLine().split(" ");
            System.out.println(type[0]);
            String xyz=br.readLine();
            bst tree;

            ArrayList<student> students=new ArrayList<>(studentCount);
            String inputLine[]=br.readLine().split(" ");
            if (type[0]=="String"){
                System.out.println("entered string");
               tree=new bst<String>();
                tree.rootdata=inputLine[0];
                for (int j=0;j<studentCount;j++){
                    tree.Insert(inputLine[j]);
                }
            }
            else if (type[0]=="Integer"){
                System.out.println("entered int");
                tree=new bst<Integer>();
                tree.rootdata=inputLine[0];
                for (int j=0;j<studentCount;j++){
                    tree.Insert(Integer.parseInt(inputLine[j]));
                }
            }
            else {
                System.out.println("entered else");
                tree=new bst<Float>();
               tree.rootdata=inputLine[0];
                for (int j=0;j<studentCount;j++){
                    tree.Insert(Float.parseFloat(inputLine[j]));
                }
            }
            tree.inOrder(tree.returnRoot());
            System.out.println("mahika "+tree.inOrderPattern);
//            Iterator ir=tree.inOrderPattern.iterator();
//
//            while (ir.hasNext()){
//
//                if(ir.next()==tree.rootdata{
//                    //todo store index somewhere
//                }
//
//            }
//            students.get(tree.rootPos).recievedTree=true;
//            students.get(tree.rootPos).values.add(tree.sum);

        }
    }


}

class student<T> {
    boolean recievedTree;
    ArrayList<T> values = new ArrayList<T>();
}

class Node<T extends Comparable<T>> {
    T data;
    Node<T> left, right;

    public Node(T data, Node<T> l, Node<T> r) {
        left = l;
        right = r;
        this.data = data;
    }

    public Node(T data) {
        this(data, null, null);
    }


}