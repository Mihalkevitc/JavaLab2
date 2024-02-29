package lab6.AbstructFabric;

// Класс Client, использующий абстрактную фабрику
public class Client
{
    private AbstractFactory factory;

    public Client(AbstractFactory factory)
    {
        this.factory = factory;
    }

    public void useProducts()
    {
        AbstractProduct productA = factory.createProductA();
        AbstractProduct productB = factory.createProductB();

        productA.doSomething();
        productB.doSomething();
    }

    public static void main(String[] args)
    {
        AbstractFactory factory = new ConcreteFactory();
        Client client = new Client(factory);
        client.useProducts();
    }
}
