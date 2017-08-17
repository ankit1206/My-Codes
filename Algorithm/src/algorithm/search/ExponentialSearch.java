package algorithm.search;

public class ExponentialSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 ={1,2,5,7,8,10,15,22,25,30,32};
		int a = 13;
		boolean x = exponentialSearch(arr1,a,0,arr1.length);
		System.out.println(x);
	}

	private static boolean exponentialSearch(int[] arr1, int a, int l,
			int n) {
		// TODO Auto-generated method stub
		for(int i=0;i<n;){
			if(arr1[i]==a){
				return true;
			}
			else if(arr1[i]<a){
				if(i==0){
					i=1;
				}
				else{
				i=i*2;
				if(i>=n){
					i=n-1;
				}
				}
			}
			else{
				return binarySearch(arr1,a,i/2,i);
			}
		}
		return false;
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

}

/*
Time Complexity : O(Log n)
Auxiliary Space : The above implementation of Binary Search is recursive and requires O()Log n) space. With iterative Binary Search, we need only O(1) space.

Applications of Exponential Search:

Exponential Binary Search is particularly useful for unbounded searches, where size of array is infinite. Please refer Unbounded Binary Search for an example.
It works better than Binary Search for bounded arrays also when the element to be searched is closer to the first element.
*/