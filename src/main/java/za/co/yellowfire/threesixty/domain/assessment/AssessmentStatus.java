package za.co.yellowfire.threesixty.domain.assessment;

import javax.validation.constraints.NotNull;

import org.springframework.util.StringUtils;

public enum AssessmentStatus {
	Creating("Creating", true),
	Created("Created", false),
	EmployeeCompleted("Employee Completed", false),
	ManagerCompleted("Manager Completed", false),
	Reviewed("Reviewed", false);
	
	private final String description;
	private final boolean allowEditing;
	
	private AssessmentStatus(final String description, final boolean allowEditing) {
		this.description = description;
		this.allowEditing = allowEditing;
	}

	public String getDescription() { return description; }
	public boolean isEditingAllowed() { return this.allowEditing; }
	
	/**
	 * Returns the status that follows the current status in the assessment progression
	 */
	public AssessmentStatus getNextStatus() {
		switch (this) {
		case Creating: return Created;
		case Created: return EmployeeCompleted;
		case EmployeeCompleted: return ManagerCompleted;
		case ManagerCompleted: return Reviewed;
		case Reviewed: return Reviewed;
		default: return this;
		}
	}
	
	public static AssessmentStatus fromString(@NotNull final String description) {
		if (StringUtils.isEmpty(description)) {
			throw new IllegalArgumentException("The assessment status description cannot be null");
		}
		
		switch(description) {
		case "Created": return Created;
		case "Employee Completed":
		case "EmployeeCompleted": return EmployeeCompleted;
		case "Manager Completed":
		case "ManagerCompleted": return ManagerCompleted;
		case "Reviewed": return Reviewed;
		default: throw new IllegalArgumentException("The assessment status " + description + " is unknown.");
		}
	}
	
	public String toString() {
		return this.description;
	}
}
