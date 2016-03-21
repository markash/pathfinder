package za.co.yellowfire.threesixty.domain.assessment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.yellowfire.threesixty.domain.user.User;

@Service
public class PeriodService {

	private PeriodRepository periodRepository;
	
	@Autowired
	public PeriodService(PeriodRepository periodRepository) {
		super();
		this.periodRepository = periodRepository;
	}

	//@Override
	public Period findById(String id) {
		return periodRepository.findOne(id);
	}

	//@Override
	public Period save(Period period, User changedBy) {
		period.auditChangedBy(changedBy);
		return periodRepository.save(period);
	}

	//@Override
	public void delete(Period period, User changedBy) {
		period.setActive(false);
		period.auditChangedBy(changedBy);
		periodRepository.save(period);
	}

	public PeriodRepository getPeriodRepository() {
		return periodRepository;
	}

	public void setPeriodRepository(PeriodRepository periodRepository) {
		this.periodRepository = periodRepository;
	}
}
