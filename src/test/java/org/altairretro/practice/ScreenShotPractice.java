package org.altairretro.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ListenerImplementation;

public class ScreenShotPractice extends BaseClass{
	
	@Test
	public void screenshot() {
		
		ListenerImplementation.stest.assignAuthor("Sunil");
		ListenerImplementation.stest.assignCategory("smoke");
	}

}
