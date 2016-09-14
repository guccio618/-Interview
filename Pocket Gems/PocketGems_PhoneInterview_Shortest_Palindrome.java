
public class PocketGems_PhoneInterview_Shortest_Palindrome {
	public String shortestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        
        int len = s.length();
        int maxLen = 0;
        
        for(int i = 0; i <= len / 2; i++){
            maxLen = Math.max(maxLen, Math.max(longestPalindrome(s, i, i), longestPalindrome(s, i, i + 1)));
        }
        
        String suffix = s.substring(maxLen + 1);
        return new StringBuilder(suffix).reverse().toString() + s.substring(0, maxLen + 1) + suffix;
    }
    
    public int longestPalindrome(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        
        if(left == -1){
            return right - 1;
        } else {
            return -1;
        }
    }
   
    
    
 /*********************************************************************/    
 // follow up: to find min Palindrome either from left or right side
    public String shortestPalindrome_follow_up(String s){
    	if(s == null || s.length() == 0){
            return "";
        }
    	
    	int len = s.length();
        int leftMaxLen = 0;
        int rightMaxLen = 0;
        
        for(int i = 0; i <= len / 2; i++){
        	leftMaxLen = Math.max(leftMaxLen, Math.max(longestLeftPalindrome(s, i, i), longestLeftPalindrome(s, i, i + 1)));
        }
        
        for(int i = len / 2 + 1; i < len; i++){
        	rightMaxLen = Math.max(rightMaxLen, Math.max(longestRightPalindrome(s, i, i), longestRightPalindrome(s, i, i + 1)));
        }
        
        if(leftMaxLen > rightMaxLen){
        	String suffix = s.substring(leftMaxLen + 1);        
            return new StringBuilder(suffix).reverse().toString() + s;//s.substring(0, leftMaxLen + 1) + suffix;
        } else {
        	String suffix = s.substring(0, len - rightMaxLen);        
            return s + new StringBuilder(suffix).reverse().toString(); 
        }   	
    } 
    
    public int longestLeftPalindrome(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        
        if(left == -1){
            return right - 1;
        } else {
            return -1;
        }
    }
    
    public int longestRightPalindrome(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        
        if(right == s.length()){
            return right - left - 1;
        } else {
            return -1;
        }
    }
}
