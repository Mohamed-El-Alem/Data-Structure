public class HeapP {
    int heap[];
    int size=0;

    public HeapP(int capacity){
        heap = new int[capacity];
    }

    public void insert(int value){
        if(isFull()){
            System.out.println("heap is full");

        }else{
            heap[size] = value;
            fixHeapAbove(size);
            size++;
        }
    }

    public void delete(int index) {
        if (isEmpty()) {
            System.out.println("heap is empty");

        }
            int parent = getParent(index);
            int deleted = heap[index];
            heap[index] = heap[size - 1];
            if (index == 0 || heap[index] < heap[parent])
                fixHeapBelow(index, size - 1);
            else
                fixHeapAbove(index);

            size--;

            //return deleted;

    }

    public void fixHeapBelow(int index, int lastIndex){
        int childToSwap;
        while(index <= lastIndex){
            int leftChild = getChild(index, true);
            int rightChild = getChild(index, false);
            if(leftChild<=lastIndex){
                if(rightChild>lastIndex) {
                    childToSwap = leftChild;
                }else {
                    childToSwap = (heap[leftChild] > heap[rightChild] ? leftChild : rightChild);
                }
                if(heap[index]<heap[childToSwap]){
                    int temp = heap[index];
                    heap[index]=heap[childToSwap];
                    heap[childToSwap]=temp;
                }else {
                    break;
                }
                index = childToSwap;
            }else{
                break;
            }

            }
        }

        public int getChild(int index, boolean left){
        return 2*index + (left? 1:2);
        }




    public void fixHeapAbove(int index){

        int value = heap[index];
        while(index >0 && heap[index] > heap[getParent(index)]){
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }
        heap[index]=value;
    }

    public int getParent(int index){
        return (index-1)/2;
    }

    public boolean isFull(){
        return size==heap.length-1;
    }
    public boolean isEmpty(){
        return size==0;
    }

    public void print(){
        for(int i=0; i< size; i++)
            System.out.print(heap[i]+" ");
    }
}
