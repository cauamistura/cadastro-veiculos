package controle;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import modelo.MCliente;

public class CClienteControl {
	
	private static ArrayList<MCliente> TableClientes;
	
	
	private static CClienteControl instancia;
	
	// Instanciar Cliente
	public static CClienteControl getInstancia() {
		if (instancia == null) {
			instancia = new CClienteControl ();
			TableClientes = new ArrayList<>();
		}
		return instancia;
	} 

	//INSERT
	public Boolean inserir(MCliente Mc) {
		if (Mc != null) {
		this.TableClientes.add(Mc);
		return true;
		}
		return false;
	}
	//UPDATE
	public Boolean alterar(MCliente c, String cpfCliente) {

			for(MCliente mc : TableClientes) {
				if (mc.getwCpf().equals(cpfCliente) ) {
					
				mc.setwCpf				(c.getwCpf());
				mc.setwCarteiraMotorista(c.getwCarteiraMotorista());
				mc.setwSexo				(c.getwSexo());
				mc.setwNome				(c.getwNome());
				mc.setwNumeroTelefone	(c.getwNumeroTelefone());
				mc.setwGmail			(c.getwGmail());
				mc.setwDataNascimento	(c.getwDataNascimento());
		
			return true;
		}
	}
	return false;

	}
	
	//DELETE
	public Boolean deletar(MCliente c, String cpfCliente) {
		for (MCliente mc : TableClientes) {
			if (mc.getwCpf().equals(cpfCliente) ){
				TableClientes.remove(mc);
				return true;
			}
		}
		return false;
	}
	
	//SELECT
	public ArrayList<MCliente> listaCliente(){
		return TableClientes;
	}

}
