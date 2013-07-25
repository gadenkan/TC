public class TheExperimentDiv2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TheExperimentDiv2 x = new TheExperimentDiv2();
		int[] res = x.determineHumidity(
				new int[] {0,110,0,0,0}, 1,
				new int[] {4,3,4,4,1,1,1});
		
		for(int i=0;i<res.length;i++){
			System.out.print(res[i]+" ");
		}

	}

	public int[] determineHumidity(int[] intensity, int L, int[] leftEnd) {

		int rows = leftEnd.length + 1;
		int cols = intensity.length;
		int[][] matrix = new int[rows][cols];

		for (int j = 0; j < cols; j++) {

			matrix[0][j] = intensity[j];

		}

		for (int j = rows-1; j > 0; j--) {
			
			int start = leftEnd[j-1];
			
			for(int i=start;i<start+L;i++){
				matrix[j][i] = matrix[0][i];
				
				for(int m=j+1;m<rows;m++){
					matrix[m][i] = 0;
				}
			}

		}
		
		
		int[] result = new int[rows-1];
		for(int i=1;i<rows;i++){
			int sum=0;
			for(int j=0;j<cols;j++){
				sum = sum+matrix[i][j];
			}
			result[i-1]=sum;
		}

		return result;
	}

}
