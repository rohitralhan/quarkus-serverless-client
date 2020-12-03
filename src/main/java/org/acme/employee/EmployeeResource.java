package org.acme.employee;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/")
public class EmployeeResource {

    @Inject
    @RestClient
    EmployeeService employeeService;	
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> employees(){
    	return employeeService.getEmployees();
    }
	
    @GET
    @Path("{empId}")
    @Produces("application/json")
    public Employee employee(@PathParam("empId") String empId){
    	return employeeService.getEmployee(empId);
    }    
}