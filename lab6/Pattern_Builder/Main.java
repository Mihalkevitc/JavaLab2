package lab6.Pattern_Builder;

public class Main
{
    public static void main(String[] args)
    {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);

        director.construct();

        String result = ((ConcreteBuilder) builder).getResult();
        System.out.println("Result: " + result);
    }
}