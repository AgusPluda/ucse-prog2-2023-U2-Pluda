package org.example;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;

public class CompletableFuture {

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

        java.util.concurrent.CompletableFuture<Integer> t1 = java.util.concurrent.CompletableFuture.supplyAsync(() -> {
            int num = generateNumber();
            System.out.println("Numero T1: " + num);
            return num;
        });
        java.util.concurrent.CompletableFuture<Integer> t2 = java.util.concurrent.CompletableFuture.supplyAsync(() -> {
            int num = generateNumber();
            System.out.println("Numero T2: " + num);
            return num;
        });
        java.util.concurrent.CompletableFuture<Integer> t3 = java.util.concurrent.CompletableFuture.supplyAsync(() -> {
            int num = generateNumber();
            System.out.println("Numero T3: " + num);
            return num;
        });
        java.util.concurrent.CompletableFuture<Integer> t4 = java.util.concurrent.CompletableFuture.supplyAsync(() -> {
            int num = generateNumber();
            System.out.println("Numero T4: " + num);
            return num;
        });

        java.util.concurrent.CompletableFuture<Void> tareas = java.util.concurrent.CompletableFuture.allOf(t1, t2, t3, t4);

        java.util.concurrent.CompletableFuture<Integer> sumaFuture = tareas.thenApply(v -> {
            try {
                return t1.get() + t2.get() + t3.get() + t4.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });

        sumaFuture.thenAccept(suma -> System.out.println("La suma de los numeros es: " + suma));

        sumaFuture.get();
    }
}
