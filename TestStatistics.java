// This program compute a number of statistics for a set of data provided by the user 
// and get and display their min, max, avg, and median 

import javax.swing.JOptionPane;

public class TestStatistics {

	public static void main(String[] args) {
		String in, out;
		
		// input array length
		in=JOptionPane.showInputDialog("Enter data size: ");
		int dataLength = Integer.parseInt(in);
		
		// Create the array
		double [] data = new double[dataLength];
		
		// Populate the array
		for(int i = 0; i < dataLength; i++) {
			in=JOptionPane.showInputDialog("Enter data iteams: ");
			data[i]= Double.parseDouble(in);
		}
		
		// Create a statics of  objects
		Statistics stat = new Statistics(data);
		double[] origData = stat.findOrigData();
		double[] sortedData = stat.findSortedData();
		double min=stat.findMin();
		double max=stat.findMax();
		double avg=stat.findMean();
		double median=stat.findMedian();
		
		// Build Output
		out = "\nOriginal Data:\n";
		out += origData[0];
		
		for(int i=0; i<origData.length; i++) {
			out = out+", " + origData[i];
		}
		// Build Output
		out += "\nSorted Data:\n";
		out += sortedData[0];
		
		for(int i=1; i<sortedData.length; i++) {
			out=out+", " + sortedData[i];
		}

		out +="\nMin: "+min+"\n";
		out +="Max: "+max+"\n";
		out +="Mean: "+avg+"\n";
		out +="Median: "+median+"\n";
		JOptionPane.showMessageDialog(null, out);
	}
}

// Statistics.java
import java.util.Arrays;

public class Statistics {
	private double [] data; // Declaration an array in Java
	private double [] sdata;
	
	// Treat the public as a void.
	public Statistics(double[] d) {
		
		/*
		data = new double [d.length];
		System.arraycopy(d, 0, data, 0, d.length);
		*/
		
		data = d.clone();
		sdata = d.clone();
		Arrays.sort(sdata);
	};
	public double findMin() {
		double min;
		min = sdata[0];
		return min;
	}
	
	public double findMax() {
		double max;
		max = sdata[sdata.length-1];
		return max;
	}
	public double findMean(){
		double sum=0;
		
		for(int i=0; i < sdata.length; i++) {
			sum += sdata[i];
		}
		double avg = sum /sdata.length;
		return avg;
	}
	public double findMedian() {
		int loIndexMid, hiIndexMid, indexMid;
		double median;
		
		if ((sdata.length%2) == 0) { // Even case
			hiIndexMid=sdata.length/2;
			loIndexMid=hiIndexMid-1;
			median = (sdata[loIndexMid]+sdata[hiIndexMid])/2.0;
		}
		else {
			indexMid = sdata.length/2;
			median = sdata[indexMid];
		}
		return median;
	}
	public double [] findOrigData() {
		double [] origData;
		origData = data.clone();
		return origData;
	}
	public double [] findSortedData() {
		double [] sortedData;
		sortedData = sdata.clone();
		return sortedData;
	}
}
