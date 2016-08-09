package za.co.yellowfire.threesixty.model;

import java.io.Serializable;

/**
 * 
 * @author Mark P Ashworth
 */
public class DisciplineModel<ID> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private ID id;
	private String name;
	private String description;
	
	public DisciplineModel() { }

	public DisciplineModel(final ID id, final String name, final String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	public ID getId() { return this.id; }
	public String getName() { return name; }
	public String getDescription() { return description; }

	public void setId(final ID id) { this.id = id; }
	public void setName(final String name) { this.name = name; }
	public void setDescription(String description) { this.description = description; }
}
