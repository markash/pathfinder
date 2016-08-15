package za.co.yellowfire.threesixty.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import za.co.yellowfire.threesixty.domain.user.User;

/**
 * 
 * @author Mark P Ashworth
 */
public class PersonModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String firstName;
	private String lastName;
	private List<String> roles; 
	private Date lastLogin;
	
	public PersonModel(final String id, final String firstName, final String lastName, final String...roles) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.roles = new ArrayList<>();
	
		if (roles != null) {
			this.roles.addAll(
					Arrays.asList(roles)
						.stream()
						.filter(role -> StringUtils.isNoneBlank(role))
						.collect(Collectors.toList()));
		}
	}
	
	public PersonModel(final User user) {
		this(user.getId(), user.getFirstName(), user.getLastName(), user.getRole().getId());		
	}
	
	public String getId() { return id;}
	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	public String getFullName() { return firstName + " " + lastName; }
	public Date getLastLogin() { return lastLogin; }
	public List<String> getRoles() { return Collections.unmodifiableList(this.roles); }
	public String getRolesAsCsv() { return StringUtils.join(this.roles, ","); }

	public void setId(final String id) { this.id = id; }
	public void setFirstName(final String firstName) { this.firstName = firstName; }
	public void setLastName(final String lastName) { this.lastName = lastName; }
	public void setFullName(final String fullName) {}
	public void setRolesAsCsv(final String roles) { }
	public void setLastLogin(final Date lastLogin) { this.lastLogin = lastLogin; }
	
}
