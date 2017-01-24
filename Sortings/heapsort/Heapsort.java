import java.util.Arrays;

public class Heapsort {

    public static int heapSize;
    public static int LEFT(int i)
    {
        
        return 2*i+1;
    }

    public static int RIGHT(int i)
    {
        return 2*i+2;
    }


    public static void BUILD_MAX_HEAP(int A[])
    {
        heapSize = A.length;//heap size initialised
        for(int i=A.length/2; i>=0;i--)
        {
            MAX_HEAPIFY(A, i);
        }
    }


    public static void MAX_HEAPIFY(int A[],int i)
    {
        int l=LEFT(i);
        int r=RIGHT(i);
        int largestElementIndex = -1;
        if(l<heapSize && A[l]>A[i]){
            largestElementIndex = l;
        }
        else 
        {
            largestElementIndex=i;
        }
        if(r<heapSize && A[r]>A[largestElementIndex])
        {
            largestElementIndex = r;
        }

        if(largestElementIndex!=i)
        {
            int temp = A[i];
            A[i]=A[largestElementIndex];
            A[largestElementIndex]=temp;
            MAX_HEAPIFY(A, largestElementIndex);
        }
    }

    public static void HEAP_SORT(int A[])
    {
        BUILD_MAX_HEAP(A);
        for(int i=A.length-1;i>=0;i--)
        {
            int temp = A[0];
            A[0]=A[i];
            A[i]=temp;
            heapSize  = heapSize-1;
            MAX_HEAPIFY(A,0);
        }
    }

    public static void main(String[] args) {


        int A[] = new int[]{4,1,3,2,16,9,10,14,8,7};
        HEAP_SORT(A);
        System.out.println(Arrays.toString(A));
    }
}