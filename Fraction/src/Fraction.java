import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Fraction class as the name suggests defines a fraction. 
 * This class supports mathematical operations like 
 * Add, Subtract, Divide, Multiply and compare two Fraction objects.
 */

/**
 * @author Punit Gadenkanahalli
 * @version 3.0
 * 
 */
public class Fraction {

	private BigInteger numerator;
	private BigInteger denominator;
	String fraction;

	/**
	 * Return the numerator of the Fraction
	 * 
	 * @return BigInteger, numerator
	 */
	public BigInteger getNumerator() {
		return numerator;
	}

	/**
	 * Set the numerator of the Fraction
	 * 
	 * @param numerator
	 */
	public void setNumerator(BigInteger numerator) {
		this.numerator = numerator;
	}

	/**
	 * Return the denominator of the Fraction
	 * 
	 * @return BigInteger, denominator
	 */
	public BigInteger getDenominator() {
		return denominator;
	}

	/**
	 * Set the denominator of the Fraction
	 * 
	 * @param denominator
	 */
	public void setDenominator(BigInteger denominator) {
		this.denominator = denominator;
	}

	/**
	 * Constructor for the Fraction class.
	 * 
	 * @param num
	 *            , numerator of the fraction.
	 * @param den
	 *            , denominator of the fraction.
	 * @throws Exception
	 */
	public Fraction(long num, long den) throws Exception {

		if (den == 0) {
			throw new Exception("Denominator cannot be zero.");
		}

		fraction = num + "/" + den;
		long gcd = gcd(num, den);
		numerator = new BigInteger(String.valueOf(num / gcd));
		denominator = new BigInteger(String.valueOf(den / gcd));

		// Swapping the sign from denominator to numerator
		// as numerators are compared when comparing two fractions
		// diving gcd step(above) takes care of case where both are negative.
		if (denominator.compareTo(BigInteger.ZERO) < 0 && numerator.compareTo(BigInteger.ZERO) > 0) {
			denominator = denominator.multiply(new BigInteger("-1"));
			numerator = numerator.multiply(new BigInteger("-1"));
		}
	}

	/**
	 * Constructor for the Fraction class from string inputs
	 * 
	 * @param num
	 *            , string numerator of the fraction.
	 * @param den
	 *            , string denominator of the fraction.
	 * @throws Exception
	 */

	public Fraction(String num, String den) throws Exception {

		
		if(!isNumber(num)){
			throw new Exception("Input numerator "+num+" is not a number");
		}
		if(!isNumber(den)){
			throw new Exception("Input denominator "+den+" is not a number");
		}
		BigInteger n = new BigInteger(num);
		BigInteger d = new BigInteger(den);
		if (d.compareTo(BigInteger.ZERO) == 0) {
			throw new Exception("Denominator cannot be zero.");
		}

		fraction = n + "/" + d;
		BigInteger gcd = gcd(n, d);
		numerator = n.divide(gcd);
		denominator = d.divide(gcd);

		// Swapping the sign from denominator to numerator
		// as numerators are compared when comparing two fractions
		// diving gcd step(above) takes care of case where both are negative.
		if (denominator.compareTo(BigInteger.ZERO) < 0 && numerator.compareTo(BigInteger.ZERO) > 0) {
			denominator = denominator.multiply(new BigInteger("-1"));
			numerator = numerator.multiply(new BigInteger("-1"));
		}

	}

	/**
	 * Constructor for the Fraction class from decimal string
	 * 
	 * @param num
	 *            , string numerator of the fraction.
	 * @param den
	 *            , string denominator of the fraction.
	 * @throws Exception
	 */

