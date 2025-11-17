package main.java;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;


import com.puppycrawl.tools.checkstyle.api.*;
import com.puppycrawl.tools.checkstyle.api.DetailAST;

class SemiColonCheckTest {

	@Test
	public void testGetDefaultTokens() {
		SemiColonCheck spy = spy(new SemiColonCheck());
		int[] mockArr = {2, 2};
		
		doReturn(mockArr).when(spy).getAcceptableTokens();
		
		assertEquals(mockArr, spy.getDefaultTokens());
		verify(spy, times(1)).getAcceptableTokens();
	}
	
	@Test
	public void testVisitToken() {
		SemiColonCheck semiColonCheck = new SemiColonCheck();
		
		DetailAST ast = mock(DetailAST.class);
		
		semiColonCheck.visitToken(ast);
	}
	
	@Test
	public void testGetAcceptableTokens() {
		SemiColonCheck SemiColonCheck = new SemiColonCheck();
		int[] correctTokens = {
				TokenTypes.SEMI
		};
		
		assertArrayEquals(correctTokens, SemiColonCheck.getAcceptableTokens());
	}
	
	@Test
	public void testGetRequiredTokens() {
		SemiColonCheck spy = spy(new SemiColonCheck());
		int[] mockArr = {2, 2};
		
		doReturn(mockArr).when(spy).getAcceptableTokens();
		
		assertEquals(mockArr, spy.getRequiredTokens());
		verify(spy, times(1)).getAcceptableTokens();
	}
	
	@Test
	public void testBeginTreeToken() {
		SemiColonCheck semiColonCheck = new SemiColonCheck();
		
		DetailAST ast = mock(DetailAST.class);
		
		semiColonCheck.beginTree(ast);
	}
	
	@Test
	public void testFinishTree() {
		SemiColonCheck spy = spy(new SemiColonCheck());
		
		DetailAST ast = mock(DetailAST.class);
		
		doNothing().when(spy).log(anyInt(), anyString());
		spy.finishTree(ast);
		verify(spy).log(0, "Total semicolons: 0-signature LB");
	}

}
