package tws.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

import tws.entity.Employee;
import tws.entity.ParkingLot;

@RunWith(SpringRunner.class)
@MybatisTest
public class ParkingLotMapperTest {

	@Autowired
    private ParkingLotMapper parkingLotMapper;

    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    @Before
    public void clearDB() {
    	JdbcTestUtils.deleteFromTables(jdbcTemplate, "parkinglot");
    }

    @After
    public void tearDown() throws Exception {
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "parkinglot");
    }
  //²é  
    @Test
    public void shouldFetchAllParkingLots() {
        // given
        jdbcTemplate.execute("INSERT INTO parkinglot VALUES(1, 10, 11);");
        // when
        List<ParkingLot> parkingLotsList = parkingLotMapper.selectAll();
        // then
        assertEquals(1, parkingLotsList.size());
    }
  //Ôö 
    @Test
    public void shouldGetParkingLotWhenCallInsertParkingLot() {
        // given
    	parkingLotMapper.insert(new ParkingLot("1", 10, 10));
        // when
        List<ParkingLot> parkingLotsList = parkingLotMapper.selectAll();
        // then
        assertEquals(1, parkingLotsList.get(0).getParkingLotID());
        assertEquals(10, parkingLotsList.get(0).getParkingLotCount());
        assertEquals(10, parkingLotsList.get(0).getAvailablePositionCount());
    }
  //¸Ä
    @Test
    public void should_fetch_emloyee_when_update_one_employee_given_a_update() {
    	//given
    	parkingLotMapper.insert(new ParkingLot("1", 20, 10));
    	//when
        List<ParkingLot> parkingLotsList = parkingLotMapper.selectAll();
    	//then
        assertEquals(20, parkingLotsList.get(0).getParkingLotCount());
    }
    
//É¾
    @Test
    public void should_fetch_emloyee_when_delete_one_employee_given_a_delete() {
    	// given
    	parkingLotMapper.deleteParkingLot("1");
        // when
        List<ParkingLot> parkingLotsList = parkingLotMapper.selectAll();
    	//then
    	assertEquals(0,parkingLotsList.size());
    }
}
