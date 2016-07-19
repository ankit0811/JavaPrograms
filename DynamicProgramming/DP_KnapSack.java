import java.util.*;

class KnapSack{
	
	void KS(int wt[],int val[],int capacity){
		System.out.println(Arrays.toString(wt));
		System.out.println(Arrays.toString(val));
		int maxWt=0;
		for (int i=0;i<wt.length;i++){
			if (maxWt<wt[i])
				maxWt=wt[i];
		}
			
		int M[][]=new int[wt.length][capacity+1];
		
		for (int i=0; i<wt.length;i++){
			M[i][0]=0;
			for (int j=0;j<=capacity;j++){
				if(i==0){
					if(wt[i]>j)
						M[i][j]=0;
					else
						M[i][j]=val[i];
				}
				else{
					if(wt[i]>j){
						M[i][j]=M[i-1][j];
					}
					else{
						M[i][j]=Math.max(val[i]+M[i-1][j-wt[i]], M[i-1][j]);
					}
					
				}
			}
		}
		
		System.out.println(Arrays.deepToString(M));
		System.out.println("Max Value is :"+ M[wt.length-1][capacity]);
		getWeights(wt,val,M);
	}
	
	void getWeights(int wt[],int val[],int M[][]){
		int i=wt.length-1;
		System.out.println(Arrays.toString(M[i]));
		int j=M[i].length-1;
		System.out.println("i="+i+"j="+j);
		
		while(M[i][j]!=0){
			if (i-1 >= 0 && j-1 >=0){
				if (M[i][j]!=M[i-1][j] && M[i][j]!=M[i][j-1]){
					System.out.println("Weigth Selected=" + wt[i]);
					j=j-wt[i];
					i=i-1;
				}
				else{
					if(M[i][j]==M[i-1][j])
						i=i-1;
					else if(M[i][j]!=M[i][j-1])
						j=j-1;
				}
			}
		}
	}
	
}

public class DP_KnapSack {

	public static void main(String args[]){
		int[] wt=new int[] {1,3,5,4};
		int[] val={1,4,5,7};
		int capacity=7;
		KnapSack k=new KnapSack();
		k.KS(wt,val,capacity);
	}
}
