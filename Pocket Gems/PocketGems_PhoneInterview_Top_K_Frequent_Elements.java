import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;


public class PocketGems_PhoneInterview_Top_K_Frequent_Elements {
	// by other using bucket sort, time complexity is O(n)
	public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList<Integer>();
        if(nums == null || nums.length == 0){
            return ans;
        } 
        
        int n = nums.length;
        List<Integer>[] bucket = new List[n + 1];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int frequency = entry.getValue();
            if(bucket[frequency] == null){
                bucket[frequency] = new ArrayList<Integer>();
            }
            bucket[frequency].add(entry.getKey());
        }
        
        int index = n;
        
        while(k > 0){
            if(index >= 0 && bucket[index] != null){
                for(int num : bucket[index]){
                    ans.add(num);
                    k--;
                    
                    if(k == 0){
                        return ans;
                    }
                }
            }
            
            index--;
        }
        
        return ans;
    }
	
	
	
	// by other, time complexity is O(nlogk)
	public List<Integer> topKFrequent2(int[] nums, int k) {
        List<Integer> ans = new ArrayList<Integer>();
        
        if(nums == null || nums.length == 0 || k <= 0){
            return ans;
        }
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Queue<Pair> heap = new PriorityQueue<Pair>(k, new Comparator<Pair>(){
            public int compare(Pair left, Pair right){
                return left.time - right.time;
            }
        });
        
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            heap.offer(new Pair(entry.getValue(), entry.getKey()));
            
            if(heap.size() > k){
                heap.poll();    
            }
        }
        
        while(!heap.isEmpty()){
            ans.add(heap.poll().value);
        }
        
        return ans;
    }
    
    class Pair {
        int time;
        int value;
        
        public Pair(int t, int v){
            time = t;
            value = v;
        }
    }
}
