package za.co.yellowfire.threesixty.domain.assessment;

import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Auditable;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.util.StringUtils;

import za.co.yellowfire.threesixty.domain.user.User;

/**
 * A discipline that the assessed person is rated against
 * @author Mark P Ashworth
 */
public class Discipline implements Auditable<User, String> {
	private static final long serialVersionUID = 1L;
	
	@Id @NotNull
	private String id;
	private String name;
	private String description;
	private boolean active = true;
	@DBRef
	private User createdBy;
	@DBRef
	private User modifiedBy;
	private DateTime createdDate;
	private DateTime modifiedDate;
	
	public static Discipline EMPTY() { return new Discipline(); }
	
	public Discipline() {
		super();
	}

	public Discipline(final String id) {
		super();
		this.id = id;
		this.createdDate = DateTime.now();
	}
	
	public Discipline(
			final String id,
			final String name,
			final String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.createdDate = DateTime.now();
	}
	
	@Override
	public String getId() { return this.id; }
	public String getName() { return name; }
	public String getDescription() { return description; }
	public boolean isActive() { return active; }
	
	public void setId(String id) { this.id = id; }
	public void setName(String name) { this.name = name; }
	public void setDescription(String description) { this.description = description; }
	public void setActive(boolean active) { this.active = active; }
	
	@Override
	public boolean isNew() { return StringUtils.isEmpty(this.id); }
	@Override
	public User getCreatedBy() { return this.createdBy; }
	@Override
	public void setCreatedBy(User createdBy) { this.createdBy = createdBy; }
	@Override
	public DateTime getCreatedDate() { return this.createdDate; }
	@Override
	public void setCreatedDate(DateTime creationDate) { this.createdDate = creationDate; }
	@Override
	public User getLastModifiedBy() { return this.modifiedBy; }
	@Override
	public void setLastModifiedBy(User lastModifiedBy) { this.modifiedBy = lastModifiedBy; }
	@Override
	public DateTime getLastModifiedDate() { return this.modifiedDate; }
	@Override
	public void setLastModifiedDate(DateTime lastModifiedDate) { this.modifiedDate = lastModifiedDate; }
	
	public void auditChangedBy(final User user) {
		if (isNew()) {
			setCreatedBy(user);
			setCreatedDate(DateTime.now());
		} else {
			setLastModifiedBy(user);
			setLastModifiedDate(DateTime.now());
		}
	}

	@Override
	public String toString() {
		return this.id;
	}
}
