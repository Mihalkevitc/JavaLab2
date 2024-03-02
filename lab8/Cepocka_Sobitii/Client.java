package lab8.Cepocka_Sobitii;

// Класс Client
public class Client
{
    void Operation(int[] requests){
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();

        handler1.setNextHandler(handler2);

        for (int request : requests)
        {
            System.out.println("Sending request: " + request);
            handler1.handleRequest(request);
        }
    }
}
