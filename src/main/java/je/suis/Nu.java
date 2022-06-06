package je.suis;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Nu {
    //65-90
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Lettre: ");
        int index = scanner.nextLine().charAt(0);
        int shift;
        if (index < 97) {
            index -= 64;
            shift = 65;
        } else {
            shift = 97;
            index -= 96;
        }

        for (int i = 0; i < index; i++) {
            for (int j = index; j > 0; j--) {
                if (i == j)
                    sb.append((char) (i + shift));
                else sb.append(" ");
            }
            for (int j = 0; j < index; j++) {
                if (i == j)
                    sb.append((char) (i + shift));
                else sb.append(" ");
            }
            sb.append("\n");
        }

        for (int i = index-1; i > 0; i--) {
            sb.append(" ");
            for (int j = index; j > 0; j--) {
                if (i == j)
                    sb.append((char) (i + shift - 1));
                else sb.append(" ");
            }
            for (int j = 2; j < index; j++) {
                if (i == j)
                    sb.append((char) (i + shift - 1));
                else sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

        try {
            FileWriter writer = new FileWriter("prism.txt");
            writer.write(sb.toString());
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
