package nagomiso.study;

import java.util.ArrayList;
import java.util.List;

public class Node {
	protected List<TraningData> sampleSet = new ArrayList<TraningData>();
	protected int depth = 0;

	public void add(TraningData sampleData) {
		sampleSet.add(sampleData);
	}

	public List<TraningData> getSampleSet() {
		return sampleSet;
	}

	public void setSampleSet(List<TraningData> sampleSet) {
		this.sampleSet = sampleSet;
	}

	public int getDepth() {
		return depth;
	}

}
