/* metodo para envio de dados de usuário cadastrado
VAR Java >>> idDoCliente | cpfcnpjDoCliente | nomeDoCliente | statusDoCliente | saldoDoCliente
COLUMS SQL > id_customer | cpf_cnpj         | nm_customer   | is_active       | vl_total
Usuário  >>> applet
Senha 	 >>> qwe123
Tabela   >>> tb_customer_account
*/
package main;

import java.sql.*;

public class Connect extends InsertData {

    protected static Connection con;
    protected static Statement stmt;
    private static String ip_Serv = "35.198.0.84";
    private static String port = "3306";
    private static String url = "jdbc:mysql://"+ip_Serv+":"+port+"/";
    private static String db = "testes";
    private static String driver = "com.mysql.jdbc.Driver";
    private static String user = "applet";
    private static String paswd = "qwe123";
    protected static String tabela = "tb_customer_account";

    public static void openConnectionSQL(){
    	try{
            Class.forName(driver);
            con = DriverManager.getConnection(url+db,user,paswd);
            stmt = con.createStatement();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void closeConnectionSQL(){
    	try{
    		con.close();
    		stmt.close();
    	}catch (Exception e){
    		System.out.println(e);
    	}
    }

    public static void updateSQL() {
        try {
            PreparedStatement stmte = con.prepareStatement("INSERT INTO " + tabela + " (cpf_cnpj,nm_customer," +
                    "is_active,vl_total) VALUES(?,?,?,?)");
            stmte.setString(1, cpfcnpjDoCliente);
            stmte.setString(2, nomeDoCliente);
            stmte.setString(3, statusDoCliente);
            stmte.setDouble(4, saldoDoCliente);
            stmte.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
