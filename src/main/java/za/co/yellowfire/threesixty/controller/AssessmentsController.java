package za.co.yellowfire.threesixty.controller;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import za.co.yellowfire.threesixty.model.AssessmentModel;
import za.co.yellowfire.threesixty.model.AssessmentRatingModel;
import za.co.yellowfire.threesixty.model.AssessmentsModelAndView;
import za.co.yellowfire.threesixty.model.DisciplineModel;
import za.co.yellowfire.threesixty.model.PeriodModel;
import za.co.yellowfire.threesixty.model.PersonModel;

/**
 * 
 * @author Mark P Ashworth
 */
@Controller
public class AssessmentsController {

	@RequestMapping(path = "/assessments")
	public ModelAndView assessment() throws ParseException {
	
		String areaDescription = "Measurement of technology delivery";
		String operationsDescription = "Measurement of operations management";
		
		String measurement = "Successful delivery is measured against the project management plan for on time delivery and constraining the costs of the delivery to the agreed upon budgets.";
		
		Date start = DateUtils.parseDate("2016-01-01", "yyyy-MM-dd");
		Date end = DateUtils.parseDate("2016-05-31", "yyyy-MM-dd");
		PeriodModel<String> period = new PeriodModel<>("1", start, end);
		
		AssessmentModel<String> assessment = new AssessmentModel<>();
		assessment.setEmployee(new PersonModel("1", "Katie", "Bear"));
		assessment.setManager(new PersonModel("2", "Ninja", "Cat"));
		assessment.setPeriod(period);
		
		DisciplineModel<String> area1 = new DisciplineModel<>("1", "Technology", areaDescription);
		DisciplineModel<String> area2 = new DisciplineModel<>("2", "Operations", operationsDescription);
		
		AssessmentRatingModel<String> rating1 = new AssessmentRatingModel<>("1", area1, measurement, 25, 4);
		AssessmentRatingModel<String> rating2 = new AssessmentRatingModel<>("2", area1, measurement, 25, 4);
		AssessmentRatingModel<String> rating3 = new AssessmentRatingModel<>("4", area2, measurement, 25, 3);
		AssessmentRatingModel<String> rating4 = new AssessmentRatingModel<>("5", area2, measurement, 25, 3);
		
		assessment.addAll(rating1, rating2, rating3, rating4);
		
		return new AssessmentsModelAndView<String>(Arrays.asList(assessment));
	}
}
