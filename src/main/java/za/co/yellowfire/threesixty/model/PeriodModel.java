package za.co.yellowfire.threesixty.model;

import java.io.Serializable;
import java.util.Date;

import za.co.yellowfire.threesixty.utils.DateUtils;

public class PeriodModel<ID> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private ID id;
	private Date start;
	private Date end;
	
	public PeriodModel() { }
	
	public PeriodModel(final ID id, final Date start, final Date end) {
		this.id = id;
		this.start = start;
		this.end = end;
	}

	public ID getId() { return id; }
	public Date getStart() { return start; }
	public Date getEnd() { return end; }

	public void setId(ID id) { this.id = id; }
	public void setStart(Date start) { this.start = start; }
	public void setEnd(Date end) { this.end = end; }
	
	public String toString() { return DateUtils.format(start) + " > " + DateUtils.format(end); }
}
