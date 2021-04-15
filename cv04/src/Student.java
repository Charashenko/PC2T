
public class Student {
	public Student(String jmeno, int rocnik)
	{
		this.jmeno=jmeno;
		this.rocnik=rocnik;
	}
	
	public String getJmeno()
	{
		return jmeno;
	}
	
	public int getRocnik()
	{
		return rocnik;
	}
	
	public float getStudijniPrumer() throws CustomException {
		if (studijniPrumer == 0){
			throw new CustomException("Priemer studenta este nebol zadany");
		}
		return studijniPrumer;
	}

	public void setStudijniPrumer(float studijniPrumer) {
		this.studijniPrumer = studijniPrumer;
	}

	private String jmeno;
	private int rocnik;
	private float studijniPrumer;
}