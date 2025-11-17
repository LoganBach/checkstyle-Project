package main.java;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;


import com.puppycrawl.tools.checkstyle.api.*;

class LoopingStatementCheckTest {

	@Test
	public void testIsCommentNodesRequired() {
		LoopingStatementCheck loopingStatementCheck = new LoopingStatementCheck();
		assertEquals(true, loopingStatementCheck.isCommentNodesRequired());
	}
	
	@Test
	public void testGetDefaultTokens() {
		LoopingStatementCheck spy = spy(new LoopingStatementCheck());
		int[] mockArr = {2, 2};
		
		doReturn(mockArr).when(spy).getAcceptableTokens();
		
		assertEquals(mockArr, spy.getDefaultTokens());
		verify(spy, times(1)).getAcceptableTokens();
	}
	
	@Test
	public void testVisitToken() {
		LoopingStatementCheck loopingStatementCheck = new LoopingStatementCheck();
		
		DetailAST ast = mock(DetailAST.class);
		
		loopingStatementCheck.visitToken(ast);
	}
	
	@Test
	public void testGetAcceptableTokens() {
		LoopingStatementCheck loopingStatementCheck = new LoopingStatementCheck();
		int[] correctTokens = {
				TokenTypes.LITERAL_FOR,
				TokenTypes.LITERAL_WHILE,
				TokenTypes.LITERAL_DO
		};
		
		assertArrayEquals(correctTokens, loopingStatementCheck.getAcceptableTokens());
	}
	
	@Test
	public void testGetRequiredTokens() {
		LoopingStatementCheck spy = spy(new LoopingStatementCheck());
		int[] mockArr = {2, 2};
		
		doReturn(mockArr).when(spy).getAcceptableTokens();
		
		assertEquals(mockArr, spy.getRequiredTokens());
		verify(spy, times(1)).getAcceptableTokens();
	}
	
	@Test
	public void testBeginTreeToken() {
		LoopingStatementCheck loopingStatementCheck = new LoopingStatementCheck();
		
		DetailAST ast = mock(DetailAST.class);
		
		loopingStatementCheck.beginTree(ast);
	}
	
	@Test
	public void testFinishTree() {
		LoopingStatementCheck spy = spy(new LoopingStatementCheck());
		
		DetailAST ast = mock(DetailAST.class);
		
		doNothing().when(spy).log(anyInt(), anyString());
		spy.finishTree(ast);
		verify(spy).log(0, "Total Looping Statements: 0-signature LB");
	}

}
