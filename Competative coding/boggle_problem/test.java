package boggle_problem;
import java.util.ArrayList;

public class test {
    public static void main(String[] arg){

        int[][] arr = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        //int[][] arr = {{width,2,3},{4,5,6},{7,8,9}};
        ArrayList<Integer> al = new ArrayList<Integer>();
        int x = 2, y = 2;
        int width = 2; //change the value of width, according to the requirement 
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if( (i == (x-width) && ( (y+width) >= j && j >= (y-width))) || (i == (x+width) && ( (y+width) >= j && j >= (y-width))) || (j == (y-width) && ( (x+width) >= i && i >= (x-width))) || (j == (y+width) && ( (x+width) >= i && i >= (x-width)))  ){
                    //if( x >= 0 && i < (i+width) && y >= 0 && j < (j+width))
                        {
                        al.add(arr[i][j]);
                        }
                }
            }
        }
        System.out.println(al);
    }

}