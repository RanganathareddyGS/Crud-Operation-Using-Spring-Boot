package SpringBoot.Crud_Boot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import SpringBoot.Crud_Boot.dto.Employee;
import SpringBoot.Crud_Boot.repository.EmployeeRepository;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeRepository repository;
	
	@GetMapping("/hello")
	public String load() {
		return "home.html";
	}
	
	@GetMapping("/add-record")
	public String addRecord(ModelMap map) {
		map.put("add", "add");
		return "home.html";
	}

	@PostMapping("/add-record")
	public String addRecord(Employee employee, ModelMap map) {
		repository.save(employee);
		map.put("success", "Record Added Success");
		return "home.html";
	}

	@GetMapping("/fetch-records")
	public String fetchRecords(ModelMap map) {
		map.put("records", repository.findAll());
		return "home.html";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam int id, ModelMap map) {
		repository.deleteById(id);
		map.put("success", "Record Deleted Success");
		return "home.html";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam int id, ModelMap map) {
		Employee employee = repository.findById(id).orElseThrow();
		map.put("emp", employee);
		map.put("edit", "edit");
		return "home.html";
	}
	
	@PostMapping("/update-record")
	public String updateRecord(Employee employee, ModelMap map) {
		repository.save(employee);
		map.put("success", "Record Updated Success");
		return "home.html";
	}
}
