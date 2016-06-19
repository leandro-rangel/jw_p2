package br.javaweb.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.javaweb.util.JavaWebException;

/**
 * Objetivo: Responsavel por criar a coneccao com o banco de dados.
 * @author Philipe
 * @author Luiz
 * @author Vitor
 */
public class ConnectionManager {

	
    /*
     * 1) Coloque o valor adequado nas constantes DATABASE, USER e PASSWORD 
     * 2) Teste esta classe para garantir que esteja funcionando
     */
    private static final String STR_DRIVER = "jdbc:derby://localhost:1527/sample";
    private static final String DATABASE = "jw";
    private static final String IP = "localhost"; //"192.168.0.1";
    private static final String STR_CON = "jdbc:derby://" + IP + ":3306/" + DATABASE;
    private static final String USER = "app";
    private static final String PASSWORD = "app";

    public static Connection getConexao() throws JavaWebException {
        Connection conn = null;
        try {
            Class.forName(STR_DRIVER);
            conn = DriverManager.getConnection(STR_CON, USER, PASSWORD);
            System.out.println("[ConnectionManager]: Obtendo conexao");
            return conn;
        } catch (ClassNotFoundException e) {
            String errorMsg = "Driver nao encontrado";
            throw new JavaWebException(errorMsg, e);
        } catch (SQLException e) {
            String errorMsg = "Erro ao obter a conexao";
            throw new JavaWebException(errorMsg, e);
        }
    }

    public static void closeAll(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("[ConnectionManager] Connection.close()");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeAll(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (conn != null || stmt != null) {
                closeAll(conn, stmt);
            }
            if (rs != null) {
                rs.close();
                System.out.println("[ConnectionManager] ResultSet.close()");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeAll(Connection conn, Statement stmt) {
        try {
            if (conn != null) {
                closeAll(conn);
            }
            if (stmt != null) {
                stmt.close();
                System.out.println("[ConnectionManager] Statement.close()");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
