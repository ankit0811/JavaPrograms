
class MaxSumRect{
	MaxSumRect(){
		
	}
	
	void getMaxRectSum(int M[][]){
		//Var assignment
		int currMax=0,actMax=0;
		int left=0,right=0,up=0,down=0;
		
		int len_i=M.length;
		int len_j=M[len_i-1].length;
		
		int temp[]=new int[len_i];
		
		for (int L=0;L<len_j;L++){
			//Reset temp array
			temp=new int[len_i];
			for (int R=L;R<len_j;R++){
				for(int i=0;i<len_i;i++){
					temp[i]=temp[i]+M[i][R];
				}
				int[] max1D=getMaxSumIndex(temp);
				currMax=max1D[0];
				if (currMax > actMax){
					up=max1D[1];
					down=max1D[2];
					actMax=currMax;
					left=L;
					right=R;
				}
				//System.out.println(Arrays.toString(max1D));
			}
		}
		
		System.out.println("MaxSum="+actMax+" left="+left+" right="+right+" up="+up+" down="+down);
	}
	
	//Kadane's Algorithm
	int[] getMaxSumIndex(int[] colArr){
		int len_i=colArr.length;
			int maxSum=0,currSum=0,stIdx=0,endIdx=0;
			for (int i=0;i<len_i;i++){
				currSum=currSum+colArr[i];
				if (currSum>maxSum){
					endIdx=i;
					maxSum=currSum;
				}
				if (currSum<0){
					stIdx=endIdx+1;
					currSum=0;
				}
			}
			
		return (new int []{maxSum,stIdx,endIdx}); 
	}
}
public class DP_MaxSumRectangle {
	public static void main(String args[]){
		int[][]M={{ 2, 1,-3,-4, 5},
				  { 0, 6, 3, 4, 1},
				  { 2,-2,-1, 4,-5},
				  {-3, 3, 1, 0, 3}};
		MaxSumRect MSR=new MaxSumRect();
		MSR.getMaxRectSum(M);
		
		//System.out.println(Arrays.toString(MSR.getMaxSumIndex(M[3])));
	}
}
