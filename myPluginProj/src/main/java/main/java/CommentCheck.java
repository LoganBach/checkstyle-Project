package main.java;

import com.puppycrawl.tools.checkstyle.api.*;


public class CommentCheck extends AbstractCheck{

	private int commentCount = 0;
	
	
	//setter for tests
	public void setCommentCount(int val) {
		commentCount = val;
	}
	
	//getter for tests
	public int getCommentCount() {
		return commentCount;
	}
	
	@Override
	public boolean isCommentNodesRequired() {
		return true;
	}
	
	/// Gets the token types used for counting comments from the getAcceptableTokens method.
	@Override
	public int[] getDefaultTokens() {
		return getAcceptableTokens();
	}
	
	/// Increments comment count, this method is only called when the tree walker goes to the specified tokens.
	@Override
	public void visitToken(DetailAST ast) {
		commentCount++;
	}

	/// Gets the specific Checkstyle tokens used to count comments.
	@Override
	public int[] getAcceptableTokens() {
		// Assumes the code is written correctly so only need to count the start of a comment.
		return new int[] {
				TokenTypes.SINGLE_LINE_COMMENT,
				TokenTypes.BLOCK_COMMENT_BEGIN,
		};
	}

	/// Gets the token types used for counting comments from the getAcceptableTokens method.
	@Override
	public int[] getRequiredTokens() {
		// TODO Auto-generated method stub
		return getAcceptableTokens();
	}
	
	/// Is called before the tree walker starts. Sets count to zero.
	@Override
	public void beginTree(DetailAST ast) {
		commentCount = 0;
	}
	
	/// Called when the entire tree is traversed, prints out final comment count.
	@Override
	public void finishTree(DetailAST ast) {
		log(0, "Total Comments: " + commentCount + "-signature LB");
	}
	
	
}

