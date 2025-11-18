package main.java;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;


import com.puppycrawl.tools.checkstyle.api.*;

class OperandCheckTest {
	
	@Test
	public void testGetDefaultTokens() {
		OperandCheck spy = spy(new OperandCheck());
		int[] mockArr = {2, 2};
		
		doReturn(mockArr).when(spy).getAcceptableTokens();
		
		assertEquals(mockArr, spy.getDefaultTokens());
		verify(spy, times(1)).getAcceptableTokens();
	}
	
	@Test
	public void testVisitToken() {
		OperandCheck operandCheck = new OperandCheck();
		
		DetailAST ast = mock(DetailAST.class);
		
		operandCheck.visitToken(ast);
	}
	
	@Test
	public void testGetAcceptableTokens() {
		OperandCheck operandCheck = new OperandCheck();
		int[] correctTokens = {
			    TokenTypes.IDENT,

			    // numeric constants
			    TokenTypes.NUM_INT,
			    TokenTypes.NUM_LONG,
			    TokenTypes.NUM_FLOAT,
			    TokenTypes.NUM_DOUBLE,

			    // literals
			    TokenTypes.STRING_LITERAL,
			    TokenTypes.CHAR_LITERAL,
			    TokenTypes.LITERAL_TRUE,
			    TokenTypes.LITERAL_FALSE,
			    TokenTypes.LITERAL_NULL
		};
		
		assertArrayEquals(correctTokens, operandCheck.getAcceptableTokens());
	}
	
	@Test
	public void testGetRequiredTokens() {
		OperandCheck spy = spy(new OperandCheck());
		int[] mockArr = {2, 2};
		
		doReturn(mockArr).when(spy).getAcceptableTokens();
		
		assertEquals(mockArr, spy.getRequiredTokens());
		verify(spy, times(1)).getAcceptableTokens();
	}
	
	@Test
	public void testBeginTreeToken() {
		OperandCheck operandCheck = new OperandCheck();
		
		DetailAST ast = mock(DetailAST.class);
		
		operandCheck.beginTree(ast);
	}
	
	@Test
	public void testFinishTree() {
		OperandCheck spy = spy(new OperandCheck());
		
		DetailAST ast = mock(DetailAST.class);
		
		doNothing().when(spy).log(anyInt(), anyString());
		spy.finishTree(ast);
		verify(spy).log(0, "Total Operands: 0-signature LB");
	}

}
