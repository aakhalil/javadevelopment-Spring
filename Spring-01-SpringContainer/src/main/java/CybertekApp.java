import interfaces.Mentor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.FullTimeMentor;

public class CybertekApp {

    public static void main(String[] args) {

        // create a container to save the beans that come from config.xml
        ApplicationContext container = new ClassPathXmlApplicationContext("config.xml");

        // with moryphysm
        //  Mentor mentor = new FullTimeMentor();

        // we need to down cast
        Mentor mentor = (Mentor) container.getBean("fullTimeMentor");

        mentor.createAccount();

        Mentor mentor1 = (Mentor) container.getBean("partTimeMentor");
        mentor1.createAccount();

       // to create an object
        Mentor mentor2 = container.getBean("fullTimeMentor", Mentor.class);




    }
}
