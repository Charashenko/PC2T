package cv07;

import java.util.*;

public class Databaze {

	private Scanner sc;
	private HashMap<String, Student> prvkyDatabaze;

	public Databaze() {
		prvkyDatabaze=new HashMap<>();
	}
	
	public void setStudent() throws InputMismatchException {
		sc = new Scanner(System.in);
		System.out.println("[Info] Zadejte jmeno studenta, rok narozeni");
		String jmeno = sc.nextLine();
		int rok = sc.nextInt();
		if(prvkyDatabaze.containsKey(jmeno)){
			System.out.println("[Warning] Student s tymto menom sa uz nachadza v DB");
			setStudent();
		} else {
			prvkyDatabaze.put(jmeno.toLowerCase(), new Student(jmeno, rok));
			System.out.println("[Info] Student bol pridany do DB");
		}
	}
	
	public boolean getStudent() throws CustomException {
		sc = new Scanner(System.in);
		System.out.println("[Info] Zadejte jmeno studenta");
		String meno = sc.nextLine();
		if(prvkyDatabaze.containsKey(meno.toLowerCase())){
			System.out.println("[Meno] " + prvkyDatabaze.get(meno).getJmeno());
			System.out.println("[Vek] " + prvkyDatabaze.get(meno).getRocnik());
			System.out.println("[Priemer] " + prvkyDatabaze.get(meno).getStudijniPrumer());
			return true;
		}
		return false;
	}
	
	public boolean setPrumer() throws CustomException, NullPointerException
	{
		sc = new Scanner(System.in);
		System.out.println("[Info] Zadejte jmeno studenta a jeho priemer");
		String meno = sc.nextLine();
		float prumer = sc.nextFloat();
		if(5 < prumer || prumer < 1) {
			throw new CustomException("[Warning] Zadany priemer nieje z dobreho rozsahu (1-5)");
		}
		if(prvkyDatabaze.containsKey(meno)){
			prvkyDatabaze.get(meno.toLowerCase()).setStudijniPrumer(prumer);
			System.out.println("[Info] Priemer studenta bol zmeneny");
			return true;
		} else {
			System.out.println("[Info] Tento student sa nenachadza v DB");
			return false;
		}
	}

	public void printNames(){
		System.out.println("[Info] Vypis mien z databazy");
		for (String str : prvkyDatabaze.keySet()) {
			System.out.println(prvkyDatabaze.get(str).getJmeno());
		}
	}

	public void removeStudent(){
		sc = new Scanner(System.in);
		String meno = sc.nextLine();
		if(prvkyDatabaze.containsKey(meno.toLowerCase())){
			prvkyDatabaze.remove(meno.toLowerCase());
			System.out.println("[Info] Student bol odstraneny");
		} else {
			System.out.println("[Warning] Student sa nenachadza v databaze");
		}
	}
}