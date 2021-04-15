package Chybne;

public class Hranol extends Cetverec{ // Cetverec -> Chybne.Ctverec

	// konstruktor se zadanim delky hrany, vysky a materialu
	Hranol(float podstava,float vyska, boolean drevena){
		// chyba super() konstruktor
		hrana=vyska;
		zeDreva=drevena;
		pocetHranolu++; //pocetHranolu je final, teda je konstanta, nemozeme ju incrementovat
	}
	
	// vypocet objemu hranolu
	float vypoctiObjem() {
		return this.hrana*hrana*hrana;		
	}
	
	// nastaveni materialu
	void setDreveny(boolean dreveny){
		zeDreva=dreveny;
	}
	
	// zjisteni materialu
	boolean jeDreveny(){
		return zeDreva;
	}
	
	// zjisteni celkoveho poctu existujicich kostek
	static int getPocetHranolu(){
		return pocetHranolu; // pocetHranolu nie je static, teda neexistuje bez objektu
	}
	
	// zjisteni vysky hranolu
	float getHrana(){					
		return hrana;
	}
	// nastaveni vysky hranolu
	void setHrana(float delka){			
		hrana=delka;
	}
		
	private float hrana;
	boolean zeDreva;
	final int pocetHranolu=0;			
	
	
}
