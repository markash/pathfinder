package za.co.yellowfire.threesixty.model;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author Mark P Ashworth
 */
public class AssessmentsModelAndView<ID> extends ModelAndView {
	public static final String VIEW = "assessments";
	public static final String FIELD_RESULT = "results";
	
	public AssessmentsModelAndView(final List<AssessmentModel<ID>> assessments) {
		super(VIEW);
		addObject(FIELD_RESULT, assessments);
	}
}
