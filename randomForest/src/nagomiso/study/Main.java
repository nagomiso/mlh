package nagomiso.study;

import java.util.ArrayList;
import java.util.List;

import static nagomiso.study.util.ImportData.*;
import static nagomiso.study.random.Random.*;

public class Main {

	public static void main(String[] args) {
		List<TraningData> data = importCsv("C:/Users/yuuki/git/randomForest/randomForest/traningdata/iris_normalized.data");
		ArrayList<TraningData> testData = new ArrayList<TraningData>();

		for (int i = 0; i < 20; ++i) {
			testData.add(data.remove(nextInt(data.size() - 1)));
		}

		ArrayList<SplitFunction> splitFunctions = new ArrayList<SplitFunction>();
		for (int i = 0; i < data.get(0).getFeatureVector().length; ++i) {
			for (double thrashold = 0d; thrashold < 1d; thrashold += 0.01)
				splitFunctions.add(new SplitFunction(i, thrashold));
		}
		Tree tree = new Tree();
		Node root = new Node();
		root.setData(data);
		tree.setRoot(root);
		tree.createTree(data, splitFunctions);
		
		
	}

}
