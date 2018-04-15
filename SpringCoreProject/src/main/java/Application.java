import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.apurv.oldway.service.IMessageRenderer;


public class Application {

	public static void main(String[] args)
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		IMessageRenderer renderer =  (IMessageRenderer) ctx.getBean("renderer");
renderer.render();

	}
	
	
}
