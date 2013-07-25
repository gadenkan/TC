
public class Decimal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		double x = 1/(Math.pow(10, 10));
		String s = String.valueOf(x);
		System.out.println(x);
		System.out.println(s.charAt(0));
		String[] a = s.split("E");
		System.out.println(a[0]);
		System.out.println(a[1]);
	}

}
