package 아침복습;

import java.util.Random;
import java.util.Scanner;

public class FortuneMachine {
    public static void main(String[] args) {
        String[] fortunes = {
            "대박! 오늘은 뭐든 잘 풀리는 날이에요! 🎉",
            "조심조심~ 발밑에 주의하세요! 😅",
            "누군가 당신을 생각하고 있어요 💌",
            "행운의 숫자: 7 🍀",
            "오늘은 모험을 피하세요. 집콕이 최고! 🏠",
            "웃으면 복이 와요~ 😄",
            "뜻밖의 연락이 올지도...? 📱",
            "지금 생각난 그 사람, 연락해보세요! ☎"
        };

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("운세를 보시려면 이름을 입력하세요: ");
        String name = "고영준";

        int LuckyIndex = random.nextInt(fortunes.length);
        String todayFortune = fortunes[LuckyIndex];

        System.out.println("\n🔮 " + name + "님의 오늘의 운세 🔮");
        System.out.println(todayFortune);
    }
}

