package main.java;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;


import com.puppycrawl.tools.checkstyle.api.*;
import com.puppycrawl.tools.checkstyle.api.DetailAST;

class ExpressionCheckTest {

	@Test
	public void testIsCommentNodesRequired() {
		ExpressionCheck expressionCheck = new ExpressionCheck();
		assertEquals(true, expressionCheck.isCommentNodesRequired());
	}
	
	@Test
	public void testGetDefaultTokens() {
		ExpressionCheck spy = spy(new ExpressionCheck());
		int[] mockArr = {2, 2};
		
		doReturn(mockArr).when(spy).getAcceptableTokens();
		
		assertEquals(mockArr, spy.getDefaultTokens());
		verify(spy, times(1)).getAcceptableTokens();
	}
	
	@Test
	public void testVisitToken() {
		ExpressionCheck expressionCheck = new ExpressionCheck();
		
		DetailAST ast = mock(DetailAST.class);
		
		expressionCheck.visitToken(ast);
	}
	
	@Test
	public void testGetAcceptableTokens() {
		ExpressionCheck expressionCheck = new ExpressionCheck();
		int[] correctTokens = {
				TokenTypes.EXPR
		};
		
		assertArrayEquals(correctTokens, expressionCheck.getAcceptableTokens());
	}
	
	@Test
	public void testGetRequiredTokens() {
		ExpressionCheck spy = spy(new ExpressionCheck());
		int[] mockArr = {2, 2};
		
		doReturn(mockArr).when(spy).getAcceptableTokens();
		
		assertEquals(mockArr, spy.getRequiredTokens());
		verify(spy, times(1)).getAcceptableTokens();
	}
	
	@Test
	public void testBeginTreeToken() {
		ExpressionCheck expressionCheck = new ExpressionCheck();
		
		DetailAST ast = mock(DetailAST.class);
		
		expressionCheck.beginTree(ast);
	}
	
	@Test
	public void testFinishTree() {
		ExpressionCheck spy = spy(new ExpressionCheck());
		
		DetailAST ast = mock(DetailAST.class);
		
		doNothing().when(spy).log(anyInt(), anyString());
		spy.finishTree(ast);
		verify(spy).log(0, "Total Expressions: 0-signature LB");
	}

}
