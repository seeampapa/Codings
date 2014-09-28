package amp.junit.inter;

public class Employee {
	private int empId;
	private String empName;
	private String empSkillSet;
	private String empDept;
	private String empEmailId;
	
	public Employee(int empId, String empName, String empSkillSet,
			String empDept, String empEmailId) {
		this.empId = empId;
		this.empName = empName;
		this.empSkillSet = empSkillSet;
		this.empDept = empDept;
		this.empEmailId = empEmailId;
	}
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpSkillSet() {
		return empSkillSet;
	}
	public void setEmpSkillSet(String empSkillSet) {
		this.empSkillSet = empSkillSet;
	}
	public String getEmpDept() {
		return empDept;
	}
	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}
	public String getEmpEmailId() {
		return empEmailId;
	}
	public void setEmpEmailId(String empEmailId) {
		this.empEmailId = empEmailId;
	}
	
	
}
