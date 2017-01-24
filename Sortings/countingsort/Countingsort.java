import java.io.*;
public class Countingsort { 
      void count_sort(int a[],int b[],int k){ 
          int[] c=new int[k]; 
         for(int j=0;j<a.length;j++){ 
             c[a[j]]=c[a[j]]+1; 
         } 
         for(int i=1;i<k;i++){ 
             c[i]=c[i]+c[i-1]; 
         } 
         for(int j=(a.length-1);j>=0;j--){ 
             b[c[a[j]]-1]=a[j]; 
             c[a[j]]=c[a[j]]-1; 
         } 
      } 
      public static void main(String args[])throws IOException 
       { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter the number of values u are going to enter:  ");
	int x = Integer.parseInt(br.readLine());
	int []a = new int[x];
	System.out.println("Counting Sort: \n Enter the values");
	for(int i=0;i<a.length;i++)
	{
		a[i]= Integer.parseInt(br.readLine());
	}  
	Countingsort ct=new Countingsort(); 
    
          int []b=new int[x];
	 int k=a[0];
           for(int i=0;i<a.length;i++)
          {   if(a[i]>k)
              { a[i]=k;
          }        }
         
          try{ 
          ct.count_sort(a,b,k); 
          }catch(Exception e){}; 
          System.out.println("Sorted Array is:"); 
          for(int i=0;i<b.length;i++){ 
              System.out.print("["+b[i]+"]"+","); 
          } 
      } 
} 