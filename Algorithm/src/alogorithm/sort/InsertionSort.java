package alogorithm.sort;

public class InsertionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr ={1,2,5,7,8,30,15,78,22,25,30,1};
		int n = arr.length;
		for(int i=0;i<n;i++){
			int j =i-1;
			int key = arr[i];
			while(j>=0 && arr[j]>key){
				arr[j+1]=arr[j];
				j=j-1;
			}
			arr[j+1]=key;
		}
		for(int i=0;i<n;i++){
			System.out.print(arr[i]+" ");
		}

	}

}
/*
Time Complexity: O(n*n)
Auxiliary Space: O(1)
Boundary Cases: Insertion sort takes maximum time to sort if elements are sorted in reverse order. And it takes minimum time (Order of n) when elements are already sorted.
Algorithmic Paradigm: Incremental Approach
Sorting In Place: Yes
Stable: Yes
Online: Yes
Uses: Insertion sort is used when number of elements is small. It can also be useful when input array is almost sorted, only few elements are misplaced in complete big array.
*/

