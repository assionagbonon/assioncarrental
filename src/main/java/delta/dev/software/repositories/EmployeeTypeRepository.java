package delta.dev.software.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import delta.dev.software.models.person.EmployeeType;

/**
 * 
 * @author Admin
 *
 */
@Repository
public interface EmployeeTypeRepository extends JpaRepository<EmployeeType, Integer> {

}