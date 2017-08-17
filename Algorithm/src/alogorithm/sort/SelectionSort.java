package alogorithm.sort;

public class SelectionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 ={1,2,5,7,8,30,15,22,25,30,32};
		int n = arr1.length;
		for(int i =0;i<n;i++){
			int min = arr1[i];
			int val=i;
			for(int j=i+1;j<n;j++){
				if(arr1[j]<min){
					min=arr1[j];
					val=j;
				}
			}
			arr1[val]=arr1[i];
			arr1[i]=min;
			System.out.println(arr1[i]);
		}
	}
}

/*
Time Complexity: O(n2) as there are two nested loops.
Auxiliary Space: O(1)
The good thing about selection sort is it never makes more than O(n) swaps and can be useful when memory write is a costly operation.
*/