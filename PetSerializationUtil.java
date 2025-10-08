import java.io.*;

public class PetSerializationUtil {
    // Запись сериализованного объекта
    public static void serialize(Pet pet, OutputStream out) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
        objectOutputStream.writeObject(pet);
    }

    // Чтение десериализованного объекта
    public static Pet deserialize(InputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(in);
        return (Pet) objectInputStream.readObject();
    }
}
