class ExpressionCheckFMCase {
	
	void test() {
	    String s = "a + b * c // not an expression";
	    // a - b / c
	    int x = 5; /* example expression */
	    System.out.println("Result: " + (x+5));
	}
}