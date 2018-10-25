package assignment6;

public class Cat extends Pet implements Boardable {

	private String hairLength;
	public int startmonth = 0;
	public int startday = 0;
	public int startyear = 0;
	public int endmonth = 0;
	public int endday = 0;
	public int endyear = 0;
	
	
	
	public Cat(String petname, String ownername, String color, int sex, String hairLength) {
		super(petname, ownername, color, sex);
		this.hairLength = hairLength;
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
	
	public String getHairLength() {
		return this.hairLength;
	}
	
	public String toString() {
		String aString = ("CAT:\n" + this.getPetname() + " owned by " + this.getOwnername() + 
				"\nColor: " + this.getColor()+ "\nSex: " + this.getSex() + "\nHair: " + this.getHairLength());	
		return aString;
	}
}
