package finalexam22_23;

public class Bistro {
    private int seats;
    private Thread order,meal,waiter;
    private volatile boolean isRunning;
    public Bistro(int n) {
        this.seats = n;
        this.order = null;
        this.meal = null;
        this.isRunning =true;
        waiter = new Thread(() -> {
            while (isRunning) {
                serve();
            }
        });
        waiter.start();     }
    public synchronized void dine(int price){
        while(seats<=0){
            try {
                wait();
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }

        }
        seats--;
        System.out.println("Guest " + Thread.currentThread().getId() + " orders for " + price + " Lari");
        order = Thread.currentThread();

        while (meal != Thread.currentThread()) {
            try {
                wait();
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        meal = null;
        System.out.println("Guest " + Thread.currentThread().getId() + "eats..." );

        seats++;
        notifyAll();


    }

    public synchronized void serve() {
        while (order == null && isRunning) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        if (!isRunning) return;

        meal = order;
        order = null;
        System.out.println("Enjoy!");
        notifyAll();


        while (meal != null && isRunning) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    public synchronized void shutdown() {
        isRunning = false;
        notifyAll();
        try {
            waiter.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] arr) {
        Bistro b = new Bistro(2);
        Thread g1 = new Thread(() -> b.dine(10));
        Thread g2 = new Thread(() -> b.dine(20));
        Thread g3 = new Thread(() -> b.dine(30));
        Thread g4 = new Thread(() -> b.dine(40));
        g1.start();
        g2.start();
        g3.start();
        g4.start();
        try {
            g1.join();
            g2.join();
            g3.join();
            g4.join();
        } catch (InterruptedException e) {}
        b.shutdown();
    }



}
