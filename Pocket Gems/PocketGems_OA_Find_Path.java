import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class PocketGems_OA_Find_Path {
	public static List<String> parseLines(List<String> lines) {
		List<String> ans = new ArrayList<String>();
		
		if(lines == null || lines.size() == 0){
			return ans;
		}
		
		String[] array = lines.get(0).split(" ");
    	String start = array[0];
		String end = array[1];
		Map<String, List<String>> graph = new HashMap<String, List<String>>();
		Set<String> visited = new HashSet<String>();
		
		for(int i = 1; i < lines.size(); i++) {
			String line = lines.get(i);
			String[] nodes = line.trim().split(":");
			List<String> list = Arrays.asList(nodes[1].trim().split("\\s{1,}"));
			graph.put(nodes[0].trim(), list);
		}
		
		String path = start;
		backtrack(ans, path, visited, graph, start, end);
		return ans;		
	}
	
	public static void backtrack(List<String> ans, String path, Set<String> visited, Map<String, List<String>> graph, String start, String target){
		if(visited.contains(start)){
			return ;
		} else if(start.equals(target)){
			ans.add(path);
			return ;
		} else if(!graph.containsKey(start)){
			return ;
		}
		
		visited.add(start);
		
		for(String str : graph.get(start)){
			backtrack(ans, path + str, visited, graph, str, target);
		}
		
		visited.remove(start);		
	}
	
	
	/**************************************** main *********************************************/
	public static void main(String[] args) throws FileNotFoundException, IOException {
        String filename = "/Users/Jackie/Downloads/pocketgem/oa1/test.txt";
        if (args.length > 0) {
        	filename = args[0];
        }
        
        List<String> answer = parseFile(filename);
        System.out.println(answer);
    }
    
    static List<String> parseFile(String filename) throws FileNotFoundException, IOException {
    	/*
    	 *  Don't modify this function
    	 */
        BufferedReader input = new BufferedReader(new FileReader(filename));
        List<String> allLines = new ArrayList<String>();
        String line;
        while ((line = input.readLine()) != null) {
        	allLines.add(line);
        }
        input.close();

        return parseLines(allLines);    	
    }
	
//	public static void main(String[] args){
//		List<String> file = new ArrayList<String>();
//		file.add("A E");
//		file.add("A:B C D");
//		file.add("B:C");
//		file.add("C:E");
//		file.add("D:B");
//		
//		List<String> ans = parseFile(file);
//		
//		for(String path : ans){
//			System.out.println(path);
//		}		
//	}
}
