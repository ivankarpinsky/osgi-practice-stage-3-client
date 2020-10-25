package client;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.osgi.service.component.ComponentContext;

import service.Affable;

@Component(enabled=true)
@Reference(
        referenceInterface = service.Affable.class,
        name = "hello",
        bind = "bind",
        unbind = "unbind"
)

public class Main {
    private Affable hello;

    @Activate
    protected void activate(ComponentContext context) {
//        this.hello = (Affable)context.locateService("hello");
//        System.out.println("Main activated");
        this.hello.Greeting();
    }

    protected void bind(Affable hello) {
        this.hello = hello;
    }

    protected void unbind(Affable hello) {
        this.hello = null;
    }
}
