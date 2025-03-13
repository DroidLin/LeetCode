package nowcoder.huawei;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
class MainHJ2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine().toUpperCase();
        char c = in.nextLine().toUpperCase().charAt(0);
        int count = 0;
        for (int index = 0; index < s.length(); index++) {
            char sChar = s.charAt(index);
            if (sChar == c) {
                count++;
            }
        }
        System.out.println(count);
    }
}