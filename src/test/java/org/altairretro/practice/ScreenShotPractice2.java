package org.altairretro.practice;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ListenerImplementation;

public class ScreenShotPractice2 extends BaseClass{
	@Test
	public void screenShot() {
		ListenerImplementation.stest.assignAuthor("ANURAG");
		ListenerImplementation.stest.assignCategory("regression");
		Assert.fail();
		
	}
	
	

}
