package proxy.test1;

public class RealSubject implements Subject {

    @Override
    public String sayHello(String name) {
        return "hello" + name;
    }

    @Override
    public String sayGoodbye() {
        return "good bye";
    }
}
