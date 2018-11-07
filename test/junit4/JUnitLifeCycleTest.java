package junit4;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import junit4.rules.CustomRule;

public class JUnitLifeCycleTest {

	@ClassRule public static CustomRule classRule = new CustomRule("@ClassRule");
	@Rule public CustomRule rule = new CustomRule("@Rule");

	// @BeforeClass 단 한번만 실행된다. 보통 DB연결을 할때 쓰인다.
	@BeforeClass public static void beforeClass(){
		System.out.println("@BeforeClass");
	}

	// @Before 테스트 환경 구성 (입력 데이터 초깃값, 클래스 초기화를 사용하는데 사용된다.) 
	@Before public void before(){
		System.out.print(" > @Before "); 
	}

	// 해당 메소드를 Test 메소드로 인식
	@Test public void testMethod1(){ 
		System.out.print(" > @Test test1 ");
	}

	// 해당 메소드를 Test 메소드로 인식
	@Test  public void testMethod2(){ 
		System.out.print(" > @Test test2 "); 
	}

	// @Ignore, @Ignore("ignore Test") Test 제외 시킨 이유를 정의 할 수 있다.
	@Ignore("ignore Test")
	@Test public void testMethod3(){ 
		System.out.print(" > @Ignore "); 
	}
	
	// @After 테스트 환경 정리(임시 데이터 삭제, 기본값 복원, 비싼 메모리 구조를 정리하여 메모리 절약 등)
	@After public void after(){ 
		System.out.print(" > @After "); 
	}
	
	// @AfterClass 단 한번만 실행된다. 정리 작업을 수행하는 데 사용된다.(보통 DB 연결을 끊을때 쓰인다.)
	@AfterClass public static void afterClass(){ 
		System.out.println("@AfterClass"); 
	}
}
