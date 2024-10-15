package no.hvl.dat100ptc.oppgave4;

import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;

import java.util.stream.DoubleStream;

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
		double[] speeds = speeds();

		for (int i = 0; i < speeds.length; i++) {
			if (speeds[i] > maxSpeed) {
				maxSpeed = speeds[i];
			}
		}

		return maxSpeed;

	}

	public double averageSpeed() {
		return totalDistance() / totalTime();
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
		double timeHours = secs / 3600.00;

		kcal = met * weight * timeHours;

		return kcal;

	}

	public double totalKcal(double weight) {
		if (gpspoints == null || gpspoints.length < 2) {
			return 0;
		}

		double totalKcal = 0;
		
		for (int i = 0; i < gpspoints.length - 1; i++) {
			int timeSecs = gpspoints[i + 1].getTime() - gpspoints[i].getTime();

			double speed = GPSUtils.speed(gpspoints[i], gpspoints[i + 1]);
			
			totalKcal += kcal(weight, timeSecs, speed);

		}
		
		return totalKcal;

	}
	
	private static double WEIGHT = 80.0;

//			==============================================
//				Total Time     :   00:36:35
//				Total distance :      13.74 km
//				Total elevation:     210.60 m
//				Max speed      :      47.98 km/t
//				Average speed  :      22.54 km/t
//				Energy         :     744.40 kcal
//			==============================================

	public void displayStatistics() {

		String utskrift = "";
		System.out.println("==============================================");

		int totaltime = totalTime();
		utskrift += "Total Time\t:\t" + GPSUtils.formatTime(totaltime) + "\n";

		double distance = totalDistance();
		utskrift += "Total distance\t:\t" + String.format("%.2f", distance) + "km\n";

		double elevation = totalElevation();
		utskrift += "Total elevation\t:\t" + String.format("%.2f", elevation) + "\tm\n";

		double maxspeed = maxSpeed();
		utskrift += "Max speed\t:\t" + String.format("%.2f", maxspeed) + "\tkm/t\n";

		double avspeed = averageSpeed();
		utskrift += "Average speed\t:\t" + String.format("%.2f", avspeed) + "\tkm/t\n";

		double energy = totalKcal(WEIGHT);
		utskrift += "Energy\t\t:\t" + String.format("%.2f", energy) + "\tkcal";

		System.out.println(utskrift);
		System.out.println("==============================================");
	}

}
