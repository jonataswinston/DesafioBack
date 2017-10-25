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
    private static String driver = "com.mysql.jdbc.Driver";
    //parametros para conexão com o Banco De Dados;
    private static String ip_Serv = "35.198.0.84";//ip do servidor
    private static String port = "3306";//porta do banco
    private static String bdDados = "testes";//banco de dados
    private static String user = "applet";//usuário do banco
    private static String paswd = "qwe123";//senha do usuário
    protected static String tabela = "tb_customer_account";//tabela a ser usada
    private static String url = "jdbc:mysql://"+ip_Serv+":"+port+"/";

    public static void openConnectionSQL(){
    	try{
            Class.forName(driver);
            con = DriverManager.getConnection(url+bdDados,user,paswd);
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