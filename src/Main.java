public class Main {
    public static void main(String[] args) {
        Caesar caesar = new Caesar("abcde",3,true);
        caesar.encryption();
        System.out.println(caesar.getCiphertext());
    }
}
