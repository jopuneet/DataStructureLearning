public class Countingsort2 { 
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
      public static void main(String args[]){ 
          Countingsort2 ct=new Countingsort2(); 
          int []a={1,4,3,1,2,3,0,3}; 
          int []b=new int[8]; 
          int k=10; 
          try{ 
          ct.count_sort(a,b,k); 
          }catch(Exception e){}; 
          System.out.println("Sorted Array is:"); 
          for(int i=0;i<b.length;i++){ 
              System.out.print("["+b[i]+"]"+","); 
          } 
      } 
} 