package no.hvl.dat100ptc.oppgave1;

public class Main {

	public static void main(String[] args) {
		
			//	d) Bruke GPSPoint-klassen
			//	Formålet med denne kort oppgaven er å bli kjent med bruken av GPSPoint-klassen før neste oppgave.
			//
			//	Implementer en klasse Main.java med en main-metode som opprettter et GPSPoint-objekt med tid 1, breddegrad 2.0, lengdegrad 3.0 og høyde 5.0.
			//
			//	Bruk getTime-metoden for å skrive tidspunkt ut på skjermen og setTime-metoden for å endre tidspunkt til 2. Bruk toString-metoden for å skrive informasjon om objektet ut på skjermen.
		
		
		// Oppgave D: Bruke GPSPoint-klassen
		GPSPoint gpsP = new GPSPoint(1,2.0,3.0,5.0);
		
		System.out.println("Tid i sekunder gitt bruk av get-metoden:\t" + gpsP.getTime());
		
		gpsP.setTime(2);
		
		System.out.println("Tid i sekunder etter endring med set-metoden:\t" + gpsP.getTime());
		
		// Bruker toString-metoden for å skrive informasjon om objektet ut på skjermen
		
		System.out.println(gpsP.toString());
		
	}

}
