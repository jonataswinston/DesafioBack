package main;

import java.sql.*;

public class Checkdata extends Connect {

    private static int leng = 1200;
    private static int idQuer[] = new int[leng];
    private static String cpfQuer[] = new String[leng];
    private static String nomeQuer[] = new String[leng];
    private static String statusQuer[] = new String[leng];
    private static double vlQuer[] = new double[leng];
    private static int vCount = 0;

    private static void getReg() {
        //obtem os dados dos clientes armazenados no banco de dados
        openConnectionSQL();
        for (int i = 1500; i <= 2700; i++) {
            try {
                ResultSet quer = null;
                PreparedStatement stmte = con.prepareStatement("SELECT id_customer, cpf_cnpj, " +
                        "nm_customer, is_active, vl_total FROM " + tabela + " WHERE id_customer BETWEEN 1500 AND 2700 " +
                        "ORDER BY vl_total");
                quer = stmte.executeQuery();
                quer.next();
                double vlcheck = quer.getDouble("vl_total");
                if (vlcheck >= 560) {
                    getStringsA(quer, vlcheck);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        closeConnectionSQL();
    }

    private static void calMedia() {
        //calcula a media dos saldos
        double valorTotal = 0;
        double mediaFinal = 0;
        for (int i = 0; i <= vCount; i++) {
            valorTotal = valorTotal + vlQuer[i];
        }
        mediaFinal = valorTotal / vCount;
        System.out.println("A média de saldo dos clientes é: " + mediaFinal);
    }

    private static void printCust() {
        //imprime a lista com os clientes usados no calculo da media
        for (int i = 0; i <= vCount; i++) {
            System.out.println(idQuer[i]);
            System.out.println(cpfQuer[i]);
            System.out.println(nomeQuer[i]);
            System.out.println(statusQuer[i]);
            System.out.println(vlQuer[i]);
        }
    }

    private static void getStringsA(ResultSet quer, double vlcheck){
        //obtem os valores das strings (Do banco) e armazena em variaveis Java
        try {
            idQuer[vCount] = quer.getInt("id_customer");
            cpfQuer[vCount] = quer.getString("cpf_cnpj");
            nomeQuer[vCount] = quer.getString("nm_customer");
            statusQuer[vCount] = quer.getString("is_active");
            vlQuer[vCount] = vlcheck;
            vCount = vCount + 1;
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void checkReg(){
        getReg();
        calMedia();
        printCust();
    }
}
