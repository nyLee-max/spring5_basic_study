package spring5_basic_study;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		try(AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(AppContext.class);){
			Greeter g1 = ctx.getBean("greeter", Greeter.class);
			Greeter g2 = ctx.getBean("greeter", Greeter.class);
			
			System.out.printf("(g1==g2) = %s%n", g1==g2);
		
			String msg = g1.greet("스프링5");
			
			System.out.println(msg);
			ctx.close();
			
		}
	}
}
