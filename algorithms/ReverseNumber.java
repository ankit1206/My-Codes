package algorithms;

import java.util.*;

public class ReverseNumber {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        long i = scan.nextInt();
        long j = scan.nextInt();
        long k = scan.nextInt();
        long count = 0;
        for(long n = i; n<=j;n++){
            if((i-reverse(n))%k==0){
            	count++;
            }
        }
        System.out.println(count);
    }
    public static long reverse(long n){
    	char arr[]=Long.toString(n).toCharArray();
    	char arr1[] = new char[arr.length];
    	for(int i=0;i<arr.length;i++){
    		arr1[i]=arr[arr.length-1-i];
    	}
    	n = Long.parseLong(new String(arr1));
    	return n;
    }
}
