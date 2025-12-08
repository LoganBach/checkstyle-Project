package main.java;

import com.puppycrawl.tools.checkstyle.api.*;

import java.util.List;
import java.util.ArrayList;


public class HalsteadVolumeCheck extends AbstractCheck{

	//keeps track of visited tokens
	private List<Integer> distinctTokens = new ArrayList<Integer>();
	private int halsteadVocab = 0;
	private int programLength = 0;
	
	
	//setter for tests
	public void setHalsteadVocab(int val) {
		halsteadVocab = val;
	}
	
	//getter for tests
	public int getVocab() {
		return halsteadVocab;
	}
	
	//setter for tests
	public void setProgramLength(int val) {
		programLength = val;
	}
	
	//setter for tests
	public int getLength() {
		return programLength;
	}
		
	@Override
	public int[] getDefaultTokens() {
		return getAcceptableTokens();
	}
	
	@Override
	public void visitToken(DetailAST ast) {
		int tokenType = ast.getType();
		
		if(!distinctTokens.contains(tokenType)) {
			halsteadVocab++;
			distinctTokens.add(tokenType);
		}
		
		programLength++;
	}

	@Override
	public int[] getAcceptableTokens() {
		// TODO Auto-generated method stub
		return new int[] {
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
	}

	@Override
	public int[] getRequiredTokens() {
		// TODO Auto-generated method stub
		return getAcceptableTokens();
	}
	
	@Override
	public void beginTree(DetailAST ast) {
		halsteadVocab = 0;
		distinctTokens.clear();
		programLength = 0;
	}
	
	@Override
	public void finishTree(DetailAST ast) {
		double halsteadVolume = 0;
		if(halsteadVocab > 0) {
			halsteadVolume = programLength * (Math.log(halsteadVocab) / Math.log(2));
		}
		
		log(0, "Halstead Volume: " + halsteadVolume + "-signature LB");
	}
	
	
}

