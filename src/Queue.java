public class Queue {
    int rear=-1;
    int front=-1;
    int[] queue;

    public Queue(int size){
        queue = new int[size];
    }

    public  void enqueue(int value){
        if(isFull()){
            System.out.println("queue is full");
        }else{
            queue[++rear] = value;
        }
    }
    public void dequeue(){
        //int x=0;
        if(isEmpty()){
            System.out.println("queue is full");
        }else{
             front++;
        }
        //return x;
    }


    public  boolean isFull(){
        return rear==queue.length-1;
    }
    public boolean isEmpty(){
        return front==rear;
    }
    public void display(){
        for(int i=front+1; i<=rear; i++)
            System.out.println(queue[i]);
        System.out.println();
    }


}
