import java.util.*;
class AgglomerativeSingle
{
    public static void printmatrix(int [][]m,int n)
    {
        for(int i=0;i<n;i++)
       {
         for(int j=0;j<n;j++)
         {
            System.out.print(m[i][j]+" ");
         }
         System.out.println();
       }
    }
    public static void findMin(int [][]inputmatrix,int n)
    {
       int  minval=Integer.MAX_VALUE;
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
       System.out.println();
       for(int i=0;i<5;i++)
       {
           inputmatrix[row][i]=Integer.min(inputmatrix[row][i],inputmatrix[row+1][i]);
       }
    }
    public static void main(String [] args)
    {
       Scanner sc=new Scanner(System.in);
       int [][]inputmatrix={{0,0,0,0,0,0},{16,0,0,0,0,0},{47,37,0,0,0,0},{72,57,40,0,0,0},{77,65,30,31,0,0},{79,66,35,23,10,0}};
        printmatrix(inputmatrix,6);
    //   for(int i=0;i<6;i++)
    //   {
    //      for(int j=0;j<6;j++)
    //      {
    //         System.out.print(inputmatrix[i][j]+" ");
    //      }
    //      System.out.println();
    //   }
       findMin(inputmatrix,6);
       
    //   for(int i=0;i<6;i++)
    //   {
    //      for(int j=0;j<6;j++)
    //      {
    //         System.out.print(inputmatrix[i][j]+" ");
    //      }
    //      System.out.println();
    //   }
       printmatrix(inputmatrix,5);
       
    }
}   
   
  
   
  
