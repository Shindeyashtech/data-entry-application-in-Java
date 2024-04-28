import java.io.*;
import java.util.Scanner;

public class Form {

    public static void main(String[] args) {
       
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Do you want to see the data? (yes/no)");
        String input = sc1.nextLine();
        
        if (input.equalsIgnoreCase("yes")) {
            ThreadFormOne t1 = new ThreadFormOne();
            t1.start();
        } else {
            System.out.println("No data will be displayed.");
        }  
        
        ThreadFormTwo t2 = new ThreadFormTwo();
        t2.start();
    }
        
}

/**
 * InnerForm
 */
class ThreadFormTwo extends Thread {

    public void run(){
        Scanner sc = new Scanner(System.in);
        try {
            do {
                // Input name
                System.out.println("Enter your Name : ");
                String name = sc.nextLine();
                writeToFile("________________________________________________________________________________________________________ ");
                writeToFile("Name: " + name);

                // Input number
                System.out.println("Enter your Number : ");
                int num = sc.nextInt();
                sc.nextLine(); // Consume newline
                writeToFile("Number: " + num);

                // Input ID
                System.out.println("Enter your ID : ");
                int id = sc.nextInt();
                sc.nextLine(); // Consume newline
                writeToFile("ID: " + id);

                // Input interest
                System.out.println("Are you Interested in Java Programming? (Yes/No) : ");
                String interest = sc.nextLine();
                writeToFile("Interest: " + interest);

                // Ask if the user wants to enter more data
                System.out.println("Do you want to enter more user data? (Yes/No): ");
                String moreData = sc.nextLine();
                if (!moreData.equalsIgnoreCase("Yes")) {
                    break; // Exit the loop if the user doesn't want to enter more data
                }
            } while (true);

        } catch (Exception e) {
            System.out.println("Invalid input: " + e.getMessage());
            return; // Exit the program if input is invalid
        }

        System.out.println("Data written to file successfully.");
    }

    private static void writeToFile(String data) {
        try (FileOutputStream fos = new FileOutputStream("C:\\Users\\yashk\\Desktop\\Java April 2024\\Hw-tread\\yas.txt", true)) {
            // Write data to file
            fos.write((data + "\n").getBytes()); // Append newline character
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

/**
 * InnerForm
 */
class ThreadFormOne extends Thread{

    public void run(){
        try {
            FileInputStream i1 = new FileInputStream("C:\\Users\\yashk\\Desktop\\Java April 2024\\Hw-tread\\yas.txt");
            int data;
            while ((data = i1.read()) != -1) {
                System.out.print((char) data);
            }
            i1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
