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

	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testNullGPXtrk() {
		double result = GPXcalculator.calculateDistanceTraveled(null);
		assertEquals(-1, result, 0);
	}

	@Test
	public void testNullNameAndArray() {
		GPXtrk trk = new GPXtrk(null, null);
		double result = GPXcalculator.calculateDistanceTraveled(trk);
		assertEquals(-1, result, 0);
	}
	
	@Test
	public void testNullArray() {
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
	
	@Test
	public void testOnlyNullSeg() {
		ArrayList<GPXtrkseg> segs = new ArrayList<GPXtrkseg>();
		segs.add(null);
		GPXtrk trk = new GPXtrk("Name", segs);
		double result = GPXcalculator.calculateDistanceTraveled(trk);
		assertEquals(0, result, 0);
	}
	
	@Test
	public void testANullSeg() {
		ArrayList<GPXtrkpt> pts = new ArrayList<GPXtrkpt>();
		pts.add(p1);
		pts.add(p2);
		
		GPXtrkseg seg = new GPXtrkseg(pts);
		
		ArrayList<GPXtrkseg> segs = new ArrayList<GPXtrkseg>();
		segs.add(seg);
		segs.add(null);
		
		GPXtrk trk = new GPXtrk("Name", segs);
		double result = GPXcalculator.calculateDistanceTraveled(trk);
		assertEquals(0, result, 0);
	}
	
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
	
	@Test
	public void testAEmptySegs() {
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
	
	@Test
	public void testAOutOfBoundsPointLatPos() {	
		GPXtrkpt a = new GPXtrkpt(90.1, 40, aDate);
		
		ArrayList<GPXtrkpt> pts = new ArrayList<GPXtrkpt>();
		pts.add(a);
		
		GPXtrkseg seg = new GPXtrkseg(pts);
		
		ArrayList<GPXtrkseg> segs = new ArrayList<GPXtrkseg>();
		segs.add(seg);
		
		GPXtrk trk = new GPXtrk("Name", segs);
		double result = GPXcalculator.calculateDistanceTraveled(trk);
		assertEquals(0, result, 0);
	}
	
	@Test
	public void testAOutOfBoundsPointLatNeg() {	
		GPXtrkpt a = new GPXtrkpt(-90.1, 40, aDate);
		
		ArrayList<GPXtrkpt> pts = new ArrayList<GPXtrkpt>();
		pts.add(a);
		
		GPXtrkseg seg = new GPXtrkseg(pts);
		
		ArrayList<GPXtrkseg> segs = new ArrayList<GPXtrkseg>();
		segs.add(seg);
		
		GPXtrk trk = new GPXtrk("Name", segs);
		double result = GPXcalculator.calculateDistanceTraveled(trk);
		assertEquals(0, result, 0);
	}
	
	@Test
	public void testAOutOfBoundsPointLonPos() {	
		GPXtrkpt a = new GPXtrkpt(40, 180.1, aDate);
		
		ArrayList<GPXtrkpt> pts = new ArrayList<GPXtrkpt>();
		pts.add(a);
		
		GPXtrkseg seg = new GPXtrkseg(pts);
		
		ArrayList<GPXtrkseg> segs = new ArrayList<GPXtrkseg>();
		segs.add(seg);
		
		GPXtrk trk = new GPXtrk("Name", segs);
		double result = GPXcalculator.calculateDistanceTraveled(trk);
		assertEquals(0, result, 0);
	}
	
	@Test
	public void testAOutOfBoundsPointLonNeg() {	
		GPXtrkpt a = new GPXtrkpt(40, -180.1, aDate);
		
		ArrayList<GPXtrkpt> pts = new ArrayList<GPXtrkpt>();
		pts.add(a);
		
		GPXtrkseg seg = new GPXtrkseg(pts);
		
		ArrayList<GPXtrkseg> segs = new ArrayList<GPXtrkseg>();
		segs.add(seg);
		
		GPXtrk trk = new GPXtrk("Name", segs);
		double result = GPXcalculator.calculateDistanceTraveled(trk);
		assertEquals(0, result, 0);
	}
	
	
	

}
