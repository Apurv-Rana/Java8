package com.apurv.apurv.collection.Matrix;
import java.util.Scanner;


public class Matrix {

	 static int[][] matrix = new int[3][3];
	    static Scanner s = new Scanner(System.in);
	    public static void setMatrix()
	    {
	        System.out.println("Enter element row wise");
	        for(int i=0 ;i <3;i++)
	        {
	            for(int j=0;j<3;j++)
	            {
	                matrix[i][j]=s.nextInt();
	            }
	        }
	    }
	    
	    public static void printMatrix()
	    {
	        int[] row = SumOfRow();
	        int[] columm = sumOfColumm();
	        int diagonal = sum0fDiagonal();
	        
	         for(int i=0 ;i <3;i++)
	        {
	            for(int j=0;j<3;j++)
	            {
	                System.out.print(matrix[i][j]+"\t");
	            }
	            
	            System.out.print("|" + row[i]+"\n");
	        }
	        
	        System.out.println("__________________    /");
	        for(int i=0;i<3;i++)
	        {
	            System.out.print(columm[i] +"\t");
	        }
	        System.out.print(diagonal);
	    }
	    
	    public  static int[] SumOfRow()
	    {
	        int[] row = new int[3];
	        int sum = 0;
	        
	        for(int i=0;i<3;i++)
	        {
	            for(int j=0;j<3;j++)
	            {
	                sum=sum+matrix[i][j];
	            }
	            row[i] = sum;
	            sum=0;
	        }
	        
	        return row;
	    }
	    
	    public static  int[] sumOfColumm()
	    {
	      int[] columm = new int[3];
	        int sum = 0;
	        
	        for(int i=0;i<3;i++)
	        {
	            for(int j=0;j<3;j++)
	            {
	                sum=sum+matrix[j][i];
	            }
	            columm[i] = sum;
	            sum=0;
	        }
	        
	        return columm;
	    }
	    
	    public static int sum0fDiagonal()
	    {
	        int sum=0;
	        for(int i =0; i<3 ; i ++)
	        {
	            sum = sum + matrix[i][i];
	        }
	        
	        return sum;
	    }
}
