package tws.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import tws.entity.ParkingLot;

public interface ParkingLotMapper {

	@Mapper
	 List<ParkingLot> selectAll();
    @Insert("insert into parkingLot values(#{parkingLot.id}, #{parkingLot.name}, #{parkingLot.age})")
    void insert(@Param("parkingLot")ParkingLot parkingLot);

    @Select("select * from parkingLot")
    List<ParkingLot> searchParkingLots();

    @Update("update parkingLot set name = #{parkingLot.name}, age = #{parkingLot.age} where id = #{parkingLot.id}")
    void updateParkingLot(@Param("parkingLot")ParkingLot parkingLot);

    @Delete("delete from parkingLot where id = #{id}")
    void deleteParkingLot(@Param("id") String id);
}
