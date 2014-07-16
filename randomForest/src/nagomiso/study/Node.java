package nagomiso.study;

import java.util.ArrayList;
import java.util.List;

public class Node {
	protected List<SampleData> sampleSet = new ArrayList<SampleData>();
	protected int depth = 0;

	public void add(SampleData sampleData) {
		sampleSet.add(sampleData);
	}

	public List<SampleData> getSampleSet() {
		return sampleSet;
	}

	public void setSampleSet(List<SampleData> sampleSet) {
		this.sampleSet = sampleSet;
	}

	public int getDepth() {
		return depth;
	}

}
