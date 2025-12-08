class LoopingStatementCheckFMCase {
    // while(true) { int x = 5; }
	
	void test() {
	    String s = "While(false)";
	    
	    for(int j = 0; j < 5; j++) 
	    {
	        for(int i = 0; i < 5; i++) 
	        {
	            // do nothing
	        }
	    }
	}
}