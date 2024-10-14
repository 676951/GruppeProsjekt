package no.hvl.dat100ptc.oppgave1;

import no.hvl.dat100ptc.TODO;

public class GPSPoint {

			//	a) Objektvariable og konstruktør
			//	Se på start-koden for klassen GPSPoint.java i pakken no.hvl.dat100ptc.oppgave1.
			//
			//	Utvid startkoden for klassen slik klassen får følgende objektvariable:
			//
			//	time (heltall) som angir tiden i sekunder
			//	latitude (desimaltall) som angir breddegrad
			//	longitude (desimaltall) som angir lengdegrad
			//	elevation (desimaltall) som angir høyde i meter
				
			//	Alle objektvariable skal være private dvs. kun synlige innenfor klassen.
			//
			//	Videre skal klassen ha en konstruktør
			//
			//	public GPSPoint(int time, double latitude, double longitude, double elevation)
			//	som kan gi verdi til alle objektvariable.
			//
			//	Test implementasjonen ved å kjøre testene i test-klassen GPSPointTester.java.

	// Objektvariabler
	private int time;			// tid i sekunder
	private double latitude;	// breddegrad
	private double longitude;	// lengdegrad
	private double elevation;	// høyde i meter
	
	// Kontstruktør
	public GPSPoint(int time, double latitude, double longitude, double elevation) {
		this.time = time;			// tid i sekunder
		this.latitude = latitude;	// breddegrad
		this.longitude = longitude;	// lengdegrad
		this.elevation = elevation;	// høyde i meter
		
	}
	
			//	b) Hent/sett-metoder
			//	Gjør ferdig implementasjonen av hent/sett (get/set)-metoder og test de med enhetstestene i test-klassen GPSPointTester.java.
	
	// Set- og get-metoder
	public int getTime() {
		
		return time;
		
	}

	public void setTime(int time) {
				
		this.time=time;
		
	}

	public double getLatitude() {
		
		return latitude;
		
		
	}

	public void setLatitude(double latitude) {
		
		this.latitude=latitude;
		
	}

	public double getLongitude() {
		
		return longitude;
		
	}

	public void setLongitude(double longitude) {
		
		this.longitude=longitude;
		
	}

	public double getElevation() {
		
		return elevation;
		
	}

	public void setElevation(double elevation) {
		
		this.elevation=elevation;
		
	}
	
			//	c) Representasjon som tekststreng
			//	Gjør ferdig implementasjonen av toString()-metoden som returnerer en strengrepresentasjon av et GPSPoint-objekt på formen:
			//
			//	"1 (2.0,3.0) 5.0\n"
			//
			//	der 1 er tiden, (2.0,3.0) er (breddegrad,lengdegrad) og 5.0 er høyden.
			//
			//	Test implementasjonen ved å bruke enhetstestene i test-klassen GPSPointTester.java.
//	
	public String toString() {
		
		String str = "";
		
		str += time + " (" + latitude + "," + longitude + ") " + elevation + "\n";

		return str;
		
	}
}
