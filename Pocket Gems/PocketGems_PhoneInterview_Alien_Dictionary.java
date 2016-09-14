import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


public class PocketGems_PhoneInterview_Alien_Dictionary {
	public String alienOrder(String[] words) {
        if(words == null || words.length == 0){
            return "";
        }
           
        int len = words.length;
        Set<Character>[] graph = new Set[256];
        StringBuilder builder = new StringBuilder();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        Queue<Character> queue = new LinkedList<Character>();
        
        for(String word : words){
            for(char c : word.toCharArray()){
                map.put(c, 0);
            }
        }
        
        for(int i = 0; i < len - 1; i++){
            int minLen = Math.min(words[i].length(), words[i + 1].length());
            
            for(int j = 0; j < minLen; j++){
                char c1 = words[i].charAt(j);
                char c2 = words[i + 1].charAt(j);
                
                if(c1 != c2){
                    if(graph[c1] == null){
                        graph[c1] = new HashSet<Character>();
                    }
                    
                    if(!graph[c1].contains(c2)){
                        graph[c1].add(c2);
                        map.put(c2, map.getOrDefault(c2, 0) + 1);
                    }
                    
                    break;
                }
            }
        }
        
        for(char c = 'a'; c <= 'z'; c++){
            if(map.get(c) != null && map.get(c) == 0){
                queue.offer(c);
            }
        }
        
        while(!queue.isEmpty()){
            char node = queue.poll();
            builder.append(node);
            
            if(graph[node] == null){
                continue;
            }
            
            for(char nextNode : graph[node]){
                int count = map.get(nextNode);
                
                if(count == 1){
                    queue.add(nextNode);
                } else {
                    map.put(nextNode, count - 1);
                }
            }
        }
        
        return builder.length() == map.size() ? builder.toString() : "";
    }
}
