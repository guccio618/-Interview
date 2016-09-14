import java.util.ArrayList;
import java.util.List;

/*************************************************************************************************************************
 * 一组数范围在［0， n] 每个数都存在， 有的数出现一次， 有的数出现两次，输出所有出现两次的数 O(n) time, O(1) space
 * 居然不是top K， 上来有点懵，稳了一下问他说可不可以改变数组元素的位置， 说可以。 就尝试扫一遍， 没到array[i] != i 的时候就交换 array[i] 和array[array[i]]
 * 直到相等。 最后所有array[i] != i的数就是重复的数。因为每次交换都会使一个位置出现array[i] ＝= i 的情况， 最多n 次交换 time O(n)
 * 
 *************************************************************************************************************************/

public class PocketGems_PhoneInterview_Find_Duplicated_Number {
	public static List<Integer> findDulicatedNumber(int[] nums){
		List<Integer> ans = new ArrayList<Integer>();
		
		if(nums == null || nums.length == 0){
			return ans;
		}
		
		int len = nums.length;
		
		for(int i = 0; i < len; i++){
			while(nums[i] >= 0 && nums[i] < len && nums[i] != i && nums[i] != nums[nums[i]]){
				int temp = nums[nums[i]];
				nums[nums[i]] = nums[i];
				nums[i] = temp;
			}
		}
		
		for(int i = 0; i < len; i++){
			if(nums[i] != i){
				ans.add(nums[i]);
			}
		}
		
		return ans;
	}
	
	
	
	
	public static void main(String[] args){
		int[] nums = {1,2,3,4,5,6,7,8,9,6,3};		
		List<Integer> ans = findDulicatedNumber(nums);
		
		for(int num : nums){
			System.out.print(num + ", ");
		}
		System.out.println();
		
		for(int num : ans){
			System.out.print(num + ", ");
		}
	}
}
