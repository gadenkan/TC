import java.util.ArrayList;
import java.util.List;

public class UndoHistory {

	public static void main(String[] args) {

		String[] lines = new String[]  {"ba","ba"};

		int res = minPresses(lines);
		System.out.println(res);
	}

	public static int minPresses(String[] lines) {
		List<String> history= new ArrayList<String>();
		int count = lines[0].length() + 1; // assuming single line also takes
											// enter
		history.add("");
		for(int i=0;i<lines[0].length();i++){
			history.add(lines[0].substring(0, i+1));
			//System.out.println(lines[0].substring(0,i+1));
		}
		
		String buffer = lines[0];
		
		for (int i = 1; i < lines.length; i++) {

			if(lines[i].equals(buffer)){
				continue;
			}
			String diff = getDiffIndex(history, lines[i]);
			
			if(!buffer.equals(diff)){
				count= count+2;
				//System.out.println("mouse");
			}
			count = count+(lines[i].length()-diff.length())+1;
			int j= diff.length()>0?diff.length()-1:0;
			for(j=diff.length();j<lines[i].length();j++){
				history.add(lines[i].substring(0, j+1));
				//System.out.println(lines[0].substring(0,i+1));
			}
			buffer = lines[i];
			//System.out.println(count);
		}

		return count;
	}

	public static String getDiffIndex(List<String> history, String x) {
		
		int ret = 0;
		String retString="";
		for(int i=1;i<history.size();i++){
			String temp = history.get(i);
			String tempTemp="";
			int y=0;
			for(int j=0;j<temp.length() && j<x.length();j++){
				if(temp.charAt(j) != x.charAt(j)){
					break;
				}
				y=j+1;
				tempTemp = tempTemp+x.charAt(j);
			}
			//System.out.println("y: "+y);
			if(y>ret)
				ret=y;
			if(tempTemp.length() > retString.length())
				retString = tempTemp;
		}

		return retString;
	}

}
