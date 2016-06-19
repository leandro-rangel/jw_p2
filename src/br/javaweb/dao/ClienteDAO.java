package br.javaweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.javaweb.beans.Cliente;
import br.javaweb.util.JavaWebException;

/**

 */
public class ClienteDAO implements IClienteDAO {

    private final String INSERT_QUERY = "INSERT INTO clientes (nome,cpf,telefone,email,senha) VALUES (?,?,?,?,?)";
    private final String SELECT_ALL_QUERY = "SELECT * FROM clientes";
    private final String SELECT_BY_ID_QUERY = "SELECT * FROM clientes WHERE id = ? ";
    private final String SELECT_BY_LOGIN_QUERY = "SELECT * FROM clientes WHERE email = ? AND senha = ?";
    private final static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS clientes (id int(11) NOT NULL AUTO_INCREMENT, nome varchar(255) NOT NULL, cpf bigint(20) NOT NULL, telefone bigint(20) NOT NULL, email varchar(255) NOT NULL, senha varchar(32) NOT NULL, PRIMARY KEY (id), UNIQUE KEY cpf_UNIQUE (cpf)) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8";

    public void save(Cliente obj) throws JavaWebException {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement prepStmt = null;
        try {
            conn = ConnectionManager.getConexao();
            prepStmt = conn.prepareStatement(INSERT_QUERY);
            prepStmt.setString(1, obj.getNome());
            prepStmt.setLong(2, obj.getCpf());
            prepStmt.setLong(3, obj.getTelefone());
            prepStmt.setString(4, obj.getEmail());
            prepStmt.setString(5, obj.getSenha());
            prepStmt.execute();
            
//            prepStmt.setNull(2, Types.BIGINT);
            
            System.out.println(INSERT_QUERY);
            
        } catch (SQLException|NullPointerException e) {
            String msg = "[ClienteDAO][save(Cliente)]: " + e.getMessage();
            throw new JavaWebException(msg, e);
        } finally {
            ConnectionManager.closeAll(conn, prepStmt, rs);
        }
    }

    public List<Cliente> getListaCliente() throws JavaWebException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Cliente> lista = new ArrayList<Cliente>();
        try {
            conn = ConnectionManager.getConexao();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SELECT_ALL_QUERY);
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String codigo = rs.getString("codigo");
                String descricao = rs.getString("descricao");
                String imagem = rs.getString("image");
                double preco = rs.getFloat("preco");
//                Produto p = new Produto(id, nome, codigo, descricao, preco, imagem);
//               
//                lista.add(p);
            }
        } catch (SQLException e) {
            String msg = "[ProdutosDB][getCatalogoProdutos()]: " + e.getMessage();
            JavaWebException ge = new JavaWebException(msg, e);
            throw ge;
        } finally {
            ConnectionManager.closeAll(conn, stmt, rs);
        }
        return lista;
    }

    public Cliente getClienteById(Long id) throws JavaWebException {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
       
        try {
            conn = ConnectionManager.getConexao();
            prepStmt = conn.prepareStatement(SELECT_BY_ID_QUERY);
            
//            prepStmt.setInt(1, id);
            
            rs = prepStmt.executeQuery();
            if (rs.next()) {
//                String nome = rs.getString("nome");
//                String codigo = rs.getString("codigo");
//                String descricao = rs.getString("descricao");
//                String imagem = rs.getString("image");
//                double preco = rs.getFloat("preco");
//                oProduto = new Produto(id, nome, codigo, descricao, preco, imagem);
            }
        } catch (SQLException e) {
            String msg = "[ProdutosDB][getProdutoById()]: " + e.getMessage();
            JavaWebException ge = new JavaWebException(msg, e);
            throw ge;
        } finally {
            ConnectionManager.closeAll(conn, prepStmt, rs);
        }
        return cliente;
    }

    public void createTable() throws JavaWebException {
        Connection conn = null;
        Statement stmt = null;
        try {

            conn = ConnectionManager.getConexao();
            stmt = conn.createStatement();
            stmt.executeUpdate(CREATE_TABLE);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new JavaWebException("Erro ao criar a tabela de produtos", e);
        } finally {
            ConnectionManager.closeAll(conn, stmt);
        }
    }

	@Override
	public Cliente getClienteByLogin(Cliente obj) throws JavaWebException {
		Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
       
        try {
            conn = ConnectionManager.getConexao();
            prepStmt = conn.prepareStatement(SELECT_BY_LOGIN_QUERY);
            
            prepStmt.setString(1, obj.getEmail());
            prepStmt.setString(2, obj.getSenha());
            
            rs = prepStmt.executeQuery();
            if (rs.next()) {
        		cliente = montaCliente(rs,new Cliente());
            }
        } catch (SQLException e) {
            String msg = "[ProdutosDB][getProdutoById()]: " + e.getMessage();
            JavaWebException ge = new JavaWebException(msg, e);
            throw ge;
        } finally {
            ConnectionManager.closeAll(conn, prepStmt, rs);
        }
        return cliente;
	}
	
	private Cliente montaCliente(ResultSet rs, Cliente c) throws SQLException{
		c.setId(rs.getLong("id"));
		c.setNome(rs.getString("nome"));
		c.setCpf(rs.getLong("cpf"));
		c.setTelefone(rs.getLong("telefone"));
		c.setEmail(rs.getString("email"));
		c.setSenha(rs.getString("senha"));
		
		return c;
	}
}
