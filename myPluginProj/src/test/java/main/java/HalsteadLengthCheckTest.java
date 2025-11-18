package main.java;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;


import com.puppycrawl.tools.checkstyle.api.*;

class HalsteadLengthCheckTest {
	
	@Test
	public void testGetDefaultTokens() {
		HalsteadLengthCheck spy = spy(new HalsteadLengthCheck());
		int[] mockArr = {2, 2};
		
		doReturn(mockArr).when(spy).getAcceptableTokens();
		
		assertEquals(mockArr, spy.getDefaultTokens());
		verify(spy, times(1)).getAcceptableTokens();
	}
	
	@Test
	public void testVisitToken() {
		HalsteadLengthCheck halsteadLengthCheck = new HalsteadLengthCheck();
		
		DetailAST ast = mock(DetailAST.class);
		
		halsteadLengthCheck.visitToken(ast);
	}
	
	@Test
	public void testGetAcceptableTokens() {
		HalsteadLengthCheck halsteadLengthCheck = new HalsteadLengthCheck();
		int[] correctTokens = {
			// --- Operators ---
				// --- Arithmetic operators ---
			    TokenTypes.PLUS, TokenTypes.MINUS, TokenTypes.STAR,
			    TokenTypes.DIV, TokenTypes.MOD,

			    // --- Relational operators ---
			    TokenTypes.LT, TokenTypes.GT, TokenTypes.LE, TokenTypes.GE,
			    TokenTypes.EQUAL, TokenTypes.NOT_EQUAL,

			    // --- Logical operators ---
			    TokenTypes.LAND, TokenTypes.LOR, TokenTypes.LNOT,

			    // --- Bitwise operators ---
			    TokenTypes.BAND, TokenTypes.BOR, TokenTypes.BXOR, TokenTypes.BNOT,
			    TokenTypes.SL, TokenTypes.SR, TokenTypes.BSR,

			    // --- Assignment operators ---
			    TokenTypes.ASSIGN,
			    TokenTypes.PLUS_ASSIGN, TokenTypes.MINUS_ASSIGN,
			    TokenTypes.STAR_ASSIGN, TokenTypes.DIV_ASSIGN, TokenTypes.MOD_ASSIGN,
			    TokenTypes.SL_ASSIGN, TokenTypes.SR_ASSIGN, TokenTypes.BSR_ASSIGN,
			    TokenTypes.BAND_ASSIGN, TokenTypes.BOR_ASSIGN, TokenTypes.BXOR_ASSIGN,

			    // --- Ternary operator ---
			    TokenTypes.QUESTION, TokenTypes.COLON,

			    // --- Function calls ---
			    TokenTypes.METHOD_CALL,

			    // --- Looping statements ---
			    TokenTypes.LITERAL_FOR, TokenTypes.LITERAL_WHILE, TokenTypes.LITERAL_DO,

			    // --- Control statements ---
			    TokenTypes.LITERAL_IF, TokenTypes.LITERAL_ELSE,
			    TokenTypes.LITERAL_SWITCH, TokenTypes.LITERAL_CASE, TokenTypes.LITERAL_DEFAULT,
			    TokenTypes.LITERAL_RETURN,
			    TokenTypes.LITERAL_BREAK,
			    TokenTypes.LITERAL_CONTINUE,
			    TokenTypes.LITERAL_THROW,
			    TokenTypes.LITERAL_TRY,
			    TokenTypes.LITERAL_CATCH,
			    TokenTypes.LITERAL_FINALLY,

			    // --- Other keyword operators ---
			    TokenTypes.LITERAL_NEW,
			    TokenTypes.LITERAL_INSTANCEOF,
			    TokenTypes.LITERAL_ASSERT,
			    TokenTypes.LITERAL_SYNCHRONIZED,

			    // --- Brackets, braces, commas, semicolons, dot ---
			    TokenTypes.RPAREN,
			    TokenTypes.RBRACK,
			    TokenTypes.RCURLY,
			    TokenTypes.COMMA,
			    TokenTypes.SEMI,
			    TokenTypes.DOT,

			    // --- Array operators ---
			    TokenTypes.ARRAY_DECLARATOR,
			    TokenTypes.INDEX_OP,
			    
			// --- Operands ---
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
		
		assertArrayEquals(correctTokens, halsteadLengthCheck.getAcceptableTokens());
	}
	
	@Test
	public void testGetRequiredTokens() {
		HalsteadLengthCheck spy = spy(new HalsteadLengthCheck());
		int[] mockArr = {2, 2};
		
		doReturn(mockArr).when(spy).getAcceptableTokens();
		
		assertEquals(mockArr, spy.getRequiredTokens());
		verify(spy, times(1)).getAcceptableTokens();
	}
	
	@Test
	public void testBeginTreeToken() {
		HalsteadLengthCheck halsteadLengthCheck = new HalsteadLengthCheck();
		
		DetailAST ast = mock(DetailAST.class);
		
		halsteadLengthCheck.beginTree(ast);
	}
	
	@Test
	public void testFinishTree() {
		HalsteadLengthCheck spy = spy(new HalsteadLengthCheck());
		
		DetailAST ast = mock(DetailAST.class);
		
		doNothing().when(spy).log(anyInt(), anyString());
		spy.finishTree(ast);
		verify(spy).log(0, "Halstead Length: 0-signature LB");
	}

}
