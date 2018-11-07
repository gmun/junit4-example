package junit4.rules;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class CustomRule implements TestRule{

	String annotation;
	
	public CustomRule(String annotation){
		this.annotation = annotation;
	}
	
	@Override
	public Statement apply(final Statement testMethods, Description description) {
		return new Statement() {

			@Override
			public void evaluate() throws Throwable {
				
				System.out.print(startRules(annotation)); //code here executes before test runs
				
				testMethods.evaluate(); // test가 실행되는 지점 (@Test)
				
				System.out.print(endRules(annotation)); //code here executes after test is finished
			}
		};
	}
	
	private String startRules(String annotation){
		String str = "";
		if(annotation.equals("@Rule")){
			str = "> start testMethod : " + annotation;
		}else{
			str = annotation + "\n";
		}
		return str;
	}
	
	private String endRules(String annotation){
		String str = "";
		if(annotation.equals("@Rule")){
			str = " > " + annotation + " : end \n";
		}else{
			str = annotation + "\n";
		}
		return str;
	}

}
