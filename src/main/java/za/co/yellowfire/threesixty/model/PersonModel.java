package za.co.yellowfire.threesixty.model;

import java.io.Serializable;

/**
 * 
 * @author Mark P Ashworth
 */
public class PersonModel<ID> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private ID id;
	private String firstName;
	private String lastName;
	
	public PersonModel(ID id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public ID getId() { return id;}
	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	public String getFullName() { return firstName + " " + lastName; }
	
	public void setId(ID id) { this.id = id; }
	public void setFirstName(String firstName) { this.firstName = firstName; }
	public void setLastName(String lastName) { this.lastName = lastName; }
	public void setFullName(String fullName) {}
}
