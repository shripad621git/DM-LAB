import java.util.*;
class AgglomerativeSingle
{
    public static void main(String [] args)
    {
       Scanner sc=new Scanner(System.in);
       int [][]inputmatrix={{0,0,0,0,0,0},{16,0,0,0,0,0},{47,37,0,0,0,0},{72,57,40,0,0,0},{77,65,30,31,0,0},{79,66,35,23,10,0}};
       
       for(int i=0;i<6;i++)
       {
         for(int j=0;j<6;j++)
         {
            System.out.print(inputmatrix[i][j]+" ");
         }
         System.out.println();
       }
       int minval=Integer.MAX_VALUE;
       int row=0;
       int col=0;
       for(int i=0;i<6;i++)
       {
         for(int j=0;j<6;j++)
         {
           if(j<i)
           {
               if(inputmatrix[i][j]<minval)
               {
                   minval=Math.min(minval,inputmatrix[i][j]);
                   row=i-1;
                   col=j;
               }
           }
         }
         
       }
       System.out.println(minval+" "+row+" "+col);
       for(int i=0;i<5;i++)
       {
           inputmatrix[row][i]=Integer.min(inputmatrix[row][i],inputmatrix[row+1][i]);
       }
       for(int i=0;i<6;i++)
       {
         for(int j=0;j<6;j++)
         {
            System.out.print(inputmatrix[i][j]+" ");
         }
         System.out.println();
       }
       
    }
}   
   
  
