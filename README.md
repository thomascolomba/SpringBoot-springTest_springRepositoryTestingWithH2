Test a @Repository XXX extends JpaRepository<> in a spring application.<br/>
<br/>
compile & test :<br/>
mvn spring-boot:run<br/>
or<br/>
mvn test<br/>

<br/>
--Employee.java<br/>
private String name;<br/>
+getters/setters/constructors<br/>
--EmployeeRepositoryImpl.java<br/>
public Employee findByName(String name);<br/>
--EmployeeRepositoryIntegrationTest.java<br/>
@Autowired<br/>
private <b>TestEntityManager</b> entityManager;<br/>
@Autowired<br/>
private EmployeeRepository employeeRepository;<br/>
@Test<br/>
public void whenFindByName_thenReturnEmployee() {<br/>
&nbsp;&nbsp;// given - Arrange<br/>
&nbsp;&nbsp;Employee alex = <b>new Employee("alex");</b><br/>
&nbsp;&nbsp;entityManager.persist(alex);<br/>
&nbsp;&nbsp;entityManager.flush();<br/>
&nbsp;&nbsp;// when - Act<br/>
&nbsp;&nbsp;Employee found = <b>employeeRepository.findByName("alex");</b><br/>
&nbsp;&nbsp;// then - Assert<br/>
&nbsp;&nbsp;<b>Assert.assertEquals(found.getName(), "alex");</b><br/>
<br/>
@Test<br/>
public void whenNotFoundByName_thenReturnNothing() {<br/>
&nbsp;&nbsp;// given - Arrange<br/>
&nbsp;&nbsp;Employee alex = <b>new Employee("alex");</b><br/>
&nbsp;&nbsp;entityManager.persist(alex);<br/>
&nbsp;&nbsp;entityManager.flush();<br/>
&nbsp;&nbsp;// when - Act<br/>
&nbsp;&nbsp;Employee found = <b>employeeRepository.findByName("georges");</b><br/>
&nbsp;&nbsp;// then - Assert<br/>
&nbsp;&nbsp;<b>Assert.assertNull(found);</b><br/>
<br/>