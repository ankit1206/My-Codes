package algorithms;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        long arr[][] = new long[n][n];
        long a[] = new long[n];
        for(int i = 0;i<n;i++){
            a[i]=scan.nextLong();
            arr[i][i] = 0;
        }
        for(int i =0;i<n;i++){
            for(int j=i+1;j<n;j++){
                arr[i][j]=a[i]+a[j];
                arr[j][i]=a[i]+a[j];
                if(arr[i][j]%k==0){
                    arr[i][j]=0;
                    arr[j][i]=0;
                }
            }
        }
        long val =0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i =0;i<n;i++){
            long count = 0;
            for(int j =0;j<n;j++){
                if(arr[i][j]!=0){
                    if(list.size()==0){
                        list.add(j);
                        count++;
                    }
                    else{
                        int x = list.size();
                        int count_a=0;
                        for(int l=0;l<x;l++){
                            if(arr[list.get(l)][j]!=0){
                                count_a++;
                                //System.out.println("Count_a:"+count_a);
                            }
                        }
                        if(count_a==x){
                            list.add(j);
                            count++;
                        }
                    }
                }
            }
            list.clear();
            if(count>val){
                val = count;
            }
            if(val == n-1){
                break;
            }
        }
        System.out.println(val+1);
    }
}