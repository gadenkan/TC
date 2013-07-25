public class TheNumberGameDivTwo {

	public static void main(String[] args) {

		int x = 4;
		String result = find(x);
		System.out.println(result);
	}

	public static String find(int n) {

		int currentPlayer = 0;
		while (!isPrime(n)) {
			for (int i = n/2; i > 1; i--) {
				if (n % i == 0) {
					n = n - i;
					break;
				}
			}
			currentPlayer = (currentPlayer + 1) % 2;
		}

		if (currentPlayer == 0) {
			return "Brus";
		} else
			return "John";
	}

	public static boolean isPrime(int n) {

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
