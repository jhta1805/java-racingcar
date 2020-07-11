package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            HashMap<String, Car> player = new HashMap<>();
            System.out.println("이름을 입력하세요.");
            String[] names = sc.next().replace(" ", "").split(",");
            System.out.println("횟수를 입력하세요.");
            String coin_ = sc.next();
            int coin = Integer.parseInt(coin_);
            for (int i = 0; i < names.length; i++) {
                player.put(names[i], new Car(names[i]));
            }
            goal(coin, player);
        }
    }

    private static void goal(int coin, HashMap<String, Car> player) {
        int num = 0;
        String mark = ">";
        while (num < coin) {
            for (Map.Entry<String, Car> entry : player.entrySet()) {
                int position = entry.getValue().play();
                String markRepeated = (String.join("", Collections.nCopies(position, mark)));
                System.out.println(entry.getKey() + ":" + markRepeated);
            }
            num++;
        }
        System.out.println("우승자는 " + winner(player));
    }

    private static String winner(HashMap<String, Car> player) {
        int maxNum = 0;
        String winner = "";
        for (Map.Entry<String, Car> entry : player.entrySet()) {
            int position = entry.getValue().getPosition();
            if (maxNum < position) {
                maxNum = position;
            }
        }
        for (Map.Entry<String, Car> entry : player.entrySet()) {
            if (entry.getValue().getPosition() == maxNum) {
                winner += entry.getKey() + ",";
            }
        }
        winner = winner.substring(0, winner.length() - 1);
        return winner;
    }
}

