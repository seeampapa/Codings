package amp.hello;

public class Hello {
	
	private String name;
	
	public Hello() {
		// TODO Auto-generated constructor stub
		name = "AMP";
	}
	
	public void printName(){
		System.out.println("Hello " + name);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hello hello = new Hello();
		hello.printName();
	}

}
