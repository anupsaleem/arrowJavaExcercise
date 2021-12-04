import java.io.*;
import java.util.*;

class TriangleDiagonalSum {
		
	static int tri[][];
	

	TriangleDiagonalSum(int breadth,int inpArr[]){
		int z=0;
		this.tri=new int[breadth][breadth];

		for(int i=0;i<breadth;i++){
			for(int j=0;j<breadth;j++){
				if(i==j){
					for (int k=0;k<j+1;k++){
						this.tri[i][k]=inpArr[z];
						z++;
					}
				}
				else{
					this.tri[i][j]=-1;
				}
				
			}
		}
	}
	
	
	static int[] maxPathSum(int tri[][], int m, int n)
	{	
		int temp=0;
		int []resultArr=new int[m+2];
		int resultArrInterator=1;
		
		resultArr[0]=tri[0][0];
		for (int i = 0; i < m ; i++)
		{
			
				if (tri[i + 1][temp] > tri[i + 1][temp + 1]){
					resultArr[resultArrInterator]=tri[i + 1][temp];
					
				}
					
				else{
					resultArr[resultArrInterator]=tri[i + 1][temp + 1];
					temp=temp+1;
				}
				
			
			resultArrInterator++;
			
		}
	
		
		return resultArr;
	}
	static void display(int n, int[]inpArr)
	{
		int inpArrIterator=0;
		for (int i=0; i<n; i++)
        {
 
            
            for (int j=n-i; j>1; j--)
            {
                
                System.out.print(" ");
            }
  
            
            for (int j=0; j<=i; j++ )
            {
                
				System.out.print(inpArr[inpArrIterator]+" ");
				inpArrIterator++;
            }
  
            
            System.out.println();
        }		
	}  
	

	
	public static void main (String[] args)
	{
		Scanner scan= new Scanner(System.in);
		int inpCount=0;
		char inpType='Y';
		int breadth=0;
		System.out.println("Please enter breadth:");
		while(true){
			breadth=scan.nextInt();
			if(breadth>=1 && breadth<=5 )
			break;
			else
			System.out.println("Invalid input. Please try again");
		}
		int[] inpArr= new int[breadth * breadth];
		int[] resArr= new int[breadth+2];
		for(int a=0;a<breadth*breadth;a++){
			inpArr[a]=-1;
		}
		while(true){
			System.out.println("Please enter Y if you want to input numbers of traingle else enter N");
			inpType=scan.next().charAt(0);
			inpType=Character.toUpperCase(inpType);
			if(inpType=='Y' || inpType=='N')
			break;
			else
			System.out.println("Invalid input");
		}
		if(inpType=='Y'){
			for(int i=0;i<breadth;i++){
				for(int j=0;j<breadth;j++){
					if(i==j){
						System.out.println("Please enter line "+(i+1)+" of triangle");
						for(int k=0;k<j+1;k++){
							while(true){
								inpArr[inpCount]=scan.nextInt();
								if(inpArr[inpCount]>=0 && inpArr[inpCount]<=9 )
								break;
								else
								System.out.println("Invalid input. Please try again");
							}
							
							
							inpCount++;
						}
						
						
					}
				}
			}
		}else{
			for(int i=0;i<breadth;i++){
				for(int j=0;j<breadth;j++){
					if(i==j){
						for(int k=0;k<j+1;k++){
							
							
							inpArr[inpCount] = (int)(Math.random() * 10);
							inpCount++;
						}
						
						
					}
				}
			}
		}
		
		TriangleDiagonalSum triangle=new TriangleDiagonalSum(breadth,inpArr);
		resArr=maxPathSum(triangle.tri, breadth-1, breadth-1);
		for(int m=0;m<breadth+1;m++){
			if(m !=breadth){
				resArr[breadth]+=resArr[m];
			}
			
		}
		System.out.print("\n");
		System.out.println("------------- OUTPUT -------------");
		System.out.print("\n");
		triangle.display(breadth,inpArr);
		System.out.print("\n");
		System.out.println("Resultant Array:"+Arrays.toString(resArr));

		
	}
		
	
}