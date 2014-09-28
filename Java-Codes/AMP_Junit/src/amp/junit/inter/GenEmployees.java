package amp.junit.inter;

import java.util.ArrayList;

public class GenEmployees {
	ArrayList<Employee> empList;
	
	public GenEmployees() {
		// TODO Auto-generated constructor stub
		empList = new ArrayList<Employee>();
	}
	
	public ArrayList<Employee> generateEmployees(){
		empList.add(new Employee(1, "AMP", "JAVA", "CC", "336839"));
		empList.add(new Employee(2, "AMR", "HR", "HR", "525252"));
		empList.add(new Employee(3, "SAS", "TESTING", "CC", "666666"));
		return empList;
	}
	 
}
