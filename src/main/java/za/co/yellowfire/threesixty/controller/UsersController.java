package za.co.yellowfire.threesixty.controller;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import za.co.yellowfire.threesixty.domain.user.UserRepository;
import za.co.yellowfire.threesixty.model.AssessmentModel;
import za.co.yellowfire.threesixty.model.AssessmentRatingModel;
import za.co.yellowfire.threesixty.model.AssessmentsModelAndView;
import za.co.yellowfire.threesixty.model.DisciplineModel;
import za.co.yellowfire.threesixty.model.ListModelAndView;
import za.co.yellowfire.threesixty.model.PeriodModel;
import za.co.yellowfire.threesixty.model.PersonModel;

/**
 * 
 * @author Mark P Ashworth
 */
@Controller
public class UsersController {

	private UserRepository userRepository;
	
	@Autowired
	public UsersController(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@RequestMapping(path = "/users")
	public ModelAndView users() throws ParseException {
	
		List<PersonModel> results = userRepository
				.findAll()
				.stream()
				.map(user -> new PersonModel(user))
				.collect(Collectors.toList());
		
		return new ListModelAndView<>("users", results);
	}
}
