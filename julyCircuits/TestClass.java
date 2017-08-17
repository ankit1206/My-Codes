package julyCircuits;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
//import for Scanner and other utility classes
import java.util.*;
import java.math.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);*/

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int arr[][]=new int[N][N];
        int value1,value2,value3,value4;
        for (int i = 0; i < N; i++) {
            for(int j=0;j<N;j++){
                arr[i][j]=s.nextInt();
            }
        }
        int count =0;
        for (int i = 0; i < N; i++) {
            for(int j=0;j<N;j++){
                if(i-1<0){
                    value1=0;
                }
                else{
                    value1=arr[i-1][j];
                }
                if(i+1==N){
                    value2=0;
                }
                else{
                    value2=arr[i+1][j];
                }
                if(j-1<0){
                    value3=0;
                }
                else{
                    value3=arr[i][j-1];
                }
                if(j+1==N){
                    value4=0;
                }
                else{
                    value4=arr[i][j+1];
                }
                int sum = value1+value2+value3+value4;
                count = count + isPrime(sum);
            }
        }
        

        System.out.println("Hello World!");
    }
    private static int isPrime(int sum){
        int sqrt = (int)Math.sqrt(sum);
        for(int i=2;i<sqrt;i++){
            if(sum%i==0){
                return 0;
            }
        }
        return 1;
    }
}
