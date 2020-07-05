package domain;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = sc.next().replace(" ", "").split(",");
        Map<Integer, Car> hm = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            new Car(names[i]);
        }
        for (Map.Entry<Integer, Car> entry : hm.entrySet()) {
            entry.getValue().play();
        }
    }

    private Integer NUM = 0;

    private String Goal(int coin, HashMap<Integer, Car> hm) {
        while (NUM <= coin) {
            for (Map.Entry<Integer, Car> entry : hm.entrySet()) {
                entry.getValue().play();
            }
            NUM++;
        }
        return "";
    }
}

