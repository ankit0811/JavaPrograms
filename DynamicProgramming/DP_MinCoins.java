import java.util.Arrays;

class MinCoin{
	int INF=999999;
	int _INF=-1;
	MinCoin(){
		
	}
	
	void getMinCoin(int coins[],int sum){
		int val_j=sum+1;
		int val_i=coins.length;
		int M[]=new int[val_j];
		int M1[]=new int[val_j];
		
		for (int j=1;j<val_j;j++){
			M[j]=INF;
			M1[j]=_INF;
		}
		
		for (int i=0;i<val_i;i++){
			for(int j=0;j<val_j;j++){
				if (j-coins[i] >=0)
					if (M[j]>1+M[j-coins[i]]){
						M1[j]=i;
						M[j]=1+M[j-coins[i]];
					}
			}
		}
		
		System.out.println(Arrays.toString(M));
		System.out.println(Arrays.toString(M1));
		System.out.println("Sum "+sum+" can be obtained from "+M[val_j-1]+" coins");
		System.out.println("Coins Selected are:");
		getCoins(M,M1,coins);
	}
	
	void getCoins(int M[],int M1[],int coins[]){
		int i=M.length-1;
		while(M[i]!=0 && i!=0){
			System.out.println(coins[M1[i]]);
			i=i-coins[M1[i]];
		}
	}
}
public class DP_MinCoins {
	public static void main(String args[]){
		int coins[]={7,2,3,6};
		int sum=13;
		MinCoin mc=new MinCoin();
		mc.getMinCoin(coins, sum);
	}
}
