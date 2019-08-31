package tws.repository;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;
import tws.entity.Employee;

import javax.sql.DataSource;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@MybatisTest
public class EmployeeMapperTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @After
    public void tearDown() throws Exception {
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "employee");
    }
//²é
    @Test
    public void shouldFetchAllEmployees() {
        // given
        jdbcTemplate.execute("INSERT INTO EMPLOYEE VALUES(1,'zhangsan', 21);");
        // when
        List<Employee> employeeList = employeeMapper.selectAll();
        // then
        assertEquals(1, employeeList.size());
    }
//Ôö 
    @Test
    public void should_fetch_emloyee_when_insert_one_employee_given_a_insert() {
        // given
     Employee employee = new Employee(1, "lisi", "18");
        // when
        employeeMapper.insert(employee);
        List<Employee> employees = employeeMapper.selectAll();
        // then
        assertEquals("lisi", employees.get(0).getName());
    }
//¸Ä
    @Test
    public void should_fetch_emloyee_when_update_one_employee_given_a_update() {
    	//given
    	Employee employee =new Employee(1,"caozhu","18");
    	//when
    	employeeMapper.updateEmployee(employee);
    	List<Employee> employees=employeeMapper.selectAll();
    	//then
    	assertEquals("caozhu",employees.get(0).getName());
    }
    
//É¾
    @Test
    public void should_fetch_emloyee_when_delete_one_employee_given_a_delete() {
    	//given
    	Employee employee =new Employee(1,"caozhu","18");
    	//when
    	employeeMapper.deleteEmployee(1);
    	List<Employee> employees=employeeMapper.selectAll();
    	//then
    	assertEquals(0,employees.size());
    }
}
