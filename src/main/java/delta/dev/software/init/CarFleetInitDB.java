package delta.dev.software.init;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import delta.dev.software.models.client.Client;
import delta.dev.software.models.client.Supplier;
import delta.dev.software.models.country.Country;
import delta.dev.software.models.country.Location;
import delta.dev.software.models.country.State;
import delta.dev.software.models.invoice.Invoice;
import delta.dev.software.models.invoice.InvoiceStatus;
import delta.dev.software.models.person.Employee;
import delta.dev.software.models.person.EmployeeType;
import delta.dev.software.models.person.JobTitle;
import delta.dev.software.models.user.Userss;
import delta.dev.software.models.vehicule.VehicleModel;
import delta.dev.software.models.vehicule.VehicleStatus;
import delta.dev.software.models.vehicule.Vehicule;
import delta.dev.software.models.vehicule.VehiculeHire;
import delta.dev.software.models.vehicule.VehiculeMaintenance;
import delta.dev.software.models.vehicule.VehiculeType;
import delta.dev.software.repositories.ClientRepository;
import delta.dev.software.repositories.CountryRepository;
import delta.dev.software.repositories.EmployeeRepository;
import delta.dev.software.repositories.EmployeeTypeRepository;
import delta.dev.software.repositories.InvoiceRepository;
import delta.dev.software.repositories.InvoiceStatusRepository;
import delta.dev.software.repositories.JobTitleRepository;
import delta.dev.software.repositories.LocationRepository;
import delta.dev.software.repositories.StateRepository;
import delta.dev.software.repositories.SupplierRepository;
import delta.dev.software.repositories.UserRepository;
import delta.dev.software.repositories.VehiculeHireRepository;
import delta.dev.software.repositories.VehiculeMaintenanceRepository;
import delta.dev.software.repositories.VehiculeModelRepository;
import delta.dev.software.repositories.VehiculeRepository;
import delta.dev.software.repositories.VehiculeStatusRepository;
import delta.dev.software.repositories.VehiculeTypeRepository;

/**
 * 
 * @author Admin
 * @version 0.1
 */
@Service
@Transactional
public class CarFleetInitDB implements ICarFleetInit{
     
	@Autowired
	CountryRepository countryRepository;
	@Autowired
	StateRepository stateRepository;
	@Autowired
	LocationRepository locationRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	ClientRepository clientRepository;
	@Autowired
	InvoiceStatusRepository   invoiceStatusRepository;
	@Autowired
	InvoiceRepository invoiceRepository;
	@Autowired
	JobTitleRepository jobTitleRepository;
	@Autowired
	EmployeeTypeRepository  employeeTypeRepository;
	@Autowired
	SupplierRepository supplierRepository;
	@Autowired
	VehiculeModelRepository vehiculeModelRepository;
	@Autowired
	VehiculeStatusRepository vehiculeStatusRepository;
	@Autowired
	VehiculeTypeRepository  vehiculeTypeRepository;
	@Autowired
	EmployeeRepository  employeeRepository;
	@Autowired
	VehiculeRepository vehiculeRepository;
	@Autowired
	VehiculeHireRepository vehiculeHireRepository;
	@Autowired
	VehiculeMaintenanceRepository  vehiculeMaintenanceRepository;
	
	/**
	 * initCounties
	 */
	@Override
	public void initCounties() {
		Country country=new Country(1,"2FECE","Lomé","Togo","Togolaise","Afrique");
		Country country2=new Country(2,"23DAE","Cotonou","Bénin","Béninoise","Afrique");
	
		countryRepository.save(country);
		countryRepository.save(country2);
	}

	/**
	 * initStates
	 */
	@Override
	public void initStates() {
		
			State state=new State(1,"Lomé", "Lomé", "0OAE", countryRepository.findById(1).get(),1, "none");
			State state2=new State(2,"Cotonou", "Cotonou", "03DAE", countryRepository.findById(2).get(),2, "none");
			stateRepository.save(state);
			stateRepository.save(state2);	
	}

	/**
	 * initLocations
	 */
	@Override
	public void initLocations() {
		Location locatio=new Location(1, "Avédji", "Avédji Esgis", countryRepository.findById(1).get(),1, stateRepository.findById(1).get(),1, "Lomé", "");
		locationRepository.save(locatio);
	}

	/**
	 * initUsers
	 */
	@Override
	public void initUsers() {
	Userss user =new Userss(1, "admin", "admin");
	Userss user2 =new Userss(2, "user", "user");
	userRepository.save(user);
	userRepository.save(user2);
	}

	/**
	 * initEmployeeTypes
	 */
	@Override
	public void initEmployeeTypes() {
	   EmployeeType employeeType1=new EmployeeType(1,"Full-Time","Full-Time");
	   EmployeeType employeeType2=new EmployeeType(2,"Part-Time","Part-Time");
	   employeeTypeRepository.save(employeeType1);
	   employeeTypeRepository.save(employeeType2);
	}

