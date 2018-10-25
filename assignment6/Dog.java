package assignment6;

public class Dog extends Pet implements Boardable {

	private String size;
	public int startmonth = 0;
	public int startday = 0;
	public int startyear = 0;
	public int endmonth = 0;
	public int endday = 0;
	public int endyear = 0;
	
	public Dog(String petname, String ownername, String color, int sex, String size) {
		super(petname, ownername, color, sex);
		this.size = size;
		// TODO Auto-generated constructor stub
	}
	
	
	public void setBoardStart(int month, int day, int year) {
		startmonth = month;
		startday = day;
		startyear = year;
	}
	
	public void setBoardEnd(int month, int day, int year) {
		endmonth = month;
		endday = day;
		endyear = year;
	} 
	
	public boolean boarding(int month, int day, int year) {
		if(year <= endyear && year >= startyear) {
			if(month <= endmonth && month>= startmonth) {
				if(day < endday && day > startday)
					return true;
			}
		}
		return false;
	} 
	
	public String getSize() {
		return this.size;
	}
	
	public String toString() {
		String aString = ("DOG:\n" + this.getPetname() + " owned by " + this.getOwnername() + 
				"\nColor: " + this.getColor()+ "\nSex: " + this.getSex() + "\nSize: " + this.getSize());	
		return aString;
	}
}
