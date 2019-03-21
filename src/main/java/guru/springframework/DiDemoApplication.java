package guru.springframework;

import guru.springframework.controllers.ConstructorInjectedController;
import guru.springframework.controllers.GetterInjectedController;
import guru.springframework.controllers.MyController;
import guru.springframework.controllers.PropertyInjectedController;
import guru.springframework.examplebeans.FakeDataSource;
import guru.springframework.examplebeans.FakeJmsBroker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"guru.springframework.services", "guru.springframework"})
public class DiDemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);

		MyController controller = (MyController) ctx.getBean("myController");

		/*System.out.println(controller.hello());
		System.out.println(ctx.getBean(PropertyInjectedController.class).sayHello());
		System.out.println(ctx.getBean(GetterInjectedController.class).sayHello());
		System.out.println(ctx.getBean(ConstructorInjectedController.class).sayHello());*/

		FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);

		System.out.println("UserName : "+fakeDataSource.getUserName());
		System.out.println("Password : "+fakeDataSource.getPwd());
		System.out.println("DbUrl : "+fakeDataSource.getDbUrl());

		FakeJmsBroker fakeJmsBroker = ctx.getBean(FakeJmsBroker.class);
        System.out.println("Jms UserName : "+fakeJmsBroker.getUserName());
        System.out.println("Jms Password : "+fakeJmsBroker.getPassword());
        System.out.println("Jms DbUrl : "+fakeJmsBroker.getUrl());
	}
}
