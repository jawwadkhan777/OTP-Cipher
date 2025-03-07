package otpCipher;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your message: ");
        String text = sc.nextLine();

        System.out.print("Choose an option, for encrypt->1 and for decrypt->0: ");
        int option = sc.nextInt();
        OTP otp = new OTP();
        switch (option) {
            case 1:
                System.out.println(otp.encrypt(text));
                break;
            case 0:
                otp.decrypt(text);
                break;
            default:
                System.out.println("Invalid option, rerun and select an appropriate option!");
        }




    }
}