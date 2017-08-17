package algorithm.search;

public class BinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 ={1,2,5,7,8,10,15,22,25,30,32};
		int a = 15;
		boolean x = binarySearch(arr1,a,0,arr1.length);
		System.out.println(x);
	}

	private static boolean binarySearch(int[] arr1,int a,int l,int r) {
		// TODO Auto-generated method stub
		if(r>=l){
		int mid = (l+r)/2;
		System.out.println(mid);
		if(arr1[mid]==a){
			return true;
		}
		if(arr1[mid]<a){
			return binarySearch(arr1,a,mid+1,r);
		}
		else 
			return binarySearch(arr1,a,l,mid-1);
		}
		return false;
	}
	
/*
	 int binarySearch(int arr[], int x)
    {
        int l = 0, r = arr.length - 1;
        while (l <= r)
        {
            int m = l + (r-l)/2;
 
            // Check if x is present at mid
            if (arr[m] == x)
                return m;
 
            // If x greater, ignore left half
            if (arr[m] < x)
                l = m + 1;
 
            // If x is smaller, ignore right half
            else
                r = m - 1;
        }
 
        // if we reach here, then element was not present
        return -1;
    }
*/
	
/*
Time Complexity:
The time complexity of Binary Search can be written as
T(n) = T(n/2) + c 
The above recurrence can be solved either using Recurrence T ree method or Master method. It falls in case II of Master Method and solution of the recurrence is \Theta(Logn).
Auxiliary Space: O(1) in case of iterative implementation. In case of recursive implementation, O(Logn) recursion call stack space.
Algorithmic Paradigm: Divide and Conquer
*/
}