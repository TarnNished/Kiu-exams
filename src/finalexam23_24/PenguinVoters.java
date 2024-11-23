package finalexam23_24;

import java.util.ArrayList;
import java.util.List;

public class PenguinVoters {
    private List<Penguin> penguins;
    public PenguinVoters() {
        this.penguins = new ArrayList<>();
    }
    public void register(Penguin p) {
        penguins.add(p);
        notifyAll();
    }
    public Penguin admit(){
        while (penguins.isEmpty()){
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        Penguin p = penguins.get(0);
        penguins.remove(0);
        return p;

    }
}
