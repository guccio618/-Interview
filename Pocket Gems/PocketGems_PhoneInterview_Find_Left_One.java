
/******************************************************************************
 * 	一个矩阵有0 和 1， 1的右边一定是1， 要找到整个矩阵最左边的1。 要求复杂度比O(mn) 好。 
 * 	从右上角第一个1开始往左找， 遇到0 往下找下一个1， 直到不能走了为止。 复杂度O(m + n)
 * 
 ******************************************************************************/

public class PocketGems_PhoneInterview_Find_Left_One {
	public static int findLeftOne(int[][] matrix){
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return 0;
		}
		
		int row = matrix.length, col = matrix[0].length;
		int start = findPos(matrix, 0, col - 1);
		
		for(int i = 1; i < row; i++){
			if(matrix[i][start] == 0){
				continue;
			} else {
				start = findPos(matrix, i, start);
			}
		}
		
		return start;
	}
	
	public static int findPos(int[][] matrix, int row, int end){
		if(end == 0){
			return end;
		}
		
		int left = 0, right = end;
		
		while(left + 1 < right){
			int mid = left + (right - left) / 2;
			
			if(matrix[row][mid] == 0){
				left = mid;
			} else {
				right = mid;
			}
		}
		
		if(matrix[row][left] == 1){
			return left;
		} else {
			return right;
		}
	}
	
	
	
	public static void main(String[] args){
		int[][] matrix = {
				{0,0,0,0,0,1,1,1,1,0,0,0},
				{0,0,0,0,1,1,1,1,1,0,0,0},
				{0,0,0,1,1,1,1,1,1,0,0,0},
				{0,0,1,1,1,1,1,1,1,0,0,0},
				{0,0,0,0,0,1,1,1,1,0,0,0},
				
		}; 
		
		System.out.println(findLeftOne(matrix));
	}
}
