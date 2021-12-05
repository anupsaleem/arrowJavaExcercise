import java.io.*;
import java.util.*;

class TriangleDiagonalSum {
	
	//global 2d array to interpret triangle object
	static int tri[][];
	
	//loading the 2d array with input array for triangle using constructor
	TriangleDiagonalSum(int breadth,int inpArr[]){
		//input array iterator
		int inpArrIterator=0;
		//initializing 2d array 
		this.tri=new int[breadth][breadth];

		//loop to load 2d array
		for(int i=0;i<breadth;i++){//loop for row
			for(int j=0;j<breadth;j++){//loop for column
				if(i==j){
					for (int k=0;k<j+1;k++){//loop for loading the 2d array when row index and column index are equal
						//loading elements into 2d array from input array
						this.tri[i][k]=inpArr[inpArrIterator];
						//incrementing input array iterator
						inpArrIterator++;
					}
				}
				else{//if row and column index are not equal load -1 at the index
					this.tri[i][j]=-1;
				}
				
			}
		}
	}
	
	
	static int[] maxPathSum(int tri[][], int m, int n)
	{	
		//Initializing temporary variable to store the index of the maximum element out of the diagonal elements
		int temp=0;
		//Initializing result array with size increased by 1 for storing sum of the maximum elements
		int []resultArr=new int[m+2];
		//For interating result array
		//iterator starts from 1 as the first value is stored outside of the loop
		int resultArrInterator=1;
		//initializing the first element into the result array
		resultArr[0]=tri[0][0];
		resultArr[m+1]=tri[0][0];
		//loop for iterating the 2d matrix
		for (int i = 0; i < m ; i++)
		{
				//determining the maximum number out of the diagonal elements
				if (tri[i + 1][temp] > tri[i + 1][temp + 1]){//if the first diagonal element is the maximum
					//loading the max element into result array
					resultArr[resultArrInterator]=tri[i + 1][temp];
					//loading the sum into the last index of result array
					resultArr[m+1]+=resultArr[resultArrInterator];
					
				}
					
				else{//if the second diagonal element is the maximum
					//loading the max element into result array
					resultArr[resultArrInterator]=tri[i + 1][temp + 1];
					//updating the temp variable with new index
					temp=temp+1;
					//loading the sum into the last index of result array
					resultArr[m+1]+=resultArr[resultArrInterator];
				}
				
			//incrementing result array iterator
			resultArrInterator++;
			
		}
	
		
		return resultArr;
	}

	//Function to display the triangle
	static void display(int n, int[]inpArr)
	{
		//Variable for iterating input array
		int inpArrIterator=0;

		for (int i=0; i<n; i++)
        {
 
            
            for (int j=n-i; j>1; j--)
            {
                //Printing spaces
                System.out.print(" ");
            }
  
            
            for (int j=0; j<=i; j++ )
            {
				//Printing values from input array
				System.out.print(inpArr[inpArrIterator]+" ");
				//Incrementing input array iterator
				inpArrIterator++;
            }
  
            //Printing new line
            System.out.println();
        }		
	}  
	

	
	public static void main (String[] args)
	{
		//Initializing necessary variables
		Scanner scan= new Scanner(System.in);
		//Variable for iterating input array
		int inpCount=0; 
		//Variable to determine input type
		char inpType='Y'; 
		//breadth of the triangle
		int breadth=0; 
		System.out.println("Please enter breadth:");
		//Applying check on input for breadth
		while(true){  												
			breadth=scan.nextInt();
			if(breadth>=1 && breadth<=5 )
			break;
			else
			System.out.println("Invalid input. Please try again");
		}
		//Inititalizing input array
		int[] inpArr= new int[breadth * breadth];
		//Initializing result array
		int[] resArr= new int[breadth+2];
		//Loading all elements of input array with -1
		for(int a=0;a<breadth*breadth;a++){
			inpArr[a]=-1;
		}
		//Applying check on input for inpType
		while(true){
			System.out.println("Please enter Y if you want to input numbers of traingle else enter N");
			inpType=scan.next().charAt(0);
			inpType=Character.toUpperCase(inpType);
			if(inpType=='Y' || inpType=='N')
			break;
			else
			System.out.println("Invalid input");
		}
		//Taking inputs into input array
		if(inpType=='Y'){//For taking inputs using scanner
			for(int i=0;i<breadth;i++){//loop for row
				for(int j=0;j<breadth;j++){//loop for column
					if(i==j){
						System.out.println("Please enter line "+(i+1)+" of triangle");
						for(int k=0;k<j+1;k++){//loop for loading the input array when row index and column index are equal
							//Applying check on number input
							while(true){
								inpArr[inpCount]=scan.nextInt();
								if(inpArr[inpCount]>=0 && inpArr[inpCount]<=9 )
								break;
								else
								System.out.println("Invalid input. Please try again");
							}
							
							//incrementing input array iterator
							inpCount++;
						}
						
						
					}
				}
			}
		}else{//for taking inputs using math.random() function
			for(int i=0;i<breadth;i++){//loop for row
				for(int j=0;j<breadth;j++){//loop for row
					if(i==j){
						for(int k=0;k<j+1;k++){//loop for loading the input array when row index and column index are equal
							
							
							inpArr[inpCount] = (int)(Math.random() * 10);
							////incrementing input array iterator
							inpCount++;
						}
						
						
					}
				}
			}
		}
		
		//initializing the triangle object
		TriangleDiagonalSum triangle=new TriangleDiagonalSum(breadth,inpArr);
		//function call to caluclate max path sum. 
		//The function returns the resultant array which is stored in resArr local variable
		resArr=maxPathSum(triangle.tri, breadth-1, breadth-1);

		//Printing output
		System.out.print("\n");
		System.out.println("------------- OUTPUT -------------");
		System.out.print("\n");
		//Function call to display the triangle
		triangle.display(breadth,inpArr);
		System.out.print("\n");
		System.out.println("Resultant Array:"+Arrays.toString(resArr));

		
	}
		
	
}