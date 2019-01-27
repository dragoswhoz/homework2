package tema_19_01.test;

import tema_19_01.*;

import static org.junit.Assert.*;

import org.junit.*;

public class TestHomework {
	private MatricePatratica testMatrix;
	private MethodsOnStrings testString = new MethodsOnStrings("Scoala informala de it");
	
	@Before
	public void setUp() {
		int n = 5;
		testMatrix = new MatricePatratica(n,1);
		
		
	}
	
	
/*	@Test
	public void printElementsOnFirstLineTest() {
		
		
	}*/
	
	@Test
	public void calculateSumOfMainDiagonalTest() {
		int result = testMatrix.calculateSumOfMainDiagonal();
		assertEquals(65, result, 0.0);
		
	}
	
	@Test
	public void calculateSumOfSecondaryDiagonalTest() {
		int result = testMatrix.calculateSumOfSecondaryDiagonal();
		assertEquals(65, result, 0.0);
	}
	
	@Test
	public void printElementsOnLineTest() {
		String result = testMatrix.printElementsOnLine(1);
		assertEquals("[1, 2, 3, 4, 5]", result);
	}
	
	@Test
	public void getMaxOnMainDiagonalTest() {
		int result = testMatrix.getMaxOnMainDiagonal();
		assertEquals(25, result);
	}
	
	@Test
	public void getMaxOnSecondaryDiagonalTest() {
		int result = testMatrix.getMaxOnSecondaryDiagonal();
		assertEquals(21, result, 0.0);
	}
	
	@Test
	public void indexOfTest() {
		int result = testString.indexOf('o');
		assertEquals(2, result, 0.0);
		
	}
	@Test
	public void indexOfTest1() {
		int result = testString.indexOf('a');
		assertEquals(3, result); // era ok asa pentru compararea a doua nre intregi
		
	}
	
	@Test
	public void isPalindromeTest() {
		boolean result = testString.isPalindrome("Buub");
		assertEquals(true, result);
				
	}
	

}
