import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RansomNote {

	/**
	 * @param args
	 * @throws IOException
	 */

	public static void main(String[] args) throws IOException {

		//String ransomeNote = "I want 5000000000000 million dollars";
		String ransomeNote = "I want 5000 million dollars";
		
		
		// considering the kidnappers wants to written english sentence with
		// regular hindu-arabic numerals without any symbols
		int[] arr = new int[256];
		int sum = 0;

		// calculate character frequency for the ransom note and the sum
		for (int i = 0; i < ransomeNote.length(); i++) {
			if (ransomeNote.charAt(i) != ' ') {
				arr[ransomeNote.charAt(i)]++;
				sum++;
			}
		}

		BufferedReader r = new BufferedReader(new FileReader("magazine1.txt"));
		String line = null;
		int lineNumber = 0;
		boolean allFound = false;
		while ((line = r.readLine()) != null) {
			lineNumber++;
			for (int i = 0; i < line.length(); i++) {
				if (line.charAt(i)<256 && arr[line.charAt(i)] > 0) {
					System.out.print("Line number: " + lineNumber);
					System.out.print("\t Character position: " + (i + 1));
					System.out.println("\t Character found: " + line.charAt(i));
					arr[line.charAt(i)]--;
					sum--;
					if (sum == 0) {
						allFound = true;
						break;
					}
				}
			}
			if (allFound) {
				break;
			}
		}
		r.close();
		if (allFound) {
			System.out.println("Now grab the scisscors.");
		} else {
			System.out.println("Find another magazine");
		}

	}

}
