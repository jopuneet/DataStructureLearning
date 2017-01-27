//Given an unsorted array of integers. Find an element such that all the elements to its left are smaller and to its right are greater. 
//Print -1 if no such element exists.
//
//Note that there can be more than one such elements. For example an array which is sorted in increasing order all elements follow the property. 
//We need to find only one such element.
//
//Examples:
//
//Input :  A[] = {4, 3, 2, 5, 8, 6, 7}  
//Output : 5 
//
//Input : A[] = {5, 6, 2, 8, 10, 9, 8} 
//Output : -1

package ArraysProb;

public class PartitionPoint {

	public static void main(String[] args) {
		int A[] = {4, 3, 2, 5, 8, 6, 7};
		int result = findPartitionPoint(A);
		System.out.println("Result is  : "+result);
	}
	
	static int findPartitionPoint(int arr[]){
		int max = arr[0];
		for (int i = 1; i < arr.length-1; i++) {
				if(arr[i]>max){
					max=arr[i];
					for (int j = max+1; j < arr.length; j++) {
						if(arr[j]>max && j==arr.length-1)
							return max;
					}
				}
		}
		return -1;
	}
}
