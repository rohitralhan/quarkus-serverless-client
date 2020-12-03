package org.acme.employee;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


@RegisterRestClient
public interface EmployeeService {

    @GET
    @Path("/employees")
    @Produces("application/json")
    List<Employee> getEmployees();

    @GET
    @Path("/employees/{empId}")
    @Produces("application/json")
    Employee getEmployee(@PathParam("empId") String empId);
}
