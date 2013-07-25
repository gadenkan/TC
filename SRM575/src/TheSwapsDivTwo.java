import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class TheSwapsDivTwo {

	public static void main(String[] args) {

		int[] x = new int[] {22, 16, 36, 35, 14, 9, 33, 6, 28, 12, 18, 14, 47, 46, 29, 22, 14, 17, 4, 15, 28, 6, 39, 24, 47, 37};

		BigInteger res = find(x);
		System.out.println(res);

	}

	public static BigInteger find(int[] sequence) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		boolean flag=false;
		for (int i = 0; i < sequence.length; i++) {

			if(map.containsKey(sequence[i])){
				map.put(sequence[i], map.get(sequence[i])+1);
				flag=true;
			}else{
				map.put(sequence[i], 1);
			}
		}

		BigInteger num = factorial(sequence.length);

		BigInteger den = new BigInteger("1");
		Set<Integer> keys = map.keySet();
		Iterator<Integer> it = keys.iterator();
		
		while(it.hasNext()){
			int s = it.next();
			System.out.println(s+" "+map.get(s));
			den = den.multiply( factorial(map.get(s))) ;
			System.out.println(den+" den");
		}
System.out.println(num);
		if(flag){
			return num.divide(den).subtract(new BigInteger("1"));
		}else{
			return num.divide(den);
		}

		
	}

	public static BigInteger factorial(int n) {
System.out.println(n);
		if (n == 0) {
			return new BigInteger("1");
		}
		BigInteger sum = new BigInteger("1");
		for (int i = 2; i <= n; i++) {
			sum = sum.multiply(new BigInteger(String.valueOf(i))) ;
		}
		return new BigInteger(String.valueOf(sum));
	}

}
