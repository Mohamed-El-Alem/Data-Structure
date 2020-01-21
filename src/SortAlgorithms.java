public class SortAlgorithms {

    public int[] selection(int []A)
    {
        // int [] intArray = {20, 35, -15, 7, 55 ,1 ,-22};// each time we select
        // the largest value and we add it to the last unsorted
        int i,j;
        for( i=0; i<A.length-1; i++){
            int min =  i;
            for( j=i+1; j<A.length; j++){
                if(A[min]>A[j])
                    min=j;
            }
            if(min != i)
            swap(A,min,i);
        }
        return A;

    }

    //bubble sort
    public int[] bubble(int [] A){
        for(int lastUnsortedIndex = A.length -1; lastUnsortedIndex  >0; lastUnsortedIndex--){
            for(int j=0; j< lastUnsortedIndex; j++){
                if(A[j]>A[j+1])
                    swap(A,j,j+1);
            }
        }
        return A;
    }

    public void swap(int[] A, int i,int j){
        if(i==j)
            return;
        int temp= A[i];
        A[i]=A[j];
        A[j]=temp;
    }

    public int[] insertion(int[] A){
        for(int firstUnsortedE = 1; firstUnsortedE < A.length; firstUnsortedE++){
            int newElement = A[firstUnsortedE];
            int i;
            for( i=firstUnsortedE ; i > 0 && A[i-1] > newElement; i--){
                A[i]=A[i-1];
            }
            A[i] = newElement;
        }
        return A;
    }

    public int binarySearch(int[] A, int key) {
        int l = 1;
        int h = A.length - 1;
        while (l < h) {
            int mid = (l + h) / 2;
            if (key == A[mid])
                return mid;
            else if (key < A[mid])
                h = mid - 1;
            else if (key > A[mid])
                l = mid + 1;

        }
        return 0;

    }

    public int binarySearchR(int[] A,int l, int h,int key){
        if(l==h){
            if(key==A[l])
                return l;
            else
                return 0;
        }else {
            int mid = (l + h) / 2;
            if (key == A[mid])
                return mid;
            else if (key < A[mid])
                return binarySearchR(A, l, mid - 1, key);
            else
            return binarySearchR(A, mid + 1, h, key);
        }

    }

    public void quickSort(int[]A, int start, int end){
        if(start < end){
            int pIndex = partition(A,start,end);
            quickSort(A,start,pIndex-1);
            quickSort(A,pIndex+1,end);
        }
    }

    public int partition(int[]A,int  start, int end){
        int pivot = A[end];
        int pIndex = start;
        for(int i=start; i<end;i++){
            if(A[i] <=pivot) {
                swap(A, i, pIndex);
                pIndex++;
            }
        }
        swap(A,end,pIndex);
        return pIndex;
    }

    //A = {20, 35, -15, 7, 55 ,1 ,-22};
    public static void mergeSort(int[] A){
        int n = A.length;
        if(n<2)
            return ;
        int mid = n/2;
        int[] left = new int[mid];
        int[] right = new int[n-mid];

        for(int i=0; i<mid ; i++)
            left[i] = A[i];

        for(int j= mid; j<n; j++)
            right[j-mid] = A[j];

        mergeSort(left);
        mergeSort(right);
        merge(left, right, A);//nte malk
    }
    public static void merge(int[] l, int[] r, int[]A){
        int nl = l.length; //length of left array l
        int nr = r.length;// length of right array r
        int[] B = new int[r.length+l.length];
        int i=0, j=0, k=0;
        while(i<nl && j<nr){//co mparing the two arrays and add the smallest to k array
            if(l[i]<=r[j]){
                B[k++]=l[i++];
            }else{
                B[k++]=A[j++];
            }
        }
        while(i<nl){
            B[k++]=A[i++];
        }
        while(j<nr){
            B[k++]=A[j++];
        }
    }

    public static void main(String[] args) {
        int [] A = {20, 35, -15, 7, 55 ,1 ,-22};
        mergeSort(A);
    }
}
