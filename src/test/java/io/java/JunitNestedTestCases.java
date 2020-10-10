package io.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/* @auther Neelesh Jaiswal
 * 
 * Nested will group all the test methods in one entry on junit report
 * if any of the test cases get failed then the grouped test considered as failed as whole
 * also if the test cases get expanded then it show individual test execution result
 * 
 * */

@TestInstance(Lifecycle.PER_CLASS)
@Nested
@DisplayName("Nested test cases")
class JunitNestedTestCases {
	
	MathUtils mathUtils;
	
	@BeforeEach
	void init() {
		System.out.println("Initialized.....");
		mathUtils = new MathUtils();
	}

	//---------Nested test classes---------------
	
	@Test
	@DisplayName("Testing add method for positive")
	void testAddPositive() {
		
		assertEquals(2, mathUtils.add(1, 1), "should add 2 numbers");
	}
	
	@Test
	@DisplayName("Testing add method for negative")
	void testAddNegative() {
		
		assertEquals(-2, mathUtils.add(-1, -1), "should add 2 numbers");
	}

//	@Test
//	void testComputeCircleArea() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testDivide() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testMultiply() {
//		fail("Not yet implemented");
//	}

}
