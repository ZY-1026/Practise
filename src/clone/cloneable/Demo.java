package clone.cloneable;

public class Demo implements Cloneable {
    private String name;
    private String value;
    private DemoInternal demoInternal;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public DemoInternal getDemoInternal() {
        return demoInternal;
    }

    public void setDemoInternal(DemoInternal demoInternal) {
        this.demoInternal = demoInternal;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Demo demo = null;
        demo = (Demo) super.clone();
        demo.demoInternal = (DemoInternal) demoInternal.clone();
        return demo;
    }
}
