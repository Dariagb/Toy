//1) Напишите класс-конструктор у которого принимает минимум 3 строки,
//        содержащие три поля id игрушки, текстовое название и частоту выпадения
//        игрушки
//        2) Из принятой строки id и частоты выпадения(веса) заполнить минимум три
//        массива.
//        3) Используя API коллекцию: java.util.PriorityQueue добавить элементы в
//        коллекцию
//        4) Организовать общую очередь 5) Вызвать Get 10 раз и записать результат в
//        файл

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String toy1 = "1 машина 4 ";
        String toy2 = "2 мишка 2 ";
        String toy3 = "3 кукла 6 ";

        ToyQueue toyQueue = new ToyQueue(toy1, toy2, toy3);
        try {
            toyQueue.writeResultsToFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}