package main.java;

import com.puppycrawl.tools.checkstyle.api.*;
import com.puppycrawl.tools.checkstyle.Checker;
import com.puppycrawl.tools.checkstyle.DefaultConfiguration;

import java.io.File;

import java.util.List;


public class BlackBoxTestEngine {
	
	public static String testCheck(AbstractCheck check, File file) throws Exception {

		Checker checker = new Checker();
		checker.setModuleClassLoader(Checker.class.getClassLoader());
		
		DefaultConfiguration treeWalkerConfig= new DefaultConfiguration("TreeWalker");
		DefaultConfiguration checkerConfig = new DefaultConfiguration("config");
		DefaultConfiguration checkConfig = new DefaultConfiguration(check.getClass().getName());
		
		treeWalkerConfig.addChild(checkConfig);
		
		checkerConfig.addChild(treeWalkerConfig);
		checker.configure(checkerConfig);
		
		
		BlackBoxEngineHelper listener = new BlackBoxEngineHelper();
		checker.addListener(listener);
		
		List<File> files = List.of(file);
		
		checker.process(files);
		checker.destroy();
		
		
		
		return listener.getLog();
	}
}
