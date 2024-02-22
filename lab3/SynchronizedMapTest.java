package lab3;
import java.util.*;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class SynchronizedMapTest
{
    public static void main(String[] args)
    {
        SynchronizedMap<Integer, String> map = new SynchronizedMap<>();
        //Счётчик для потоков
        CountDownLatch lat1 = new CountDownLatch(3);

        // Цикл для запуска потоков
        for (int i = 0; i < 3; i++)
        {
            new Thread(() -> {
                try
                {
                    // Добавление и удаление элементов
                    for (int j = 0; j < 10; j++) {
                        map.put(j, String.valueOf(j));
                        map.remove(j);
                    }
                }
                finally
                {
                    // Уменьшаем счетчик после завершения работы потока
                    lat1.countDown();
                }
            }).start();
        }

        try
        {
            lat1.await(); // Ждём пока все потоки завершаться
            System.out.println("Проверка пройдена упешно");
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
