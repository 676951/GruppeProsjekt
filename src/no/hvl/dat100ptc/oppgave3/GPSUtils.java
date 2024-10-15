package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.TODO;

public class GPSUtils {

	// a)
	// Implementer metoden

	// double findMin(double[] da)
	// som finner minste tall i en tabell med flyttall. Det kan antas at der er
	// minst et element i tabellen.
	// Hint: se på implementasjonen av metoden findMax som allerede finnes i
	// klassen.

	public static double findMax(double[] da) {

		double max;

		max = da[0];

		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}

		return max;
	}

	public static double findMin(double[] da) {

		double min;

		min = da[0];

		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}
		return min;

	}

	// b)
	// Implementer metoden
	//
	// public static double[] getLatitudes(GPSPoint[] gpspoints)
	// som tar en tabell med GPS punkter som parameter og returnerer
	// en tabell av desimaltall inneholdende breddegradene for GPS-punktene.
	//
	// Hint: metoden skal først opprette en tabell av desimaltall med samme lengde
	// som gpspoints-tabellen og så kopiere de enkelte breddegrader over i den nye
	// tabellen.
	// Husk at getLatitude-metoden på et GPSPoint-objekt kan brukes til å lese ut
	// breddegrad i et objekt.

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		double[] latitudes = new double[gpspoints.length];

		for (int i = 0; i < gpspoints.length; i++) {

			latitudes[i] = gpspoints[i].getLatitude();
		}

		return latitudes;
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		double[] longitudes = new double[gpspoints.length];

		for (int i = 0; i < gpspoints.length; i++) {

			longitudes[i] = gpspoints[i].getLongitude();
		}

		return longitudes;

	}

	// Oppgave D
	// Beregner og returnerer avstanden d i meter mellom to GPS-punkt

	private static final int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;

		double latitude1 = toRadians(gpspoint1.getLatitude());
		double latitude2 = toRadians(gpspoint2.getLatitude());

		double longitude1 = toRadians(gpspoint1.getLongitude());
		double longitude2 = toRadians(gpspoint2.getLongitude());

		double deltaphi = latitude2-latitude1;
		double deltadelta = longitude2-longitude1;
		
		double a = compute_a(latitude1, latitude2, deltaphi, deltadelta);
		double c = compute_c(a);

		d = R * c;
		
		return d;

	}

	private static double compute_a(double phi1, double phi2, double deltaphi, double deltadelta) {
		
		return pow(sin(deltaphi / 2), 2)
				+ cos(phi1) * cos(phi2) * pow(Math.sin(deltadelta / 2), 2);

	}
	
	private static double compute_c(double a) {
		return 2 * atan2(sqrt(a), sqrt(1 - a));

	}
	
		//	e)
		//	Implementer metoden
		//
		//	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {
		//	som beregninger gjennomsnittshastighet i m/s om man beveger seg fra punktet gitt ved gpspoint1 til punktet gpspoint2.
		//
		//	Hint: Bruk metoden distance fra d) samt get-metode(r) på GPSPoint-objekt.

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {
		
		int secs = gpspoint2.getTime()-gpspoint1.getTime();
		
	    double dist = distance(gpspoint1, gpspoint2);

	    double speed = dist / secs;

	    return speed;
	}
		


	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";
		
		int hours = secs / 3600;
		int minutes= (secs % 3600) /60;
		int seconds= secs % 60;

		timestr = String.format("%02d%s%02d%s%02d", hours, TIMESEP, minutes, TIMESEP, seconds); // setter formatet hh:mm:ss
		
		return timestr;
	
	}

	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str = String.format("%.02f", d); // Tar inn double parameter, forkorter til 2 desimaler / float
		
		str = String.format("%" + TEXTWIDTH + "s", str); // setter lengden til 10, s=string, % = formatering
		
		return str;

	}
}
