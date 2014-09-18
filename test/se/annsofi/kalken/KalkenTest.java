package se.annsofi.kalken;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class KalkenTest {
	private Kalken testFrame;
	@Before
	public void setUp(){
		testFrame = new Kalken();		
	}
	
	@After
	public void tearDown(){
		 if (this.testFrame != null) {
	            this.testFrame.dispose(  );
	            this.testFrame = null;
	        }		
	}
	@Test
	public void testKalken() {
		fail("Not yet implemented");
	}

	@Test
	public void testButtonEnabler() {
		fail("Not yet implemented");
	}

	@Test
	public void testLevelChooser() {
		fail("Not yet implemented");
	}

	@Test
	public void testMove() {
		fail("Not yet implemented");
	}

	@Test
	public void testRandom() {
		fail("Not yet implemented");
	}

	@Test
	public void testEmpty() {
		fail("Not yet implemented");
	}

	@Test
	public void testRestart() {
		fail("Not yet implemented");
	}

	@Test
	public void testLevel1() {
		fail("Not yet implemented");
	}

	@Test
	public void testLevel2() {
		fail("Not yet implemented");
	}

	@Test
	public void testLevel3() {
		fail("Not yet implemented");
	}

	@Test
	public void testLevel4() {
		fail("Not yet implemented");
	}

	@Test
	public void testActionPerformed() {
		fail("Not yet implemented");
	}

	@Test
	public void testMain() {
		fail("Not yet implemented");
	}

}
