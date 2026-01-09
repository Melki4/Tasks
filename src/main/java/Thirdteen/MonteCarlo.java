package Thirdteen;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class MonteCarlo implements Runnable{

    private final int dotsToGenerate;
    private final AtomicLong totalDotsInCircle;

    public MonteCarlo(int dotsToGenerate, AtomicLong totalDotsInCircle) {
        this.dotsToGenerate = dotsToGenerate;
        this.totalDotsInCircle = totalDotsInCircle;
    }

    @Override
    public void run() {
        try {
            Random random = new Random();
            long dotsInCircle = 0;

            for (int i = 0; i < dotsToGenerate; i++) {
                // Проверка на прерывание
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Поток прерван");
                    return;
                }

                double x = random.nextDouble();
                double y = random.nextDouble();

                if (x * x + y * y <= 1.0) {
                    dotsInCircle++;
                }
            }
            totalDotsInCircle.addAndGet(dotsInCircle);

        } catch (Exception e) {
            System.out.println("Поток прерван: " + e.getMessage());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        if (args.length != 2) {
            System.out.println("Использование: java MonteCarloMain <количество_точек> <количество_потоков>");
            return;
        }

        int totalDots = Integer.parseInt(args[0]);
        int threadCount = Integer.parseInt(args[1]);

        if (totalDots <= 0 || threadCount <= 0) {
            System.out.println("Аргументы должны быть положительными числами");
            return;
        }

        AtomicLong totalDotsInCircle = new AtomicLong(0);
        Thread[] threads = new Thread[threadCount];

        // Распределение точек по потокам
        int baseDotsPerThread = totalDots / threadCount;
        int remainingDots = totalDots % threadCount;

        // Создание и запуск потоков
        for (int i = 0; i < threadCount; i++) {
            int dotsForThisThread = baseDotsPerThread;
            if (i < remainingDots) {
                dotsForThisThread++;  // Распределяем остаточные точки
            }

            // Вариант 1: с Runnable
            Thread thread = new Thread(new MonteCarlo(dotsForThisThread, totalDotsInCircle));
            threads[i] = thread;
            thread.start();

//             Или вариант 2: с наследованием от Thread
//             Thread thread = new MonteCarlo(dotsForThisThread, totalDotsInCircle);
//             threads[i] = thread;
//             thread.start();
        }

        // Ожидание завершения всех потоков
        for (Thread thread : threads) {
            thread.join();
        }

        // Вычисление π
        double piEstimate = 4.0 * totalDotsInCircle.get() / totalDots;
        System.out.println("Результат вычисления π: " + piEstimate);
        System.out.println("Точек в окружности: " + totalDotsInCircle.get() + " из " + totalDots);
    }
}
