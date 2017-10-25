package main;
import java.util.Scanner;

import static main.Checkdata.checkReg;
import static main.InsertData.insertCustomerAccount;

public class Main {

    public static void main(String[]args) {
        //teste
        Scanner ler = new Scanner(System.in);
        String res = "";
        do {
        System.out.println("Escolha uma opção!");
        System.out.println("1 - Cadastrar um cliente");
        System.out.println("2 - Checar media de saldos");
        System.out.println("9 - Sair");
        res = ler.next();
        switch (res) {
            case "1":
                insertCustomerAccount();
                break;
            case "2":
                checkReg();
                break;
            case "3":
                res = "9";
                break;
        }
        }while(!res.equals("9"));
        }


}
