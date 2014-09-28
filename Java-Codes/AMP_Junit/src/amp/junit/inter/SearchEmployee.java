package amp.junit.inter;

import java.util.ArrayList;

public class SearchEmployee {
	
	public String searchForHRName(ArrayList<Employee> empList){
		for(Employee emp:empList){
			if(isHR(emp)){
				return emp.getEmpName() + "::" + emp.getEmpSkillSet();
			}
		}
		return null;
	}
	
	public boolean isHR(Employee emp){
		if(emp.getEmpSkillSet().equals("HR"))
			return true;
		return false;
	}
}
