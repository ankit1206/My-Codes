package algorithms;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class NewClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        long n = in.nextLong();
        char arr[]=s.toCharArray();
        long count = 0;
        for(int i =0;i<arr.length;i++){
        	if(arr[i]=='a'){
        		count++;
        	}
        }
        count = count*(n/s.length());
        for(int i=0;i<n%s.length();i++){
        	if(arr[i]=='a'){
        		count++;
        	}
        }
        System.out.println(count);
        SortedSet set = new TreeSet();
        Object[] arr1 = set.toArray();
        Collec
        
	}

}
