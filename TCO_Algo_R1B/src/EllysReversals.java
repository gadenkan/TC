import java.util.ArrayList;
import java.util.List;

public class EllysReversals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String[] words = new String[] { "topcoder", "redocpot", "doretopc", "cpotdoer", "harlemshake" };

		EllysReversals e = new EllysReversals();
		int x = e.getMin(words);
		System.out.println(x);
	}

	public int getMin(String[] words) {

		List<String> words2 = new ArrayList<String>();

		for (int i = 0; i < words.length; i++) {
			// System.out.println("add: "+words[i]);
			words2.add(words[i]);
		}

		for (int i = 0; i < words2.size(); i++) {

			if (words2.get(i).length() % 2 != 0) {
				continue;
			}
			List<String> list = makeList(words2.get(i));

			for (int j = 0; j < words2.size(); j++) {
				if (list.contains(words2.get(j))) {
					// System.out.println("contains: " + words2.get(i) + " "
					// + words2.get(j));
					words2.remove(words2.get(j));
					if (words2.size() <= i)
						words2.remove(words2.get(i));
					break;
				}
			}
		}

		for (int i = 0; i < words2.size(); i++) {
			System.out.println("final: " + words2.get(i));
		}
		return words2.size();
	}

	public List<String> makeList(String string) {
		List<String> list = new ArrayList<String>();

		list.add(string);
		int count = 2;
		while (count <= string.length()) {
			int size = list.size();
			for (int i = 0; i < size; i++) {
				for (int j = 2; j <= string.length(); j = j + 2) {
					String temp = flip(list.get(i), j);
					list.add(temp);
				}
			}
			count = count + 2;
		}

		while (list.remove(string)) {
			list.remove(string);
		}

		// for (int i = 0; i < list.size(); i++) {
		// //System.out.println(list.get(i));
		// }

		return list;

	}

	public String flip(String string, int count) {
		String sub = string.substring(count);
		String first = string.substring(0, count);
		String rev = reverse(first);

		// System.out.println("Sub: " + sub);
		// System.out.println("flip: " + rev + sub);
		return rev + sub;
	}

	public String reverse(String first) {
		return new StringBuffer(first).reverse().toString();
	}

}
