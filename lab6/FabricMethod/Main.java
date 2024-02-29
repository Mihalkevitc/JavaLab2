package lab6.FabricMethod;

public class Main
{
    public static void main(String[] args)
    {
        Creator creator = new ConcreteCreator();
        creator.anOperation();
    }
}