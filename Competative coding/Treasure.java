/*
While diving in ancient river of Egypt, Shil came across an oblivion treasure of algorithms and data structures.This treasure has powerful algorithmic lock.The procedure to open the lock is as follows:
Given N natural numbers A1, A2, A3 . . . AN, you have process Q queries of following two types:
1 i j: Perform the operation Ai = j.
2 L R: Print the LCM of the elements AL, AL+1, AL+2 . . . AR.
Here LCM stands for lowest common multiple. Please help Shil to open the lock.

Input
First line will contain integer N.
Second line will contain N natural numbers denoting array A.
Third line will contain number of queries Q.
Then next Q lines will contain either query of Type 1 or 2.

Output
For each query of Type 2 output the required answer. Since LCM can be very large output it modulus 109+7.

Constraints
1 = N = 104
1 = Ai = 1000
1 = Q = 104
1 = L = R = N
1 = i = N
1 = j = 1000

Sample Input(Plaintext Link)
 6
1 3 2 5 10 3
5
2 2 3
1 5 5
2 4 5
2 4 6
2 2 2

Sample Output(Plaintext Link)
 6
5
15
3

Explanation
In above Sample Case, there are 5 queries. In First query , you have to calculate LCM of a[2] and a[3] and output its value i.e. 6 In Second query , you have to update a[5] to 5 In Third query , you have to calculate LCM of a[4] and a[5] and output its value .i.e 5

*/
import java.io.*;
import java.util.Arrays;
class Treasure
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		String L="";

		String s1 = br.readLine();
		String s2[] = s1.split(" ");
		int A2[][] = new int[s2.length][3];
		int A[] = new int[s2.length];

		for(int i=0;i<s2.length;i++)
		{
			A[i] = Integer.parseInt(s2[i]);
		}

		int Q = Integer.parseInt(br.readLine());

		for(int i=0;i<Q;i++)
		{
				String s3 = br.readLine();
				String s4[] = s3.split(" ");

				for(int k=0;i<3;k++)
				{
					A2[i][k] = Integer.parseInt(s4[k]);
				}
		}

		for(int i=0;i<Q;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(A2[i][j]==1)
				{
					A[A2[i][j+1]-1] = A2[i][j+2];
					continue;
				}
				else if(A2[i][j]==2)
				{

					int size = A2[i][j+2] - A2[i][j+1];
					int[] B = new int[size];
					B = Arrays.copyOfRange(A,A2[i][j+2],A2[i][j+1]);
					long c = (long)lcm(B);
					L=L+" "+c;
				}

			}
		}
		System.out.println(L);
	}

	private static int gcd(int a, int b)
	{
		while (b > 0)
		{
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

	private static int gcd(int[] input)
	{
		int result = input[0];
		for(int i = 1; i < input.length; i++) result = gcd(result, input[i]);
		return result;
	}

	private static int lcm(int[] input)
	{
	    int result = input[0];
	    for(int i = 1; i < input.length; i++)
	    result = lcm(result, input[i]);
	    return result;
	}
	private static int lcm(int a, int b)
	{
	    return a * (b / gcd(a, b));
	}

}