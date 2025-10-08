import java.io.*;
import java.util.Arrays;

public class PetStreamUtil {
    // Запись в байтовый поток
    public static void output(Pet pet, OutputStream out) throws IOException {
        pet.output(out);
    }

    // Чтение из байтового потока
    public static Pet input(InputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(in);
        return (Pet) objectInputStream.readObject();
    }
    // Запись данных в символьный поток
    public static void write(Pet pet, Writer out) throws IOException {
        pet.write(out);
    }
    // Чтение из символьного потока
    public static Pet read(Reader in) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(in);
        String line = bufferedReader.readLine();
        String[] parts = line.split(" ");
        // Создаем объект Parrot или Fish, в зависимости от данных
        return new Parrot(Integer.parseInt(parts[0]), parts[1], Arrays.copyOfRange(parts, 2, parts.length)); //преобраз в интовые значения
    }
}
