package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {

	
	private static int TIME_STARTINDEX = 11; 

	
			//Når data leses inn fra fil vil informasjon om GPS punktet være representert som en (tekst)streng. Eksempelvis vil tiden for et innlest GPS punkt være representert som strengen:
			//
			//"2017-08-13T08:52:26.000Z"
			//Gjør ferdig implementasjon av metoden
			//
			//public static int toSeconds(String timestr)
			//som omregner tidsdata i en tekstreng som representert ovenfor til antall sekunder. For eksemplet ovenfor skal de 8 timer, 52 minutter og 26 regnes om til sekunder omregnes til 31946 sekunder og returneres.
			//
			//Hint: Se på substring-metoden i String-klassen samt parseInt-metoden i Integer-klassen.
	
	
	public static int toSeconds(String timestr) {
		
	    int hr = Integer.parseInt(timestr.substring(TIME_STARTINDEX, TIME_STARTINDEX + 2));
	    int min = Integer.parseInt(timestr.substring(TIME_STARTINDEX + 3, TIME_STARTINDEX + 5));
	    int sec = Integer.parseInt(timestr.substring(TIME_STARTINDEX + 6, TIME_STARTINDEX + 8));
	    
	    // Beregner total tid i sekunder
	    int secs = hr * 3600 + min * 60 + sec;
	    
	    return secs;
		
	}
	
		//	Implementer metoden
		//	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {
	
		//	som tar String-representasjoner av tid, breddegrad, lengdegrad og høyde, konverterer disse og oppretter et GPSPoint-objekt med de tilsvarende data. Metoden skal returnere en peker til det GPSPoint-objekt som blev opprettet.
		//
		//	Hvis eksempelvis skal metoden kalles med
		//	convert("2017-08-13T08:52:26.000Z","60.385390","5.217217","61.9")
	
		//	da skal metoden returne et GPSPoint-objekt der time er 31946, latitude er 60.385390, longitude er 5.217217 og elevation er 61.9.
		//
		//	Test metodene med enhetstestene som finnes i klassen GPSDataConverterTester.java.

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {

	    int timeInSeconds = toSeconds(timeStr);
	    double latitude = Double.parseDouble(latitudeStr);
	    double longitude = Double.parseDouble(longitudeStr);
	    double elevation = Double.parseDouble(elevationStr);

	    // Opprett et nytt GPSPoint-objekt med de konverterte verdiene
	    GPSPoint gpspoint = new GPSPoint(timeInSeconds, latitude, longitude, elevation);

	    return gpspoint;
		
	}
	
}