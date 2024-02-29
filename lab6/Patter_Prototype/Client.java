package lab6.Patter_Prototype;

public class Client
{
    void Operation()
    {
        Prototype prototype = new ConcretePrototype1();
        Prototype clone = prototype.clone();
        System.out.println("Cloned prototype1: " + clone);
        prototype = new ConcretePrototype2();
        clone = prototype.clone();
        System.out.println("Cloned prototype2: " + clone);
    }
}