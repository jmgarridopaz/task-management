package io.github.jmgarridopaz.taskmanagement.adapters.forassigningtasks.test.runner;

import java.io.PrintWriter;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

public class JUnit5Runner {
	
	public JUnit5Runner () {}

	
	public void runTestsOfUseCase ( Class<?> testCasesClass ) {
		
		SimpleReportTestExecutionListener reportListener = new SimpleReportTestExecutionListener();
		SummaryGeneratingListener summaryListener = new SummaryGeneratingListener();		
		LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder
												.request()
												.selectors ( selectClass(testCasesClass) )
												.build();
		PrintWriter sysOutPrintWriter = new PrintWriter(System.out);
				
		Launcher launcher = LauncherFactory.create();
		launcher.registerTestExecutionListeners ( reportListener, summaryListener );
		launcher.execute ( request );
		
		reportListener.printReportTo ( sysOutPrintWriter );
		summaryListener.getSummary().printTo ( sysOutPrintWriter );		
	}
	
}
