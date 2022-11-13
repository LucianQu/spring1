import org.example.ls1.SomeService;
import org.example.ls1.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ls1MyTest {
    //使用构造方法创建对象
    @Test
    public void test01() {
        SomeService someService = new SomeServiceImpl() ;
        someService.doSome();
    }

    //使用spring容器创建的对象，繁琐，刚学的时候这样用
    @Test
    public void test02() {
        //1、指定spring配置文件的名称
        String config = "Ls1/Ls1Beans.xml";
        //2、创建表示spring容器的对象，ApplicationContext ;
        //ApplicationContext就是表示Spring容器，通过容器获取对象，它是接口，实现类用 ClassPathXmlApplicationContext实现类
        //ClassPathXmlApplicationContext:表示从类路径中加载spring的配置文件,从target->classes加载
        ApplicationContext ac = new ClassPathXmlApplicationContext(config) ; //配置文件路径

        //从容器中获取某个对象，调用容器方法
        //getBean(配置文件中bean对象的id值）
        SomeService someService = (SomeService) ac.getBean("someService");//容器帮你创建，直接拿，然后用
        someService.doSome();

    }
}
