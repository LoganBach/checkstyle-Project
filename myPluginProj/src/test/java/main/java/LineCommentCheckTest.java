package main.java;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;


import com.puppycrawl.tools.checkstyle.api.*;
import com.puppycrawl.tools.checkstyle.api.DetailAST;

class LineCommentCheckTest {

	@Test
	public void testIsCommentNodesRequired() {
		LineCommentCheck lineCommentCheck = new LineCommentCheck();
		assertEquals(true, lineCommentCheck.isCommentNodesRequired());
	}
	
	@Test
	public void testGetDefaultTokens() {
		LineCommentCheck spy = spy(new LineCommentCheck());
		int[] mockArr = {2, 2};
		
		doReturn(mockArr).when(spy).getAcceptableTokens();
		
		assertEquals(mockArr, spy.getDefaultTokens());
		verify(spy, times(1)).getAcceptableTokens();
	}
	
	@Test
	public void testVisitToken() {
		LineCommentCheck lineCommentCheck = new LineCommentCheck();
		
		DetailAST ast = mock(DetailAST.class);
		
		lineCommentCheck.visitToken(ast);
	}
	
	@Test
	public void testGetAcceptableTokens() {
		LineCommentCheck lineCommentCheck = new LineCommentCheck();
		int[] correctTokens = {
				TokenTypes.SINGLE_LINE_COMMENT,
		};
		
		assertArrayEquals(correctTokens, lineCommentCheck.getAcceptableTokens());
	}
	
	@Test
	public void testGetRequiredTokens() {
		LineCommentCheck spy = spy(new LineCommentCheck());
		int[] mockArr = {2, 2};
		
		doReturn(mockArr).when(spy).getAcceptableTokens();
		
		assertEquals(mockArr, spy.getRequiredTokens());
		verify(spy, times(1)).getAcceptableTokens();
	}
	
	@Test
	public void testBeginTreeToken() {
		LineCommentCheck lineCommentCheck = new LineCommentCheck();
		
		DetailAST ast = mock(DetailAST.class);
		
		lineCommentCheck.beginTree(ast);
	}
	
	@Test
	public void testFinishTree() {
		LineCommentCheck spy = spy(new LineCommentCheck());
		
		DetailAST ast = mock(DetailAST.class);
		
		doNothing().when(spy).log(anyInt(), anyString());
		spy.finishTree(ast);
		verify(spy).log(0, "Total Line Comments: 0-signature LB");
	}

}
