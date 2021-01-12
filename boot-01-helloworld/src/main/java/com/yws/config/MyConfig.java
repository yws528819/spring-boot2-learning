package com.yws.config;

import ch.qos.logback.core.db.DBHelper;
import com.yws.bean.Pet;
import com.yws.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 1.配置类使用 @Bean 标注在方法上给容器注册组件，默认也是单实例的。
 * 2.配置类本身也是组件
 * 3.proxyBeanMethods：代理bean的方法
 *      Full(proxyBeanMethods = true)、
 *      Lite(proxyBeanMethods = false)
 *      组件依赖
 *
 * 4. @Import({User.class, DBHelper.class})
 *      给容器中自动创建出两个类型的组件，默认组件的名字就是全类名
 */
//@ConditionalOnBean(name = "pet01")
@ConditionalOnMissingBean(name = "pet01")
@Import({User.class, DBHelper.class})
@Configuration(proxyBeanMethods = true)  //告诉SpringBoot 这是一个配置类 == 配置文件
public class MyConfig {

    /**
     * 外部无论对注册类中的这个组件注册方法调用多少次，获取的都是之前注册容器中的单实例对象
     * @return
     */
    @Bean //给容器中添加组件。以方法名作为组件的id。返回类型就是组件的类型。返回的值，就是组件在容器中的实例。
    public Runnable runnable() {
        return ()-> {};
    }

    @Bean
    public User user01() {
        User user = new User("张三", 18);
        //user组件依赖了Pet组件
        user.setPet(pet01());
        return user;
    }

    @Bean("tom22")
    public Pet pet01() {
        return new Pet("tom");
    }


//    public static void main(String[] args) {
//        Runnable run1 = ()-> {};
//        Runnable run2 = ()-> {};
//        System.out.println(run1 == run2);
//    }
}
