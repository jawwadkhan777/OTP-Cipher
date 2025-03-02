package otpCipher;

public class OTP {
    char [] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static StringBuilder generateKey(String plainText) {
        String regex = "[^a-zA-Z]+";
        String [] arr = plainText.split(regex);
        String onlyLettersInText = String.join("",arr);
        char [] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder key = new StringBuilder();
        for (int i = 0; i< onlyLettersInText.length(); i++) {
            int randNum = (int) (Math.random()*26);
            key.append(alphabet[randNum]);
        }
        return key;
    }

    public String encrypt(String plainText) {


        return "ciphertext";
    }

    public String decrypt(String cipherText) {

        return "plainText";
    }
}
