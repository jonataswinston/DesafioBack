package main;
import java.util.Scanner;
import static main.Connect.*;

public class InsertData {
    public static Scanner ler = new Scanner(System.in);

    private static int idDoCliente = 0;
    protected static String nomeDoCliente = "";
    protected static String cpfcnpjDoCliente = "";
    protected static String statusDoCliente = "";
    protected static double saldoDoCliente = 0;

    private static void insCustomerAccount(){
        System.out.println("Insira o nome do cliente");
        nomeDoCliente = ler.nextLine();
        System.out.println("Insira o CPF ou CNPJ do cliente " + nomeDoCliente);
        cpfcnpjDoCliente = ler.next();
        System.out.printf("Qual o status do cliente %s?\nAtivo | Inativo\n", nomeDoCliente);
        statusDoCliente = ler.next().toUpperCase();
        System.out.println("Qual o saldo atual do cliente?");
        saldoDoCliente = ler.nextDouble();
        System.out.println("Nome do cliente: "+nomeDoCliente+" | CPF/CNPJ: "+cpfcnpjDoCliente+" | Status: "
                +statusDoCliente+" | Saldo atual: "+saldoDoCliente);//teste
    }

    private static void insertCusAccount(){
        openConnectionSQL();
        insCustomerAccount();
        updateSQL();
        closeConnectionSQL();
        clearVar();
        System.out.println("Cliente cadastrado!");
    }

    public static void insertCustomerAccount(){
        String rep = "";
        do{
            insertCusAccount();
            System.out.println("Deseja cadastrar um novo cliente? s ou n");
            rep = ler.next();
        }while (!rep.equalsIgnoreCase("n"));
    }

    private static void clearVar(){
        nomeDoCliente = "";
        cpfcnpjDoCliente = "";
        statusDoCliente = "";
        saldoDoCliente = 0;
    }
}
