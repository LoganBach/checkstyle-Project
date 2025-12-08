package main.java;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;


import com.puppycrawl.tools.checkstyle.api.*;
import com.puppycrawl.tools.checkstyle.api.DetailAST;

class CommentCheckTest {

	@Test
	public void testIsCommentNodesRequired() {
		CommentCheck commentCheck = new CommentCheck();
		assertEquals(true, commentCheck.isCommentNodesRequired());
	}
	
	@Test
	public void testGetDefaultTokens() {
		CommentCheck spy = spy(new CommentCheck());
		int[] mockArr = {2, 2};
		
		doReturn(mockArr).when(spy).getAcceptableTokens();
		
		assertEquals(mockArr, spy.getDefaultTokens());
		verify(spy, times(1)).getAcceptableTokens();
	}
	
	@Test
	public void testVisitToken() {
		CommentCheck commentCheck = new CommentCheck();
		
		DetailAST ast = mock(DetailAST.class);
		commentCheck.setCommentCount(1);
		commentCheck.visitToken(ast);
		
		assertEquals(2, commentCheck.getCommentCount());
	}
	
	@Test
	public void testGetAcceptableTokens() {
		CommentCheck commentCheck = new CommentCheck();
		int[] correctTokens = {
				TokenTypes.SINGLE_LINE_COMMENT,
				TokenTypes.BLOCK_COMMENT_BEGIN,
		};
		
		assertArrayEquals(correctTokens, commentCheck.getAcceptableTokens());
	}
	
	@Test
	public void testGetRequiredTokens() {
		CommentCheck spy = spy(new CommentCheck());
		int[] mockArr = {2, 2};
		
		doReturn(mockArr).when(spy).getAcceptableTokens();
		
		assertEquals(mockArr, spy.getRequiredTokens());
		verify(spy, times(1)).getAcceptableTokens();
	}
	
	@Test
	public void testBeginTreeToken() {
		CommentCheck commentCheck = new CommentCheck();
		
		DetailAST ast = mock(DetailAST.class);
		
		commentCheck.beginTree(ast);
	}
	
	@Test
	public void testFinishTree() {
		CommentCheck spy = spy(new CommentCheck());
		
		DetailAST ast = mock(DetailAST.class);
		
		doNothing().when(spy).log(anyInt(), anyString());
		spy.finishTree(ast);
		verify(spy).log(0, "Total Comments: 0-signature LB");
	}

}