	public Fraction(String dec) throws Exception {

		String[] s = decimalToFraction(dec);
		String num = s[0];
		String den = s[1];
		
		BigInteger n = new BigInteger(num);
		BigInteger d = new BigInteger(den);
		if (d.compareTo(BigInteger.ZERO) == 0) {
			throw new Exception("Denominator cannot be zero.");
		}

		fraction = n + "/" + d;
		BigInteger gcd = gcd(n, d);
		numerator = n.divide(gcd);
		denominator = d.divide(gcd);

		// Swapping the sign from denominator to numerator
		// as numerators are compared when comparing two fractions
		// diving gcd step(above) takes care of case where both are negative.
		if (denominator.compareTo(BigInteger.ZERO) < 0 && numerator.compareTo(BigInteger.ZERO) > 0) {
			denominator = denominator.multiply(new BigInteger("-1"));
			numerator = numerator.multiply(new BigInteger("-1"));
		}

	}
	
	/**
	 * Returns the sum of two Fractions (this class and the passed class) as a
	 * new Fraction class
	 * 
	 * @param f
	 *            Fraction class which is added to this class
	 * @return Fraction, sum of the two fractions
	 * @throws Exception
	 */
	public Fraction add(Fraction f) throws Exception {

		BigInteger num = (numerator.multiply(f.getDenominator()))
				.add((denominator.multiply(f.getNumerator())));
		BigInteger den = denominator.multiply(f.getDenominator());

		BigInteger gcd = gcd(num, den);
		num = num.divide(gcd);
		den = den.divide(gcd);

		return new Fraction(num.toString(), den.toString());
	}

	/**
	 * Returns the gcd of two BigIntegers numbers.
	 * 
	 * @param a
	 *            BigInteger
	 * @param b
	 *            BigInteger
	 * @return BigInteger, gcd of the two input BigInteger numbers
	 */
	private BigInteger gcd(BigInteger a, BigInteger b) {

		BigInteger temp;
		while (b.intValue() != 0) {
			temp = b;
			b = a.mod(b.abs());
			a = temp;
		}
		return a;
	}

	/**
	 * Returns the difference of two Fractions (this class and the passed class)
	 * as a new Fraction class
	 * 
	 * @param f
	 *            Fraction class which is subtracted from this class
	 * @return Fraction, difference of the two fractions
	 * @throws Exception
	 */
	public Fraction subtract(Fraction f) throws Exception {
		BigInteger num = (numerator.multiply(f.getDenominator()))
				.subtract((denominator.multiply(f.getNumerator())));
		BigInteger den = denominator.multiply(f.getDenominator());

		BigInteger gcd = gcd(num, den);
		num = num.divide(gcd);
		den = den.divide(gcd);

		return new Fraction(num.toString(), den.toString());
	}

	/**
	 * Returns the product of two Fractions (this class and the passed class) as
	 * a new Fraction class
	 * 
	 * @param f
	 *            Fraction class which is multiplied to this class
	 * @return Fraction, product of the two fractions
	 * @throws Exception
	 */
	public Fraction multiply(Fraction f) throws Exception {

		BigInteger num = numerator.multiply(f.getNumerator());
		BigInteger den = denominator.multiply(f.getDenominator());

		BigInteger gcd = gcd(num, den);
		num = num.divide(gcd);
		den = den.divide(gcd);

		return new Fraction(num.toString(), den.toString());
	}

	/**
	 * Returns the quotient of two Fractions (this class and the passed class)
	 * as a new Fraction class
	 * 
	 * @param f
	 *            Fraction class which is divided by this class
	 * @return Fraction, quotient
	 * @throws Exception
	 */
	public Fraction divide(Fraction f) throws Exception {

		BigInteger num = numerator.multiply(f.getDenominator());
		BigInteger den = denominator.multiply(f.getNumerator());

		BigInteger gcd = gcd(num, den);
		num = num.divide(gcd);
		den = den.divide(gcd);

		try {
			return new Fraction(num.toString(), den.toString());
		} catch (Exception e) {
			throw new Exception(
					"Divisor Fraction is zero. Denominator cannot be zero.");
		}
	}

