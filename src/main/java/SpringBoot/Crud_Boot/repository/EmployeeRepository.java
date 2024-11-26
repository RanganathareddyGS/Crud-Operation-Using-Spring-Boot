package SpringBoot.Crud_Boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import SpringBoot.Crud_Boot.dto.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