	/**
	 * initJobTitles
	 */
	@Override
	public void initJobTitles() {
		JobTitle jobTitle=new JobTitle(1, "Directeur", "Directeur");
		JobTitle jobTitle2=new JobTitle(2, "Chef service", "Chef service");
		JobTitle jobTitle3=new JobTitle(3, "Agent", "Subordonnés");
		jobTitleRepository.save(jobTitle);
		jobTitleRepository.save(jobTitle2);
		jobTitleRepository.save(jobTitle3);
	}

	/**
	 * initEmployees
	 */
	@Override
	public void initEmployees() {
		Employee emp1=new Employee(1, "Assiongbon T.", "AGBONON", "Alex",
				"Agent", "", "9G979H8G", "H", "Marié",
				countryRepository.findById(2).get(), 2, stateRepository.findById(1).get(), 
				2, new Date(), "Lomé", "2885 Rue Totsi\r\n Malboro 94612", "97532235", "31431341",
				"alexassion@gmail.com", "bud.jpg", employeeTypeRepository.findById(1).get(), 1, "",
				"", jobTitleRepository.findById(1).get(), 1, new Date());
		employeeRepository.save(emp1);
	}

	@Override
	public void initContacts() {
		
	}

	/**
	 * initSuppliers
	 */
	@Override
	public void initSuppliers() {
		Supplier supplier=new Supplier(1, "Douti SARL", "651 Rue, Avedji 31305", "Lomé", "92965858", "92965858", "www.google.com", "doutsi@gmail.com", countryRepository.findById(2).get(), 2, stateRepository.findById(2).get(), 2, "none");
		supplierRepository.save(supplier);
		
	}

	/**
	 * initClients
	 */
	@Override
	public void initClients() {
		Client c=new Client(1, "Ola-ale gon go", "75 Rue Agoe \r\n" +
				"Carrefour bleu 02038", "Lomé", "97532235", "92965858", "", "ola@gmail.com", countryRepository.findById(1).get(), 1, stateRepository.findById(1).get(), 1, "none","4646446586");
		clientRepository.save(c);
	}

	/**
	 * initInvoiceStatus
	 */
	@Override
	public void initInvoiceStatus() {
		InvoiceStatus invoiceStatus=new InvoiceStatus(1, "Valid", "none");
		InvoiceStatus invoiceStatus2=new InvoiceStatus(2, "Expiré", "none");
		invoiceStatusRepository.save(invoiceStatus);
		invoiceStatusRepository.save(invoiceStatus2);
	}

	/**
	 * initInvoices
	 */
	@Override
	public void initInvoices() {
		Invoice invoice=new Invoice(1, new Date(), invoiceStatusRepository.findById(1).get(), 1, clientRepository.findById(1).get(), 1, "none");
		invoiceRepository.save(invoice);
	}

	/**
	 * initVehiculeMaintenance
	 */
	@Override
	public void initVehiculeMaintenance() {
		VehiculeMaintenance vehiculeMaintenance=new VehiculeMaintenance(1, vehiculeRepository.findById(1).get(), 1, new Date(), new Date(), 22.0, supplierRepository.findById(1).get(), 1, "none");
	    vehiculeMaintenanceRepository.save(vehiculeMaintenance);
	}

	/**
	 * initVehiculeModel
	 */
	@Override
	public void initVehiculeModel() {
		VehicleModel vehiculeModel=new VehicleModel(1, "Toyota", "Toyota");
		vehiculeModelRepository.save(vehiculeModel);
	}

	/**
	 * initVehiculeStatus
	 */
	@Override
	public void initVehiculeStatus() {
		VehicleStatus vehiculeStatus=new VehicleStatus(1,"Bon","Good");
		VehicleStatus vehiculeStatus2=new VehicleStatus(2,"Mauvais","Bad");
		vehiculeStatusRepository.save(vehiculeStatus);
		vehiculeStatusRepository.save(vehiculeStatus2);
		
	}

	/**
	 * initVehiculeType
	 */
	@Override
	public void initVehiculeType() {
     VehiculeType vehiculeType=new VehiculeType(1, "Sedan", "Sedan");
     VehiculeType vehiculeType2=new VehiculeType(2, "Berline", "Berline");
     vehiculeTypeRepository.save(vehiculeType);
     vehiculeTypeRepository.save(vehiculeType2);
	}

	/**
	 * initVehicules
	 */
	@Override
	public void initVehicules() {
		Vehicule v=new Vehicule(1, "Toyota", vehiculeTypeRepository.findById(1).get(),
				1, "32D2D22", new Date(), new Date(), "", "", "",
				vehiculeStatusRepository.findById(1).get(), 1, "22", employeeRepository.findById(1).get(), 
				1, vehiculeModelRepository.findById(1).get(), 1,
				locationRepository.findById(1).get(), 1, "none");
		vehiculeRepository.save(v);
	}

	/**
	 * initVehiculehire
	 */
	@Override
	public void initVehiculehire() {
		VehiculeHire vehiculeHire=new VehiculeHire(1, vehiculeRepository.findById(1).get(), 1, new Date(), new Date(), new Date(), new Date(), clientRepository.findById(1).get(),1, locationRepository.findById(1).get(), 1, 33.3, "none");
		vehiculeHireRepository.save(vehiculeHire);
	}

	

}
