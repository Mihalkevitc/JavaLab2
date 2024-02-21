package lab3;

import java.util.*;

public class SemaphoreListTest
{
    public static void main(String[] args)
    {
        SemaphoreList<Integer> list = new SemaphoreList<>();
        // Создание списка потоков
        List<Thread> threads = new ArrayList<>();

        // Цикл для каждого потока
        for (int i = 0; i < 5; i++)
        {
            Thread thread = new Thread(() -> {
                // Цикл итераций добавления и удаления элементов из списка
                for (int j = 0; j < 5; j++)
                {
                    // Добавление случайного целого числа в список
                    int value = (int) (Math.random() * 100);
                    list.add(value);

                    // Удаление случайного целого числа из списка
                    int index = (int) (Math.random() * list.size());
                    list.remove(index);
                }
            });
            threads.add(thread);
            thread.start();
        }

        // Ожидание завершения всех потоков
        for (Thread thread : threads)
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
        if (list.isEmpty())
        {
            System.out.println("Список пуст. Все элементы были успешно добавлены и удалены.");
        }
        else
        {
            System.out.println("Список не пуст. Что-то пошло не так.");
        }
    }
}
