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

    public StringBuilder encrypt(String text) {
        String key = String.valueOf(generateKey(text));
        System.out.println("Key: " + key);
        int [] textIndex = new int[text.length()];
        int [] keyIndex = new int[key.length()];
//        find index values of text char from alphabet
        for(int i=0; i<text.length(); i++) {
            for(int j=0; j< alphabet.length; j++) {
                if (text.charAt(i)==alphabet[j]) {
                    textIndex[i] = j;
                    break;
                }
            }
        }
//        find index values of key char from alphabet
        for(int i=0; i<key.length(); i++) {
            for(int j=0; j< alphabet.length; j++) {
                if (key.charAt(i)==alphabet[j]) {
                    keyIndex[i] = j;
                    break;
                }
            }
        }
//        find cipher index by adding text and key indexes
        int [] cipherIndex = new int[textIndex.length];
        for (int i=0; i<textIndex.length; i++) {
            if(textIndex[i] + keyIndex[i]<26) cipherIndex[i] = textIndex[i] + keyIndex[i];
            else cipherIndex[i] = (textIndex[i] + keyIndex[i]) - 26;
        }

        StringBuilder cipherText = new StringBuilder();
        for(int val: cipherIndex) {
            cipherText.append(alphabet[val]);
        }

        return cipherText;
    }

    public StringBuilder decrypt(String cipherText) {
        String key = String.valueOf(generateKey(cipherText));
        System.out.println("Key: " + key);
        int [] textIndex = new int[cipherText.length()];
        int [] keyIndex = new int[key.length()];
        //        find index values of text char from alphabet
        for(int i=0; i<cipherText.length(); i++) {
            for(int j=0; j< alphabet.length; j++) {
                if (cipherText.charAt(i)==alphabet[j]) {
                    textIndex[i] = j;
                    break;
                }
            }
        }
//        find index values of key char from alphabet
        for(int i=0; i<key.length(); i++) {
            for(int j=0; j< alphabet.length; j++) {
                if (key.charAt(i)==alphabet[j]) {
                    keyIndex[i] = j;
                    break;
                }
            }
        }
        //        find plain text indexes by subtracting text and key indexes
        int [] plainIndex = new int[textIndex.length];
        for (int i=0; i<textIndex.length; i++) {
            if(textIndex[i] - keyIndex[i]<0) plainIndex[i] = (textIndex[i] - keyIndex[i])+26;
            else plainIndex[i] = textIndex[i] - keyIndex[i];
        }

        StringBuilder plainText = new StringBuilder();
        for(int val: plainIndex) {
            plainText.append(alphabet[val]);
        }

        return plainText;
    }
}
