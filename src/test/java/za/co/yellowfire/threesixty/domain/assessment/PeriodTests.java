package za.co.yellowfire.threesixty.domain.assessment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import za.co.yellowfire.threesixty.PathfinderApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PathfinderApplication.class)
@WebAppConfiguration
public class PeriodTests {

	@Autowired
	private PeriodRepository repository;
	
	@Test
	public void testFindAll() {
		for (Period period : repository.findAll()) {
			System.out.println(period);
		}
	}
}
