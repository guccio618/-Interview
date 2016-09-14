import java.util.Stack;


public class PocketGems_PhoneInterview_Basic_Calculator {
	public int calculate(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        
        s = s.trim();
        int len = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0, ans = 0;
        int sign = 1;
        
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                num = num * 10 + (int) (c - '0');
            } else if(c == '+'){
                ans += num * sign;
                num = 0;
                sign = 1;
            } else if(c == '-'){
                ans += num * sign;
                num = 0;
                sign = -1;
            } else if(c == '('){
                ans += num * sign;
                stack.push(ans);
                stack.push(sign);
                num = 0;
                ans = 0;
                sign = 1;
            } else if(c == ')'){
                ans += num * sign;
                ans *= stack.pop();
                ans += stack.pop();
                num = 0;
                sign = 1;
            }
        }
        
        if(num != 0){
            ans += num * sign;
        }
        
        return ans;
    }
}
