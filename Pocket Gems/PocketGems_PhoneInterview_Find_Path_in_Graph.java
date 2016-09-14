public class PocketGems_PhoneInterview_Find_Path_in_Graph {
	private static String ans = "";
	
	public static String findMinPath(String[] words){
		int row = words.length;
		int col = words[0].length();
		char[][] matrix = new char[row][col];
		
		for(int i = 0; i < row; i++){
			matrix[i] = words[i].toCharArray();
		}
		
		boolean[][] visited = new boolean[row][col];
		
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				if(matrix[i][j] == '2'){
					backtrack(matrix, visited, i, j, "");
				}
			}
		}
		
		return ans;
	}
	
	public static void backtrack(char[][] matrix, boolean[][] visited, int x, int y, String path){
		if(visited[x][y] == true){
			return ;
		} else if(matrix[x][y] == '3'){			
			if(ans.length() == 0 || path.length() + 1 < ans.length()){	
				ans = path + matrix[x][y];
			}
			return ;
		}
		
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		
		visited[x][y] = true;
		
		for(int i = 0; i < 4; i++){
			int newX = x + dx[i];
			int newY = y + dy[i];
			
			if(newX >= 0 && newX < matrix.length && newY >= 0 && newY < matrix[0].length && matrix[newX][newY] != '0' && matrix[newX][newY] != '2'){
				backtrack(matrix, visited, newX, newY, path + matrix[x][y]);
			}
		}
		
		visited[x][y] = false;
	}
	
	
	
	public static void main(String[] args){
//		String[] words = {
//				"02111",
//				"01001",
//				"01001",
//				"01003"
//		};
		
		String[] words = {
				"02111",
				"01111",
				"01000",
				"01113"
		};
		
		System.out.println(findMinPath(words));
	}
	
	
	
//	['02111',
//	 '01001',
//	 '01001',
//	 '01003',]
}
