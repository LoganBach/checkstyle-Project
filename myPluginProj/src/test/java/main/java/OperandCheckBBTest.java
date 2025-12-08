package main.java;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.File;


class OperandCheckBBTest {

	@Test
	public void testCheck() throws Exception {
		File file = new File("BlackBoxTestCases/OperatorCheckFMCase.java");
		OperatorCheck check = new OperatorCheck();
		
		String log = BlackBoxTestEngine.testCheck(check, file);
		assertFalse(log.isEmpty());
		
		int expectedCount = 3;
		
		String[] parts = log.split(":");
		String finalCountString = parts[1].trim();
		finalCountString = finalCountString.split("-")[0].trim();
		int finalCount = Integer.parseInt(finalCountString);
		
		
		assertEquals(expectedCount, finalCount);
	}

}
