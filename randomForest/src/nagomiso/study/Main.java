package nagomiso.study;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<TraningData> data = new ArrayList<TraningData>();

		TraningData sparrow = new TraningData("aves",
				new double[] { 1d, 1d, 1d });
		TraningData lion = new TraningData("mammalia", new double[] { 1d, 2d,
				1d });
		TraningData lizard = new TraningData("reptiles", new double[] { 1d, 1d,
				2d });
		TraningData ostrich = new TraningData("aves",
				new double[] { 2d, 1d, 1d });
		TraningData cattle = new TraningData("mammalia", new double[] { 2d, 2d,
				1d });

		data.add(sparrow);
		data.add(lion);
		data.add(lizard);
		data.add(ostrich);
		data.add(cattle);

		ArrayList<SplitFunction> splitFunctions = new ArrayList<SplitFunction>();
		for (int i = 0; i < data.get(0).getFeatureVector().length; ++i) {
			splitFunctions.add(new SplitFunction(i, 2d));
		}

		Tree tree = new Tree();
		Node root =new Node();
		root.setData(data);
		tree.setRoot(root);
		tree.createTree(data, tree.getRoot(), splitFunctions);
		
		System.out.print(true);
	}

}
