package pmo.dbproc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import pmo.db.helpers.JDB;
import pmo.pagebean.BV;
import pmo.pagebean.Login;
import pmo.viewbean.BVDataTable;

public class BVbean{
	
	private JDB jdb;
	
	private List<BVDataTable> effortsList;
	
	public List<BVDataTable> getEffortsList() {
		return effortsList;
	}

	public void setEffortsList(List<BVDataTable> effortsList) {
		this.effortsList = effortsList;
	}

	private void init(){
		if(jdb==null){
			jdb = new JDB();
		}
	}
	
	public HashMap<String, String> getManagerMap(){
		init();
		ResultSet rs = jdb.selectQuery("SELECT distinct A.MNGR_TCS_EMP_ID, A.TCS_EMP_NAME FROM ASSOCIATES A WHERE A.TCS_EMP_ID = A.MNGR_TCS_EMP_ID");
		HashMap<String, String> managerMap = new HashMap<String, String>();
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
	
	public String loadTable(){
		init();
		BV bv = (BV) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("bv");
		ResultSet rs = jdb.selectQuery("SELECT A.TCS_EMP_ID, A.lBG_CT_ID, A.LBG_FNAME, A.LBG_LNAME, A.BILL_RATE FROM ASSOCIATES A WHERE A.MNGR_TCS_EMP_ID = '" + bv.getSelectedMngr() +"' ORDER BY A.TCS_EMP_ID");
		effortsList = new ArrayList<BVDataTable>();
		try {
			while(rs.next()){
				BVDataTable bvDataTable = new BVDataTable();
				bvDataTable.setTcsEmpId(rs.getInt("TCS_EMP_ID"));
				bvDataTable.setCtId(rs.getString("LBG_CT_ID"));
				bvDataTable.setfName(rs.getString("LBG_FNAME"));
				bvDataTable.setlName(rs.getString("LBG_LNAME"));
				bvDataTable.setBillRate(rs.getDouble("BILL_RATE"));
					
				ResultSet res = jdb.selectQuery("SELECT * FROM ASSOCIATES A, BV B WHERE B.TCS_EMP_ID =  '" + rs.getInt("TCS_EMP_ID") + "' AND B.BV_PERIOD = '" + bv.getPeriodSelected() + "'");
				String rsEfforts;
				if(res.next()){
					rsEfforts = res.getString("BV_EFFORTS");
					bvDataTable.setBvDaysEffort(res.getDouble("BV_DAYS_EFFORT"));
					bvDataTable.setBvBilledAmt(res.getDouble("BV_BILLED_AMT"));
					bvDataTable.setBvAdjust(res.getDouble("BV_ADJUST"));
					bvDataTable.setBvAdjustedDaysEff(res.getDouble("BV_ADJUSTED_DAYS_EFF"));
					bvDataTable.setBvAdjustedBillAmt(res.getDouble("BV_ADJUSTED_BILLED_AMT"));
					bvDataTable.setFromDB(true);
				}else{
					rsEfforts = "0:0:0:0:0:0:0:0:0:0:0:0:0:0:0:0:0:0:0:0:0:0:0:0:0:0:0:0:0:0:0";
					rsEfforts = rsEfforts.substring(0, (bv.getPeriodLastDate()*2)-1);
					bvDataTable.setBvDaysEffort(0);
					bvDataTable.setBvBilledAmt(0);
					bvDataTable.setBvAdjust(0);
					bvDataTable.setBvAdjustedDaysEff(0);
					bvDataTable.setBvAdjustedBillAmt(0);
					bvDataTable.setFromDB(false);
				}
				
				bvDataTable.setBvEffort(rsEfforts);
				effortsList.add(bvDataTable);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "loadTable";
	}
	
	/*public void updateTable(ActionEvent event){
		BV bv = (BV) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("bv");
		BVDataTable bvDataTable = new BVDataTable();
		bvDataTable = (BVDataTable) event.getComponent().getAttributes().get("row");
		System.out.println(bvDataTable.getTcsEmpId() + " " + bvDataTable.getBvEffort() + " " + bvDataTable.getNewVal());
		String qry = "";
		if(bvDataTable.isFromDB()){
			qry = "UPDATE BV SET BV_EFFORTS = '" + bvDataTable.getNewVal() + "' WHERE TCS_EMP_ID = '" + bvDataTable.getTcsEmpId() + "'";
		}else{
			qry = "INSERT INTO BV (`TCS_EMP_ID`, `BV_PERIOD`,`BV_EFFORTS`) " +
					"VALUES ("+ bvDataTable.getTcsEmpId() + ", '" + bv.getPeriodSelected() + "', '" +bvDataTable.getNewVal() + "')";
		}
		jdb.execUpdate(qry);
		loadTable();
	}*/
	
	public void updateTable(ActionEvent event){
		BV bv = (BV) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("bv");
		List<BVDataTable> bvDataTableList = new ArrayList<BVDataTable>();
		bvDataTableList = (List<BVDataTable>) event.getComponent().getAttributes().get("rows");
		for(int i=0; i<bvDataTableList.size(); i++){
			BVDataTable bvDataTable = bvDataTableList.get(i);
			System.out.println(bvDataTable.getTcsEmpId() + " " + bvDataTable.getBvEffort() + " " + bvDataTable.getNewVal());
			String qry = "";
			if(!bvDataTable.getNewVal().equals("") && !bvDataTable.getBvEffort().equals(bvDataTable.getNewVal())){
				if(bvDataTable.isFromDB()){
					qry = "UPDATE BV SET BV_EFFORTS = '" + bvDataTable.getNewVal() + "'," +
							"BV_DAYS_EFFORT = '" + bvDataTable.getBvDaysEffort() + "'," +
							"BV_BILLED_AMT = '" + bvDataTable.getBvBilledAmt() + "'," +
							"BV_ADJUST = '" + bvDataTable.getBvAdjust() + "'," +
							"BV_ADJUSTED_DAYS_EFF = '" + bvDataTable.getBvAdjustedDaysEff() + "'," +
							"BV_ADJUSTED_BILLED_AMT = '" + bvDataTable.getBvAdjustedBillAmt() + "'" +
							" WHERE TCS_EMP_ID = '" + bvDataTable.getTcsEmpId() + "' AND BV_PERIOD = '" + bv.getPeriodSelected() + "'";
				}else{
					qry = "INSERT INTO BV (TCS_EMP_ID, MNGR_TCS_EMP_ID, BV_PERIOD,BV_EFFORTS, BV_DAYS_EFFORT,BV_BILLED_AMT, BV_ADJUST, BV_ADJUSTED_DAYS_EFF, BV_ADJUSTED_BILLED_AMT) " +
							"VALUES ("+ bvDataTable.getTcsEmpId() + ","+bv.getSelectedMngr()+", '" + bv.getPeriodSelected() + "', '" +bvDataTable.getNewVal() + "', " + 
							bvDataTable.getBvDaysEffort() + ", " +bvDataTable.getBvBilledAmt() + ", " +bvDataTable.getBvAdjust() + ", " +
							bvDataTable.getBvAdjustedDaysEff() + ", " +bvDataTable.getBvAdjustedBillAmt() + ")";
				}
				jdb.execUpdate(qry);
			}
		}
		loadTable();
	}
}
