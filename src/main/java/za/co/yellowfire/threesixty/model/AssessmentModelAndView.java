package za.co.yellowfire.threesixty.model;

import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author Mark P Ashworth
 */
public class AssessmentModelAndView<ID> extends ModelAndView {
	public static final String VIEW = "assessment";
	public static final String FIELD_RESULT = "result";
	
	public AssessmentModelAndView(final AssessmentModel<ID> assessment) {
		super(VIEW);
		addObject(FIELD_RESULT, assessment);
	}
}
