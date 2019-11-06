package kingja.chat.util;

/**
 * Description:TODO
 * Create Time:2019/11/6 0006 下午 2:25
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class RandomUtil {

    public static int randomCode(int num) {
        return (int) ((Math.random() * 9 + 1) * Math.pow(10,num));
    }

    public static int random6Code() {
        return randomCode(5);
    }

    public static void main(String[] args) {
        System.out.println("randomCode："+Math.random());
        System.out.println("randomCode六位数："+randomCode(5));
        System.out.println("randomCode五位数："+randomCode(4));
        System.out.println("randomCode四位数："+randomCode(3));
    }
}
