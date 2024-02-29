package lab6.FabricMethod;

// Класс ConcreteProduct, который реализует интерфейс Product
class ConcreteProduct implements Product
{
    @Override
    public void doSomething()
    {
        System.out.println("ConcreteProduct is doing something.");
    }
}