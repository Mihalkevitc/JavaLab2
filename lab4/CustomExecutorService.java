package lab4;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class CustomExecutorService implements ExecutorService
{
    private final ThreadPoolExecutor executor;
    public CustomExecutorService(int numThreads)
    {
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        this.executor = new ThreadPoolExecutor(numThreads, numThreads, 0L, TimeUnit.MILLISECONDS, queue);
    }

    @Override
    public void execute(Runnable command) {
        executor.execute(command);
    }

    @Override
    public void shutdown() {
        executor.shutdown();
    }

    @Override
    public List<Runnable> shutdownNow() {
        return executor.shutdownNow();
    }

    @Override
    public boolean isShutdown() {
        return executor.isShutdown();
    }

    @Override
    public boolean isTerminated() {
        return executor.isTerminated();
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return executor.awaitTermination(timeout, unit);
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return null;
    }

    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        return null;
    }

    @Override
    public Future<?> submit(Runnable task) {
        return null;
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        return null;
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        return null;
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }

    public static void main(String[] args)
    {
        int numThreads = 5;
        CustomExecutorService customExecutor = new CustomExecutorService(numThreads);

        for (int i = 0; i < 10; i++)
        {
            customExecutor.execute(() -> {
                System.out.println("Задача выполнена тредом: " + Thread.currentThread().getName());
            });
        }

        customExecutor.shutdown();
    }
}
