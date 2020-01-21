public class Main {
    public static void main(String[] args) {
        SortAlgorithms sA = new SortAlgorithms();
        BST bst = new BST();
        HeapP h = new HeapP(8);
        LL ll= new LL();

        /*
        Queue q = new Queue(5);
        q.enqueue(4);
        q.enqueue(6);
        q.enqueue(10);
        q.enqueue(15);
        q.enqueue(20);
        q.display();
        q.dequeue();
        q.dequeue();
        q.display(); 
        */

        int [] A = {20, 35, -15, 7, 55 ,1 ,-22};

        //ll.insert(80);
        //ll.insert(80);

        bst.insert(30 );
        bst.insert(10);
        bst.insert(50);
        bst.insert(5);
        bst.insert(2);
        BST deleted = bst.delete(bst.getRoot(),30);
        bst.inorder(bst.getRoot());
        //ll.dupRemove();
        //ll.print();
       // System.out.println(ll.PalindromL());


        /*

        bst.insert(10);
        bst.insert(5);
        bst.insert(20);
        bst.insert(8);
        bst.insert(30);
        bst.inorder(bst.getRoot());

         */
        //int[] sorted = sA.selection(A);
        //System.out.println(sorted);

        //for (int i=0; i<sorted.length; i++)
         //   System.out.println(A[i]);
/*
        h.insert(80);
        h.insert(75);
        h.insert(60 );
        h.insert(68);
        h.insert(55);
        h.insert(40);
        h.insert(52);
        h.insert(67);
        h.print();

        h.delete(1);
        System.out.println();
        h.print();
        h.delete(7);
        System.out.println();
        h.print();

 */


    }
}
