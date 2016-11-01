package common;

/**
 *
 * @author Instlogin
 */
public class Dog {
    private String name;
    private int age;
    private String rabiesId;

    public Dog(String name, int age, String rabiesId) {
        this.name = name;
        this.age = age;
        this.rabiesId = rabiesId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRabiesId() {
        return rabiesId;
    }

    public void setRabiesId(String rabiesId) {
        this.rabiesId = rabiesId;
    }

    @Override
    public String toString() {
        return "Dog{" + "name=" + name + ", age=" + age + ", rabiesId=" + rabiesId + '}';
    }

    
}
