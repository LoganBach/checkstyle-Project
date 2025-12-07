# checkstyle-Project
Eclipse plugin to detect structual metrics through custom checks exteding from the Eclipse Checkstyle Plugin.



**Check Details:**
 - Each check uses checkstyle to count tokens to get a total count of the specific types of occurances. For example counting line comments counts the occurances of the toke SINGLE_LINE_COMMENT. SINGLE_LINE_COMMENT represents the beginning of a single line comment '//'. The counting works by traversing an abstract synax tree for the code being checked. It calls a function visitToken whenever one of the tokentypes being looked for is found while traversing the tree. The one check that requires calculating a result besides just counting tokens is the Halstead Volume Check. This check calculates the volume by the equation Program Length * log2(Halstead Vocabulary). Where Program Length is the total operand and operator occurances, and Halstead Vocabulary is the total distinct operand and operator occurances.
   
**MISC Checks**
- AntiHungarian Check: Demo Check which checks for hungarian notation
  No JUnit Tests written for the AntiHungarian Check
  **0%** Coverage
  - SemiColon Check: Counts the number of Semicolons in the file.
  **100%** Line and Branch coverage from Junit Test Class

**Category A Checks**
- Comment Check: Counts the number of single and block comments in the file.
  Tokens counted are: SINGLE_LINE_COMMENT, BLOCK_COMMENT_BEGIN
  **100%** Line and Branch coverage from Junit Test Class
  
- Line Comment Check: Counts the number of Line comments in the file.
  Tokens counted are: SINGLE_LINE_COMMENT
  **100%** Line and Branch coverage from Junit Test Class
  
- Looping Statement Check: Counts the number of looping statements in the file.
  Tokens counted are: LITERAL_FOR, LITERAL_WHILE, LITERAL_DO
  **100%** Line and Branch coverage from Junit Test Class
  
- Operator Check: Counts the number of Halstead Operators in the file.
  Check the getAcceptableTokens() in OperatorCheck.java 
  **100%** Line and Branch coverage from Junit Test Class
  
- Operand Check: Counts the number of Halstead Operands in the file.
  Check the getAcceptableTokens() in OperandCheck.java 
  **100%** Line and Branch coverage from Junit Test Class
  
- Expression Check: Counts the number of Expressions in the file.
  Tokens counted are: EXPR
  **100%** Line and Branch coverage from Junit Test Class

**Category B Checks**
- Halstead Length Check: Counts the total sum of operators and operands in the file.
  **100%** Line and Branch coverage from Junit Test Class
- Halstead Volume Check: Calculates the Halstead volume of the file from it's program length and vocabulary size.
  **100%** Line and Branch coverage from Junit Test Class
  
**Test Details:**
- All whitebox tests use Junit and Mockito and coverage was tested with eclipse built in coverage testing
- The only function which required multiple cases (the only function with a branch) was the HalsteadVolumeCheck.java's VisitToken() function. In this function a list of unique operators/operands visited is checked to see if it does not contain the currently visited token. To cover the case where it has not been visited the function was called without any extra modifications. To cover the case where it does contain, the test contains a doReturn TokenType.FALSE when DetailAST.getType(). Then the function is called twice.
