package no.hvl.dat100ptc.oppgave4;

import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;

import static java.lang.Math.toRadians;

import no.hvl.dat100ptc.TODO;

public class GPSComputer {

	private GPSPoint[] gpspoints;

	public GPSComputer(String filename) {

		GPSData gpsdata = GPSDataFileReader.readGPSFile(filename);
		gpspoints = gpsdata.getGPSPoints();

	}

	public GPSComputer(GPSPoint[] gpspoints) {
		this.gpspoints = gpspoints;
	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}

	public double totalDistance() {

		double totalDistance = 0;

		for (int i = 0; i < gpspoints.length - 1; i++) {
			double distance = GPSUtils.distance(gpspoints[i], gpspoints[i + 1]);
			totalDistance += distance;
		}

		return totalDistance;

	}

	public double totalElevation() {

		double totalElevation = 0;

		for (int i = 0; i < gpspoints.length - 1; i++) {
			double elevationDifference = gpspoints[i + 1].getElevation() - gpspoints[i].getElevation();
			if (elevationDifference > 0) {
				totalElevation += elevationDifference;
			}
		}
		return totalElevation;

	}

	public int totalTime() {

		int totalTime = 0;

		for (int i = 0; i < gpspoints.length - 1; i++) {
			int time1 = gpspoints[i].getTime();
			int time2 = gpspoints[i + 1].getTime();
			totalTime += time2 - time1;
		}
		return totalTime;
	}

	public double[] speeds() {

		double[] speeds = new double[gpspoints.length - 1];

		for (int i = 0; i < gpspoints.length - 1; i++) {

			speeds[i] = GPSUtils.speed(gpspoints[i], gpspoints[i + 1]);
		}

		return speeds;
	}

	public double maxSpeed() {

		double maxSpeed = 0;

		for (int i = 0; i < gpspoints.length - 1; i++) {
			double speed = GPSUtils.speed(gpspoints[i], gpspoints[i + 1]);
			if (speed > maxSpeed) {
				maxSpeed = speed;
			}
		}

		return maxSpeed;
	}

	public double averageSpeed() {

		double totalSpeed = 0;
		for (int i = 0; i < gpspoints.length - 1; i++) {
			double speed = GPSUtils.speed(gpspoints[i], gpspoints[i + 1]);
			totalSpeed += speed;
		}

		double averageSpeed = totalSpeed / (gpspoints.length - 1.5);

		return averageSpeed;
	}

	// conversion factor m/s to miles per hour (mps)
	public static final double MS = 2.23;

	public double kcal(double weight, int secs, double speed) {

		double kcal;

		double met = 0;
		double speedmph = speed * MS;

		if (speedmph < 10) {
			met = 4.0;
		} else if (speedmph < 12) {
			met = 6.0;
		} else if (speedmph < 14) {
			met = 8.0;
		} else if (speedmph < 16) {
			met = 10;
		} else if (speedmph < 20) {
			met = 12;
		} else {
			met = 16;
		}
		double timeHours = secs / 3600;

		kcal = met * weight * timeHours;

		return kcal;

	}

	public double totalKcal (double weight) {
		 if (gpspoints == null || gpspoints.length < 2) {
		        return 0;
		    }

		    double totalKcal = 0; 

		    
		    for (int i = 0; i < gpspoints.length - 1; i++) {
		        
		        int timeSecs = gpspoints[i + 1].getTime() - gpspoints[i].getTime();

		        
		        if (timeSecs > 0) {
		           
		            double speed = GPSUtils.distance(gpspoints[i], gpspoints[i + 1]) / timeSecs; 

		            
		            totalKcal += kcal(weight, timeSecs, speed);
		        }
		    }
		    return totalKcal;
		
	}
		   	  

	
	public void displayStatistics() {

		// TODO
		throw new UnsupportedOperationException(TODO.method());

	}

}
