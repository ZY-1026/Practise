package equalsHashcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Model {
    private String  name;
    private Map<Integer, Integer> map = new HashMap<>();
    private String age;
    private String othername;

    public Model(String name, String age, String othername) {
        super();
        this.name = name;
        this.age = age;
        this.othername = othername;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getOthername() {
        return othername;
    }

    public void setOthername(String othername) {
        this.othername = othername;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Model model = (Model) o;
        return Objects.equals(name, model.name) &&
                Objects.equals(age, model.age) &&
                Objects.equals(othername, model.othername);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, othername);
    }


} // model
