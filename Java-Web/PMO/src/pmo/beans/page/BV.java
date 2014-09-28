package pmo.beans.page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.context.FacesContext;

import pmo.bean.bvtables.MatrixRows;
import pmo.db.helpers.JDB;
import pmo.pagebean.Login;

public class BV {
	private HashMap<String, String> managerMap;
	
	private String selectedMngr;
	
	private String period;
	
	private int lastDate;
	private int firstDay;
	private int lastDay;
	
	private String[] values;
	
	public String[] getValues(){
		return values;
	}
	public void setValues(String[] a){
		values = a;
	}
	
	private String[] dayValues;
	
	public String[] getDayValues(){
		return dayValues;
	}
	public void setDayValues(String[] a){
		dayValues = a;
	}
	
	private boolean bVavailable;

	public boolean isbVavailable() {
		return bVavailable;
	}
	public void setbVavailable(boolean bVavailable) {
		this.bVavailable = bVavailable;
	}
	
	
	private boolean weekend;
	
	public boolean isWeekend() {
		return weekend;
	}
	public void setWeekend(boolean weekend) {
		this.weekend = weekend;
	}

	private List<MatrixRows> matrixRows;

	private JDB jdb = new JDB();
	
	public int getLastDate() {
		return lastDate;
	}
	
	public void setLastDate(int lastDate) {
		this.lastDate = lastDate;
	}

	public int getFirstDay() {
		return firstDay;
	}

	public void setFirstDay(int firstDay) {
		this.firstDay = firstDay;
	}

	public int getLastDay() {
		return lastDay;
	}

	public void setLastDay(int lastDay) {
		this.lastDay = lastDay;
	}

	public HashMap<String, String> getManagerMap() {
		ResultSet rs = jdb.selectQuery("SELECT distinct A.MNGR_TCS_EMP_ID, A.TCS_EMP_NAME FROM ASSOCIATES A WHERE A.TCS_EMP_ID = A.MNGR_TCS_EMP_ID");
		managerMap = new HashMap<String, String>();
		try {
			while(rs.next()){
				managerMap.put(rs.getString("TCS_EMP_NAME"), ""+rs.getInt("MNGR_TCS_EMP_ID")+"");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return managerMap;
	}
	
	public void setManagerMap(HashMap<String, String> managerMap) {
		this.managerMap = managerMap;
	}
	
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	
	public String getSelectedMngr() {
		return selectedMngr;
	}
	
	public void setSelectedMngr(String selectedMngr) {
		this.selectedMngr = selectedMngr;
	}
	
	public List<MatrixRows> getMatrixRows(){
		return matrixRows;
	}
	
	public void setMatrixRows(List<MatrixRows> matrixRows) {
		this.matrixRows = matrixRows;
	}
	
	/*
	 * All information required for BV table is to fetched and arranged here. 
	 */
	public String getTable(){
		ResultSet rs = jdb.selectQuery("SELECT TCS_EMP_ID, LBG_CT_ID, LBG_FNAME, LBG_LNAME " +
				"FROM ASSOCIATES WHERE MNGR_TCS_EMP_ID = '" + getSelectedMngr() + "'");
		ResultSet res = jdb.selectQuery("SELECT * FROM BV WHERE " +
				"MNGR_TCS_EMP_ID = '" + getSelectedMngr() + "' AND BV_PERIOD='" + getPeriod() + "'");

		String[] weekDays = {"S", "M", "Tu", "W", "Th", "F", "S"};
		int noOfDays = getLastDate();
		int firstDay = getFirstDay();
		try {
			if(res.getFetchSize() == 0){
				bVavailable = false;
				String zeroValues = "";
				String dayVals = "";
				for(int i=0;i<noOfDays;i++){
					if(i==noOfDays-1){
						zeroValues = zeroValues + "0";
						dayVals = dayVals + weekDays[(firstDay+i)%7];
					}else{
						zeroValues = zeroValues + "0:";
						dayVals = dayVals + weekDays[(firstDay+i)%7]+":";
					}
				}
				values = zeroValues.split(":");
				dayValues = dayVals.split(":");
			}else{
				bVavailable = true;
				values = res.getString("BV_ROW").split(":");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		matrixRows = new ArrayList<MatrixRows>();
		try {
			while(rs.next()){
				MatrixRows matrixRow = new MatrixRows();
				matrixRow.setEmpId(rs.getInt("TCS_EMP_ID"));
				matrixRow.setCtId(rs.getString("LBG_CT_ID"));
				matrixRow.setfName(rs.getString("LBG_FNAME"));
				matrixRow.setDate(getLastDate());
				matrixRows.add(matrixRow);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "BV";
	}
	
	public String getDay(int i){
		return dayValues[i];
	}
	
	/*public String getTable(){
		ResultSet rs = jdb.selectQuery("SELECT TCS_EMP_ID, LBG_CT_ID, LBG_FNAME, LBG_LNAME " +
				"FROM ASSOCIATES WHERE MNGR_TCS_EMP_ID = '" + getSelectedMngr() + "'");
		String[] weekDays = {"Su", "M", "Tu", "W", "Th", "F", "Sa"};
		int noOfDays = getLastDate();
		int firstDay = getFirstDay();
		//matrixRows = new ArrayList<MatrixRows>();
		effortsTablesList = new ArrayList<EffortsTable>();
		try {
			while(rs.next()){
				//effortsTablesList = new ArrayList<EffortsTable>();
				for(int i=0; i<noOfDays; i++){
					EffortsTable effortsTable = new EffortsTable();
					effortsTable.setDate(i+1);
					effortsTable.setDay(weekDays[(firstDay+i)%7]);
					effortsTable.setValue(0);
					effortsTablesList.add(effortsTable);
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "BV";
	}*/
	
	private boolean editable;
	
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	public String toggleEdit(){
		if(editable)
			editable=false;
		else
			editable=true;
		return "done";
	}
	
	public String addTable(){
		
		return "Added";
	}
	
}
