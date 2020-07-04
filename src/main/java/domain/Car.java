package domain;

import java.util.Arrays;

public class Car implements Racing {
    private final String name;
    private int position = 0;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    /*TODO: 2020/06/28 추가기능 구현*/

    @Override
    public String racing() {
        String finish = "";
        int dice = (int) (Math.random() * 10);
        if (position == 0)
            finish = " : ";
        if (dice > 4)
            finish += "-";
        return finish;
    }

    @Override
    public String finish(String[] check) {
        System.out.println(Arrays.toString(check));
        String winner = "";
        int[] point = new int[check.length];
        for (int i = 0; i < check.length; i++) {
            if (check[i].indexOf("-") != -1)
                point[i] = check[i].substring(check[i].indexOf("-"), check[i].length()).length();
        }
        int max = Arrays.stream(point).max().getAsInt();
        for (int i = 0; i < point.length; i++) {
            if (point[i] == max) {
                winner += check[i].substring(0, check[i].indexOf(" ")) + ", ";
            }
        }
        return winner;
    }

}

