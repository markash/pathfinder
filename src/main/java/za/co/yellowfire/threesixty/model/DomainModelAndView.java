package za.co.yellowfire.threesixty.model;

import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author Mark P Ashworth
 */
public class DomainModelAndView<T> extends ModelAndView {
	public static final String FIELD_RESULT = "result";
	
	public DomainModelAndView(final String view, final T result) {
		super(view);
		addObject(FIELD_RESULT, result);
	}
}
