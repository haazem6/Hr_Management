package net.javaguides.emsbackend.controller;


import lombok.AllArgsConstructor;
import net.javaguides.emsbackend.dto.EmployeeDto;
import net.javaguides.emsbackend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;
    // build Add employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {

        EmployeeDto savedEmployee=employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED)  ;
    }
    // build Get employee REST API
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {

        EmployeeDto employeeDto=employeeService.getEmployeeById(employeeId);
        return  ResponseEntity.ok(employeeDto);
    }

    // build Get employee REST API
    @GetMapping()
    public ResponseEntity<List<EmployeeDto>> getallEmployee() {

        List<EmployeeDto> employees =employeeService.getAllEmployees();
        return  ResponseEntity.ok(employees);
    }
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> UpdateEmployee(@PathVariable("id") Long employeeId,@RequestBody EmployeeDto updateEmployee) {

        EmployeeDto employeeDto=employeeService.updateEmployee(employeeId,updateEmployee);
        return  ResponseEntity.ok(employeeDto);
    }
    // build Delete employee REST API
    @DeleteMapping("{id}")
    ResponseEntity<String> DeleteEmployee(@PathVariable("id") Long employeeId) {

        employeeService.deleteEmployee(employeeId);
        return  ResponseEntity.ok("employee deleted successfully");
    }


}
