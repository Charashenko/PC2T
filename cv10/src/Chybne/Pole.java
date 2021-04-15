package Chybne;

import java.util.Scanner;

public class Pole {

	// Konstruktor s velikosti pole
	Pole(int velikost)
	{
		mojeHranoly=new Hranol[velikost];
		sc=new Scanner(System.in);
	}
	
	// vlozeni hranolu do pole na prvni volnou pozici
	void zadejHranol(){
		boolean drevena=false;
		float delka=0;
		float vyska=0;
		System.out.println("Zadejte delku podstavy hranolu");
		while(!sc.hasNextFloat())
		{
			sc.next();
		}
		delka=sc.nextFloat();
		System.out.println("Zadejte vysku hranolu");
		while(!sc.hasNextFloat())
		{
			sc.next();
		}
		vyska=sc.nextFloat();
		System.out.println("Je drevena?");
		while(!sc.hasNextFloat()) // hasNextFloat -> hasNextBoolean
		{
			sc.next();
		}
		drevena=sc.nextBoolean();
		if (Hranol.getPocetHranolu()>mojeHranoly.length) // objekt pole sa nikde nevytvara, a preto je mojeHranoly null,
			// pocet hranolov nebude nikdy vyzsi ako velkost mojeHranoly
		{
			System.out.println("Chybne.Pole uz je zaplneno");
			return;
		}
		mojeHranoly[Hranol.getPocetHranolu()].setHrana(delka);			
		mojeHranoly[Hranol.getPocetHranolu()].setHrana(vyska); //prepis "delka"
		mojeHranoly[Hranol.getPocetHranolu()].setDreveny(drevena);
	}
	
	// vypis objemu vsech hranolu
	void vypoctiObjem() //nazov vypoctiObjem pre vypocet obsahu
	{
		for (int i=0;i<Hranol.getPocetHranolu();i++)
			System.out.println("Objem i. hranolu je" + mojeHranoly[i].vypoctiObsah());
		// vypoctiObsah neexistuje v triede Hranol
		// a pretoze je zly extends nevie to najst ani v triede Ctverec
	}
	
	// vypis obsahu podstavy vsech hranolu
	void vypoctiObsahPodstavy() //nazov vypoctiObsahPodstavy pre vypocet objemu
	{
		for (int i=0;i<Hranol.getPocetHranolu();i++)
			System.out.println("Obsah i. hranolu je" + mojeHranoly[i].vypoctiObjem());
	}
	
	// nalezeni indexu nejmensiho hranolu
	int najdiNejmensiObjem()
	{
		float min=0;									
		int idx=0;										
		for (int i=0;i<Hranol.getPocetHranolu();i++)
		{
			if (mojeHranoly[i].vypoctiObjem()<min){ // nikdy toto nenastane, pretoze min = 0
				min=mojeHranoly[i].vypoctiObjem();
				idx=i;
			}
		}
		return idx;
	}
	
	// zjisteni celkoveho poctu drevenych kostek
	int zjistiPocetDrevenych(){
		int pocetDrevenych=0;
		for (int i=1;i>mojeHranoly.length;)	// chybny for loop
		{
			if (mojeHranoly[i].zeDreva=true) // = -> ==
				pocetDrevenych++;
		}
		return pocetDrevenych;
	}

	private Scanner sc;
	private Hranol []mojeHranoly;
}
