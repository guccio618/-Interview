
public class PocketGems_PhoneInterview_Multiply_Strings {
	public String multiply(String num1, String num2) {
        if(num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0){
            return "";
        }
        
        int len1 = num1.length();
        int len2 = num2.length();
        int[] ans = new int[len1 + len2];
        char[] letters1 = num1.toCharArray();
	    char[] letters2 = num2.toCharArray();
        int mul = 0;
        int sum = 0;
        StringBuilder builder = new StringBuilder();
        
        for(int i = len1 - 1; i >= 0; i--){
            for(int j = len2 - 1; j >= 0; j--){
                int x = i + j;
                int y = i + j + 1;
                
                mul = (letters1[i] - '0') * (letters2[j] - '0');
                sum = mul + ans[y];
                
                ans[y] = sum % 10;
                ans[x] += sum / 10;
            }
        }
        
        for(int num : ans){
            if(builder.length() == 0 && num == 0){
                continue;
            }
            
            builder.append(num);
        }
        
        return builder.length() == 0 ? "0" : builder.toString();
    }
}
