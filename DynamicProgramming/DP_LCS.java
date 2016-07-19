import java.util.Arrays;

//Longest Common Subsequence
class LCS{
	
	LCS(){
		
	}
	void getLCS(String str1, String str2){
		int st_i=str1.length()+1;
		int st_j=str2.length()+1;
		int M[][]=new int[str1.length()+1][str2.length()+1];
		
		//Initialize 0th row and 0th column to 0
		for(int i=0;i<st_i;i++)
			M[i][0]=0;
		for(int j=0;j<st_j;j++)
			M[0][j]=0;
		
		for (int i=1;i<st_i;i++){
			for (int j=	1;j<st_j;j++){
				if (i==0){
					if (str1.charAt(i-1)==str2.charAt(j-1))
						M[i][j]=1;
					else
						M[i][j]=0;
				}
				else{
					if (str1.charAt(i-1)==str2.charAt(j-1))
						M[i][j]=M[i-1][j-1]+1;
					else
						M[i][j]=Math.max(Math.max(M[i-1][j-1], M[i-1][j]),M[i][j-1]);
				}
			}
		}
		
		System.out.println(Arrays.deepToString(M));
		System.out.println("Length of LCS="+M[st_i-1][st_j-1]);
		getLCSVal(str1,str2,M);
		
	}
	
	
	void getLCSVal(String str1,String str2, int M[][]){
		String lcs="";
		System.out.println(M[6][0]);
		int i=str1.length();
		int j=str2.length();
		while(M[i][j] !=0){
			if(i-1 >=0 && j-1 >=0){
					if(M[i][j]==M[i][j-1])
						j=j-1;
					else if(M[i][j]==M[i-1][j])
						i=i-1;
					else if(M[i][j]==M[i-1][j-1]+1){
						//Can push the elements onto a stack and then pop the element in the end
						lcs=lcs+str1.charAt(i-1);
						System.out.println("At ["+i+"]["+j+"]");
						i=i-1;
						j=j-1;
					}
					
				}
		}
		System.out.println("LCS is "+new StringBuilder(lcs).reverse().toString());
		
	}
	
}
public class DP_LCS {
	public static void main(String args[]){
		LCS l=new LCS();
		String str1="abcdaf";
		String str2="acbcf";
		l.getLCS(str1, str2);
	}
}
