package finalexam23_24;

import java.util.HashMap;
import java.util.Map;

public class Dictionary<T> {

    private T value;
    private Map<Character, Dictionary<T>> h;


    public Dictionary() {
        this.value = null; // Default to null
        this.h = new HashMap<>();
    }


    public void record(String s, int currentIndex, T value){
        if(currentIndex == s.length() - 1){
            this.value=value;
            return;
        }
        if( h == null){
            h = new HashMap<>();
        }

        Character c = s.charAt(currentIndex);
        if(!h.containsKey(c)){
            h.put(c,new Dictionary<>());
        }

        Dictionary<T> successor = this.h.get(c);
        successor.record(s, currentIndex + 1, value);

    }
    public void record(String s, T value) {
        if (s.isEmpty()) return;
        record(s, 0, value);
    }
    public T lookup(String s, int index){
        if(h == null){
            return null;
        }
        if (index == s.length() - 1) {
            return this.value;
        }
        Character c = s.charAt(index);
        if(!h.containsKey(c)){
            return lookup(s, index + 1);
        }else
            return h.get(c).value;


    }
    public T lookup(String s){
        if (s.isEmpty()) return null;
        return lookup(s,0);
    }

    private T remove(String s, int currentIndex) {
        if (currentIndex == s.length() - 1) {
            T oldValue = this.value;
            this.value = null;
            return oldValue;
        }

        if (h == null || !h.containsKey(s.charAt(currentIndex))) {
            return null;
        }

        T removedValue = h.get(s.charAt(currentIndex)).remove(s, currentIndex + 1);

        if (h.get(s.charAt(currentIndex)).isEmpty()) {
            h.remove(s.charAt(currentIndex));
        }

        return removedValue;
    }
    public T remove(String s) {
        if (s.isEmpty()) return null;
        return remove(s, 0);
    }

    public boolean isEmpty() {
        if (this.value != null) return false;
        if (h == null) return true;
        return h.isEmpty();
    }

    public static void main(String[] args) {
        Dictionary<Meaning<Integer>> dict  = new Dictionary<>();

        for (int i = 0; i < args.length ; i++) {
            int iCopy = i;
            dict.record(args[i], () -> iCopy);
        }

        for(String arg : args){
            Meaning<Integer> m = dict.remove(arg);
            if(m != null){
                System.out.println(arg + ": " + m.meaning());
            }
        }
    }


}
