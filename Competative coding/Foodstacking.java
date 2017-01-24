/**Given an array of non-negative integers. Find if the array can be sorted(ascending) in single swap of two numbers or not.
ex1 :- A = [12,14,23,42,28,33,39,25,45] should return true. since swapping 42 and 25 will sort the array A.


ex2 :- A = [12,14,23,42,28,33,22,25,45] should return false. */

import java.io.*;
class Foodstacking
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a[] = new int[10];
		int t=0;
		for(int i=0;i<10;i++)
		{
			a[i] = Integer.parseInt(br.readLine());
		}
		if(!Foodstacking.sortcheck(a[]))
		{
			for(int i=0;i<9;i++)
			{
				for(int j=i;j<10;j++)
				{
					if(a[i]>a[j])
					{
						t=a[i];
						a[i]=a[j];
						a[j]=t;
						if(Foodstacking.sortcheck(a[]))
						return true;
					}
				}
		}
	}

	public boolean sortcheck(int[] b)
	{
		int p=0;
		for(int i=0;i<9;i++)
		{
			if(b[i]<=b[i+1])
			p++;
		}

		if(p==8)
		return true;
		else
		return false;
	}
}