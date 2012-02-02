package edu.upenn.cis350.gpx;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ OutOfContextUnitTests.class, ShouldWork.class,
		TestGPXcalculator3.class })
public class TestGPXcalculator {

}
