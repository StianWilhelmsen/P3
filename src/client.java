import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

public class client {


    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
        try {
            Socket s = new Socket("localhost", 80);
            System.out.println("Socket connected to server");

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);

            while (true) {
                System.out.println("Choose your operator: (add/sub):");
                String operation = scanner.nextLine();
                System.out.println("Enter first number:");
                String num1 = scanner.nextLine();
                System.out.println("Enter second number:");
                String num2 = scanner.nextLine();

                out.println(num1);
                out.println(num2);
                out.println(operation);

                String result = in.readLine();
                out.println(result);

            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
