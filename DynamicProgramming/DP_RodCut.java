import java.util.Arrays;

class RodCut{
	RodCut(){
		
	}
	
	void getRodCutVal(int val[][],int rodLen){
		int len_j=rodLen+1;
		int len_i=val.length;
		int M[][]=new int[len_i][len_j];
		
		for (int i=0;i<len_i;i++){
			for (int j=0;j<len_j;j++){
				if (j==0)
					M[i][j]=0;
				if (i==0){
					if (val[i][0]<=j )
						if (j-val[i][0] >=0)
							M[i][j]=val[i][1]+M[i][j-val[i][0]];
						else
							M[i][j]=val[i][1];
							
				}
				else{
					if (val[i][0]<=j )
						if (j-val[i][0] >=0)
							M[i][j]=Math.max(val[i][1]+M[i][j-val[i][0]],M[i-1][j]);
						else
							M[i][j]=Math.max(val[i][1],M[i-1][j]);
					else
						M[i][j]=M[i-1][j];
				}
			}
		}
		
		System.out.println(Arrays.deepToString(M));
		System.out.println("Max sum obtained is "+M[len_i-1][len_j-1]);
		getRodCuts(val,M);
	}
	
	void getRodCuts(int val[][],int M[][]){
		System.out.println("Len:Val");
		int i=M.length-1;
		int j=M[i].length-1;
		while(j!=0){
			
			if (i!=0 && j!=0){
				
					if (j-val[i][0] >= 0 && M[i][j]==val[i][1]+M[i][j-val[i][0]]){
						System.out.println(val[i][0]+"  :  "+val[i][1]);
						j=j-(val[i][0]);
					}
				else if (M[i][j]==M[i-1][j]){
						i=i-1;
					}
				
			}
			
		}
	}
}
public class DP_RodCut {
	public static void main(String args[]){
		RodCut rc=new RodCut();
		//0th col: Rod cut length
		//1st col: Rod cut val
		int[][] val={{1,2},{2,5},{3,7},{4,8}};
		int rodLen=5;
		rc.getRodCutVal(val, rodLen);
	}
}
