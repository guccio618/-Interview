import java.util.Set;


public class PocketGems_PhoneInterview_Word_Break {
	public boolean wordBreak(String s, Set<String> wordDict) {
        if(s == null || s.length() == 0 || wordDict.size() == 0){
            return false;
        }
        
        int maxWordLen = getMaxLen(wordDict);
        int len = s.length();
        boolean[] canSplit = new boolean[len + 1];
        canSplit[0] = true;
        
        for(int i = 1; i <= len; i++){
            for(int lastWordLen = 1; i - lastWordLen >= 0 && lastWordLen <= maxWordLen; lastWordLen++){
                if(canSplit[i - lastWordLen] == true){
                    String newWord = s.substring(i - lastWordLen, i);
                    
                    if(wordDict.contains(newWord)){
                        canSplit[i] = true;
                        break;
                    }
                }
            }
        }
        
        return canSplit[len];
    }
    
    public int getMaxLen(Set<String> wordDict){
        int count = 0;
        
        for(String word : wordDict){
            count = Math.max(count, word.length());
        }
        
        return count;
    }
}
