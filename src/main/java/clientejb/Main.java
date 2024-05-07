package clientejb;

import controlador.ClienteControlador;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import ec.edu.ups.ppw63.demo63.business.GestionClientesRemoto;
import ec.edu.ups.ppw63.demo63.model.Cliente;
import vista.VistaCliente;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
            final Hashtable<String, String> jndiProperties = new Hashtable<>();
            jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
            jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
            jndiProperties.put(Context.SECURITY_PRINCIPAL, "daniel"); // Reemplaza 'username' con tu nombre de usuario
            jndiProperties.put(Context.SECURITY_CREDENTIALS, "Collaguazo123"); // Reemplaza 'password' con tu contraseña
            jndiProperties.put("jboss.naming.client.ejb.context", "true");
            final Context context = new InitialContext(jndiProperties);
            
                    ClienteControlador conCliente = new ClienteControlador(context);
                    VistaCliente v = new VistaCliente(conCliente);
                    
                    v.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }

	}

}