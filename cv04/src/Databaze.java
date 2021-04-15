import java.util.InputMismatchException;
import java.util.Scanner;

public class Databaze {
	public Databaze(int pocetPrvku)
	{
		prvkyDatabaze=new Student[pocetPrvku];
		sc=new Scanner(System.in);
	}
	
	public void setStudent() throws ArrayIndexOutOfBoundsException, InputMismatchException
	{
		sc=new Scanner(System.in);
		System.out.println("Zadejte jmeno studenta, rok narozeni");
		String jmeno = sc.nextLine();
		int rok = sc.nextInt();
		prvkyDatabaze[posledniStudent++] = new Student(jmeno, rok);
	}
	
	public Student getStudent(int idx)
	{
		return prvkyDatabaze[idx];
	}
	
	public void setPrumer(int idx, float prumer) throws CustomException, ArrayIndexOutOfBoundsException, NullPointerException
	{
		if(5 < prumer || prumer < 1)
			throw new CustomException("Zadany priemer nieje z dobreho rozsahu (1-5)");
		prvkyDatabaze[idx].setStudijniPrumer(prumer);
	}
	
	private Scanner sc;
	private Student[] prvkyDatabaze;
	private int posledniStudent;
}