package org.example;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;

public class CompletableFuture2 {

    private static int generateNumber() {
        int random = ThreadLocalRandom.current().nextInt(100, 501);
        try {
            Thread.sleep(random);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return random;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> t1 = CompletableFuture.supplyAsync(() -> {
            int num = generateNumber();
            System.out.println("Numero T1: " + num);
            return num;
        });
        CompletableFuture<Integer> t2 = CompletableFuture.supplyAsync(() -> {
            int num = generateNumber();
            System.out.println("Numero T2: " + num);
            return num;
        });
        CompletableFuture<Integer> t3 = CompletableFuture.supplyAsync(() -> {
            int num = generateNumber();
            System.out.println("Numero T3: " + num);
            return num;
        });
        CompletableFuture<Integer> t4 = CompletableFuture.supplyAsync(() -> {
            int num = generateNumber();
            System.out.println("Numero T4: " + num);
            return num;
        });

        CompletableFuture<Object> primera = CompletableFuture.anyOf(t1, t2, t3, t4);

        primera.thenAccept(nro -> {
            System.out.println("La primera tarea dio como resultado: " + nro);
        });

        primera.get();
    }
}
