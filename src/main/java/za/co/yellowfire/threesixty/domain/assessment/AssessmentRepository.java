package za.co.yellowfire.threesixty.domain.assessment;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface AssessmentRepository extends MongoRepository<Assessment, String> {
	@Query("{$and: [{status: {$nin: ['Creating']}} ,{$or: [{employee.id: {$eq : ?0} }, {manager.id: {$eq : ?0}} ]}]}")
	List<Assessment> findByAccessTo(final String userName);
}
