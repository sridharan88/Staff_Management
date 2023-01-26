package com.staffmanagement.management.repository;
import com.staffmanagement.management.dto.StaffCountDto;
import com.staffmanagement.management.model.Allotment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;









public interface AllotmentRepository extends JpaRepository<Allotment,Integer>{
    
    @Query(value = "select staff_details_staff_id as id,s.staff_name as name,count(*)  as count from allotment_table inner join staff_details s on allotment_table.staff_details_staff_id = s.staff_id group by staff_details_staff_id,s.staff_name", nativeQuery = true)
    List<StaffCountDto> findAllStaffCount();

    @Query(value = "select * from allotment_table a where a.days=:day and a.periods=:period and a.staff_details_staff_id=:staffId",nativeQuery = true)
    Allotment findAlreadyExist(@Param(value = "day") String days, @Param(value = "period") int periods, @Param(value = "staffId") int staffId);

   
}
