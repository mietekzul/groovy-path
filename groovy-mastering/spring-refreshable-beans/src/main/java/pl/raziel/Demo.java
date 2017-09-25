package pl.raziel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Demo {
    public static void main(String[] args) {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext(
                        "applicationContext.xml");
        Evaluator e = (Evaluator) ctx.getBean("groovyEvaluator");
        boolean ok;

        for (int i = 0; i < 10; i++) {
            ok = e.approve(null);
            System.out.println(ok ? "approved" : "denied");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        ((ClassPathXmlApplicationContext) ctx).close();
    }
}