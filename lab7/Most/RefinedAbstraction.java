package lab7.Most;

// Класс RefinedAbstraction
class RefinedAbstraction extends Abstraction
{
    public RefinedAbstraction(Implementor implementor)
    {
        super(implementor);
    }

    @Override
    public void operation()
    {
        System.out.println("RefinedAbstraction's operation method is called.");
        implementor.operationImp();
    }
}