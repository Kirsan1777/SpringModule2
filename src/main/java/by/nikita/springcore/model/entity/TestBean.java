package by.nikita.springcore.model.entity;

public class TestBean {
    private String name;

    public TestBean(String name) {
        this.name = name;
    }

    public TestBean(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "name='" + name + '\'' +
                '}';
    }
}
