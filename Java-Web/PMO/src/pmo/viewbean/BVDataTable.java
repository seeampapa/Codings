package pmo.viewbean;

public class BVDataTable {
	private int tcsEmpId;
	private String ctId;
	private String fName;
	private String lName;
	private double billRate;
	private String bvEffort;
	private double bvDaysEffort;
	private double bvBilledAmt;
	private double bvAdjust;
	private double bvAdjustedDaysEff;
	private double bvAdjustedBillAmt;
	private String newVal;
	private boolean fromDB;
	 
	public int getTcsEmpId() {
		return tcsEmpId;
	}
	public void setTcsEmpId(int tcsEmpId) {
		this.tcsEmpId = tcsEmpId;
	}
	public String getCtId() {
		return ctId;
	}
	public void setCtId(String ctId) {
		this.ctId = ctId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public double getBillRate() {
		return billRate;
	}
	public void setBillRate(double billRate) {
		this.billRate = billRate;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getBvEffort() {
		return bvEffort;
	}
	public void setBvEffort(String bvEffort) {
		this.bvEffort = bvEffort;
	}
	public double getBvDaysEffort() {
		return bvDaysEffort;
	}
	public void setBvDaysEffort(double bvDaysEffort) {
		this.bvDaysEffort = bvDaysEffort;
	}
	public double getBvBilledAmt() {
		return bvBilledAmt;
	}
	public void setBvBilledAmt(double bvBilledAmt) {
		this.bvBilledAmt = bvBilledAmt;
	}
	public double getBvAdjust() {
		return bvAdjust;
	}
	public void setBvAdjust(double bvAdjust) {
		this.bvAdjust = bvAdjust;
	}
	public double getBvAdjustedDaysEff() {
		return bvAdjustedDaysEff;
	}
	public void setBvAdjustedDaysEff(double bvAdjustedDaysEff) {
		this.bvAdjustedDaysEff = bvAdjustedDaysEff;
	}
	public double getBvAdjustedBillAmt() {
		return bvAdjustedBillAmt;
	}
	public void setBvAdjustedBillAmt(double bvAdjustedBillAmt) {
		this.bvAdjustedBillAmt = bvAdjustedBillAmt;
	}
	public String getNewVal() {
		return newVal;
	}
	public void setNewVal(String newVal) {
		this.newVal = newVal;
	}
	public boolean isFromDB() {
		return fromDB;
	}
	public void setFromDB(boolean fromDB) {
		this.fromDB = fromDB;
	}
}
