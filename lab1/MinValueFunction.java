package lab1;

import java.util.Arrays;
import java.util.function.Function;

public class MinValueFunction implements Function<int[], String>
{
    @Override
    public String apply(int[] nums)
    {
        //Сортируем массив
        Arrays.sort(nums);

        StringBuilder result = new StringBuilder();

        result.append(nums[0]);

        for (int i = 1; i < nums.length; i++)
        {
            //Проверка на одинаковость циферек в отсортированном массиве
            if (nums[i] != nums[i - 1])
            {
                result.append(nums[i]);
            }
        }

        return result.toString();
    }

    public static void main(String[] args)
    {
        int[] numbers = {1, 3, 1, 3, 5, 7, 7};
        MinValueFunction minValueFunction = new MinValueFunction();
        String result = minValueFunction.apply(numbers);
        System.out.println(result);
    }
}
