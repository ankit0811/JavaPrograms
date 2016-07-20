import java.util.Arrays;

class LISS{
	LISS(){
		
	}
	
	void getLISS(int a[]){
		
		int len=a.length;
		int M[]=new int[len];
		
		//Default max length of every element is 1
		for (int i=0;i<len;i++)
			M[i]=1;
		
		for (int i=1;i<len;i++){
			for (int j=0;j<i;j++){
				if(a[i]>a[j]){
					M[i]=Math.max(M[i],M[j]+1);
				}
			}
		}
		
		System.out.println(Arrays.toString(M));
		int max=-99;
		for(int i=0;i<len;i++){
			if (M[i]>max)
				max=a[i];
		}
		System.out.println("Max Length is "+max);
	}
	
}
public class DP_LongestIncrSubSeqLen {
	public static void main(String args[]){
		int a[]={3,4,-1,-5,6,2,-3};
		LISS l=new LISS();
		l.getLISS(a);
	}
}
