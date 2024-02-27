package loveTech.manager.service;

import loveTech.manager.exception.UserNotFoundException;
import loveTech.manager.model.Employee;
import loveTech.manager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

//employee is constructed have access to the repo
@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }
    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }
    public Employee udpateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("User by ID not found"));
    }
    public void deleteEmployee(Long id) {
        employeeRepo.deleteEmployeeById(id);
    }
}
