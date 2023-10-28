package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int restart = 0, st = 0, ball = 0, user = 0;
        List<Integer> userInput = new ArrayList<Integer>();
        do {
            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            while (st != 3) {
                st = 0;
                ball = 0;
                userInput.clear();
                System.out.print("숫자를 입력해주세요 : ");
                user = Integer.parseInt(readLine());
                if (user < 100 || user > 999){
                    throw new IllegalArgumentException();
                }
                int tmpUser = user;
                userInput.add(user / 100);
                user %= 100;
                userInput.add(user / 10);
                user %= 10;
                userInput.add(user);
                if (userInput.get(0).equals(userInput.get(1)) || userInput.get(0).equals(userInput.get(2)) || userInput.get(1).equals(userInput.get(2))) {
                    throw new IllegalArgumentException();
                }
                if (userInput.get(0).equals(computer.get(1)) || userInput.get(0).equals(computer.get(2))) {
                    ball++;
                }
                if (userInput.get(1).equals(computer.get(0)) || userInput.get(1).equals(computer.get(2))) {
                    ball++;
                }
                if (userInput.get(2).equals(computer.get(0)) || userInput.get(2).equals(computer.get(1))) {
                    ball++;
                }
                if (userInput.get(0).equals(computer.get(0))) {
                    st++;
                }
                if (userInput.get(1).equals(computer.get(1))) {
                    st++;
                }
                if (userInput.get(2).equals(computer.get(2))) {
                    st++;
                }
                if (st == 0 && ball == 0) {
                    System.out.println("낫싱");
                }
                else if (st == 0) {
                    System.out.println(ball + "볼");
                }
                else if (ball == 0) {
                    System.out.println(st + "스트라이크");
                }
                else {
                    System.out.println(ball + "볼 " + st + "스트라이크");
                }
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            restart = Integer.parseInt(readLine());
            if (restart != 1 && restart != 2){
                throw new IllegalArgumentException();
            }
            st = 0;
            ball = 0;
        } while (restart == 1);
    }
}
