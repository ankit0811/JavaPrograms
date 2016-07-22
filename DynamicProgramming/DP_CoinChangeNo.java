import java.util.Arrays;

class CoinChange{
	CoinChange(){
		
	}
	
	void getCoinChangeNo(int coins[],int sum){
		int len_i=coins.length;
		
		int M[][]=new int[len_i][sum+1];
		for(int i=0;i<len_i;i++){
			M[i][0]=1;
			for (int j=1;j<sum+1;j++){
				if(i==0){
					//System.out.println("j= "+j+" coins[i]="+coins[i]);
					if (coins[i]<=j && j%coins[i]==0)
						M[i][j]=1;
				}
				else{
					if (coins[i]>j)
						M[i][j]=M[i-1][j];
					else
						M[i][j]=M[i][j-coins[i]]+M[i-1][j];
				}
			}
			
		}
		
		System.out.println(Arrays.deepToString(M));
		System.out.println("No of ways sum of "+sum+" can be acheived is "+M[len_i-1][sum]);
	}
}
public class DP_CoinChangeNo {
	public static void main(String args[]){
		CoinChange cc=new CoinChange();
		int coins[]={3,5};
		int sum=20;
		cc.getCoinChangeNo(coins,sum);
	}
}
