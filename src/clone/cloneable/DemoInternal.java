package clone.cloneable;

public class DemoInternal implements Cloneable {
    private String internalName;

    private String internalValue;

    public String getInternalName() {
        return internalName;
    }

    public void setInternalName(String internalName) {
        this.internalName = internalName;
    }

    public String getInternalValue() {
        return internalValue;
    }

    public void setInternalValue(String internalValue) {
        this.internalValue = internalValue;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        DemoInternal demoInternal = null;
        demoInternal = (DemoInternal) super.clone();
        return demoInternal;
    }
}
