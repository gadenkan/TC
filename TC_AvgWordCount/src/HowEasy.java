
public class HowEasy {

	private String problemStatement;
	public static void main(String[] args) {
		
		HowEasy e = new HowEasy();
		e.problemStatement = "afj.j adjddj. asjddl";
		int x = e.pointVal(e.problemStatement);
		System.out.println(x);
	}

	public int pointVal(String problemStatement){
		String[] words = problemStatement.split("[^a-zA-Z]+");
		int noOfLetters=0;
		int noOfWords=0;
		for(int i=0; i<words.length;i++){
			System.out.println(words[i]);
			boolean isWord = isAWord(words[i]);
			if(isWord){
				noOfWords++;
				noOfLetters = noOfLetters + words[i].length();				
			}
		}
		int result = 0;
		if(noOfWords == 0){
			return 250;
		}else{
			result = noOfLetters/noOfWords;
			System.out.println(noOfLetters);
			System.out.println(noOfWords);
			System.out.println(result);
		}
		if(result<=3){
			return 250;
		}else if(result==4 || result==5){
			return 500;
		}else{
			return 1000;
		}
	}

	public boolean isAWord(String word) {
		
		char[] chars = word.toCharArray();
		for(int i=0;i<chars.length;i++){
			
			if(!(chars[i]>='A' && chars[i]<='Z' || chars[i]>='a' && chars[i]<='z' || chars[i] == '.')){
				return false;
			}

			if(chars[i] == '.' && i <= chars.length-1){
				return false;
			}
			System.out.println(chars[i]);
		}
		
		return true;
	}
}
