
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
		uf.getURLify("Mr John Smith    ");
		             
	}
}


