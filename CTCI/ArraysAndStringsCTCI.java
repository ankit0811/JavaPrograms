
package ArraysAndStrings;
import java.util.*;

/*Algorithm to check wtr all strings are unique or not*/
class checkUnique{
	checkUnique(){
		
	}
	
	int isUniqueHashTable(String str){
		Hashtable unq = new Hashtable();
		int existingVal=0;
		for (int i=0;i<str.length();i++){
			char existChar=str.charAt(i);
			System.out.println(existChar+" "+unq.get(existChar));
			if (unq.get(existChar)==null){
				existingVal=0;
				unq.put(existChar, existingVal);
			}
			else{
				existingVal=Integer.parseInt(unq.get(existChar).toString());
				unq.put(existChar, existingVal+1);
				Enumeration e = unq.keys();
			    while (e.hasMoreElements()){
			    	String t=e.nextElement().toString();
			    	System.out.println(t+":"+unq.get(t.charAt(0)));
			    }

			  
				return -1;
			}
			
		}
		return 0;
		
	}
	
	int isUniqueHashMap(String str){
		int strLen=str.length();
		HashSet hs=new HashSet();
		for (int i=0;i<strLen;i++){
			hs.add(str.charAt(i));
		}
		
		if (strLen==hs.size())
			return 1;
		
		
		return -1;
		
	}
}

/*----------------------------------------------------------------*/


/*Algorithm to check wtr two strings are permutation of each other*/
class checkPermutation{
	checkPermutation(){
		
	}
	
	int isPermutationHashMap(String str1, String str2){
		int str1Len=str1.length();
		int str2Len=str2.length();
		
		if (str1Len != str2Len)
			return -1;
		HashMap hm=new HashMap();
		for (int i=0;i<str1Len;i++){
			if (hm.get(str1.charAt(i))==null){
				hm.put(str1.charAt(i),1);
			}
			else{
				hm.put(str1.charAt(i),Integer.parseInt(hm.get(str1.charAt(i)).toString())+1);
			}
			if (hm.get(str2.charAt(i))==null){
				hm.put(str2.charAt(i),-1);
			}
			else{
				hm.put(str2.charAt(i),Integer.parseInt(hm.get(str2.charAt(i)).toString())-1);
			}
		}
		
		for (Object i: hm.values()){
			if (Integer.parseInt(i.toString())!=0){
				return -1;
			}
			
		}
				

		return 0;
	}
	
	
	int isPermutationString(String str1, String str2){
		if (str1.length()!=str2.length())
			return -1;
		
		char strArr1[]=str1.toCharArray();
		char strArr2[]=str2.toCharArray();
		Arrays.sort(strArr1);
		Arrays.sort(strArr2);
			
		for (int i=0;i<strArr1.length;i++)
			if (strArr1[i] != strArr2[i]){
				return -1;
			}
		return 0;
		
	}
}

/*----------------------------------------------------------------*/

/*URLify Replace space with %20 given enough space at the end of the string
 * I/p: "Mr John Smith    ",13
 * O/p: "Mr%20John%20Smith"
 * */

class URLify{
	URLify(){
		
	}
	
	void getURLify(String str){
		char strArr[]=str.toCharArray();
		System.out.println(Arrays.toString(strArr));
		System.out.println("i="+strArr.length);
		
		int i=strArr.length-1;
		while(strArr[i] == ' '){
			i--;
		}
		System.out.println(i);
		
		for (int j=strArr.length-1;i>0;i--){
			System.out.println(Arrays.toString(strArr));
			System.out.println("strArr[i]="+strArr[i]);
			
			System.out.println(i);
			if (strArr[i]==' '){
				strArr[j--]='0';
				strArr[j--]='2';
				strArr[j--]='%';
			}
			else{
				strArr[j--]=strArr[i];
			}
			
		}
		System.out.println(String.copyValueOf(strArr));
		
	}
	
}


/*----------------------------------------------------------------*/

/*Palindrome Permutation 
 * Check wtr a string(considering all char) 
 * can be arranged to form a palindrome or not*/

class palindromePermutation{
	palindromePermutation(){
		
	}
	
	boolean chkPermutation(String str){
		HashMap hm=new HashMap();
		int spaceCount=0; 
		for (int i=0;i<str.length();i++){
			if (str.charAt(i) != ' '){
				if (hm.containsKey(str.charAt(i)) && Integer.parseInt(hm.get(str.charAt(i)).toString()) != 0)
					hm.put(str.charAt(i), 
						Integer.parseInt(hm.get(str.charAt(i)).toString())-1);
				else
					hm.put(str.charAt(i), 1);
			}
			else
				spaceCount++;
		}
		
		
		for (Object i : hm.values()){
			System.out.println(Integer.parseInt(i.toString()));
			
		}
		
		if (((str.length()-spaceCount)%2)== 0 && hm.values().contains(1))
			return false;
		if (((str.length()-spaceCount)%2)== 1 && ! (hm.values().contains(1)))
			return false;
			
		
		return true;
	}
}


