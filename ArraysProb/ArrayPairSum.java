//Given an array of n distinct and positive elements, the task is to find pair whose sum already exists in given array.
//
//Examples:
//
//Input : arr[] = {2, 8, 7, 1, 5};
//Output : 2 5
//         7 1    
//     
//Input : arr[] = {7, 8, 5, 9, 11};
//Output : Not Exist

package ArraysProb;

import java.util.HashSet;

class ArrayPairSum {
	public static void main(String[] args) {
		int arr[] = { 2, 8, 7, 1, 5 };

		boolean v = calculateArrayPair(arr);
		if (v == false)
			System.out.println("Not exist");
	}

	// Inefficiient Solution
	// static boolean calculateArrayPair(int[] arr) {
	//
	// boolean val = false;
	// for (int i = 0; i < arr.length-1; i++)
	// {
	// for (int j = i+1; j < arr.length; j++) {
	// {
	// for (int j2 = 0; j2 < arr.length; j2++) {
	// {
	// if (arr[i] + arr[j] == arr[j2]) {
	// System.out.println(arr[i] + " " + arr[j]);
	// val = true;
	// }
	// }
	// }
	// }
	// }
	// }
	// return val;
	// }

	static boolean calculateArrayPair(int[] arr) {

		boolean val = false;
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(set.contains(arr[i]+arr[j])){
					System.out.println(arr[i]+" "+arr[j]);
					val = true;
				}
			}
		}
		return val;
	}
}