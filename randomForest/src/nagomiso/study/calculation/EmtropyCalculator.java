package nagomiso.study.calculation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import nagomiso.study.TraningData;

public class EmtropyCalculator {
	public static double getEmtropy(List<TraningData> datas) {
		ArrayList<String> labelList = new ArrayList<String>();
		for(TraningData data : datas){
			labelList.add(data.getLabel());
		}
		
		HashSet<String> labelSet = new HashSet<String>(labelList);

		double sum = 0;
		for (String label : labelSet) {
			sum -= getProbability(labelList, label)
					* (Math.log(getProbability(labelList, label)) / Math
							.log(2));
		}

		return sum;
	}

	private static int countLabel(List<String> labelList, String label) {
		int counted = 0;
		for (String l : labelList) {
			if (l.equals(label))
				++counted;
		}
		return counted;
	}

	private static double getProbability(List<String> labelList, String label) {
		return (double) countLabel(labelList, label) / labelList.size();
	}
}
