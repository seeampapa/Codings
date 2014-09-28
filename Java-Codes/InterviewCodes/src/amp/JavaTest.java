package amp.pack;

abstract class AbstractTest {
	public abstract void method1();
	
	public abstract void method2();
	
	public abstract void method3();
	
	public static void main(){
		System.out.println("Amp");
	}
}

public class JavaTest extends AbstractTest{

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method3() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String a[]){
		AbstractTest.main();
	}
	
}

class JTest implements AbstractTest{

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method3() {
		// TODO Auto-generated method stub
		
	}
	
}