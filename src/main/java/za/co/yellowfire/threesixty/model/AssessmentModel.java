package za.co.yellowfire.threesixty.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Mark P Ashworth
 */
public class AssessmentModel<ID> implements Serializable {
	private static final long serialVersionUID = 1L;

	private PersonModel employee;
	private PersonModel manager;
	private PeriodModel<ID> period;
	private AssessmentRatingModel<ID> current;
	private Set<AssessmentRatingModel<ID>> ratings = new HashSet<>();
	private double weightingTotal = 0.0;
	
	public PersonModel getEmployee() { return employee; }
	public PersonModel getManager() { return manager; }
	public Set<AssessmentRatingModel<ID>> getRatings() { return ratings; }
	public double getWeightingTotal() { return weightingTotal; }
	public AssessmentRatingModel<ID> getCurrent() { return current; }
	public PeriodModel<ID> getPeriod() { return period; }
	
	public void setEmployee(final PersonModel employee) { this.employee = employee; }
	public void setManager(final PersonModel manager) { this.manager = manager; }
	public void setRatings(final Set<AssessmentRatingModel<ID>> ratings) { this.ratings = ratings; }
	public void setWeightingTotal(final double weightingTotal) { this.weightingTotal = weightingTotal; }
	public void setCurrent(final AssessmentRatingModel<ID> current) { this.current = current; }
	public void setScore(final double score) {}
	public void setPeriod(final PeriodModel<ID> period) { this.period = period; }
	
	public double getScore() {
		double scoreTotal = 0.00;
		for (AssessmentRatingModel<ID> assessmentRatingModel : ratings) {
			scoreTotal += assessmentRatingModel.getScore();
		}
		
		return scoreTotal;
	}

	@SuppressWarnings("unchecked")
	public void addAll(AssessmentRatingModel<ID>...rating) {
		for (AssessmentRatingModel<ID> assessmentRatingModel : rating) {
			assessmentRatingModel.setAssessment(this);
			ratings.add(assessmentRatingModel);
		}
		
		if (ratings.size() > 0) {
			this.current = ratings.iterator().next();
		} else {
			this.current = new AssessmentRatingModel<>();
		}
	}
}
