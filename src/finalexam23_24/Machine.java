package finalexam23_24;

public class Machine extends Thread {
    private PenguinVoters penguinVoters;

    public Machine(PenguinVoters penguinVoters) {
        this.penguinVoters = penguinVoters;
    }

    public void run() {
        while (true) {
            try {
                penguinVoters.admit().vote();
            } catch (InterruptedException e) {
                return;
            }catch (Exception ignored){

            }
        }
    }

}
