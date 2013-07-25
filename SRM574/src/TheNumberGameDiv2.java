public class TheNumberGameDiv2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int A = 5162;
		int B = 16;

		int ret = minimumMoves(A, B);
		System.out.println(ret);

	}

	public static int minimumMoves(int A, int B) {

		String a = String.valueOf(A);
		String b = String.valueOf(B);
		int count = -1;
		boolean inRev = false;
		boolean inStr = false;
		
		int i = a.indexOf(b);
		
		String newStr = new StringBuffer(a).reverse().toString();
		int j = newStr.indexOf(b);
		int j2 = newStr.lastIndexOf(b);

		
		if(i==-1 && j==-1){
			return -1;
		}
		
		if(i==0){
			count = a.length()-b.length();
			return count;
		}
		if(i>0){
			if(b.length()==1){
				count = 1 + a.length()-b.length();
			}else{
				count = 2 + a.length()-b.length();
			}
			
			return count;
		}
		
		if(j>=0){
			count = 1+ newStr.length()-b.length();
			return count;
		}
		return count;
	}

}
