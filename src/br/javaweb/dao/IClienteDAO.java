package br.javaweb.dao;

import java.util.List;

import br.javaweb.beans.Cliente;
import br.javaweb.util.JavaWebException;

/**
 
 */
public interface IClienteDAO {

    public void save(Cliente p) throws JavaWebException;

    public List<Cliente> getListaCliente() throws JavaWebException;

    public Cliente getClienteById(Long id) throws JavaWebException;
    
    public Cliente getClienteByLogin(Cliente obj) throws JavaWebException;

    public void createTable() throws JavaWebException;
}