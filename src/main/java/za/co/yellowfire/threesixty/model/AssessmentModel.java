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

	private PersonModel<ID> employee;
	private PersonModel<ID> manager;
	private AssessmentRatingModel<ID> current;
	private Set<AssessmentRatingModel<ID>> ratings = new HashSet<>();
	private double weightingTotal = 0.0;
	
	public PersonModel<ID> getEmployee() { return employee; }
	public PersonModel<ID> getManager() { return manager; }
	public Set<AssessmentRatingModel<ID>> getRatings() { return ratings; }
	public double getWeightingTotal() { return weightingTotal; }
	public AssessmentRatingModel<ID> getCurrent() { return current; }
	
	public void setEmployee(final PersonModel<ID> employee) { this.employee = employee; }
	public void setManager(final PersonModel<ID> manager) { this.manager = manager; }
	public void setRatings(Set<AssessmentRatingModel<ID>> ratings) { this.ratings = ratings; }
	public void setWeightingTotal(double weightingTotal) { this.weightingTotal = weightingTotal; }
	public void setCurrent(AssessmentRatingModel<ID> current) { this.current = current; }
	public void setScore(final double score) {}
	
	public double getScore() {
		double scoreTotal = 0.00;
		for (AssessmentRatingModel<ID> assessmentRatingModel : ratings) {
			scoreTotal += assessmentRatingModel.getScore();
		}
		
		return scoreTotal;
	}

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
