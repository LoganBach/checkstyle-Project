package main.java;

import com.puppycrawl.tools.checkstyle.api.*;
import com.puppycrawl.tools.checkstyle.Checker;
import com.puppycrawl.tools.checkstyle.DefaultConfiguration;

import java.io.File;

import java.util.List;


public class BlackBoxTestEngine {
	
	public static String testCheck(AbstractCheck check, File file) throws Exception {

		
		DefaultConfiguration treeWalkerConfig= new DefaultConfiguration("TreeWalker");
		DefaultConfiguration checkConfig = new DefaultConfiguration(check.getClass().getName());
		
		treeWalkerConfig.addChild(checkConfig);
		
		Checker checker = new Checker();
		checker.setModuleClassLoader(Checker.class.getClassLoader());
		checker.configure(treeWalkerConfig);
		
		BlackBoxEngineHelper listener = new BlackBoxEngineHelper();
		checker.addListener(listener);
		
		List<File> files = List.of(file);
		
		checker.process(files);
		checker.destroy();
		
		
		
		return listener.getLog();
	}
}
