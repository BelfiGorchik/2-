import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.Writer;

public class Fish implements Pet, Serializable {
    int age = 5;
    String name = "Барсик";
    String[] food = { "Вискас", "Молоко" };

    public Fish() {
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return this.name;
    }

    public String getFood(int ind) {
        return this.food[ind];
    }

    public String eatFood(int ind) {
        return "Еда " + this.name + "а: " + this.food[ind];
    }

    public Fish(int a, String n, String[] f) {
        this.age = a;
        this.name = n;
        this.food = f;
    }

    public void age(int a) {
        System.out.println(this.age);
    }

    public void name(String n) {
        System.out.println(this.name);
    }

    public void foodK(int index) {
        System.out.println(this.food[index]);
    }

    public String toString() {
        return "рыбу зовут: " + name;
    }

    public boolean equals(Object obj) {
        Fish otherFish = (Fish) obj;
        if (this.age == otherFish.age) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int h1 = 1;
        h1 = 31 * h1 + ((name == null) ? 0 : name.hashCode());
        h1 = 31 * h1 + age;
        h1 = 31 * h1 + ((name == null) ? 0 : name.hashCode());
        return h1;
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