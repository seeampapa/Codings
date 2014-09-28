package amp.inher.samp2;

/*
 * B ----> A
 * C ----> A
 */

class A{
	void text(){
		System.out.println("class A");
	}
}

class B extends A{
	void text(){
		System.out.println("class B");
	}
}

class C extends A{
	void text(){
		System.out.println("class C");
	}
}

interface IntA{
	// compilation fails if a method from Interface is not implemented.
	void txt();
}

class ImplA implements IntA{
	public void txt(){
		System.out.println("implemented");
	}
	
	void text(){
		System.out.println("ImplA");
	}
}

public class Samp2 {
	public static void main(String[] args) {
		A ab = new B();
		ab.text();
		A ac = new C();
		ac.text();
		IntA a = new ImplA();
		//a.text(); // compilation fails
		a.txt();
	}
}
