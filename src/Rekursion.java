/**
 * Verschiedene rekursive Methoden, EiP Übungsblatt 6
 * @author Zin Yosrim
 *
 */
public class Rekursion 
{
	/**
	 * 
	 * berechnet x^y rekursiv.
	 * hoerbei gehen wir davon aus, dass die Menge der nat. Zahlen der Menge N0 entspricht
	 * @param x, die Basis
	 * @param y, der Exponent
	 * @return x hoch y
	 * 
	 */
	public static long potenz(long x, int y){
		if (y>0) {
			return potenz(x,y-1)*x;
		}
		else return 1;
	}
	
	/**
	 * Aufgabe 6-2 (a) 
	 * Berechnet die Stellen einer Dezimalzahl. Die Funktion aus Skript Folie 305. 
	 * 
	 * @param n die Dezimalzahl
	 * @return die Anzahl der Stellen
	 * 
	 */
	public static int stellen(long n) { 
		
		if(n / 10 == 0) {
			return 1; 
		} 
		
		else {
			return 1 + stellen(n / 10);
		} 
	}
	
	/**
	 * Aufgabe 6-2 (b)
	 * Die rekursive Methode spiegelzahl berechnet zu einer gegebenen ganzen Zahl ihre Spiegelzahl, 
	 * also die Zahl, die bei umgedrehter Ziffernreihenfolge entsteht.
	 * 
	 * @param z
	 * @return die Spiegelzahl
	 * 
	 */
	public static long spiegelzahl(long z){
		if (stellen(z) == 1){
			return z;
		}
		else {
			return (z%10)*potenz(10,stellen(z)-1)+spiegelzahl((z-z%10)/10);
		}
	}
	
	/**
	 * Aufgabe 6-2 (b)
	 * Die rekursive Methode bestimmt, ob eine Zahl ein Palindrom ist.
	 * 
	 * @param z
	 * @return true wenn palindrom, sonst false
	 * 
	 */
	public static boolean istPalindrom(long z){
		// durch 10 teilbar -> kein Palindrom
		if (z%10 == 0){
			return false;
		}
		// einstellige zahl ist immer ein palindom
		else if (stellen(z) == 1){
			return true;
		}
		// wenn stellenzahl gerade, dann muss die erste Hälfte der Zahl und der Spiegelzahl der 2. Hälfte identisch sein
		else if ( stellen(z)%2==0 && (z/potenz(10,stellen(z)/2) == spiegelzahl(z%potenz(10,stellen(z)/2)))) {
			return true;
		}
		// bei ungerader stellenzahl vergleicht man den linken und rechten teil (die Spiegelzahl davon) von der mittleren zahl 
		else if ( stellen(z)%2!=0 && (z/potenz(10,((stellen(z)+1)/2)) == spiegelzahl(z%potenz(10,((stellen(z)-1)/2))))) {
			return true;
		}
		return false;
	}
	/**
	 * Aufgabe 6-3 (a)
	 * Rekursive Umsetzung des Peer Reviews. Für eine gegebene Anzahl von Keksen wir bestimmt,
	 * wie viele Kekse getestet werden müssen, ohne alle aufzuessen.
	 * 
	 * @param n Anzahl der Menge der Kekse
	 * @return Anzahl der zu testenden Kekse
	 * 
	 */
	public static int peer(int n){
		if (n==0){
			return 0;
		}
		else if (n==1){
			return 1;
		}
		else if (n%2 == 0){
			return 2+peer((n-2)/2);
		}
		else{
			return 1+peer(n-1);
		}
	}
	/**
	 * Aufgabe 6-4 (a)
	 * Berechnet rekursiv die Summe 1+2..+n
	 * @param n 
	 * @return Summe 1+2..+n
	 * 
	 */
	public static int summeRek(int n){
		if (n==1)return 1;
		else return n+summeRek(n-1);
	}
	
	/**
	 * Aufgabe 6-4 (b)
	 * Berechnet iterativ die Summe 1+2..+n
	 * @param n 
	 * @return Summe 1+2..+n
	 * 
	 */	
	public static int summeIt(int n){
		int summe = 0;
		for (int i=1;i<=n;i++){
			summe = summe+i;
		}
		return summe;	
	}
	
	/**
	 * iterative Umsetzng des Heron Verfahrens
	 * Annäherung an Wurzel von x (in n+1 Schritten)
	 *  
	 * @param x Zahl deren Wurzel berechnet werden soll
	 * @param n Genauigkeit
	 * @return Wurzel von x
	 * 
	 */
	public static double wurzelIt(double x, int n){
		
		double x_n = 0;
		int i=0;
		x_n = (x+1)/2;
		while (i<n){
			x_n=0.5*(x_n+x/(x_n));
			i++;		
		}
		return x_n;
	}
		
	/**
	 * Aufgabe 6-4 (d)
	 * Iterative Berechnung der Fibonacci Zahlen
	 * 1ste ist 0, 2te ist 1
	 * @param n 
	 * @return n-te fibonaccizahl
	 * 
	 * PS kann man vermutlich eleganter programmieren aber zur späten stunde kam nix besseres raus
	 */
	public static int fibIt(int n){
		if (n == 1) return 0;
		else if ( n==2 ) return 1;
		else{
			int fib = 0;
			int vorletzte = 0;
			int letzte = 1;
			int zaehler = 2;
			while (zaehler < n){
				fib = vorletzte + letzte;
				vorletzte = letzte;
				letzte = fib;
				zaehler++;
			}
			return fib;
		}
	}
	
	/**
	 * Test der Methoden
	 * @param args
	 */
	public static void main( String [ ] args ) { 
		System.out.println(potenz(10,3));
		System.out.println(stellen(12343));
		System.out.println(spiegelzahl(17340));
		System.out.println(istPalindrom(222));
		System.out.println(peer(8));
		System.out.println(summeRek(4));
		System.out.println(summeIt(10));
		System.out.println(fibIt(7));
		System.out.println(wurzelIt(16,2));		
	}
}