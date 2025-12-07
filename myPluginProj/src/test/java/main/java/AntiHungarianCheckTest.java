package main.java;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;


import com.puppycrawl.tools.checkstyle.api.*;

class AntiHungarianCheckTest{
	
	@Test
	public void testGetDefaultTokens() {
		AntiHungarianCheck hungCheck = new AntiHungarianCheck();
		int[] correctTokens = {
				TokenTypes.VARIABLE_DEF,
		};
		
		assertArrayEquals(correctTokens, hungCheck.getAcceptableTokens());
	}


}
