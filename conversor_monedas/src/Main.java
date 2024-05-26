import com.conversor_monedas.api.Request;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int doesUserLeave;
        System.out.println("""
                ***************************************************************
                             Welcome to the currency converter!
                ***************************************************************
                """);

        do {
            System.out.println("""
                    Choose an option:
                    
                    1) USD to ARS
                    2) ARS to USD
                    3) USD to BRL
                    4) BRL to USD
                    5) USD to COP
                    6) COP to USD
                    7) Leave
                    """);
            var numberOption = scanner.nextInt();
            doesUserLeave = numberOption;
                System.out.println("Write an amount");
                var amountOption = scanner.nextDouble();
                Request moneyConversion = new Request();
                switch (numberOption){
                    case 1:
                    {
                        moneyConversion.requestMethod(0, 1, amountOption);
                    break;}
                    case 2:
                    {
                        moneyConversion.requestMethod(1, 0, amountOption);
                        break;}
                    case 3: {
                        moneyConversion.requestMethod(0, 2, amountOption);
                        break;}


                    case 4:{
                            moneyConversion.requestMethod(2, 0, amountOption);
                            break;}


                    case 5:{
                            moneyConversion.requestMethod(0, 3, amountOption);
                            break;}


                    case 6:{
                            moneyConversion.requestMethod(3, 0, amountOption);
                            break;}

                    default:{
                            System.out.println("Invalid option");
                            break;}

            }


        }while (doesUserLeave != 7);

    }
}