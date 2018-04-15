import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.apurv.oldway.service.IMessageRenderer;

@ComponentScan(basePackages="com.apurv.oldway.service")
@Configuration
public class Application {

	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Application.class);

		IMessageRenderer renderer =  (IMessageRenderer) ctx.getBean("renderer");
renderer.render();

	}
	
	
}
