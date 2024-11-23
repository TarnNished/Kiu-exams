package midterm1_23_24;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Friends {
    static void suggestion(String[] mariamFriends, String[] niniFriends){
        for (String mariamFriend : mariamFriends) {
            boolean found = false;
            for (String niniFriend : niniFriends) {
                if (mariamFriend.equals(niniFriend)) {
                    found = true;
                    break;
                }
            }
            if (!found) System.out.println(mariamFriend);
        }
    }
    static void suggest(String[] mariamFriends, String[] niniFriends){
        Set<String> mariamset = new HashSet<>(Arrays.asList(mariamFriends));
        Set<String> niniset = new HashSet<>(Arrays.asList(niniFriends));
        mariamset.removeAll(niniset);
        System.out.println(mariamset);
        niniset.removeAll(mariamset);
        System.out.println(niniset);
    }
    public static void main(String[] args) {
        String[] mariamFriends = {"A", "B", "C", "D", "E", "F"};
        String[] niniFriends = {"A", "B", "C", "D", "E", "F"};
        suggestion(mariamFriends, niniFriends);
        suggest(mariamFriends, niniFriends);
    }


}
