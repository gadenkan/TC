public class PrimalUnlicensedCreatures {

	public static void main(String[] args) {

		int[] powers = new int[] { 7, 8, 9, 10 };
		int initialPower = 7;

		int res = maxWins(initialPower, powers);
		System.out.println(res);

	}

	public static int maxWins(int initialLevel, int[] grezPower) {

		grezPower = sort(grezPower);
		int level = initialLevel;
		int count = 0;
		for(int i=0;i<grezPower.length && level>grezPower[i];i++ ){
			count++;
			level = level + grezPower[i]/2;
		}

		return count;
	}

	public static int[] sort(int[] powers) {

		for(int i=0;i<powers.length;i++){
			
			for(int j=i;j<powers.length;j++){
				
				if(powers[i] > powers[j]){
					int temp = powers[i];
					powers[i] = powers[j];
					powers[j] = temp;
				}
			}
		}
		return powers;
	}

}
