package csc130.maloneye.Classwork;

public class CauseException {
	public void myMethod() throws MyException {
		System.out.println("Throwing");
		throw new MyException();
	}

}
