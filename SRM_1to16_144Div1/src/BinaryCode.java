public class BinaryCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String msg = "3";
		BinaryCode bin = new BinaryCode();
		String[] res = bin.decode(msg);
		System.out.println(res[0]);
		System.out.println(res[1]);

	}

	public String[] decode(String message) {

		String[] result = new String[2];
		boolean[] flag = { true, true };
		result[0] = "0";
		result[1] = "1";
		for (int i = 0; i < message.length(); i++) {

			int tempSum = Integer.parseInt(((Character) message.charAt(i))
					.toString());
			if (flag[0]) {
				
				int current = Integer
						.parseInt(((Character) result[0].charAt(i)).toString());
				
				int next;
				if(i==0){
					next = (tempSum - current);
				}else{
					int previous = Integer
							.parseInt(((Character) result[0].charAt(i-1)).toString());
					if(i==message.length()-1){
						next = (tempSum-previous);
					}else{
						next = (tempSum-current-previous);
					}
				}
				

				if (next != 0 && next != 1) {
					flag[0] = false;
					result[0] = "NONE";
				} else {
					if(i<message.length()-1)
						result[0] = result[0]+next; 
				}

			}
			if (flag[1]) {

				int current = Integer
						.parseInt(((Character) result[1].charAt(i)).toString());
				
				int next;
				if(i==0){
					next = (tempSum - current);
				}else{
					int previous = Integer
							.parseInt(((Character) result[1].charAt(i-1)).toString());
					if(i==message.length()-1){
						next = (tempSum-previous);
					}else{
						next = (tempSum-current-previous);
					}
				}
				

				if (next != 0 && next != 1) {
					flag[1] = false;
					result[1] = "NONE";
				} else {
					if(i<message.length()-1)
						result[1] = result[1]+next; 
				}
			}

		}

		return result;
	}
}
