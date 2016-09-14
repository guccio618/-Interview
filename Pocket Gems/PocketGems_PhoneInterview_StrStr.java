
public class PocketGems_PhoneInterview_StrStr {
	public static int strStr(String haystack, String needle){
		if(haystack == null || needle == null){
			return -1;
		} else if(needle.length() > haystack.length()){
			return -1;
		}
		
		int len1 = haystack.length(), len2 = needle.length();
		char c = needle.charAt(0);
		
		for(int i = 0; i <= len1 - len2; i++){		
			if(c == haystack.charAt(i)){
				if(haystack.substring(i, i + len2).equals(needle)){
					return i;
				}
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args){
		String str = "aaaaaaab";
		String subStr = "aab";
		
		System.out.println(strStr(str, subStr));
	}
}
