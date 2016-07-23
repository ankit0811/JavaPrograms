import java.util.Arrays;

class EggBreaking{
	EggBreaking(){
		
	}
	
	void getMinTries(int flr,int egg){
		int len_i=egg+1;
		int len_j=flr+1;
		int M[][]=new int[len_i][len_j];
			
		
		for (int i=0;i<len_i;i++){
			for (int j=0;j<len_j;j++){
				if (i==0||j==0)
					M[i][j]=0;
				else if (i==1)
					M[i][j]=j;
				else{
					if (i>j)
						M[i][j]=M[i-1][j];
					else{
						int min=999;
						for (int k=1;k<=j;k++){
							System.out.println((i-1) + " " + (j-k));
							//1. 1st parameter for egg breaks(reduce egg no,and floor no)
							//2. 2nd parameter for egg doesn't breaks(egg no is same, floors remaining)
							if (min > Math.max(M[i-1][k-1], M[i][j-k])+1){
								min=Math.max(M[i-1][k-1], M[i][j-k])+1;
							}
								
						}
						M[i][j]=min;
					}
						
				}
			}
		}
		
		System.out.println(Arrays.deepToString(M));
		System.out.println("Min No of Tries req is "+M[len_i-1][len_j-1]);
	}
	
	
}
public class DP_EggBreaking {
	public static void main(String args[]){
		EggBreaking EB =new EggBreaking();
		int flr=36;
		int egg=2;
		EB.getMinTries(flr, egg);
	}
}
