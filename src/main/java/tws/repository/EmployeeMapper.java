package tws.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import tws.entity.Employee;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    List<Employee> selectAll();
    @Insert("insert into employee values(#{employee.id}, #{employee.name}, #{employee.age})")
    void insert(@Param("employee")Employee employee);

    @Select("select * from employee")
    List<Employee> searchEmployees();

    @Update("update employee set name = #{employee.name}, age = #{employee.age} where id = #{employee.id}")
    void updateEmployee(@Param("employee")Employee employee);

    @Delete("delete from employee where id = #{id}")
    void deleteEmployee(@Param("id") int id);
   
}
