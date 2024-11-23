package finalexam23_24;

public class Election {
    private PenguinVoters pv;
    private Machine[] machines;

    public Election(int n){
        machines = new Machine[n];
        pv = new PenguinVoters();

        for (int i = 0; i <n ; i++) {
           machines[i] = new Machine(pv);
           machines[i].start();
        }
    }
    public void arrive(Penguin p){

       pv.register(p);
    }

    public void shutdown() throws InterruptedException {
        for (Machine m : machines) {
            m.interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Election e = new Election(4);
        Penguin p1 = () -> System.out.println("peng");
        Penguin p2 = () -> System.out.println("guin");
        e.arrive(p1);
        e.arrive(p2);
        Thread.sleep(1000);

        e.shutdown();
    }
}
