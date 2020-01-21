public class Stack {
    Node top=null;
    int size;

    public void push(int value){
        Node n= new Node(value);
        n.next=top;
        top=n;
    }
}
