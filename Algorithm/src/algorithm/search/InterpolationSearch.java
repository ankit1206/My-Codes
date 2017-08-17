package algorithm.search;

public class InterpolationSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 ={1,2,5,7,8,10,15,22,25,30,32};
		int a = 15;
		boolean x = interpolationSearch(arr1,a,0,arr1.length-1);
		System.out.println(x);
	}

	private static boolean interpolationSearch(int[] arr,int x,int lo,int hi) {
		// TODO Auto-generated method stub
		if(hi>=lo){
		int pos = lo + ((x-arr[lo])*(hi-lo) / (arr[hi]-arr[lo]));
		System.out.println(pos);
		if(arr[pos]==x){
			return true;
		}
		if(arr[pos]<x){
			return interpolationSearch(arr,x,pos+1,hi);
		}
		else 
			return interpolationSearch(arr,x,lo,pos-1);
		}
		return false;
	}
	
}

/*
Time Complexity : If elements are uniformly distributed, then O (log log n)). In worst case it can take upto O(n).
Auxiliary Space : O(1)*/