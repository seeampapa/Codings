package amp.hiber.persist;

public class Dept {
	private int deptNo;
	private String deptName;
	private String location;
	
	public Dept() {
		// TODO Auto-generated constructor stub
	}
	
	public Dept(int deptNo, String deptName, String location){
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.location = location;
	}
	
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
