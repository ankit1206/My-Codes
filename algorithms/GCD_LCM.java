package algorithms;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class GCD_LCM {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for(int b_i=0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
        }
        int result_a = a[0];
        for(int i =1;i<n;i++){
        	result_a = lcm(result_a,a[i]);
        }
        int result_b = b[0];
        for(int i =1;i<m;i++){
        	result_b = gcd(result_b,b[i]);
        }
        int num =0;
        if(gcd(result_a,result_b)==result_a){
        	num = fact(result_a,result_b);
        }
        System.out.println(num);
    }
    public static int fact(int a,int b){
    	if(a==b){
    		return 1;
    	}
    	int count = 0;
    	for(int i =a;i<=b;){
    		if(b%i==0 && i%a == 0){
    			count = count++;
    			i = i + a;
    		}
    	}
    	return count;
    }
    public static int gcd(int a,int b){
    	while(b>0){
    		int temp = b;
    		b = a%b;
    		a = temp;
    	}
    	return a;
    }
    public static int lcm(int a,int b){
    	return a*(b/gcd(a,b));
    }
}
