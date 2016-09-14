import java.util.ArrayList;
import java.util.HashMap;


public class PocketGems_PhoneInterview_Insert_Delete_GetRandom_O_1 {
	private ArrayList<Integer> numbers;
    private HashMap<Integer, Integer> number_pos_Map;
    private java.util.Random rand = new java.util.Random();
    
    
    /** Initialize your data structure here. */
    public PocketGems_PhoneInterview_Insert_Delete_GetRandom_O_1() {
        numbers = new ArrayList<Integer>();
        number_pos_Map = new HashMap<Integer, Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(number_pos_Map.containsKey(val)){
            return false;
        }
        
        number_pos_Map.put(val, numbers.size());
        numbers.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!number_pos_Map.containsKey(val)){
            return false;
        }
        
        int pos = number_pos_Map.get(val);
        
        if(pos < numbers.size() - 1){
            int lastElement = numbers.get(numbers.size() - 1);
            number_pos_Map.put(lastElement, pos);
            numbers.set(pos, lastElement);
        }
        
        number_pos_Map.remove(val);
        numbers.remove(numbers.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return numbers.get(rand.nextInt(numbers.size()));
    }
}
