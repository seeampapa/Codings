package amp.inher.samp1;

class SuperClass{
	int i, j;
	public SuperClass() {
		// TODO Auto-generated constructor stub
	}
	public SuperClass(int i, int j) {
		this.i = i;
		this.j = j;
	}
	void std(){
		System.out.println("Super Class");
	}
	void sys(){
		System.out.println("Sys in Super Class");
	}
	void sysOut(){
		System.out.println(i);
		System.out.println(j);
	}
}

class SubClass1 extends SuperClass{
	int k;
	public SubClass1() {
		// TODO Auto-generated constructor stub
	}
	public SubClass1(int i, int j, int k) {
		super(i,j);
		this.k = k;
	}
	void std(){
		System.out.println("Sub Class 1");
	}
	void sys(String a){
		System.out.println("Sys in Sub Class " + a);
	}
	void sysOut(){
		System.out.println(i);
		System.out.println(j);
		System.out.println(k);
	}
}

public class Samp1 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SuperClass sup = new SubClass1();
		sup.sysOut(); // Calls SubClass1's sysOut()
		//sup.sys();
		SuperClass sc = new SubClass1();
		sc.std();
		//sup.sys(); // compilation fails
	}
}
