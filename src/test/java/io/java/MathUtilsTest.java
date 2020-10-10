package io.java;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

/* @auther Neelesh Jaiswal
 * 
 * @TestInstance(TestInstance.Lifecycle.PER_METHOD) default configuration 
 * which will create new instance for every method execution
 * 
 * we can change it to 
 * @TestInstance(TestInstance.Lifecycle.PER_CLASS)
 * which create only single instance for all method execution 
 * in both the cases sequence of method execution is not defined
 * in this config @BeforeAll, @AfterAll does not require to be static
 * 
 * ----------------------------------------------------
 * 
 * 
 * */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {

	MathUtils mathUtils;

	@BeforeAll
	static void beforeAllInit() {
		System.out.println("this is before all");
	}

	@BeforeEach
	void init() {
		System.out.println("Initialized.....");
		mathUtils = new MathUtils();
	}

	@AfterEach
	void cleanup() {
		System.out.println("Cleaning up.....");
	}

	@AfterAll
	static void afterAll() {
		System.out.println("this is after all");
	}

	/*
	 * DisplayName is used to declare a custom display name for the annotated test
	 * class or test method.
	 */
	@Test
	@DisplayName("Testing add method")
	void test() {
		int expected = 2;
		int actual = mathUtils.add(1, 1);
		assertEquals(expected, actual, "Add methods should add 2 numbers");
	}

	@Test
	void test_compute_circle_area() {

		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return right circle area");

	}

	@Test
	void test_divide() {
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "divide by zero should throw");
		// assertThrows(NullPointerException.class, () -> mathUtils.divide(1, 0),
		// "divide by zero should throw");
	}

	@Test
	@Disabled
	@DisplayName("Test method implementation is in progress and disabled using @Disabled")
	void test_disable_test() {
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "divide by zero should throw");
		// assertThrows(NullPointerException.class, () -> mathUtils.divide(1, 0),
		// "divide by zero should throw");
	}

	/*
	 * condition execution
	 * to be run on specif os
	 * @EnabledOnOs(OS.LINUX)
	 * OS.(MAC,SOLARIS,WINDOWS...etc)
	 * if we choose OS.MAC then test cases will only be enable for MAC
	 * for others it will be disabled
	 * 
	 * @EnabledOnJre(JRE.JAVA_11)
	 * certain java 11 feature need to be test
	 * apart from java 11 it will be disabled for all other version
	 * 
	 * @EnabledIf
	 * @EnabledIfSystemProperty
	 * @EnabledIfEnvironmentVariable
	 */
	
	//----------assumptions---------------
	
	/* 
	 * assumeTrue()
	 * junit will assume that value inside assumeTrue(value) should be true then only test cases will be executed further
	 * 
	 */
	
	@Test
	void test_for_assumption() {
		boolean isServerUp = false;
		assumeTrue(isServerUp);
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "divide by zero should throw");
	}
	

	@Test
	@DisplayName("multiply method")
	void testMultiply() {
		assertNotNull(mathUtils.multiply(2, 2), "should not be null");
		//assertEquals(4, mathUtils.multiply(2,2), "should multiply 2 values");
		//assertAll will execute multiple assert at same time if any one of them get failed the test method will fail
		assertAll(
					() -> assertEquals(4, mathUtils.multiply(2,2), "should multiply 2 values"),
					() -> assertEquals(-4, mathUtils.multiply(2,-2), "should multiply 2 values with negative result"),
					() -> assertEquals(0, mathUtils.multiply(2,0), "should multiply 2 values with result as 0")
				);
	}
	
	
	
}
