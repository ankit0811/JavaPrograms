import java.util.Arrays;

class WeightJobSch{
	WeightJobSch(){
		
	}
	
	void getWeight(int sch[][]){
		System.out.println(Arrays.deepToString(sch));
		//Sort on end time asc
		sch=getSortedEndTime(sch);
		System.out.println(Arrays.deepToString(sch));
		int len_i=sch.length;
		int M[][]=new int[len_i][2];
		
		for (int i=0;i<len_i;i++){
			M[i][0]=sch[i][2];
			M[i][1]=i;
		}
		
		
		for (int i=1;i<len_i;i++){
			for (int j=0;j<i;j++){
				if (sch[i][0] >= sch[j][1]){
					M[i][0]=Math.max(M[j][0]+sch[i][2], M[i][0]);
					M[i][1]= M[j][0]+sch[i][2] >= M[i][0] ? j:M[i][1] ;
				}
			}
		}
		System.out.println(Arrays.deepToString(M));
		System.out.println("Intervals Choosen:\n[St,Et,Wt]");
		getSch(M,sch);
	}
	
	int[][] getSortedEndTime(int[][] sch){
		
		for (int i=0;i<sch.length;i++){
			for (int j=i+1;j<sch.length;j++){
				if (sch[i][1]>sch[j][1]){
					int temp[]=sch[i];
					sch[i]=sch[j];
					sch[j]=temp;
				}
			}
		}
		
		return sch;
	}
	
	void getSch(int[][] M,int [][] sch){
		int max=M[0][0];
		int maxIdx=0;
		for(int i=1;i<M.length;i++){
			if (max<M[i][0]){
				max=M[i][0];
				maxIdx=i;
			}
		}
		
		int i=maxIdx;
		while(i!=M[i][1]){
			System.out.println(Arrays.toString(sch[i]));
			i=M[i][1];
		}
		System.out.println(Arrays.toString(sch[i]));
	}
}
public class DP_WeightedJobSchedule {
	public static void main(String args[]){
		WeightJobSch WJS=new WeightJobSch();
		//{strt time, end time, weight}
		int sch[][]={{7,9,2},{5,8,11},{4,6,5},{6,7,4},{1,3,5},{2,5,6}};
		WJS.getWeight(sch);
	}
}
