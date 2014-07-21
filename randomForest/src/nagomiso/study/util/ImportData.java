package nagomiso.study.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import nagomiso.study.TraningData;

public class ImportData {

	public static List<TraningData> importCsv(String path) {
		ArrayList<TraningData> traningData = new ArrayList<TraningData>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(path));

			// 最終行まで読み込む
			String line = "";
			while ((line = br.readLine()) != null) {

				// 1行をデータの要素に分割
				StringTokenizer st = new StringTokenizer(line, ",");
				int tokensSize = st.countTokens();
				ArrayList<Double> featureVector = new ArrayList<Double>();
				for(int i=0 ; i < tokensSize -1 ; ++i) {
					featureVector.add((Double.parseDouble(st.nextToken())));
				}
				
				traningData.add(new TraningData(st.nextToken(), featureVector));
			}
			br.close();
		} catch (FileNotFoundException e) {
			// Fileオブジェクト生成時の例外捕捉
			e.printStackTrace();
		} catch (IOException e) {
			// BufferedReaderオブジェクトのクローズ時の例外捕捉
			e.printStackTrace();
		}
		return traningData;
	}
}
