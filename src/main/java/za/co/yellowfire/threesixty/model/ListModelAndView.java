package za.co.yellowfire.threesixty.model;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author Mark P Ashworth
 */
public class ListModelAndView<T> extends ModelAndView {
	public static final String FIELD_RESULT = "results";
	
	public ListModelAndView(final String view, final List<T> results) {
		super(view);
		addObject(FIELD_RESULT, results);
	}
}
