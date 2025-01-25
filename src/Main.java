public class Main {
    public static void main(String[] args) {
        String crypt = "qw6erasdf1tyg4hu3jwj897ehjwq987heqwiuniu2n32oi91jj029j";
        String password = "password123";
        Encrypter n = new Encrypter( 64, ":", crypt, 3, 52, 453, 43, 324234, 42342, 666, 4523);

        System.out.println(crypt);
        System.out.println("original  -> "+password);
        System.out.println("encrypted -> "+n.encrypt(password));

    }
}
