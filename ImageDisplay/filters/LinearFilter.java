/**
 * @author Eric D. Dill eddill@ncsu.edu
 * @author James D. Martin jdmartin@ncsu.edu
 * Copyright � 2010-2013 North Carolina State University. All rights reserved
 */
package filters;

public class LinearFilter implements ImageFilter {
	@Override
	public double[][] apply(double[][] data, double min, double max) {
		double[][] newData = new double[data.length][data[0].length];
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				if(data[i][j] < min) { newData[i][j] = 0; }
				else if(data[i][j] > max) { newData[i][j] = 1; }
				else { newData[i][j] = (data[i][j]-min) / (max-min); }
			}
		}
		return data;
	}
	@Override
	public double[][] apply(double[][] data) {
		double[][] newData = new double[data.length][data[0].length];
		// find the min and max values in the current data array
		double min = Double.MAX_VALUE;
		double max = Double.MIN_VALUE;
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				if(min > data[i][j]) { min = data[i][j]; }
				if(max < data[i][j]) { max = data[i][j]; }
			}
		}
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				newData[i][j] = (data[i][j]-min) / (max-min);
			}
		}
		return newData;
	}
}
