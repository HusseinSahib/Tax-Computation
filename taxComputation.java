/*author: Hussein Sahib
date: 4/12/2017
description: this program calculates total tax*/
import java.util.*;
public class Assignment1b
{ 
  public static void main(String[] args)
  {
      double Number_of_Exemptions = enter_input ("Enter Number of Exemptions");//seting up variables
      double Gross_Salary = enter_input ("Enter Gross Salary");
      double Interest_Income =   enter_input ("Enter Interest Income");
      double Capital_Gains =  enter_input ("Enter Capital Gains");
      double Charitable_Contributions =  enter_input ("Enter Charitable Contributions"); 
      double Total_Income =  TotalIncome ( Gross_Salary, Interest_Income,  Capital_Gains);//calculating total income
      double Adjusted_Income =   AdjustedIncome ( Total_Income,  Number_of_Exemptions,  Charitable_Contributions);//calculating adjusted income
      double Total_Tax =  TotalTax ( Adjusted_Income); //calculating total tax
      display ( Total_Income, Total_Tax, Adjusted_Income);//displaying out put
        
   } 
  public static double enter_input (String words){//takes input
   Scanner ip = new Scanner(System.in);//intilizing ip
   System.out.printf("%s: ",words);
   double input = ip.nextDouble();//input
   return input;
  }
  public static double TotalIncome (double Gross_Salary, double Interest_Income, double Capital_Gains){//calculates total income
      return (Gross_Salary + Interest_Income + Capital_Gains);//returns result
  }
  public static double AdjustedIncome (double Total_Income, double Number_of_Exemptions, double Charitable_Contributions){//calculate adjusted income
       return(Total_Income - (Number_of_Exemptions * 1500.00) - Charitable_Contributions);//returns result
  }
  public static double TotalTax (double Adjusted_Income){//calculating total tax
     double check = Adjusted_Income;
     double total = 0;
     if(check <= 10000){//first check
        return 0;
     } 
     else if (check >=50000){//second check
        check -= 32000;//check is for clarification
        total += (22000 * 0.15); //calculating using a formula
        check -= 18000;
        total += (18000 * 0.23);
        check -= (Adjusted_Income-50000 ) ;
        total += (Adjusted_Income-50000 ) * 0.28;
     }  
     
     return total;
  }
  public static void display (double Total_Income,double Total_Tax,double Adjusted_Income){//display out put
     System.out.println("Total income: " + Total_Income );//displaying total income
     System.out.println("Adjusted Income: " + Adjusted_Income );
     System.out.printf("Total Tax: %.2f ", Total_Tax );//using print format
  }
  }
//end of program  