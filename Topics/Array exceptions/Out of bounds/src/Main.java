import java.util.*;

class FixingStringIndexOutOfBoundsException {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();
        int index = scanner.nextInt();

    //    System.out.println(string.charAt(index));

        if (index < 0 || index >= string.length()) {
            System.out.println("Out of bounds!");
        } else {
            System.out.println(string.charAt(index));
        }
    }
}