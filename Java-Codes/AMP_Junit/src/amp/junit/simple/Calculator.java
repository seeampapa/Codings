package amp.junit.simple;

public class Calculator {
	
	private int i;
	private int j;
	
	public Calculator() {
		// TODO Auto-generated constructor stub
	}
	
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public int add(){
		return i+j;
	}
	
	public int sub(){
		return i-j;
	}
}
