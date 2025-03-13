package nowcoder.huawei;

import java.util.*;

class MainHJ3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            if (!list.contains(num)) {
                list.add(num);
            }
        }
        Collections.sort(list);
        for (Integer integer : list) {
            System.out.print(integer + "\n");
        }
    }
}