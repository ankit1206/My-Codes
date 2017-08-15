/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moneysplit;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 *
 * @author 438776
 */
public class MoneySplit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of Users:");
        String userCount = sc.nextLine();
        int N = Integer.parseInt(userCount);
        HashMap<String,Double> userTranDetails = new HashMap<>();
        String[] user = new String[N];
        for(int i=0;i<N;i++){
            System.out.print("Enter name of User"+(i+1)+":");
            userTranDetails.put(sc.nextLine(), 0.00);
        }
        String ch = "Y";
        while(ch.equals("Y")){
            System.out.print("Enter Payer Name:");
            String payer = sc.nextLine();
            System.out.print("Enter Payee Names:");
            String payee = sc.nextLine();
            String userTran[] = payee.trim().split("\\s+");
            System.out.print("Enter Amount Spent:");
            double amtTran = sc.nextDouble();
            sc.nextLine();
            System.out.println();
            int numberOfTranUser = userTran.length;
            for(int j=0;j<numberOfTranUser;j++){
                if(!userTran[j].equals(payee)){
                    userTranDetails.replace(userTran[j], userTranDetails.get(userTran[j])-amtTran/numberOfTranUser);
                    userTranDetails.replace(payee, userTranDetails.get(payee)-amtTran/numberOfTranUser);
                }
            }
            String amtString="";
            String userString="";
            for (Map.Entry<String, Double> entry : userTranDetails.entrySet())
            {
                if(round(entry.getValue(),2)==0.00){
                    entry.setValue(0.00);
                    userTranDetails.replace(entry.getKey(),0.00);
                }
                if(entry.getValue()!=0){
                amtString = amtString+entry.getValue()+" ";
                userString = userString+entry.getKey()+" ";
                }
            }
            String tempUser[] = userString.trim().split("\\s+");
            String tempTotal[] = amtString.trim().split("\\s+");
            int N1=tempTotal.length;
            double tempTot[]=new double[N1];
            for(int i=0;i<N1;i++){
                tempTot[i]=Double.parseDouble(tempTotal[i]);
            }
            for (int i = 0; i < N1-1; i++){
                for (int j = 0; j < N1-i-1; j++){
                    if (tempTot[j] >tempTot[j+1])
                    {
                    double temp = tempTot[j];
                    String temp1 = tempUser[j];
                    tempUser[j]=tempUser[j+1];
                    tempUser[j+1]=temp1;
                    tempTot[j] = tempTot[j+1];
                    tempTot[j+1] = temp;
                    }
                }
            }
            int deflection  = -1;
            for(int i=0;i<N1;i++){
                if(tempTot[i]>0){
                    deflection = i;
                    break;
                }
            }
            for(int i=0,j=N1-1;i<deflection && j>=deflection;){
                if(tempTot[i]+tempTot[j]<0){
                    System.out.println(tempUser[i]+" pays "+tempUser[j]+" Rs."+round(tempTot[j],2));
                    tempTot[i]=tempTot[i]+tempTot[j];
                    j--;
                }
                else if(tempTot[i]+tempTot[j]>0){
                    System.out.println(tempUser[i]+" pays "+tempUser[j]+" Rs."+(-1)*round(tempTot[i],2));
                    tempTot[j]=tempTot[i]+tempTot[j];
                    i++;
                }
                else{
                    System.out.println(tempUser[i]+" pays "+tempUser[j]+" Rs."+(-1)*round(tempTot[i],2));
                    tempTot[j]=tempTot[i]+tempTot[j];
                    i++;
                    j--;
                }
            }
            System.out.println("Add Another Transaction Y/N");
            ch = sc.nextLine();
        }
    }
    public static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();

    BigDecimal bd = new BigDecimal(value);
    bd = bd.setScale(places, RoundingMode.HALF_UP);
    return bd.doubleValue();
}
}