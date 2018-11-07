package junit4;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.*;

public class AssertionsTest {
	@Test public void assertEqualsTest(){
		Object obj = "value";
		String str = "value";
		int   a = 1;
		float b = 1;
		
		// Success
		assertEquals("다형성" , obj, str);
		assertEquals("실수 정수 값 비교" , a, b, 0); // 숫자 자료형 단정문 assertEquals(기대 값, 비교 값, 오차범위);
	
		// failure
		//assertEquals("다른 정수 값 비교" , 2, a, 0); // java.lang.AssertionError: 실수 정수 값 비교 expected:<2.0> but was:<1.0>
	}
	
	@Test public void assertArrayEqualsTest(){
		Object[] ObjA = new Object[4];
		String[] ObjB = new String[4];
		String[] ObjC = new String[4];
		String[] ObjSize3 = new String[3];
		Object[] ObjValue = new String[]{"a","a","a","a"};
		
		// Success
		assertArrayEquals("다형성 ", ObjA, ObjB);
		assertArrayEquals("같은 자료형 배열", ObjB, ObjC);

		// failure
		//assertArrayEquals("크기가 다른 배열", ObjB, ObjSize3); 	// 크기가 다른 배열: array lengths differed, expected.length=4 actual.length=3
		//assertArrayEquals("다른 값 배열", ObjB, ObjValue);   	// 다른 값 배열: arrays first differed at element [0]; expected:<null> but was:<a>
	}
	
	
	@Test public void assertTrueFalseTest(){
		boolean flagA = true;
		boolean flagB = false;
		
		assertTrue("조건이 true인지 가정한다.", flagA);
		assertFalse("조건이 false인지 가정한다.", flagB);
	}
	
	@Test public void assertSameNotSameTest(){
		boolean flagA = true;
		boolean[] ObjFlagA = new boolean[] {true, true, false, false};
		
		assertSame("두 객체가 동일한 객체를 참조하는지 가정한다.", flagA, ObjFlagA[0]);
		assertNotSame("두 객체가 동일하지 않는 객체를 참조하는지 가정한다.", flagA, ObjFlagA[3]);
	}
	
	@Test public void assertNullNotNullTest(){
		boolean[] ObjFlagA = new boolean[] {true, true, false, false};
		boolean[] ObjFlagB = null;
		
		assertNull("객체가 null임을 가정한다.", ObjFlagB);
		assertNotNull("객체가 null이 아님을 가정한다.", ObjFlagA);
	}
	
	@Test public void assertThatTest(){
		boolean flagA = true;
		assertThat("기대 값과 비교로직이 담긴 Matcher를 동일하다고 가정한다.", flagA, is(true));
	}
	
	@Test public void failTest(){
		//failure
		//fail("강제로 테스트를 실패한다.");
	}
}
