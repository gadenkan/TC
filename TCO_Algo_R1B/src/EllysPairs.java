
public class EllysPairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] know = new int[]{5, 1, 8, 8, 13, 7, 6, 2, 1, 9, 5, 11, 3, 4};
		int x = getDifference(know);
		System.out.println(x);
	}

	public static int getDifference(int[] know) {

		know = sort(know);
		int[] sums = new int[know.length/2];
		for(int i=0;i<(know.length/2);i++){
			sums[i] = know[i]+know[know.length-1-i];
		}
		int max = max(sums);
		int min = min(sums);
		//System.out.println(max);
		//System.out.println(min);
		return max-min;
	}

	public static int min(int[] sums) {
		int min = 2000;
		for(int i=0;i<sums.length;i++){
			if(sums[i] < min)
				min = sums[i];
		}
		return min;
	}

	public static int max(int[] sums) {
		int max = 0;
		for(int i=0;i<sums.length;i++){
			if(sums[i] > max)
				max = sums[i];
		}
		return max;
	}

	public static int[] sort(int[] know) {
		
		for(int i=0;i<know.length;i++){
			for(int j=0;j<know.length;j++){
				if(know[i] < know[j]){
					int temp = know[i];
					know[i] = know[j];
					know[j] = temp;
				}
			}
		}
		return know;
	}

}
