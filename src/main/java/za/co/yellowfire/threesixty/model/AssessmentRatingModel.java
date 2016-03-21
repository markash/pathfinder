package za.co.yellowfire.threesixty.model;

import java.io.Serializable;

/**
 * 
 * @author Mark P Ashworth
 */
public class AssessmentRatingModel<ID> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private ID id;
	private PerformanceAreaModel<ID> performanceArea;
	private String measurement;
	private String managerComment;
	private String employeeComment;
	private double weight = 1.0;
	private double rating = 0.0;
	private double employeeRating = 0.0;
	private double managerRating = 0.0;
	private double reviewRating = 0.0;
	private AssessmentModel<ID> assessment;
	
	public AssessmentRatingModel() { }
	
	public AssessmentRatingModel(
			final ID id, 
			final PerformanceAreaModel<ID> performanceArea, 
			final String measurement, 
			final double weight, 
			final double rating) {
		super();
		this.id = id;
		this.performanceArea = performanceArea;
		this.measurement = measurement;
		this.weight = weight;
		this.rating = rating;
	}
	public ID getId() { return id; }
	public String getMeasurement() { return measurement; }
	public String getManagerComment() { return managerComment; }
	public String getEmployeeComment() { return employeeComment; }
	public double getWeight() { return weight; }
	public double getRating() { return rating; }
	public double getEmployeeRating() { return employeeRating; }
	public double getManagerRating() { return managerRating; }
	public double getReviewRating() { return reviewRating; }	
	public PerformanceAreaModel<ID> getPerformanceArea() { return performanceArea; }
	public AssessmentModel<ID> getAssessment() { return assessment; }
	public double getWeightingTotal() { return getAssessment() != null ? getAssessment().getWeightingTotal() : 0.00; }
	public double getScore() { return getRating() * (getWeight() / 100); }
	
	public void setId(ID id) { this.id = id; }
	public void setMeasurement(String measurement) { this.measurement = measurement; }
	public void setManagerComment(String managerComment) { this.managerComment = managerComment; }
	public void setEmployeeComment(String employeeComment) { this.employeeComment = employeeComment; }
	public void setWeight(double weight) { this.weight = weight; }
	public void setRating(double rating) { this.rating = rating; }
	public void setEmployeeRating(double employeeRating) { this.employeeRating = employeeRating; }
	public void setManagerRating(double managerRating) { this.managerRating = managerRating; }
	public void setReviewRating(double reviewRating) { this.reviewRating = reviewRating; }
	public void setPerformanceArea(final PerformanceAreaModel<ID> performanceArea) { this.performanceArea = performanceArea; }
	public void setAssessment(final AssessmentModel<ID> assessment) { this.assessment = assessment; }
	public void setWeightingTotal(final double weightingTotal) { if (getAssessment() != null) { getAssessment().setWeightingTotal(weightingTotal); } }
}
