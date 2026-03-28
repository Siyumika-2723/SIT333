package sit707_tasks;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author Ahsan Habib
 */
public class DateUtilTest {
	
	@Test
	public void testStudentIdentity() {
		String studentId = "s225520039";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Siyumika";
		Assert.assertNotNull("Student name is null", studentName);
	}

	@Test
	public void testMaxJanuary31ShouldIncrementToFebruary1() {
		// January max boundary area: max+1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldIncrementToFebruary1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
	}
	
	@Test
	public void testMaxJanuary31ShouldDecrementToJanuary30() {
		// January max boundary area: max-1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldDecrementToJanuary30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
	}
	
	@Test
	public void testNominalJanuary() {
		int rand_day_1_to_31 = 1 + new Random().nextInt(31);
        DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
        System.out.println("testJanuaryNominal > " + date);
        date.increment();
        System.out.println(date);
	}
	
	/*
	 * Complete below test cases.
	 */
	
	
	@Test(expected = RuntimeException.class)
	public void testInvalidDateJune31() {
	    new DateUtil(31, 6, 2024); 
	}
	
	// 1B: June 1 → next = June 2
	@Test
	public void testCase1B() {
	    DateUtil date = new DateUtil(1, 6, 1994);
	    date.increment();
	    Assert.assertEquals(2, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	}

	// 2B: June 2 → next = June 3
	@Test
	public void testCase2B() {
	    DateUtil date = new DateUtil(2, 6, 1994);
	    date.increment();
	    Assert.assertEquals(3, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	}

	// 3B: June 15 → next = June 16
	@Test
	public void testCase3B() {
	    DateUtil date = new DateUtil(15, 6, 1994);
	    date.increment();
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	}

	// 4B: June 30 → next = July 1
	@Test
	public void testCase4B() {
	    DateUtil date = new DateUtil(30, 6, 1994);
	    date.increment();
	    Assert.assertEquals(1, date.getDay());
	    Assert.assertEquals(7, date.getMonth());
	}

	// 5B: June 31 → Invalid Date
	@Test(expected = RuntimeException.class)
	public void testCase5B() {
	    new DateUtil(31, 6, 1994);
	}

	// 6B: Jan 15 → next = Jan 16
	@Test
	public void testCase6B() {
	    DateUtil date = new DateUtil(15, 1, 1994);
	    date.increment();
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(1, date.getMonth());
	}

	// 7B: Feb 15 → next = Feb 16
	@Test
	public void testCase7B() {
	    DateUtil date = new DateUtil(15, 2, 1994);
	    date.increment();
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(2, date.getMonth());
	}

	// 8B: Nov 15 → next = Nov 16
	@Test
	public void testCase8B() {
	    DateUtil date = new DateUtil(15, 11, 1994);
	    date.increment();
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(11, date.getMonth());
	}

	// 9B: Dec 15 → next = Dec 16
	@Test
	public void testCase9B() {
	    DateUtil date = new DateUtil(15, 12, 1994);
	    date.increment();
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(12, date.getMonth());
	}

	// 10B: June 15, 1700 → next = June 16, 1700
	@Test
	public void testCase10B() {
	    DateUtil date = new DateUtil(15, 6, 1700);
	    date.increment();
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	}

	// 11B: June 15, 1701 → next = June 16, 1701
	@Test
	public void testCase11B() {
	    DateUtil date = new DateUtil(15, 6, 1701);
	    date.increment();
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	}

	// 12B: June 15, 2023 → next = June 16, 2023
	@Test
	public void testCase12B() {
	    DateUtil date = new DateUtil(15, 6, 2023);
	    date.increment();
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	}

	// 13B: June 15, 2024 → next = June 16, 2024
	@Test
	public void testCase13B() {
	    DateUtil date = new DateUtil(15, 6, 2024);
	    date.increment();
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	}
}
