package org.altairretro.practice;


import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RealOne {
	
	
	@Test(groups="regression")
	public void India() {
		Assert.fail();
		System.out.println("INDIA");
	
	}
	@Test(groups="sanity")
	public void Nepal() {
		System.out.println("NEPAL");
	}
}
