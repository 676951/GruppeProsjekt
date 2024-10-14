package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class Main {
	
		//	c) Bruke GPSData-klassen

		//
		//	Oppretter to GPSPoint-objekter (velg selv argumenter for konstruktøren)
		//
		//	Oppretter et GPSData-objekt med plass til to GPSPoint-objekt
		//
		//	Setter inn de to objektene ved å bruke insertGPS-metoden på GPSData-objektet.
		//
		//	Skriver ut informasjon om GPSPoint-objektene ved å bruke print-metoden på et GPSData-objekt.

	
	public static void main(String[] args) {

		GPSPoint p1 = new GPSPoint(4,2.0,3.0,5.0);
		GPSPoint p2 = new GPSPoint(6,3.0,8.0,9.0);
		
		GPSData n = new GPSData(2);
		
		n.insertGPS(p1);
		n.insertGPS(p2);
		
		n.print();
		
		
	}
}