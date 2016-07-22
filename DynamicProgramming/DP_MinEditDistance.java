import java.util.Arrays;

class minEdit{
	minEdit(){
		
	}
	
	void getminEdit(String str1,String str2){
		int len_i=str1.length()+1;
		int len_j=str2.length()+1;
		
		int M[][]=new int[len_i][len_j];
		//Initialize column and row of first index to i and j 
		//as that is the cost it will take to convert null string to stri or strj to null string
		for (int i=0;i<len_i;i++)
			M[i][0]=i;
		for (int j=0;j<len_j;j++)
			M[0][j]=j;
		
		for (int i=1;i<len_i;i++){
			for (int j=1;j<len_j;j++){
				if(str1.charAt(i-1)==str2.charAt(j-1))
					M[i][j]=M[i-1][j-1];
				else
					M[i][j]=Math.min(Math.min(M[i-1][j], M[i][j-1]),M[i-1][j-1])+1;
			}
		}
		
		System.out.println(Arrays.deepToString(M));
		System.out.println("Min Edits req to convert str2 to str1 is "+M[len_i-1][len_j-1]);
		getEdits(str1,str2,M);
	}
	
	void getEdits(String str1,String str2,int[][] M){
		int i=M.length-1;
		int j=M[i].length-1;
		
		while(i!=0 && j!=0){
			if (M[i][j]==M[i][j-1]+1){
				System.out.println("Delete element from str2 "+str2.charAt(j-1)+" at position "+(j-1));
				j=j-1;
			}
			else if(M[i][j]==M[i-1][j-1]+1){
				System.out.println("Replace element from str2 "+str2.charAt(j-1)+" at position "+(j-1) +
						" with element from str1 " + str1.charAt(i-1)+" at position "+(i-1));
				i=i-1;j=j-1;
			}
			else if (M[i][j]==M[i-1][j-1]){
				i=i-1;j=j-1;
			}
			
			
		}
		
	}
}
public class DP_MinEditDistance {
	public static void main (String args[]){
		minEdit m=new minEdit();
		String str1="azced";
		String str2="abcdef";
		m.getminEdit(str1, str2);
	}
}
