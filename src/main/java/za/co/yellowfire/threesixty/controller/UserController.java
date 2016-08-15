package za.co.yellowfire.threesixty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import za.co.yellowfire.threesixty.domain.user.UserRepository;
import za.co.yellowfire.threesixty.model.DomainModelAndView;
import za.co.yellowfire.threesixty.model.PersonModel;

/**
 * 
 * @author Mark P Ashworth
 */
@Controller
public class UserController {

private UserRepository userRepository;
	
	@Autowired
	public UserController(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@RequestMapping(path = "/user/{id}")
	public ModelAndView assessment(
			@PathVariable("id") final String id) {
	
		PersonModel model = new PersonModel(userRepository.findOne(id));
		return new DomainModelAndView<PersonModel>("user", model);
	}
}