/*----------------------------------------------------------------*/

/*One Away:
 * Given Two strings, chk if they are one edit or zero edit away 
 * */

class editsAway{
	editsAway(){
		
	}
	
	boolean chkEditsAway(String str1, String str2){
		int lenI=str2.length()+1;
		int lenJ=str1.length()+1;
		int M[][]=new int [lenI][lenJ];
		for (int i=0;i<lenI;i++)
			M[i][0]=i;
		for (int j=0;j<lenJ;j++)
			M[0][j]=j;
		
		for (int i=1;i<lenI;i++){
			for (int j=1;j<lenJ;j++){
				if (str2.charAt(i-1) != str1.charAt(j-1))
					M[i][j]=Math.min(M[i-1][j-1], Math.min(M[i][j-1], M[i-1][j]))+1;
				else
					M[i][j]=Math.min(M[i-1][j-1], Math.min(M[i][j-1], M[i-1][j]));
				
			}
		}
		
		System.out.println(Arrays.deepToString(M));
		if (M[lenI-1][lenJ-1]==0 || M[lenI-1][lenJ-1]==1 )
			return true;
		else
			return false;
	}
}


/*----------------------------------------------------------------*/

/*Rotate Matrix:
 * Given a NxN matrix, rotate the matrix by 90 degrees 
 * */

class MatrixRot{
	MatrixRot(){
		
	}
	
	void getRotMatrix(int M[][],int n){
		int newM[][]=new int [n][n];
		System.out.println("Original Array:");
		System.out.println(Arrays.deepToString(M));
		for (int i =0;i<n;i++){
			for (int j=0;j<n;j++){
				/*Col of original matrix becomes Row of rotated matrix
				 * N - Row of original matrix becomes column of rotated matrix
				 * i.e M[j][n-i]=M[i][j]
				 * So swapping the elements without temp var (add subtract logic)*/
				
				/*M[i][j]=M[i][j]+M[j][n-i-1];
				M[j][n-i-1]=M[i][j]-M[j][n-i-1];
				M[i][j]=M[i][j]-M[j][n-i-1];*/
				newM[j][n-i-1]=M[i][j];
				
			}
			
		}
		System.out.println("Rotated Array:");
		System.out.println(Arrays.deepToString(newM));
	}
}

class MatrixZero{
	MatrixZero(){
		
	}
	
	void getMatrixZero(int M[][]){
		System.out.println("Original Matrix:");
		System.out.println(Arrays.deepToString(M));
		
		int inti=M.length;
		int intj=M[0].length;
		for (int i=1; i<inti; i++){
			for (int j=0; j<intj; j++){
				if ( M[i][j]==0 ){
					M[i][0]=0;
					M[0][j]=0;
				}
			}
		}
		System.out.println("Zero Matrix:");
		System.out.println(Arrays.deepToString(M));
		
		for (int i=1; i<inti; i++){
			if (M[i][0] == 0)
				for (int j=1;j<intj;j++)
					M[i][j]=0;
		}
		System.out.println("Row Zero Matrix:");
		System.out.println(Arrays.deepToString(M));
		
		
		for (int j=1; j<intj; j++){
			if (M[0][j] == 0)
				for (int i=1;i<inti;i++)
					M[i][j]=0;
		}
		
		if (M[0][0]==0){
			for (int i=0;i<inti;i++)
				M[i][0]=0;
			for (int j=0;j<intj;j++)
				M[0][j]=0;
		}
		
		
		System.out.println("Zero Matrix:");
		System.out.println(Arrays.deepToString(M));
		
	}
}



public class ArraysAndStringsCTCI {
	public static void main (String Args[]){
		
		checkUnique cU=new checkUnique();
	//	System.out.println(cU.isUniqueHashTable("ABA"));
	//	System.out.println(cU.isUniqueHashMap("ABC"));
		
		checkPermutation cP=new checkPermutation();
	//	System.out.println(cP.isPermutationHashMap("DOG", "GOD"));
	//	System.out.println(cP.isPermutationHashMap("DOG", "GOd"));
		
	//	System.out.println(cP.isPermutationString("DOG", "GOf"));
		
		URLify uf=new URLify();
	//	uf.getURLify("Mr John Smith    ");

		palindromePermutation pp=new palindromePermutation();
	//	System.out.println(pp.chkPermutation("tact coa"));
		
		editsAway eA=new editsAway();
	//	System.out.println(eA.chkEditsAway("pale", "ales"));
		
		MatrixRot mr= new MatrixRot();
		int M[][]={{1,2},{3,4}};
		int n=M.length;
	//	mr.getRotMatrix(M, n);
		
		MatrixZero mz=new MatrixZero();
		int M1[][]={{0,1,2,0},{4,5,0,7},{5,8,9,10}};
		mz.getMatrixZero(M1);
	}
}


