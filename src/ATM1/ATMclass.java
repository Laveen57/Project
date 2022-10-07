package ATM1;


import java.util.*;
public class ATMclass{
      int amount,total=0;
      int twothousands;
      int fivehundreds;
      int hundred;
      String id[]= {"101","102","103","104","105"};
      String name[]= {"Suresh","Ramesh","Ganesh","Mahesh","Harish"};
      String pin[]= {"2343","5432","7854","2345","1907"};
      int bal[]= {25234,34123,26100,80000,103400};
  public void loadCash(){
      Scanner sc=new Scanner(System.in);
      System.out.println("Enter number of Two Thousands");
      twothousands=sc.nextInt();
      System.out.println("Enter number of Five Hundreds");
      fivehundreds=sc.nextInt();
      System.out.println("Enter number of  Hundreds");
      hundred=sc.nextInt();
      total=(2000*twothousands)+(500*fivehundreds)+(100*hundred);
      System.out.println("\n");
      System.out.println("Denomination"+" "+"Number"+" "+"Value");
      System.out.println("2000"+"         "+twothousands+"     "+(2000*twothousands));
      System.out.println("500"+"          "+fivehundreds+"    "+(500*fivehundreds));
      System.out.println("100"+"          "+hundred+"    "+(100*hundred));
      System.out.println("\nTotal cash available:"+total);
   }  
  public void customerDetails(){
      String id[]= {"101","102","103","104","105"};
      String name[]= {"Suresh","Ramesh","Ganesh","Mahesh","Harish"};
      String pin[]= {"2343","5432","7854","2345","1907"};
      int bal[]= {25234,34123,26100,80000,103400};
      System.out.println("\nAccNo"+" "+"Account Holder"+" "+"Pin Number"+" "+"Account Balance");
      for(int i=0;i<5;i++){
          System.out.println(id[i]+"      "+name[i]+"       "+pin[i]+"       "+bal[i]);
          }
          System.out.println("\n");
      }
  public void ATMOperations(){
	  int ch;
      do
      {
    	    System.out.println("ATM Operations");
            System.out.println("1.Check Balance");
            System.out.println("2.Withdraw Money");
            System.out.println("3.Transfer Money");
            System.out.println("4.Check ATM Balance");
            System.out.println("5.Exit");
            System.out.println("\nEnter the choice: ");
            Scanner sc=new Scanner(System.in);
            ch=sc.nextInt();
        switch(ch)
        {
         case 1:
           {
                String acn=sc.next();
                String apin=sc.next();
                for(int i=0;i<5;i++)
                {
                  if(id[i].equals(acn)&&pin[i].equals(apin))
                  {
                       System.out.println(bal[i]);
                       break;
                   }
                  else
                  {
               	   System.out.println("There is no Valid Balance to display...!!!"); 
               	   break;
                  } 
                } 
                break;
            }
         case 2:
            {
                   int i;
                   String acn=sc.next();
                   String apin=sc.next();
                   for( i=0;i<5;i++)
                   {
                     if(id[i].equals(acn)&&pin[i].equals(apin))
                     {
                        System.out.println("Enter the amount to be withdraw:");
                        amount=sc.nextInt();
                        if(amount<=bal[i])
                        {
                             System.out.println("Please take your Money...!!!");
                             bal[i]-=amount;    
                         }
                       else
                       System.out.println("Withdrawal failed...!!!");
                      }
                   }
                   break;
              }
          case 3:
            {
             System.out.println("Enter the account no of the sender:");
             String acNosen=sc.next();
             System.out.println("Enter the pin number of the sender:");
             String pinNosen=sc.next();
             System.out.println("Enter the  of the account no of the receiver:");
             String acNoRes=sc.next();
             System.out.println("Enter the amount to be transfer:");
             int transferamt=sc.nextInt();
             for(int i=0;i<5;i++)
             {
             if(id[i].equals(acNosen)&&pin[i].equals(pinNosen))
             {
                 if((transferamt<=bal[i])&&(transferamt>1000&&transferamt<10000))
                 {
                       System.out.println("Transaction Successfull...!!!");
                 }
               else
                 {
                     System.out.println("Transaction failed...!!!");
                 }
              }
             }
            int i;
            for(i=0;i<5;i++)
            {
               if(id[i].equals(acNoRes))
              {
                bal[i]+=transferamt;
                System.out.print(bal[i]+" is the amount resides at the receiver side after the transaction...!!!\n");
              }
            }
            for(i=0;i<5;i++)
            {
               if(id[i].equals(acNosen))
              {
                bal[i]-=transferamt;    
                System.out.print(bal[i]+" is the amount resides at the sender side after the transaction...!!!\n");
              }
            }
       break;
        }
     case 4:
      {
        int total1=total-amount;
        twothousands -= amount/2000;
        amount -= amount/2000;
        fivehundreds -= amount/1000;
        amount -= amount/1000;
        hundred -= amount/100;
        amount -= 100;
        System.out.println("Denomination"+" "+"Number"+" "+"Value");
        System.out.println("2000"+" "+twothousands+" "+(2000*twothousands));
        System.out.println("500"+" "+fivehundreds+" "+(500*fivehundreds));
        System.out.println("100"+" "+hundred+" "+(100*hundred));
        System.out.print("                                                          ");
        System.out.println("Total cash available in ATM after some process:"+total1);
        break;
      }
     case 5:{
   	  System.out.println("Thanks for Choosing our ATM service...!!!");
   	  break;
        }
      }
    }while(ch!=5);
}
      public static void main(String[] args){
            ATMclass m=new ATMclass();
            m.loadCash();
            m.customerDetails();
            m.ATMOperations();
  }
}