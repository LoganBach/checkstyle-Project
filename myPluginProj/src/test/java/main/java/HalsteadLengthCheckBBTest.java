package main.java;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.File;


class HalsteadLengthCheckBBTest {

	@Test
	public void testCheck() throws Exception {
		File file = new File("BlackBoxTestCases/HalsteadLengthCheckFMCase.java");
		HalsteadLengthCheck check = new HalsteadLengthCheck();
		
		String log = BlackBoxTestEngine.testCheck(check, file);
		assertFalse(log.isEmpty());
		
		int expectedCount = 7;
		
		String[] parts = log.split(":");
		String finalCountString = parts[1].trim();
		finalCountString = finalCountString.split("-")[0].trim();
		int finalCount = Integer.parseInt(finalCountString);
		
		
		assertEquals(expectedCount, finalCount);
	}

}
