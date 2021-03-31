package service;


import com.yws.bean.HelloProperties;
import org.springframework.beans.factory.annotation.Autowired;

public class HelloService {
    @Autowired
    private HelloProperties helloProperties;

    public String sayHello(String name) {
        return helloProperties.getPrefix() + name + helloProperties.getSuffix();
    }
}
