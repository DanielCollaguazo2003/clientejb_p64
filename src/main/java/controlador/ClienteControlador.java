/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import ec.edu.ups.ppw63.demo63.business.GestionClientesRemoto;
import ec.edu.ups.ppw63.demo63.model.Cliente;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author colla
 */
public class ClienteControlador {

    GestionClientesRemoto gestionClientes;
    
    public ClienteControlador(Context context) {
        
        try {
            this.gestionClientes = (GestionClientesRemoto) context.lookup("ejb:/demo63/GestionClientes!ec.edu.ups.ppw63.demo63.business.GestionClientesRemoto");
        } catch (NamingException ex) {
            Logger.getLogger(ClienteControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearCliente(String nombre, String dni, String Direccion, int id) {

        try {
            // Uso del EJB
            Cliente cliente = new Cliente();
            cliente.setDni(dni);
            cliente.setNombre(nombre);
            cliente.setDireccion(Direccion);
            cliente.setCodigo(3);
            gestionClientes.guardarClientes(cliente);
            System.out.println("Cliente guardado!");
        } catch (Exception ex) {
            Logger.getLogger(ClienteControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
