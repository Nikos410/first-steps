public class Wuerfelbecher {
	// Bezugsobjekte
	private Wuerfel hatWuerfel1;
	private Wuerfel hatWuerfel2;
	
	// Attribute

	// Konstruktor
	public Wuerfelbecher() {
		hatWuerfel1 = new Wuerfel();
		hatWuerfel2 = new Wuerfel();
	}

	// Dienste/Methoden
	public void schuettelDich() {
		hatWuerfel1.wuerfelDich();
		hatWuerfel2.wuerfelDich();
	}
	
	public int zeigeWuerfelergebnis() { 
		if(hatWuerfel1.gibAugenzahl() > hatWuerfel2.gibAugenzahl()) {
			return 10 * hatWuerfel1.gibAugenzahl() + hatWuerfel2.gibAugenzahl();
		} else {
			return 10 * hatWuerfel2.gibAugenzahl() + hatWuerfel1.gibAugenzahl();
		}
		
	}
	
	public int wrf(){
	    hatWuerfel1.wuerfelDich();
		hatWuerfel2.wuerfelDich();
		
		if(hatWuerfel1.gibAugenzahl() > hatWuerfel2.gibAugenzahl()) {
			return 10 * hatWuerfel1.gibAugenzahl() + hatWuerfel2.gibAugenzahl();
		} else {
			return 10 * hatWuerfel2.gibAugenzahl() + hatWuerfel1.gibAugenzahl();
		}
	   }
}