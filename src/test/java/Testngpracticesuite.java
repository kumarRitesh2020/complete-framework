

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testngpracticesuite 
{
	@BeforeSuite
	public void suitelevel()
	{
		System.out.println("suitelevel");		
	}
	@BeforeTest
	public void testlevel() {
		System.out.println("testlevel");
	}
	@BeforeClass
	public void classlevel() {
		System.out.println("classlevel");
	}
	@BeforeMethod
	public void methodlevel() {
		System.out.println("methodlevel");
	}
	@Test
	public void maintest() {
		System.out.println("a");
	}
    @Test
    public void main2test()
    {
    	System.out.println("a");
    }
    @AfterMethod
    public void methoddown()
    {
    System.out.println("methoddown");	
    }
    @AfterClass
    public void classdown() 
    {
     System.out.println("classdown");     
    }
    @AfterTest
    public void testdown()
    {
    System.out.println("testdown");	
    }
    
}
