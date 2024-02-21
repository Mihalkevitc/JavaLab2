package lab3;
import java.util.*;
import java.util.Map;

public class SynchronizedMapTest
{
    public static void main(String[] args)
    {
        Map<Integer, Integer> map = new SynchronizedMap<>();
        // Спичок потоков чтения
        List<Thread> readerThreads = new ArrayList<>();

        // Цикл для каждого поток чтения
        for (int i = 0; i < 5; i++)
        {
            Thread thread = new Thread(() -> {
                // Цикл для итераций чтения элементов из Map
                for (int j = 0; j < 10; j++)
                {
                    int key = (int) (Math.random() * 100);
                    Integer value = map.get(key);

                    if (value == null)
                    {
                        // Печатаем ключ и значение
                        System.out.println("Поток чтения " + Thread.currentThread().getName() + " прочитал ключ " + key + " со значением " + value);
                    }
                }
            });
            readerThreads.add(thread);
            thread.start();
        }

        // Создаем список потоков записи
        List<Thread> writerThreads = new ArrayList<>();

        // Цикл для каждого потока записи
        for (int i = 0; i < 5; i++)
        {
            Thread thread = new Thread(() -> {
                // Цикл для итераций записи элементов в Map
                for (int j = 0; j < 10; j++)
                {
                    int key = (int) (Math.random() * 100);
                    int value = (int) (Math.random() * 100);

                    map.put(key, value);
                    // Печатаем ключ и значение
                    System.out.println("Поток записи " + Thread.currentThread().getName() + " записал ключ " + key + " со значением " + value);
                }
            });
            writerThreads.add(thread);
            thread.start();
        }

        // Ждем завершения всех потоков
        for (Thread thread : readerThreads)
        {
            try
            {
                thread.join();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        for (Thread thread : writerThreads)
        {
            try
            {
                thread.join();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        // Проверка
        if (map.isEmpty())
        {
            System.out.println("Map пуст. Все элементы были успешно добавлены и удалены.");
        }
        else
        {
            System.out.println("Map не пуст. Что-то пошло не так.");
        }
    }
}
