public class LL {
    Node head;
    public void insert(int data){
        Node n= new Node(data);
        n.next=null;
        if(head==null) {
            head = n;
        }else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = n;
        }

    }
    public void dupRemove(){
        if(head==null || head.next==null)
            return;
        Node temp = head;
        Node q= temp.next;
        while(q!= null) {
            if(temp.data == q.data){
                temp.next = q.next;
                q=temp.next;
            }
            temp =q;
            q=q.next;
        }

    }
    public boolean PalindromL(){
        Node slow=head;
        Node fast = head;
        while(fast!=null && fast.next!= null){
            slow=slow.next;
            fast=fast.next.next;
        }
        slow = reversed(slow);
        fast =head;
        while(slow!= null){
            if(slow.data != fast.data)
                return false;
            slow=slow.next;
            fast=fast.next;
        }
        return true;
    }
    public Node reversed(Node head){
        Node prev = null;
        while(head!=null){
            Node next = head.next;
            head.next=prev;
            prev=head;
            head = next;

        }
        return prev;
    }
    public void print(){
        Node temp = head;
        while(temp!=null) {
            System.out.print(temp.data+", ");
            temp = temp.next;
        }
        System.out.println();
    }
}
