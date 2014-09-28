package amp.junit.inter;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class SearchEmployeeTest {
	
	ArrayList<Employee> genEmpList;
	GenEmployees genEmp;
	
	SearchEmployee searchEmp = new SearchEmployee();
	
	@Before
	public void genEmpList(){
		genEmp = new GenEmployees();
		genEmpList = genEmp.generateEmployees();
	}
	
	@Test
	public void testIsHR() {
		assertTrue(searchEmp.isHR(genEmpList.get(2)));
	}

}
