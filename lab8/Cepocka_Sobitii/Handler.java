package lab8.Cepocka_Sobitii;

// Интерфейс Handler
interface Handler
{
    void setNextHandler(Handler nextHandler);
    void handleRequest(int request);
}