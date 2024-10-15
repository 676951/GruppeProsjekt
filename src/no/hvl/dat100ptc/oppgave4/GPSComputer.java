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
		
		
		for (int i = 0; i < gpspoints.length -1; i++) {
			double elevationDifference = gpspoints[i +1].getElevation() - gpspoints[i].getElevation();
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
			int time2 = gpspoints[i+1].getTime();
			totalTime += time2-time1;
		}

<<<<<<< Updated upstream
		return totalTime;
		
=======
		int totalTime = 0;
		
		for (int i = 0; i < gpspoints.length -1; i++) {
			int timeDifference = gpspoints[i +1].getTime() - gpspoints[i].getTime();
			if (timeDifference > 0) {
				totalTime += timeDifference;
			}
		}
		return totalTime;
		

>>>>>>> Stashed changes
	}
	
			//	d)
			//	Implementer metoden
			//
			//	public double[] speeds()
			//	som skal returnere en tabell med gjennomsnitshastigheter målt i m/s mellom hver av de punktene 
			//	vi har beveget oss mellom. 
			//	Dvs. første inngang i tabellen skal være hastigheten vi beveget oss med mellom punkt 0 og punkt 1, 
			//	andre inngang hastigheten mellom punkt 1 og 2 osv. 
			//	Hvis antall GPS datapunker er N da vil lengden av den tabellen som returneres være N-1.

	public double[] speeds() {

		double[] speeds = new double[gpspoints.length - 1];
		
	    for (int i = 0; i < gpspoints.length - 1; i++) {

<<<<<<< Updated upstream
	        speeds[i] = GPSUtils.speed(gpspoints[i], gpspoints[i + 1]);
	    }
=======
		
>>>>>>> Stashed changes

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

		double average = 0;

		// TODO
		throw new UnsupportedOperationException(TODO.method());

	}

	// conversion factor m/s to miles per hour (mps)
	public static final double MS = 2.23;

	public double kcal(double weight, int secs, double speed) {

		double kcal;

		double met = 0;
		double speedmph = speed * MS;

		// TODO
		throw new UnsupportedOperationException(TODO.method());

	}

	public double totalKcal(double weight) {

		double totalkcal = 0;

		// TODO
		throw new UnsupportedOperationException(TODO.method());

	}

	private static double WEIGHT = 80.0;

	public void displayStatistics() {

		// TODO
		throw new UnsupportedOperationException(TODO.method());

	}

}
