package domain;

import java.util.Scanner;

public class Application {
    public static Car car;
    static Scanner scanner = new Scanner(System.in);

    public static String[] carReady() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String name = scanner.next();
        String[] cars = name.split(",");
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].length() > 5) {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                name = scanner.next();
                cars = name.split(",");
            }
        }
        return cars;
    }

    public static void main(String[] args) {
        String[] carRacers = carReady();
        System.out.println("시도할 회수는 몇회인가요?");
        int turn = scanner.nextInt();
        String[] check = carRacers;
        for (int i = 0; i < turn; i++) {
            for (int j = 0; j < carRacers.length; j++) {
                car = new Car(carRacers[j], i);
                check[j] += car.racing();
                System.out.println(check[j]);
            }
        }
        System.out.println(car.finish(check) + "(이) 최종 우승했습니다.");
    }
}

