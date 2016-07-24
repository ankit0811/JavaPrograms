import java.util.Arrays;

class LCS1{
	LCS1(){
		
	}
	void getLCS(String str1,String str2){
		int len_i=str1.length()+1;
		int len_j=str2.length()+1;
		
		int M[][]=new int[len_i][len_j];
		
		for (int i=1;i<len_i;i++){
			
			for (int j=1;j<len_j;j++){
				if (str1.charAt(i-1)==str2.charAt(j-1))
					M[i][j]=M[i-1][j-1]+1;
				else
					M[i][j]=0;
			}
		}
		System.out.println(Arrays.deepToString(M));
		int idx[]=getMaxLength(M);
		System.out.println(idx[0]+"::"+idx[1]);
		int i=idx[0];
		int j=idx[1];
		String outStr="";
		while(i!=0 && j!=0){
			if (M[i][j]>0){
				outStr=str1.charAt(i-1)+outStr;
			}
			i=i-1;
			j=j-1;
			
			
		}
		
		System.out.println("Substring is :" + outStr);
	}
	
	int[] getMaxLength(int[][] M){
		int max=-1;
		int idx[]=new int[2];
		for (int i=0;i<M.length;i++)
			for(int j=0;j<M[i].length;j++){
				if (max<M[i][j]){
					max=M[i][j];
					idx[0]=i;
					idx[1]=j;
				}
			}
		System.out.println("Max substring length is : "+max);
		return idx;
	}
	
}
public class DP_LongestCommonSubstring {
	public static void main(String args[]){
		LCS1 l=new LCS1();
		String str1="abcdaf";
		String str2="zbcdf";
		
		l.getLCS(str1, str2);
	}
}
