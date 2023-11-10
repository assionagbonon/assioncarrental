package delta.dev.software.controllers;

import java.util.List;

import delta.dev.software.models.client.Client;
import delta.dev.software.models.country.Country;
import delta.dev.software.models.country.State;
import delta.dev.software.models.person.JobTitle;
import delta.dev.software.services.JobTitlesService;
import delta.dev.software.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import delta.dev.software.models.person.Employee;
import delta.dev.software.services.EmployeeService;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;

/**
 * 
 * @author Delta Dev Software
 * @version 0.1
 */
@Controller
public class EmployeeController {

	/**
	 * employeeService
	 */
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private JobTitlesService jobtitleService;

	/**
	 * getEmployees
	 * @param model
	 * @return
	 */
	@GetMapping("/employees")
	public String getEmployees(Model model) {
		List<JobTitle> jobTitles = jobtitleService.getJobTitless();
		model.addAttribute("jobtitles", jobTitles);
		List<Employee> employees = employeeService.getEmployees();
		model.addAttribute("employees", employees);
		return "employees";
	}

	/**
	 * addCountry
	 * @param e
	 * @return
	 */
	@PostMapping("/addemployee")
	public String addEmployee(Employee e) {
		employeeService.save(e);
		return "redirect:/employees";
	}

	@RequestMapping("/employee/{id}")
	public String findById(@PathVariable("id") int id, Model model) {
		List<JobTitle> jobTitles = jobtitleService.getJobTitless();
		model.addAttribute("jobtitles", jobTitles);

		Employee employee = employeeService.findById(id).get();
		model.addAttribute("employee", employee);
		return "editEmployee";
	}

	/**
	 * updateClient
	 * @param id
	 * @param employee
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/updateemployee/{id}")
	public String updateEmployee(@PathVariable("id") long id, @Validated Employee employee, BindingResult result,
							   Model model) {

		employeeService.save(employee);
		return "redirect:/employees";
	}

	/**
	 * deleteClient
	 * @param id
	 * @return
	 */
	@GetMapping("/deleteemployee/{id}")
	@Transactional
	public String deleteEmployee(@PathVariable("id") int id) {
		employeeService.delete(id);
		return "redirect:/employees";
	}

}
