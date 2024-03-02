package lab7.Adapter;

// Client class
public class Client
{
    void Operation()
    {
        Adaptee adaptee = new Adaptee();
        Target adapter = new Adapter(adaptee);
        adapter.request();
    }

}

