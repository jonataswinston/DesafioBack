package main;

import java.sql.*;

public class Checkdata extends Connect {

    public static void checkReg() {
        int leng = 1200;
        int idQuer[] = new int[leng];
        String cpfQuer[] = new String[leng];
        String nomeQuer[] = new String[leng];
        String statusQuer[] = new String[leng];
        double vlQuer[] = new double[leng];
        int vCount = 0;

        openConnectionSQL();
        for (int i = 1500; i <= 2700; i++) {
            try {
                ResultSet quer = null;

                PreparedStatement stmte = con.prepareStatement("SELECT id_customer, cpf_cnpj, " +
                        "nm_customer, is_active, vl_total FROM "+tabela+" WHERE id_customer BETWEEN 1500 AND 2700 " +
                        "ORDER BY vl_total");
                quer = stmte.executeQuery();
                quer.next();
                double vlcheck = quer.getDouble("vl_total");
                if (vlcheck >= 560){
                    idQuer[vCount] = quer.getInt("id_customer");
                    cpfQuer[vCount] = quer.getString("cpf_cnpj");
                    nomeQuer[vCount] = quer.getString("nm_customer");
                    statusQuer[vCount] = quer.getString("is_active");
                    vlQuer[vCount] = vlcheck;
                    vCount = vCount + 1;
                }

            }catch(Exception e){
                System.out.println(e);
            }
        }
        closeConnectionSQL();
        double valorTotal = 0;
        double mediaFinal = 0;
        for (int i = 0; i<=vCount; i++){
            valorTotal = valorTotal + vlQuer[i];
        }
        mediaFinal = valorTotal/vCount;
    System.out.println("A média de saldo dos clientes é: "+mediaFinal);

        for (int i = 0; i<=vCount; i++){
            System.out.println(idQuer[i]);
            System.out.println(cpfQuer[i]);
            System.out.println(nomeQuer[i]);
            System.out.println(statusQuer[i]);
            System.out.println(vlQuer[i]);
        }
    }
}
