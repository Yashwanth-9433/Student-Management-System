public class Student {

    private final String id;
    private String name;
    private int age;
    private String course;

    public Student(String id, String name, int age, String course) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Student ID cannot be empty.");
        }
        if (id.contains(",")) {
            throw new IllegalArgumentException("Student ID cannot contain commas.");
        }
        this.id = id.trim();
        setName(name);
        setAge(age);
        setCourse(course);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        if (!name.trim().matches("[a-zA-Z ]+")) {
            throw new IllegalArgumentException("Name must contain only letters and spaces.");
        }
        this.name = name.trim();
    }

    public void setAge(int age) {
        if (age < 5 || age > 100) {
            throw new IllegalArgumentException("Age must be between 5 and 100.");
        }
        this.age = age;
    }

    public void setCourse(String course) {
        if (course == null || course.trim().isEmpty()) {
            throw new IllegalArgumentException("Course cannot be empty.");
        }
        if (course.contains(",")) {
            throw new IllegalArgumentException("Course cannot contain commas.");
        }
        this.course = course.trim();
    }

    @Override
    public String toString() {
        return String.format("ID: %-5s | Name: %-15s | Age: %-3d | Course: %s", id, name, age, course);
    }
}