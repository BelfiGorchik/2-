import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class laba3 {
    public static void main(String[] args) {
        // Кошки
        String[] foodForFish = { "Похлебка", "Корм", "Кости" };
        Fish petFish = new Fish();

        System.out.println("Возраст рыбы: "+petFish.getAge());
        System.out.println("Имя рыбы: "+petFish.getName());
        System.out.println(petFish.getFood(0));
        System.out.println(petFish.getFood(1));

        Fish petFish1 = new Fish(4, "Клубок", foodForFish);

        System.out.println("\nКонструктор: ");

        petFish1.getAge();
        petFish1.getName();
        petFish1.getFood(0);
        petFish1.getFood(1);

        System.out.println("\ntoString "+petFish);
        System.out.println("equals() Возраст: " + petFish.equals(petFish));
        System.out.println("equals() Возраст: " + petFish.equals(petFish1));

        System.out.println("hashCode: " + petFish.hashCode());
        System.out.println("\t  " + petFish1.hashCode());

        String[] foodForSharik = { "Колбаса", "Кошка", "Мясо" };

        Parrot Sharik = new Parrot(6, "Шарик", foodForSharik);
        Parrot SharikCopy = Sharik;

        System.out.println("Проверка методов конструктора");
        System.out.println("Возраст Шарика: " + Sharik.getAge());
        System.out.println("Имя Шарика: " + Sharik.getName());
        System.out.println("еда Шарика: " + Sharik.getFood(1));
        System.out.println("еда Шарика: " + Sharik.getFood(0));
        System.out.println("еда Шарика: " + Sharik.getFood(2));
        
        try {
            System.out.println(Sharik.eatFood(2));
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Проверка методов toString, equals, hashCode: ");
        System.out.println("toString: " + Sharik);
        System.out.println("equals:");
        System.out.println(Sharik.equals(SharikCopy));
        System.out.println("hashCode:");
        System.out.println(Sharik.hashCode());



        Pet[] arr = {new Fish(4, "Клубок", foodForFish), new Parrot(99, "Barsik", foodForSharik), new Fish(13, "Murz", foodForFish), new Parrot(15, "Warik", foodForSharik), new Fish(4, "Клубок", foodForFish), new Parrot(4, "Barsik", foodForSharik), new Fish(13, "Murz", foodForFish), new Parrot(15, "Warik", foodForSharik)};
        List<Pet> newPets = new ArrayList<Pet>();

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println();

        // найти в массиве объекты, функциональный метод которых возвращают одинаковый результат, поместить такие объекты в другой массив

        try {
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length - 1; j++) {
                        if(arr[i].eatFood(0).equals(arr[j].eatFood(0))) {
                            //newPets.add(arr[i]);
                            System.out.println("1: " + arr[i].getName() + ", 2: " + arr[j].getName());
                        }
                }
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        // Массив на два массива, в которых будут храниться однотипные элементы
        System.out.println("Два массива с однотипными элементами:");

        Pet[] fishArray = new Pet[arr.length];
        Pet[] parrotArray = new Pet[arr.length];
        int fishIndex = 0;
        int parrotIndex = 0;

        for (Pet pet : arr) {
            if (pet instanceof Fish) {
                fishArray[fishIndex++] = pet;
            } else if (pet instanceof Parrot) {
                parrotArray[parrotIndex++] = pet;
            }
        }

        // Вывод массива продуктов
        System.out.println("рыбы:");
        for (int i = 0; i < fishIndex; i++) {
            System.out.println(fishArray[i]);
        }

        // Вывод массива товаров
        System.out.println("\nпопугаи:");
        for (int i = 0; i < parrotIndex; i++) {
            System.out.println(parrotArray[i]);
        

        
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // созд обьектаа ридер который позволяет читать данные
            
            // Пример работы с потоками данных
            System.out.println("Введите данные для записи в байтовый поток:");
            Pet pet = PetStreamUtil.read(reader); // выз метод рид из ч тоб прочитать даные из ридер
            ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
            PetStreamUtil.output(pet, byteOutputStream); // выз метод оутпут из класса энимал  и записать даннные в байтауттпут
            System.out.println("Данные записаны в байтовый поток: " + byteOutputStream.toString());

            // Пример сериализации
            System.out.println("Сериализуем объект...");
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            PetSerializationUtil.serialize(pet, byteStream); //вызываем метод сер чет там  из класса энималсер.. чтобв сериалищовать обтект энимал и записать его в байт стрим
            System.out.println("Объект успешно сериализован");

            // Пример десериализации
            System.out.println("Десериализуем объект...");
            ByteArrayInputStream byteInput = new ByteArrayInputStream(byteStream.toByteArray());
            Pet deserializedPet = PetSerializationUtil.deserialize(byteInput); // выз метод десер из класса чтоб десер байтинпут и получить энималюююю дес
            System.out.println("Объект успешно десериализован: " + deserializedPet);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}}