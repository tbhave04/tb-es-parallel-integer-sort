package input;

import java.util.Random;

class NumberGenerator {
    static int N = 100;
    public static void main (String[] args) {
        if (args.length > 2) {
            N = Integer.parseInt(args[2]);
        }
        Random gen = new Random();
        for (int i = 0; i < N; i++) {
            System.out.println(gen.nextInt());
        }
    }
}