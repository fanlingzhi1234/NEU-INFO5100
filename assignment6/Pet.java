package assignment6;

public class Pet {
	private String petname;
	private String ownername;
	private String color;
	protected int sex;
	
	public static final int MALE = 100;
	public static final int FEMALE = 200;
	public static final int SPAYED = 300;
	public static final int NEUTERED = 400;
	
	public Pet(String petname, String ownername, String color, int sex) {
		this.petname = petname;
		this.ownername = ownername;
		this.color= color;
		this.sex = sex;
	}
	
	public String getPetname() {
		return petname;
	}
	
	public String getOwnername() {
		return ownername;
	}
	
	public String getColor() {
		return color;
	}

	public String getSex() {
		if(sex == 100) 
			return "MALE";
		else if(sex == 200)
			return "FEMALE";
		else if(sex == 300)
			return "SPAYED";
		else if(sex == 400)
			return "NEUTERED";
		else 
			return "oops... no gender";
	}

	public void setSex(int sexid) {
		this.sex = sexid;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String aString = (this.getPetname() + " owned by " + this.getOwnername() + 
							"\nColor: " + this.getColor()+ "\nSex: " + this.getSex());
		return aString;
	}
	
}
