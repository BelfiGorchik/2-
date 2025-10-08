import java.io.*;

public interface Pet {
    public int getAge();

    public String getFood(int index);

    public String getName();

    public String eatFood(int index) throws Exception;
    //создает два новых абстрактных метода
    void output(OutputStream out) throws IOException;
    void write(Writer out) throws IOException;
}