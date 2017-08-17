package alogorithm.sort;

public class MergeSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr ={1,2,5,7,8,30,15,78,22,25,30,1};
		int n = arr.length;
		mergeSort(arr,0,n-1);
		for(int i=0;i<n;i++){
			System.out.print(arr[i]+" ");
		}
	}

	private static void mergeSort(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		if(i<j){
			int mid = (i+j)/2;
			mergeSort(arr,i,mid);
			mergeSort(arr,mid+1,j);
			merge(arr,i,mid,j);
		}
		
	}

	private static void merge(int[] arr, int i, int mid, int j) {
		// TODO Auto-generated method stub
		int n1=mid-i+1;
		int n2=j-mid;
		
		int L[] = new int[n1];
		int R[] = new int[n2];
		
		for(int x=0;x<n1;x++){
			L[x]=arr[i+x];
		}
		for(int x=0;x<n2;x++){
			R[x]=arr[mid+1+x];
		}
		int k=i;
		int x=0,y=0;
		while(x<n1 && y<n2){
			if(L[x]<R[y]){
				arr[k]=L[x];
				x++;
			}
			else{
				arr[k]=R[y];
				y++;
			}
			k++;
		}
		while(x<n1){
			arr[k]=L[x];
			x++;
			k++;
		}
		while(y<n2){
			arr[k]=R[y];
			y++;
			k++;
		}
	}
}

/*
Time Complexity: Sorting arrays on different machines. Merge Sort is a recursive algorithm and time complexity can be expressed as following recurrence relation.
T(n) = 2T(n/2) + \Theta(n)
The above recurrence can be solved either using Recurrence Tree method or Master method. It falls in case II of Master Method and solution of the recurrence is \Theta(nLogn).
Time complexity of Merge Sort is \Theta(nLogn) in all 3 cases (worst, average and best) as merge sort always divides the array in two halves and take linear time to merge two halves.
Auxiliary Space: O(n)
Algorithmic Paradigm: Divide and Conquer
Sorting In Place: No in a typical implementation
Stable: Yes
Applications of Merge Sort
Merge Sort is useful for sorting linked lists in O(nLogn) time.In case of linked lists the case is different mainly due to difference in memory allocation of arrays and linked lists. Unlike arrays, linked list nodes may not be adjacent in memory. Unlike array, in linked list, we can insert items in the middle in O(1) extra space and O(1) time. Therefore merge operation of merge sort can be implemented without extra space for linked lists.
In arrays, we can do random access as elements are continuous in memory. Let us say we have an integer (4-byte) array A and let the address of A[0] be x then to access A[i], we can directly access the memory at (x + i*4). Unlike arrays, we can not do random access in linked list. Quick Sort requires a lot of this kind of access. In linked list to access i’th index, we have to travel each and every node from the head to i’th node as we don’t have continuous block of memory. Therefore, the overhead increases for quick sort. Merge sort accesses data sequentially and the need of random access is low.
Inversion Count Problem
Used in External Sorting
*/
