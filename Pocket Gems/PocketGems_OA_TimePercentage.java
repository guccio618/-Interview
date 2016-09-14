import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;


public class PocketGems_OA_TimePercentage {
	/**************************************************************/
	// multi-user
	static String parseLines(String[] lines) {
		if(lines == null || lines.length == 0){
			return "";
		}
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("START", 3);
		map.put("CONNECTED", 4);
		map.put("DISCONNECTED", 2);
		map.put("SHUTDOWN", 1);
		
		Queue<Pair> heap = new PriorityQueue<Pair>(1, new Comparator<Pair>() {
			public int compare(Pair left, Pair right){
				if(left.timeStamp != right.timeStamp){
					if(left.timeStamp < right.timeStamp){
						return -1;
					} else if(left.timeStamp > right.timeStamp){
						return 1;
					} else {
						return 0;
					}
				} else {
					return map.get(left.status) - map.get(right.status);
				}
			}
		});
		
		SimpleDateFormat formatter = new SimpleDateFormat( "yyyy/MM/dd-HH:mm:ss");
		Date date = new Date();
		long startTime = 0, endTime = 0;
		
		
		for(String str : lines){
			String[] array = str.split("::");
			array[0] = array[0].trim();
			array[0] = array[0].substring(1, array[0].length() - 1);
			array[1] = array[1].trim();
			
			try {
				date =  formatter.parse(array[0]);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			long timeStamp = date.getTime();
			heap.offer(new Pair(timeStamp, array[1]));
			
			if(array[1].equals("START")){
				startTime = timeStamp;
			}
			if(array[1].equals("SHUTDOWN")){
				endTime = timeStamp;
			}
		}
		
		long connectStart = -1;
		long connectTime = 0;
		boolean startFlag = false;
		int connectCount = 0;
		
		while(!heap.isEmpty()){
			Pair node = heap.poll();
			
			if(startFlag == false && !node.status.equals("START")){
				continue;
			} else if(node.status.equals("START")){
				startFlag = true;
			} else if(node.status.equals("SHUTDOWN")){
				if(connectStart != -1){
					connectTime += node.timeStamp - connectStart;
				}
				break;
			} else if(node.status.equals("CONNECTED")){
				if(connectCount == 0){
					connectStart = node.timeStamp;
				}
				connectCount++;
			} else if(node.status.equals("DISCONNECTED")){
				connectCount--;
				
				if(connectCount == 0){
					connectTime += node.timeStamp - connectStart;
					connectStart = -1;					
				}
			}			
		}
		
		double ratio = (double) connectTime / (endTime - startTime) * 100;
        return String.format("%d%s", (int) ratio, "%");
	}
	
	static class Pair {
		long timeStamp;
		String status;
		
		public Pair(long timeStamp, String status){
			this.timeStamp = timeStamp;
			this.status = status;
		}
	}
	
	
	
	/**************************************************************/
	// single-user
	static String parseLines2(String[] lines) {
    	if (lines == null || lines.length == 0) {
			return "";
		}
    	
		Map<String, Integer> status = new HashMap<String, Integer>();
		status.put("START", 0);
		status.put("CONNECTED", 1);
		status.put("DISCONNECTED", -1);
		status.put("SHUTDOWN", -1);
		List<Date> timeStamps = new ArrayList<Date>();
		List<String> Logged = new ArrayList<String>();
		
		for (int i = 0; i < lines.length; i++) {
			String[] line = lines[i].split(" :: ");
			
			if (!status.containsKey(line[1])) {
				continue;
			}
			
			timeStamps.add(getDate(line[0].substring(1, line[0].length() - 1)));
			Logged.add(line[1]);
		}
		
		long totalTime = timeStamps.get(timeStamps.size() - 1).getTime() - timeStamps.get(0).getTime();
		long connectedTime = 0;
		long lastTimeStamp = 0;
		
		for (int i = 1; i < timeStamps.size(); i++) {
			String currentEvent = Logged.get(i);
			long currentTime = timeStamps.get(i).getTime();
			
			if (status.get(currentEvent) > 0) {
				lastTimeStamp = currentTime;
			} else if (lastTimeStamp > 0) {
				connectedTime += currentTime - lastTimeStamp;
				lastTimeStamp = -1;
			}
		}
		
		double ratio = (double) connectedTime / totalTime * 100;
		return String.format("%d%s", (int) ratio, "%");
    }
	
	private static Date getDate(String dateStr) {
	    DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy-hh:mm:ss");
	    Date date = new Date();
	    
	    try {
	    	date = formatter.parse(dateStr);
	    } catch (ParseException exception) {
	    	exception.printStackTrace();
	    }
	    
	    return date;
	}
	
	
	
	/**************************************** main *********************************************/
	public static void main(String[] args) throws FileNotFoundException, IOException {
        String filename = "/Users/Jackie/Downloads/pocketgem/oa2/test5.txt";
        if (args.length > 0) {
        	filename = args[0];
        }

        String answer = parseFile(filename);
        System.out.println(answer);
    }

    static String parseFile(String filename)
            throws FileNotFoundException, IOException {
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

        return parseLines(allLines.toArray(new String[allLines.size()]));
    }
}
