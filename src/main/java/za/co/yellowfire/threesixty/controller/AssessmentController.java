package za.co.yellowfire.threesixty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import za.co.yellowfire.threesixty.model.AssessmentModel;
import za.co.yellowfire.threesixty.model.AssessmentModelAndView;
import za.co.yellowfire.threesixty.model.AssessmentRatingModel;
import za.co.yellowfire.threesixty.model.PerformanceAreaModel;
import za.co.yellowfire.threesixty.model.PersonModel;

/**
 * 
 * @author Mark P Ashworth
 */
@Controller
public class AssessmentController {

	@RequestMapping(path = "/assessment/{id}")
	public ModelAndView assessment(
			@PathVariable("id") final String id) {
	
		String areaDescription = "Measurement of technology delivery";
		String operationsDescription = "Measurement of operations management";
		
		String measurement = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sit amet laoreet tortor, eu bibendum dui. Cras congue massa eu tellus sagittis, eu tincidunt lacus pulvinar. Nulla nec odio sed nunc euismod rutrum eget vel velit. Donec cursus tincidunt libero";
		
		AssessmentModel<String> assessment = new AssessmentModel<>();
		assessment.setEmployee(new PersonModel<String>("1", "Katie", "Bear"));
		assessment.setManager(new PersonModel<String>("2", "Ninja", "Cat"));
		
		PerformanceAreaModel<String> area1 = new PerformanceAreaModel<>("Technology", areaDescription);
		PerformanceAreaModel<String> area2 = new PerformanceAreaModel<>("Operations", operationsDescription);
		
		AssessmentRatingModel<String> rating1 = new AssessmentRatingModel<>("1", area1, measurement, 25, 4);
		AssessmentRatingModel<String> rating2 = new AssessmentRatingModel<>("2", area1, measurement, 25, 4);
		AssessmentRatingModel<String> rating3 = new AssessmentRatingModel<>("4", area2, measurement, 25, 3);
		AssessmentRatingModel<String> rating4 = new AssessmentRatingModel<>("5", area2, measurement, 25, 3);
		
		assessment.addAll(rating1, rating2, rating3, rating4);
		
		return new AssessmentModelAndView<String>(assessment);
	}
}
