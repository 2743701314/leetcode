import java.util.Scanner;

public class Solution{
    public static void main(String[] args) {
        System.out.println(new Solution().encryption("hello","234137"));
    }

public String encryption(String plaintext,String key) {
    char[] textnum = plaintext.toCharArray();
    char[] keynum = key.toCharArray();
    char tmp = 'a';
    int index = 0;
    for (int j = 0; j < textnum.length; j++) {
        if (j % 2 == 0) {
            index = j % keynum.length;
            tmp = (char) (textnum[j] + (keynum[index] - '0'));
            if (tmp > 'z') {
                textnum[j] = (char) (tmp - 26);
            } else {
                textnum[j] = tmp;
            }
        } else {
            index = j % keynum.length;
            tmp = (char) (textnum[j] - (keynum[index] - '0'));
            if (tmp < 'a') {
                textnum[j] = (char) (tmp + 26);
            } else {
                textnum[j] = tmp;
            }
        }
    }
    String res = "";
    for (int i = 0; i < textnum.length; i++) {
        res = res + textnum[i];
    }
    return res;
}


}
