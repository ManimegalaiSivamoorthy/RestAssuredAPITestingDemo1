package pojo;

public class Posts {
    private Integer id;
    private String name;
    private Integer age;
    private String character;

    public Posts() {}

    public Posts(Integer id, String name, Integer age, String character) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.character = character;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
