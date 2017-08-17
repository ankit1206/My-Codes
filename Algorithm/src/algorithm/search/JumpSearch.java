package algorithm.search;

public class JumpSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 ={1,2,5,7,8,10,15,22,25};
		int a = 8;
		boolean x = jumpSearch(arr1,a,0,arr1.length);
		System.out.println(x);
	}

	private static boolean jumpSearch(int[] arr1, int a, int l, int n) {
		// TODO Auto-generated method stub
		int flag =0;
		for(int i=0;i<n;){
			if(arr1[i]==a){
				return true;
			}
			else if(arr1[i]<a && flag==0){
				i=i+(int)Math.pow(n, 0.5);
			}
			else if(arr1[i]>a){
				i--;
				flag =1;
			}
			else{
				return false;
			}
		}
		return false;
	}

/*	private static boolean jumpSearch(int[] arr1, int a, int l, int n) {
		// TODO Auto-generated method stub
		if(l>=n){
			l=n-1;
		}
		if(l<n){
		System.out.println(l+" "+arr1[l]+" "+a);
		if(arr1[l]==a){
			return true;
		}
		else if(arr1[l]>a){
			for(int i=l-(int)Math.pow(n, 0.5);i<l;i++){
				System.out.println(arr1[i]);
				if(arr1[i]==a){
					return true;
				}
			}
			return false;
		}
		else{
			return jumpSearch(arr1,a,l+(int)Math.pow(n, 0.5),n);
		}
		}
		return false;
	}*/
}

/*
 Time Complexity : O(√n)
Auxiliary Space : O(1)

Important points:
Works only sorted arrays.
The optimal size of a block to be jumped is O(√ n). This makes the time complexity of Jump Search O(√ n).
The time complexity of Jump Search is between Linear Search ( ( O(n) ) and Binary Search ( O (Log n) ).
Binary Search is better than Jump Search, but Jump search has an advantage that we traverse back only once (Binary Search may require up to O(Log n) jumps, consider a situation where the element to be search is the smallest element or smaller than the smallest). So in a systems where jumping back is costly, we use Jump Search.
*/