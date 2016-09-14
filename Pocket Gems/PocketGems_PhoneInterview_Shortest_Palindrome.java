
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
}
