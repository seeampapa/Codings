package amp.sf.cache;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class Dependencies implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String cname;
	private String dname;
	private Map<String, List<String>> dependMap;
	
	public Dependencies(){
		dependMap = new Hashtable<String, List<String>>();
	}
	
	public Dependencies(String cname, String dname, Map<String, List<String>> dependMap) {
		this.cname = cname;
		this.dname = dname;
		this.dependMap = dependMap;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Map<String, List<String>> getDependMap() {
		return dependMap;
	}
	
	public void addDependencies(String cval, String dval){
		ArrayList<String> dVals;
		if(cval!=null && dval!=null){
			if(dependMap.get(cval)!=null){
				dVals = (ArrayList<String>) dependMap.get(cval);
			}else{
				dVals = new ArrayList<String>();
			}
			dVals.add(dval);
			dependMap.put(cval, dVals);
		}
	}
}
