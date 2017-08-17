package alogorithm.sort;

public class BubbleSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 ={1,2,5,7,8,30,15,22,25,30,32};
		int n = arr1.length;
		for(int i =0;i<n;i++){
			for(int j=0;j<n-1;j++){
				if(arr1[j]>arr1[j+1]){
					int temp = arr1[j];
					arr1[j]=arr1[j+1];
					arr1[j+1]=temp;
				}
			}
		}
		for(int i=0;i<n;i++){
			System.out.println(arr1[i]);
		}
	}

}
