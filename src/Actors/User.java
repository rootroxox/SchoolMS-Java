package Actors;

public class User {
	private String name;
	private String surname;
	private String ID;

	public User(String name, String surname, String iD) {
		super();
		this.name = name;
		this.surname = surname;
		ID = iD;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getID() {
		return ID;
	}
	
	public void setID(String iD) {
		ID = iD;
	}	
	
	public void printUserInfo() {
		System.out.println("Name Surname: " + this.name + " " + this.surname + "\nID: " + this.ID);
	}
}
