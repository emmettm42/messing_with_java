package data_structures;
// Emmett Maloney
// Spring 2017

public class CauseException {
	public void myMethod() throws MyException {
		System.out.println("Throwing");
		throw new MyException();
	}

}
