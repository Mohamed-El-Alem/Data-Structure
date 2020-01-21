
public class Heaps {
    int[] heaps;
    int size=0;
    public Heaps(int capacity){
        heaps = new int[capacity];
    }

    public void insert(int value){
        if(isFull()){
            System.out.println(value+" cant be added , is full");
        }else{
            heaps[size] = value;
            fixHeapAbove(size);
            size++;
        }
    }

    public int delete(int index){
        if(isEmpty()){
            System.out.println("is Empty");
        }
            int parent = getParent(index);
            int deleted = heaps[index];
            heaps[index] = heaps[size-1];
            if(index ==0 || heaps[index] < heaps[getParent(index)])
                fixHeapBelow(index, size-1);
            else
                fixHeapAbove(index);

        size--;
        return deleted;
    }
    public void fixHeapAbove(int index){
        int newV = heaps[index];
        while(index > 0 && newV > heaps[getParent(index)]){
            heaps[index] = heaps[getParent(index)];
            index = getParent(index);
        }
        heaps[index] = newV;
    }

    public void fixHeapBelow(int index, int lastIndex){
        int childtoswap;
        while(index <=lastIndex){
            int leftChild = getChild(index, true);
            int rightChild = getChild(index, false);
            if(leftChild <= lastIndex){
                if(rightChild > lastIndex)
                    childtoswap = leftChild;
                else
                    childtoswap = (heaps[leftChild]>heaps[rightChild] ? leftChild : rightChild);
                if(heaps[index] < heaps[childtoswap]) {
                    int temp = heaps[index];
                    heaps[index] = heaps[childtoswap];
                    heaps[childtoswap]=temp;
                }else {
                    break;
                }
                index = childtoswap;
            }else{
                break ;
            }
        }
    }

    public void sort(){
        int lastIndex= size -1;
        for(int i=0; i<lastIndex; i++){
            int temp = heaps[0];
            heaps[0] = heaps[lastIndex-i];
            heaps[lastIndex-i] = temp ;

            fixHeapBelow(0, lastIndex-i-1);
        }
    }
    public int getChild(int index, boolean left){
        return 2*index+(left ? 1 : 2);
    }

    public int getParent(int index){
        return (index - 1)/2;
    }

    public boolean isEmpty(){
        return size==0;
    }
    public boolean isFull(){
        return size==heaps.length;
    }


    public void print(){
        for(int i=0; i< size; i++)
            System.out.print(heaps[i]+" ");
    }
}
