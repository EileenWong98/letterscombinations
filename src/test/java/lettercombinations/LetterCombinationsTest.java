package lettercombinations;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.eileen.lettercombinations.utils.LetterCombination;

public class LetterCombinationsTest {
	
	LetterCombination letterCombinationUtil;
	
	@Before
	public void initLetterCombinationUtil() {
		letterCombinationUtil = new LetterCombination();
	}
	
	//input only has one digit
	//the digit is not mapping to an empty string.
	@Test
	public void testLetterCombinations01() {
		int[] input= {1};
		String result = letterCombinationUtil.combination(input);
		Assert.assertEquals("", result);
	}
	
	//input only has one digit.
	//the digit is mapping to an empty string.
	@Test
	public void testLetterCombinations02() {
		int[] input= {9};
		String result = letterCombinationUtil.combination(input);
		Assert.assertEquals("w x y z", result);
	}
	
	//input has two digits.
	//the first digit is not mapping to an empty string.
	//the second digit is also not mapping to an empty string.
	@Test
	public void testLetterCombinations03() {
		int[] input= {2,3};
		String result = letterCombinationUtil.combination(input);
		Assert.assertEquals("ad ae af bd be bf cd ce cf", result);
	}
	
	//input has two digits.
	//the first digit is not mapping to an empty string.
	//but the second digit is mapping to an empty string.
	@Test
	public void testLetterCombinations04() {
		int[] input= {2,1};
		String result = letterCombinationUtil.combination(input);
		Assert.assertEquals("a b c", result);
	}
	
	//input has two digits.
	//the first digit is mapping to an empty string.
	//but the second digit is not mapping to an empty string.
	@Test
	public void testLetterCombinations05() {
		int[] input= {1,2};
		String result = letterCombinationUtil.combination(input);
		Assert.assertEquals("a b c", result);
	}
	
	//input has two digits.
	//both the first digit and the second digit are mapping to an empty string.
	@Test
	public void testLetterCombinations06() {
		int[] input= {1,0};
		String result = letterCombinationUtil.combination(input);
		Assert.assertEquals("", result);
	}

}
