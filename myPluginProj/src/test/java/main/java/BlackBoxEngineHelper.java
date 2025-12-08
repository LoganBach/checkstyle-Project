package main.java;
import com.puppycrawl.tools.checkstyle.api.*;

public class BlackBoxEngineHelper implements AuditListener{

	// builds string result of tests	
	private StringBuilder log = new StringBuilder();
		
		
		
		@Override
		public void addError(AuditEvent event) {
			log.append(event.getMessage());
			log.append("\n");
		}



		@Override
		public void addException(AuditEvent arg0, Throwable arg1) {
			// TODO Auto-generated method stub
			
		}



		@Override
		public void auditFinished(AuditEvent arg0) {
			// TODO Auto-generated method stub
			
		}



		@Override
		public void auditStarted(AuditEvent arg0) {
			// TODO Auto-generated method stub
			
		}



		@Override
		public void fileFinished(AuditEvent arg0) {
			// TODO Auto-generated method stub
			
		}



		@Override
		public void fileStarted(AuditEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		public String getLog() {
			return log.toString();
		}
		
		public void reset() {
			log = new StringBuilder();
		}
		
}
