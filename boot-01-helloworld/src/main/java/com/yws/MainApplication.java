package com.yws;

import ch.qos.logback.core.db.DBHelper;
import com.yws.bean.Pet;
import com.yws.bean.User;
import com.yws.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 主程序类；主配置类
 * @SpringBootApplication ：这是一个SpringBoot应用
 */
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        //1.返回我们的IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
//
//        //2.查看容器里面的组件
//        String[] beanDefinitionNames = run.getBeanDefinitionNames();
//
//        for(String name : beanDefinitionNames) {
//            System.out.println(name);
//        }
//
//        //3.从容器中获取组件
//        Runnable runnable01 = run.getBean("runnable", Runnable.class);
//        Runnable runnable02 = run.getBean("runnable",  Runnable.class);
//        System.out.println("组件：" + (runnable01 == runnable02));
//
//        //4.com.yws.config.MyConfig$$EnhancerBySpringCGLIB$$3e31a857@6622a690
//        MyConfig bean = run.getBean(MyConfig.class);
//        System.out.println(bean);
//
//        //如果 @Configuration(proxyBean=true) 代理对象调用方法。SpringBoot总会检查这个组件是否在容器里。
//        //保存组件单实例
//        User user01 = bean.user01();
//        User user02 = bean.user01();
//        System.out.println(user01 == user02);
//
//
//        //组件依赖 与 @Configuration(proxyBeanMethods = false) 作用
//        User user = run.getBean("user01", User.class);
//        Pet pet = run.getBean("pet01", Pet.class);
//        System.out.println("用户的宠物是不是同一只：" + (user.getPet() == pet));
//
//        System.out.println("=======");
//        //5.获取组件
//        String[] beanNamesForType = run.getBeanNamesForType(User.class);
//        for (String s : beanNamesForType) {
//            System.out.println(s);
//        }
//
//        System.out.println(run.getBean(DBHelper.class));


        //5.
        boolean user01Exist = run.containsBean("user01");
        System.out.println("容器中user01组件是否存在：" + user01Exist);

        boolean pet01Exist = run.containsBean("tom22");
        System.out.println("容器中pet01组件是否存在：" + pet01Exist);


    }
}
