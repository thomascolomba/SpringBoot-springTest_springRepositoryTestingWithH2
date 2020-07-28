package com.thomas;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.thomas.entities.Employee;
import com.thomas.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryIntegrationTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	public void whenFindByName_thenReturnEmployee() {
	    // given - Arrange
	    Employee alex = new Employee("alex");
	    entityManager.persist(alex);
	    entityManager.flush();
	    
	    // when - Act
	    Employee found = employeeRepository.findByName("alex");
	    
	    // then - Assert
	    Assert.assertEquals(found.getName(), "alex");
	}

	@Test
	public void whenNotFoundByName_thenReturnNothing() {
		// given - Arrange
		Employee alex = new Employee("alex");
		entityManager.persist(alex);
		entityManager.flush();
		
		// when - Act
		Employee found = employeeRepository.findByName("georges");
		
		// then - Assert
		Assert.assertNull(found);
	}
}