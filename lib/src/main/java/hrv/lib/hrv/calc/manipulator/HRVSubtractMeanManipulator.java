package hrv.lib.hrv.calc.manipulator;

import hrv.lib.hrv.RRData;
import org.apache.commons.math3.stat.descriptive.moment.Mean;

public class HRVSubtractMeanManipulator implements HRVDataManipulator {

	@Override
	public RRData manipulate(RRData data) {
		
		double[] oldRRY = data.getValueAxis();
		double[] oldRRX = data.getTimeAxis();
		
		var newRRY = new double[data.getValueAxis().length];
		var newRRX = new double[data.getTimeAxis().length];
		
		var m = new Mean();
		double mean = m.evaluate(oldRRY);

		for (var i = 0; i < newRRY.length; i++) {
			newRRY[i] = oldRRY[i] - mean;
			newRRX[i] = oldRRX[i];
		}
		
		return new RRData(newRRX, data.getTimeAxisUnit(), newRRY, data.getValueAxisUnit());
	}

}
