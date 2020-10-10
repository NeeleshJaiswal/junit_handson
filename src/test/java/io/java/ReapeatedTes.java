package io.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/* @auther Neelesh Jaiswal
 * 
 * Repeated test cases will repeat the execution the number of times provided in @Repeated(3)
 * 
 * */

@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("Nested test cases")
class ReapeatedTes {
	
	MathUtils mathUtils;
	
	@BeforeEach
	void init() {
		System.out.println("Initialized.....");
		mathUtils = new MathUtils();
	}

	//---------Repeated test classes---------------
	
	//To get hold on repetition index can us RepetitionInfo in input args
	@DisplayName("Testing add method for positive")
	@RepeatedTest(3)
	void testAddPositive() {
		
		assertEquals(2, mathUtils.add(1, 1), "should add 2 numbers");
	}
	
	//To get hold on repetition index can us RepetitionInfo in input args
		@DisplayName("Testing add method for positive")
		@RepeatedTest(3)
		void testAddPositiveRepetition(RepetitionInfo repetitionInfo) {
			System.out.println("repetition index>> "+repetitionInfo.getCurrentRepetition());
			assertEquals(2, mathUtils.add(1, 1), "should add 2 numbers");
		}
}