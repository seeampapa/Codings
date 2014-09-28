package pmo.pagebean;

import java.util.HashMap;

import pmo.dbproc.BVbean;

public class BV {
	
	private BVbean bvBean;
	
	private void init(){
		if(bvBean==null)
			bvBean = new BVbean();
	}
	
	/*
	 * For populating default form for bv.jsp
	 * 0. selectedMngr
	 * 1. ManagerMap to populate radio buttons.
	 * 2. period chosen
	 * 
	 */
	private String selectedMngr;
	
	public String getSelectedMngr() {
		return selectedMngr;
	}

	public void setSelectedMngr(String selectedMngr) {
		this.selectedMngr = selectedMngr;
	}

	private HashMap<String, String> managerMap;

	public HashMap<String, String> getManagerMap() {
		init();
		if(managerMap==null){
			managerMap = bvBean.getManagerMap();
		}
		return managerMap;
	}

	public void setManagerMap(HashMap<String, String> managerMap) {
		this.managerMap = managerMap;
	}
	
	private String periodSelected;
	private int periodLastDate;
	private int periodStartDay;

	public String getPeriodSelected() {
		return periodSelected;
	}

	public void setPeriodSelected(String periodSelected) {
		this.periodSelected = periodSelected;
	}

	public int getPeriodLastDate() {
		return periodLastDate;
	}

	public void setPeriodLastDate(int periodLastDate) {
		this.periodLastDate = periodLastDate;
	}

	public int getPeriodStartDay() {
		return periodStartDay;
	}

	public void setPeriodStartDay(int periodStartDay) {
		this.periodStartDay = periodStartDay;
	}
	
	
	
	/*
	 * Actions
	 * 
	 */
	
}
