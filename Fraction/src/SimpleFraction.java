/**
 * SimpleFraction class as the name suggests defines a fraction. 
 * This class supports mathematical operations like 
 * Add, Subtract, Divide, Multiply and compare two SimpleFraction objects.
 */

/**
 * @author Punit Gadenkanahalli
 * @version 1.0
 * 
 */
public class SimpleFraction {

	private long numerator;
	private long denominator;
	String fraction;

	/**
	 * Return the numerator of the Fraction
	 * 
	 * @return long, numerator
	 */
	public long getNumerator() {
		return numerator;
	}

	/**
	 * Set the numerator of the Fraction
	 * 
	 * @param numerator
	 */
	public void setNumerator(long numerator) {
		this.numerator = numerator;
	}

	/**
	 * Return the denominator of the Fraction
	 * 
	 * @return long, denominator
	 */
	public long getDenominator() {
		return denominator;
	}

	/**
	 * Set the denominator of the Fraction
	 * 
	 * @param denominator
	 */
	public void setDenominator(long denominator) {
		this.denominator = denominator;
	}

	/**
	 * Constructor for the SimpleFraction class.
	 * 
	 * @param num
	 *            , numerator of the fraction.
	 * @param den
	 *            , denominator of the fraction.
	 * @throws Exception
	 */
	public SimpleFraction(long num, long den) throws Exception {

		if (den == 0) {
			throw new Exception("Denominator cannot be zero.");
		}

		fraction = num + "/" + den;
		long gcd = gcd(num, den);
		numerator = num / gcd;
		denominator = den / gcd;
		
		// Swapping the sign from denominator to numerator
		// as numerators are compared when comparing two fractions
		// diving gcd step(above) takes care of case where both are negative.
		if(denominator<0 && numerator>0){
			denominator = denominator * -1;
			numerator = numerator * -1;
		}
	}

	/**
	 * Returns the sum of two Fractions (this class and the passed class) as a
	 * new Fraction class
	 * 
	 * @param f
	 *            SimpleFraction class which is added to this class
	 * @return SimpleFraction, sum of the two fractions
	 * @throws Exception
	 */
	public SimpleFraction add(SimpleFraction f) throws Exception {

		long num = (numerator * f.getDenominator())
				+ (denominator * f.getNumerator());
		long den = denominator * f.getDenominator();

		long gcd = gcd(num, den);
		num = num / gcd;
		den = den / gcd;

		return new SimpleFraction(num, den);
	}

	/**
	 * Returns the difference of two Fractions (this class and the passed class)
	 * as a new SimpleFraction class
	 * 
	 * @param f
	 *            SimpleFraction class which is subtracted from this class
	 * @return SimpleFraction, difference of the two fractions
	 * @throws Exception
	 */
	public SimpleFraction subtract(SimpleFraction f) throws Exception {
		long num = (numerator * f.getDenominator())
				- (denominator * f.getNumerator());
		long den = denominator * f.getDenominator();

		long gcd = gcd(num, den);
		num = num / gcd;
		den = den / gcd;

		return new SimpleFraction(num, den);
	}

	/**
	 * Returns the product of two Fractions (this class and the passed class) as
	 * a new SimpleFraction class
	 * 
	 * @param f
	 *            SimpleFraction class which is multiplied to this class
	 * @return SimpleFraction, product of the two fractions
	 * @throws Exception
	 */
	public SimpleFraction multiply(SimpleFraction f) throws Exception {

		long num = numerator * f.getNumerator();
		long den = denominator * f.getDenominator();

		long gcd = gcd(num, den);
		num = num / gcd;
		den = den / gcd;

		return new SimpleFraction(num, den);
	}

	/**
	 * Returns the quotient of two Fractions (this class and the passed class)
	 * as a new SimpleFraction class
	 * 
	 * @param f
	 *            SimpleFraction class which is divided by this class
	 * @return SimpleFraction, quotient
	 * @throws Exception 
	 */
	public SimpleFraction divide(SimpleFraction f) throws Exception{

		long num = numerator * f.getDenominator();
		long den = denominator * f.getNumerator();

		long gcd = gcd(num, den);
		num = num / gcd;
		den = den / gcd;

		try {
			return new SimpleFraction(num, den);
		} catch (Exception e) {
			throw new Exception("Divisor Fraction is zero. Denominator cannot be zero.");
		}
	}

	/**
	 * Compared this class with the passed SimpleFraction class. Returns true, if this
	 * class is greater than the passed SimpleFraction class.
	 * 
	 * @param f
	 *            SimpleFraction class that is compared
	 * @return boolean, true if this class is greater than the passed SimpleFraction
	 */
	public boolean isGreater(SimpleFraction f) {

		long num = numerator * f.getDenominator();
		long num2 = denominator * f.getNumerator();
		return num>num2;
	}

	/**
	 * Compared this class with the passed SimpleFraction class. Returns true, if this
	 * class is lesser than the passed SimpleFraction class.
	 * 
	 * @param f
	 * @return boolean, true if this class is lesser than the passed SimpleFraction
	 */
	public boolean isLesser(SimpleFraction f) {

		long num = numerator * f.getDenominator();
		long num2 = denominator * f.getNumerator();
		return num<num2;
	}

	/**
	 * Compared this class with the passed SimpleFraction class. Returns true, if this
	 * class is equal to the passed SimpleFraction class.
	 * 
	 * @param f
	 * @return boolean, true if this class is equal to the passed SimpleFraction
	 */
	public boolean isEqual(SimpleFraction f) {

		long num = numerator * f.getDenominator();
		long num2 = denominator * f.getNumerator();
		return num==num2;
	}

	/**
	 * Displays the fraction and its value.
	 * 
	 */
	public void display() {

		System.out.println("Fraction is " + fraction);
		System.out.println("Simplified Fraction is " + numerator + "/"
				+ denominator);
		System.out.println("Value is: " + (double) numerator / denominator
				+ "\n");
	}

	/**
	 * Returns the gcd of two long numbers.
	 * 
	 * @param a
	 *            long
	 * @param b
	 *            long
	 * @return long, gcd of the two input long numbers
	 */
	public long gcd(long a, long b) {
		long temp;
		while (b != 0) {
			temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

	/**
	 * Main function.
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		SimpleFraction f = new SimpleFraction(1024343434433434344l, 67);
		f.display();
		SimpleFraction f2 = new SimpleFraction(1034334343434343433l, 67);
		f2.display();
		
		System.out.println(f2.isGreater(f));
		SimpleFraction f3 = f.add(f2);
		f3.display();

		f3 = f.subtract(f2);
		f3.display();
		
		f3 = f.multiply(f2);
		f3.display();
		System.out.println(f3.isGreater(f));
		
		
		f3 = f.divide(f2);
		f3.display();
		
		System.out.println(f2.isGreater(f));
		System.out.println(f2.isLesser(f));
		System.out.println(f.isEqual(f2));
	}

}
