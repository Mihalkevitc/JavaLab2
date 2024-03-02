package lab7.Most;

public class Main
{
    public static void main(String[] args)
    {
        Implementor concreteImplementor = new ConcreteImplementor();
        Abstraction refinedAbstraction = new RefinedAbstraction(concreteImplementor);

        refinedAbstraction.operation();
    }
}
