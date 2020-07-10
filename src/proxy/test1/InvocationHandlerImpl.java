package proxy.test1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class InvocationHandlerImpl implements InvocationHandler {
    private Object subject;

    public InvocationHandlerImpl(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用前");
        System.out.println("Method:" + method);
        Object returnValue = method.invoke(subject, args);
        System.out.println("调用前");
        return returnValue;
    }
}
