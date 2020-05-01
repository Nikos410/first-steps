
 public class Wuerfel {
	private int augenzahl;
	
	// Konstruktor
	public Wuerfel() {}

	// Dienste/Methoden
	public int gibAugenzahl() {
		return augenzahl;
	}
	
	public void wuerfelDich() {
		double dezimalZahl = Math.random();
		augenzahl = (int)Math.round( dezimalZahl * 5 ) + 1;
	}
}