	/**
	 * Compared this class with the passed Fraction class. Returns true, if this
	 * class is greater than the passed Fraction class.
	 * 
	 * @param f
	 *            Fraction class that is compared
	 * @return boolean, true if this class is greater than the passed Fraction
	 */
	public boolean isGreater(Fraction f) {

		BigInteger num = numerator.multiply(f.getDenominator());
		BigInteger num2 = denominator.multiply(f.getNumerator());
		int res = num.compareTo(num2);
		if (res == 1) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Compared this class with the passed Fraction class. Returns true, if this
	 * class is lesser than the passed Fraction class.
	 * 
	 * @param f
	 * @return boolean, true if this class is lesser than the passed Fraction
	 */
	public boolean isLesser(Fraction f) {

		BigInteger num = numerator.multiply(f.getDenominator());
		BigInteger num2 = denominator.multiply(f.getNumerator());
		int res = num.compareTo(num2);
		if (res == -1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Compared this class with the passed Fraction class. Returns true, if this
	 * class is equal to the passed Fraction class.
	 * 
	 * @param f
	 * @return boolean, true if this class is equal to the passed Fraction
	 */
	public boolean isEqual(Fraction f) {

		BigInteger num = numerator.multiply(f.getDenominator());
		BigInteger num2 = denominator.multiply(f.getNumerator());
		int res = num.compareTo(num2);
		if (res == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Displays the fraction and its value.
	 * 
	 */
	public void display() {

		System.out.println("Fraction is " + fraction);
		System.out.println("Simplified Fraction is " + numerator + "/"
				+ denominator);
		BigDecimal decNum = new BigDecimal(numerator);
		BigDecimal decDen = new BigDecimal(denominator);
		BigDecimal value = decNum.divide(decDen,30,BigDecimal.ROUND_DOWN);
		
		System.out.println("Value is: " + value
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
	 * Checks if the input string is a number
	 * @param s, input String which contains a number
	 * @return boolean, true if the string is a number, else false
	 */
	public boolean isNumber(String s){
		int i=0;
		if(s.charAt(0)=='-'){
			i=1;
		}
		for(;i<s.length();i++){
			char temp = s.charAt(i);
			if((temp>57 || temp<48)){
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * Converts the input string which contains a decimal into Fraction
	 * @param s, input String which contains a decimal
	 * @throws Exception 
	 */
	public String[] decimalToFraction(String s) throws Exception{
		
		String num="0";
		String den="1";
		int i=0;
		if(s.charAt(0)=='-'){
			i=1;
			num="-0";
		}
		boolean dotOccured=false;
		for(;i<s.length();i++){
			char temp = s.charAt(i);
			
			if((temp=='.' && dotOccured) && (temp>57 || temp<48)){
				throw new Exception(s+" is not a number");
			}
			if(temp=='.'){
				dotOccured = true;
				continue;
			}
			
			if(dotOccured){
				num = num+String.valueOf(temp);
				den = den+"0";
			}else{
				num = num+String.valueOf(temp);
			}
					
		}
		
		return new String[]{num,den};
	}

	/**
	 * Main function.
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		Fraction f = new Fraction(102427487249879823l, -67);
		f.display();
		Fraction f2 = new Fraction(10323094849280948l, 71);
		f2.display();

		System.out.println(f2.isGreater(f));
		Fraction f3 = f.add(f2);
		f3.display();

		f3 = f.subtract(f2);
		f3.display();

		f3 = f.multiply(f2);
		f3.display();
		System.out.println(f3.isGreater(f));

		f3 = f.divide(f2);
		f3.display();

		Fraction s = new Fraction("123", "-12");
		s.display();
		
		Fraction s2 = new Fraction("-0.00434");
		s2.display();
		
		f3 = s.add(s2);
		f3.display();
		
		String[] s1= s.decimalToFraction("-2.33");
		System.out.println(s1[0]);
		System.out.println(s1[1]);
		
		System.out.println(f2.isGreater(f));
		System.out.println(f2.isLesser(f));
		System.out.println(f.isEqual(f2));
	}

}
