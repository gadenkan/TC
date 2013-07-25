import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class CityMap {

	public static void main(String[] args) {

		String[] cityMap = new String[] {"...........",
				 "...........",
				 "...........",
				 "..........T"};

		int[] POIs = new int[] { 1};

		CityMap c = new CityMap();
		String ret = c.getLegend(cityMap, POIs);
		System.out.println(ret);
	}

	public String getLegend(String[] cityMap, int[] POIs) {

		Map h = new LinkedHashMap<Character,Integer>();
		String ret = null;
		try {
			for (int i = 0; i < cityMap.length; i++) {
				for (int j = 0; j < cityMap[i].length(); j++) {

					Character poi = cityMap[i].charAt(j);
					if (h.get(poi) == null) {
						h.put(poi, 1);
					} else {
						int count = (Integer) h.get(poi);
						h.put(poi, count + 1);
					}
				}
			}

			ret = "";
			Set keys = h.keySet();

			for (int i = 0; i < POIs.length; i++) {
				int count = POIs[i];
				Iterator it = keys.iterator();
				while (it.hasNext()) {
					char key = (Character) it.next();
					int value = (Integer) h.get(key);
					if (count == value) {
						ret = ret + key;
						break;
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ret;

	}
}
