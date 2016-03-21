package za.co.yellowfire.threesixty.model;

import java.io.Serializable;

/**
 * 
 * @author Mark P Ashworth
 */
public class PerformanceAreaModel<ID> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private ID name;
	private String description;
	
	public PerformanceAreaModel() { }

	public PerformanceAreaModel(ID name, final String description) {
		this.name = name;
		this.description = description;
	}
	
	public ID getName() { return name; }
	public String getDescription() { return description; }

	public void setName(ID name) { this.name = name; }
	public void setDescription(String description) { this.description = description; }
}
