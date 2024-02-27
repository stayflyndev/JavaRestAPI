package loveTech.manager.repo;

import loveTech.manager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

//connected to JPA to access crud methods in this library
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
   void deleteEmployeeById(Long id);


   Optional<Employee> findEmployeeById(Long id);
}
