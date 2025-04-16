package Lab2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GiftWrap {
    static InputReader rd = new InputReader(System.in);

    public static void main(String[] args) {
        int sizeOfGift = rd.nextInt();
        int sizeOfPaper = rd.nextInt();
        int[] numsOfGift = new int[sizeOfGift];
        int[] numsOfPaper = new int[sizeOfPaper];
        for (int i = 0; i < numsOfGift.length; i++) {
            numsOfGift[i] = rd.nextInt();
        }
        for (int i = 0; i < numsOfPaper.length; i++) {
            numsOfPaper[i] = rd.nextInt();
        }
        Arrays.sort(numsOfGift);
        Arrays.sort(numsOfPaper);
        int count = 0;
        int i = 0;
        int j = 0;
        while (i < numsOfGift.length && j < numsOfPaper.length) {
            if (numsOfPaper[j] >= numsOfGift[i] * 2 && numsOfPaper[j] <= numsOfGift[i] * 3) {
                count++;
                i++;
                j++;
            } else if (numsOfPaper[j] < numsOfGift[i] * 2) {
                j++;
            } else if (numsOfPaper[j] > numsOfGift[i] * 3) {
                i++;
            }
        }

        System.out.println(count);
    }

    public static class InputReader {
        StringTokenizer tokenizer;
        BufferedReader reader;
        String token;
        String temp;

        public InputReader(InputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public InputReader(FileInputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextLine() throws IOException {
            return reader.readLine();
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    if (temp != null) {
                        tokenizer = new StringTokenizer(temp);
                        temp = null;
                    } else {
                        tokenizer = new StringTokenizer(reader.readLine());
                    }
                } catch (IOException e) {
                }
            }
            return tokenizer.nextToken();
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }

}
