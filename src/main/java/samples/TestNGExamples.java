package samples;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGExamples {
	
	
	@BeforeClass
	public void beforeclass() {
		System.out.println("Before Method......!!!!!");
	}
	
	@AfterClass
    public void afterclass() {
		
		System.out.println("After Method......!!!!!");
		
	}
	
	@Test
    public void method1() {
		System.out.println("Method  1. .....!!!!!");
	}
	
	@Test
    public void method2() {
		System.out.println("Method  2. .....!!!!!");
	}
	
	
	

}
