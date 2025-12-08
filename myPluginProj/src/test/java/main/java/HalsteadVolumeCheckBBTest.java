package main.java;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.File;


class HalsteadVolumeCheckBBTest {

	@Test
	public void testCheck() throws Exception {
		File file = new File("BlackBoxTestCases/HalsteadVolumeCheckFMCase.java");
		HalsteadVolumeCheck check = new HalsteadVolumeCheck();
		
		String log = BlackBoxTestEngine.testCheck(check, file);
		assertFalse(log.isEmpty());
		double expectedCount = 36.19;
		
		String[] parts = log.split(":");
		String finalCountString = parts[1].trim();
		finalCountString = finalCountString.split("-")[0].trim();
		double finalCount = Double.parseDouble(finalCountString);
		finalCount = Math.round(finalCount * 100.0)/100.0;
		
		assertEquals(expectedCount, finalCount);
	}
	
	@Test
	public void testCheck2() throws Exception {
		File file = new File("BlackBoxTestCases/HalsteadVolumeCheckFMCase2.java");
		HalsteadVolumeCheck check = new HalsteadVolumeCheck();
		
		String log = BlackBoxTestEngine.testCheck(check, file);
		assertFalse(log.isEmpty());
		
		double expectedCount = 0;
		
		String[] parts = log.split(":");
		String finalCountString = parts[1].trim();
		finalCountString = finalCountString.split("-")[0].trim();
		double finalCount = Double.parseDouble(finalCountString);
		
		
		assertEquals(expectedCount, finalCount);
	}

}
