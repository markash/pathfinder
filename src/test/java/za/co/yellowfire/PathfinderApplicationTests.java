package za.co.yellowfire;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import za.co.yellowfire.threesixty.PathfinderApplication;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PathfinderApplication.class)
@WebAppConfiguration
public class PathfinderApplicationTests {

	@Test
	public void contextLoads() {
	}

}
