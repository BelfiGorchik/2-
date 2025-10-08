import java.io.*;

public class Parrot implements Pet, Serializable {
    private int age = 0;
    private String name = "попугай";
    private String[] food = { "Корм", "Мясо" };;

    public Parrot(int age, String name, String[] food) {
        this.age = age;
        this.name = name;
        this.food = food;
    }

    public String getFood(int index) {
        return this.food[index];
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    public String eatFood(int index) throws Exception {
        try {
            if (age > 25) {
                throw new Exception("попугаи столько не живут");
            }
            return this.name + " съел " + this.food[index];
        } catch (NullPointerException e) {
            return e.getMessage();
        }
    }

    public String toString() {
        return "попугай по имени " + getName();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return false;
    }

    public int hashCode() {

        int res = 1;
        res = 31 * res + ((name == null) ? 0 : name.hashCode());
        res = 31 * res + age;
        res = 31 * res + ((name == null) ? 0 : name.hashCode());

        return res;
    }

    @Override
    public void output(OutputStream out) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
        objectOutputStream.writeObject(this);
    }

    @Override
    public void write(Writer out) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(out);
        bufferedWriter.write(this.getAge() + " " + this.getName() + " " + String.join(" ", this.food));
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }
}