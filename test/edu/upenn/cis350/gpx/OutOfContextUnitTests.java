package edu.upenn.cis350.gpx;

import static org.junit.Assert.*;
import java.util.Date;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class OutOfContextUnitTests {
	GPXtrkpt p1, p2;
	Date aDate;
	
	@Before
	public void setUp() throws Exception {
		p1 = new GPXtrkpt(40,40,aDate);
		p2 = new GPXtrkpt(50,50,aDate);
		aDate = new Date(1000);
	}
	
	/*
	 * If the GPXtrk object is null, the method should return -1.
	 */
	@Test
	public void testNullGPXtrk() {
		double result = GPXcalculator.calculateDistanceTraveled(null);
		assertEquals(-1, result, 0);
	}

	/*
	 * If the GPXtrk contains no GPXtrkseg objects, the method should return -1.
	 */
	@Test
	public void testNullNameAndArrayList() {
		GPXtrk trk = new GPXtrk(null, null);
		double result = GPXcalculator.calculateDistanceTraveled(trk);
		assertEquals(-1, result, 0);
	}
	@Test
	public void testNullArrayList() {
		GPXtrk trk = new GPXtrk("Name", null);
		double result = GPXcalculator.calculateDistanceTraveled(trk);
		assertEquals(-1, result, 0);
	}
	@Test
	public void testEmptyArrayList() {
		GPXtrk trk = new GPXtrk("Name", new ArrayList<GPXtrkseg>() );
		double result = GPXcalculator.calculateDistanceTraveled(trk);
		assertEquals(-1, result, 0);
	}

	/*
	 * If any GPXtrkseg in the GPXtrk is null, the distance traveled for that GPXtrkseg should be
considered 0.
	 */
	@Test
	public void testOnlyNullSeg() {
		ArrayList<GPXtrkseg> segs = new ArrayList<GPXtrkseg>();
		segs.add(null);
		GPXtrk trk = new GPXtrk("Name", segs);
		double result = GPXcalculator.calculateDistanceTraveled(trk);
		assertEquals(0, result, 0);
	}

	/*
	 * There should be no distance traveled all segs only have one point.
	 */
	public void testTwoIdentitalPoints() {
		ArrayList<GPXtrkpt> pts = new ArrayList<GPXtrkpt>();
		pts.add(p1);
		pts.add(p1);
		
		GPXtrkseg seg = new GPXtrkseg(pts);
		
		ArrayList<GPXtrkseg> segs = new ArrayList<GPXtrkseg>();
		segs.add(seg);
		
		GPXtrk trk = new GPXtrk("Name", segs);
		double result = GPXcalculator.calculateDistanceTraveled(trk);
		assertEquals(0, result, 0);
	}
	
	/*
	 * If a GPXtrkseg contains no GPXtrkpt objects, the distance traveled for that GPXtrkseg should
be considered 0.
	 */
	@Test
	public void testSegWithNullArrayList() {
		GPXtrkseg seg1 = new GPXtrkseg(null);
		GPXtrkseg seg2 = new GPXtrkseg(null);
		GPXtrkseg seg3 = new GPXtrkseg(null);
		ArrayList<GPXtrkseg> segs = new ArrayList<GPXtrkseg>();
		segs.add(seg1);
		segs.add(seg2);
		segs.add(seg3);
		
		GPXtrk trk = new GPXtrk("Name", segs);
		double result = GPXcalculator.calculateDistanceTraveled(trk);
		assertEquals(0, result, 0);
	}
	@Test
	public void testAEmptySegs() {
		GPXtrkseg seg1 = new GPXtrkseg(new ArrayList<GPXtrkpt>());
		GPXtrkseg seg2 = new GPXtrkseg(new ArrayList<GPXtrkpt>());
		GPXtrkseg seg3 = new GPXtrkseg(new ArrayList<GPXtrkpt>());
		ArrayList<GPXtrkseg> segs = new ArrayList<GPXtrkseg>();
		segs.add(seg1);
		segs.add(seg2);
		segs.add(seg3);
		
		GPXtrk trk = new GPXtrk("Name", segs);
		double result = GPXcalculator.calculateDistanceTraveled(trk);
		assertEquals(0, result, 0);
	}
	
	/*
	 * If a GPXtrkseg contains only one GPXtrkpt, the distance traveled for that GPXtrkseg should be
considered 0.
	 */
	@Test
	public void testSinglePointSeg() {
		ArrayList<GPXtrkpt> pts = new ArrayList<GPXtrkpt>();
		pts.add(p1);
		
		GPXtrkseg seg = new GPXtrkseg(null);
		ArrayList<GPXtrkseg> segs = new ArrayList<GPXtrkseg>();
		segs.add(seg);
		
		GPXtrk trk = new GPXtrk("Name", segs);
		double result = GPXcalculator.calculateDistanceTraveled(trk);
		assertEquals(0, result, 0);
	}
	
	/*
	 * If any GPXtrkpt in a GPXtrkseg is null, the distance traveled for that GPXtrkseg should be
considered 0.
	 */
	@Test
	public void testANullPointInSeg() {
		ArrayList<GPXtrkpt> pts = new ArrayList<GPXtrkpt>();
		pts.add(null);
		
		GPXtrkseg seg = new GPXtrkseg(null);
		ArrayList<GPXtrkseg> segs = new ArrayList<GPXtrkseg>();
		segs.add(seg);
		
		GPXtrk trk = new GPXtrk("Name", segs);
		double result = GPXcalculator.calculateDistanceTraveled(trk);
		assertEquals(0, result, 0);
	}
}
