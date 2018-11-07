package junit4;

import org.junit.*;

/**
 * JUnit4 fixture annotation test
 * 픽스처 애노테이션에서 오브젝트를 생성하고 각 오브젝트의 해쉬코드를 출력하여 확인해보자. 
 * @BeforeClass, @Befroe 애노테이션에서 픽스처를 정의하고
 * 정의한 픽스처 ObjectA와 ObjectB의 해시코드를  @BeforeClass, @Befroe, @After, @AfterClass에서 출력하여 확인해보자. 
 * */
public class AnnotationsTest {
	private static ObjectA obj1;
	private static ObjectB obj2;
	
	@BeforeClass
	public static void beforeClass() {
		obj1 = new ObjectA();
		System.out.println("obj1 >" + obj1.hashCode() + ", obj2 >" + obj2 + " : @BeforeClass beforeClass\n");
	}
	
	@Before
	public void before() {
		obj2 = new ObjectB();
		System.out.println("obj1 >" + obj1.hashCode() + ", obj2 >" + obj2.hashCode() + " : @Before before");
	}
	
	@Test
	public void test1() {
		System.out.println("obj1 >" + obj1.hashCode() + ", obj2 >" + obj2.hashCode() + " : @Test test1");
	}
	
	@Test
	public void test2() {
		System.out.println("obj1 >" + obj1.hashCode() + ", obj2 >" + obj2.hashCode() + " : @Test test2");
	}
	
	@After
	public void after() {
		System.out.println("obj1 >" + obj1.hashCode() + ", obj2 >" + obj2.hashCode() + " : @After after\n");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("obj1 >" + obj1.hashCode() + ", obj2 >" + obj2.hashCode() + " : @AfterClass afterClass");
	}
	
	public static class ObjectA{
		public ObjectA() {
			System.out.println("ObjectA 초기화");
		}
	}
	public static class ObjectB{
		public ObjectB() {
			System.out.println("ObjectB 초기화");
		}
	}
}
