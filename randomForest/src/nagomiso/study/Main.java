package nagomiso.study;

import java.util.ArrayList;
import java.util.List;

import static nagomiso.study.util.ImportData.*;
import static nagomiso.study.random.Random.*;

public class Main {

	public static void main(String[] args) {
		List<TraningData> traningDataSet = importCsv("./traningdata/iris_normalized.data");
		ArrayList<TraningData> testDataSet = new ArrayList<TraningData>();

		for (int i = 0; i < 20; ++i) {
			testDataSet
					.add(traningDataSet.remove(nextInt(traningDataSet.size() - 1)));
		}

		Forest forest = new Forest();
		forest.lean(traningDataSet, 1000, 10);

		System.out.printf("%-16s\t%-16s\n", "actual", "expected");
		System.out
				.println("-----------------------------------------------------");
		for (TraningData test : testDataSet) {
			String actual = forest.predict(test.getFeatureVector());
			String expected = test.getLabel();
			System.out.printf("%-16s\t%-16s\t%-5s\n", actual, expected,
					actual.equals(expected));
		}
	}

}
