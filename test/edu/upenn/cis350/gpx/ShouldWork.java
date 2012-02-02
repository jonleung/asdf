package edu.upenn.cis350.gpx;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class ShouldWork {

	private GPXtrk _trk_1;
	private GPXtrk _trk_12;
	private GPXtrk _trk_3;
	
	ArrayList<GPXtrkseg> segs_23;
	
	@Before
	public void setUp() throws Exception {
		
		Date aDate = new Date(1000);
		
		ArrayList<GPXtrkpt> pts1 = new ArrayList<GPXtrkpt>();
		pts1.add(new GPXtrkpt(10, 1, aDate));
		pts1.add(new GPXtrkpt(10, 2, aDate));
		pts1.add(new GPXtrkpt(10, 3, aDate));
		pts1.add(new GPXtrkpt(10, 4, aDate));
		
		ArrayList<GPXtrkpt> pts2 = new ArrayList<GPXtrkpt>();
		pts2.add(new GPXtrkpt(1, 10, aDate));
		pts2.add(new GPXtrkpt(2, 10, aDate));
		pts2.add(new GPXtrkpt(3, 10, aDate));
		pts2.add(new GPXtrkpt(4, 10, aDate));
		
		ArrayList<GPXtrkpt> pts3 = new ArrayList<GPXtrkpt>();
		pts3.add(new GPXtrkpt(47.040106664,-45, aDate));
		pts3.add(new GPXtrkpt(36.5978702,111.09375, aDate));
		pts3.add(new GPXtrkpt(25.79988833,90.703125, aDate));
		pts3.add(new GPXtrkpt(51.6180737,125.15625, aDate));
		pts3.add(new GPXtrkpt(67.60926382,169.453125, aDate));
		pts3.add(new GPXtrkpt(78.76774321,-3.515625, aDate));
		pts3.add(new GPXtrkpt(47.040106664,26.71875, aDate));
		pts3.add(new GPXtrkpt(47.040106664,-83.671875, aDate));
		pts3.add(new GPXtrkpt(-11.867459308,22.5, aDate));
		pts3.add(new GPXtrkpt(51.6180737,59.765625, aDate));
		pts3.add(new GPXtrkpt(-54.97769625,-66.09375, aDate));
		pts3.add(new GPXtrkpt(30.14517613,134.296875, aDate));
		pts3.add(new GPXtrkpt(36.03133187,3.515625, aDate));
		pts3.add(new GPXtrkpt(5.61598534,5.625, aDate));
		pts3.add(new GPXtrkpt(-63.23332568,-67.5, aDate));
		pts3.add(new GPXtrkpt(-77.31223142,144.84375, aDate));
		pts3.add(new GPXtrkpt(-73.6273994,-18.28125, aDate));
		pts3.add(new GPXtrkpt(-49.382009544,-56.953125, aDate));
		pts3.add(new GPXtrkpt(-16.63639765,62.578125, aDate));
		pts3.add(new GPXtrkpt(28.92162129,-177.1875, aDate));
		pts3.add(new GPXtrkpt(13.239986312,-90.703125, aDate));
		pts3.add(new GPXtrkpt(-3.513440032,161.71875, aDate));
		pts3.add(new GPXtrkpt(48.45830866,-136.40625, aDate));
		pts3.add(new GPXtrkpt(60.58695869,78.75, aDate));
		pts3.add(new GPXtrkpt(80.297974,-11.953125, aDate));
		pts3.add(new GPXtrkpt(75.40886455,-35.15625, aDate));
		pts3.add(new GPXtrkpt(73.32780696,-110.0390625, aDate));
		pts3.add(new GPXtrkpt(44.96473101,-7.3828125, aDate));
		pts3.add(new GPXtrkpt(34.45222654,47.109375, aDate));
		pts3.add(new GPXtrkpt(41.37680233,19.248046875, aDate));
		pts3.add(new GPXtrkpt(47.635764854,-8.61328125, aDate));
		// From a calculation done here:
		// https://docs.google.com/spreadsheet/ccc?key=0AggpMwEqzvVzdHZENjdOUWE0NWhPQkRHR3ZYSDhocEE
		// the total distance traveled over these points should be 3496.04738184403
		// because of rounding errors, lets hope that it stays within at least a +/- .99
		
		GPXtrkseg seg1 = new GPXtrkseg(pts1);
		GPXtrkseg seg2 = new GPXtrkseg(pts2);
		GPXtrkseg seg3 = new GPXtrkseg(pts3);
		
		ArrayList<GPXtrkseg> segs_1 = new ArrayList<GPXtrkseg>();
		segs_1.add(seg1);
		
		ArrayList<GPXtrkseg> segs_12 = new ArrayList<GPXtrkseg>();
		segs_12.add(seg1);
		segs_12.add(seg2);
		
		ArrayList<GPXtrkseg> segs_3 = new ArrayList<GPXtrkseg>();
		segs_3.add(seg3);
		
		segs_23 = new ArrayList<GPXtrkseg>();
		segs_23.add(seg2);
		segs_23.add(seg3);
				
		_trk_1 = new GPXtrk("trk_1", segs_1);
		_trk_12 = new GPXtrk("trk_12", segs_12);
		_trk_3 = new GPXtrk("trk_3", segs_3);
	}

	@Test
	public void testTrk_1() {
		double dist = GPXcalculator.calculateDistanceTraveled(_trk_1);
		assertEquals(3, dist, 0);
	}
	
	@Test
	public void testTrk_12() {
		double dist = GPXcalculator.calculateDistanceTraveled(_trk_12);
		assertEquals(6, dist, 0);
	}
	
	@Test
	public void testTrk_3_11() {
		assertEquals(3496.04738184403, GPXcalculator.calculateDistanceTraveled(_trk_3), 0.00000000001);
	}
	@Test
	public void testTrk_3_10() {
		assertEquals(3496.04738184403, GPXcalculator.calculateDistanceTraveled(_trk_3), 0.0000000001);
	}
	@Test
	public void testTrk_3_9() {
		assertEquals(3496.04738184403, GPXcalculator.calculateDistanceTraveled(_trk_3), 0.000000001);
	}
	@Test
	public void testTrk_3_8() {
		assertEquals(3496.04738184403, GPXcalculator.calculateDistanceTraveled(_trk_3), 0.00000001);
	}
	@Test
	public void testTrk_3_7() {
		assertEquals(3496.04738184403, GPXcalculator.calculateDistanceTraveled(_trk_3), 0.0000001);
	}
	@Test
	public void testTrk_3_6() {
		assertEquals(3496.04738184403, GPXcalculator.calculateDistanceTraveled(_trk_3), 0.000001);
	}
	@Test
	public void testTrk_3_5() {
		assertEquals(3496.04738184403, GPXcalculator.calculateDistanceTraveled(_trk_3), 0.00001);
	}
	@Test
	public void testTrk_3_4() {
		assertEquals(3496.04738184403, GPXcalculator.calculateDistanceTraveled(_trk_3), 0.0001);
	}
	@Test
	public void testTrk_3_3() {
		assertEquals(3496.04738184403, GPXcalculator.calculateDistanceTraveled(_trk_3), 0.001);
	}
	@Test
	public void testTrk_3_2() {
		assertEquals(3496.04738184403, GPXcalculator.calculateDistanceTraveled(_trk_3), 0.01);
	}
	@Test
	public void testTrk_3_1() {
		assertEquals(3496.04738184403, GPXcalculator.calculateDistanceTraveled(_trk_3), 0.1);
	}
	@Test
	public void testTrk_3_0() {
		assertEquals(3496.04738184403, GPXcalculator.calculateDistanceTraveled(_trk_3), 1.0);
	}
	@Test
	public void testTrk_3_m10() {
		assertEquals(3496.04738184403, GPXcalculator.calculateDistanceTraveled(_trk_3), 10.0);
	}
	@Test
	public void testTrk_3_m100() {
		assertEquals(3496.04738184403, GPXcalculator.calculateDistanceTraveled(_trk_3), 100.0);
	}
	
	

}
