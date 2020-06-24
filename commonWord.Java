import java.util.Scanner;
import java.util.HashMap;

public class Program2 {

    public static void main(String[] args) {
        HashMap<String, Integer> hash = new HashMap<>();
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        boolean done = false;
        String lrg = "";
        int lar = 0;
        while (!done) {
            if (a.isEmpty()) {
                done = true;
            } else {
                String x[] = a.split("\\s+");
                for (String l : x) {
                    if(hash.get(l) != null){
                        hash.replace(l,hash.get(l) + 1);
                    }
                    else
                    {
                        hash.put(l,1);
                    }
                    if(hash.get(l)>lar){
                        lar = hash.get(l);
                        lrg = l;
                    }
                }
                a = in.nextLine();
            }
        }
            System.out.print("The most common word is (" + lrg + ") which appeared " + lar + " times");


    }
}
