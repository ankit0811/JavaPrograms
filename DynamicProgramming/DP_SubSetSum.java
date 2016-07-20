import java.util.Arrays;

class SubsetSum{
	SubsetSum(){
		
	}
	
	void getSubSetSum(int set[],int sum){
		int val_i=set.length;
		int val_j=sum+1;
		int M[][]=new int[val_i][val_j];
		
		for(int i=0;i<val_i;i++){
			M[i][0]=0;
			for(int j=0;j<val_j;j++){
				if(i==0){
					if (j==set[i])
						M[i][j]=1;
					else
						M[i][j]=0;
				}
				else{
					if (j==set[i])
						M[i][j]=1;
					else{
						if (j>set[i])
							M[i][j]=Math.max(M[i-1][j], M[i-1][j-set[i]]);
						else
							M[i][j]=M[i-1][j];
					}
				}
			}
		}
		
		System.out.println(Arrays.deepToString(M));
		System.out.println("Can "+sum+" be obtained from subset "+Arrays.toString(set)+" ? \nAns:" +M[val_i-1][val_j-1] );
		getSubSetVal(set,M);
		
	}
	
	void getSubSetVal(int set[],int M[][]){
		int i=M.length-1;
		int j=M[i].length-1;
		while(i>=0 && j != 0){
			if(M[i][j-set[i]]==1 || (M[i][j]==1 && j-set[i]==0)){
				System.out.println(set[i]);
				j=j-set[i];
			}
			i=i-1;
		}
		
	}
}
public class DP_SubSetSum {
	public static void main(String args[]){
		SubsetSum ss=new SubsetSum();
		int set[]={10,8,3,2,7};
		int sum=11;
		ss.getSubSetSum(set,sum);
	}

}
