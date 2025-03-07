package otpCipher;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your message: ");
        String text = sc.nextLine();

        OTP otp = new OTP();
        System.out.print("Choose an option, for encrypt->1 and for decrypt->0: ");
        try {
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Encrypted message: " + otp.encrypt(text));
                    break;
                case 0:
                    System.out.println("Decrypted message: " + otp.decrypt(text));
                    break;
                default:
                    System.out.println("Invalid option, rerun and select an appropriate option!");
            }
        } catch (InputMismatchException exception) {
            System.out.println("Invalid input, read the instruction carefully!");
        }
    }
}