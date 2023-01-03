package controle;

import java.util.ArrayList;

import modelo.MVeiculo;

public class CVeiculoControl {

	private static ArrayList<MVeiculo> TableVeiculos;
	
	private static CVeiculoControl instancia;
	
	// Instanciar veiculo
	public static CVeiculoControl getInstacia() {
		if (instancia == null) {
			instancia = new CVeiculoControl();
			TableVeiculos = new ArrayList<>();
		}
		return instancia;
	}
	//INSERT
	public Boolean inserir(MVeiculo v) {
		if (v != null) {
			this.TableVeiculos.add(v);
			return true;
		}
		return false;
	}
	//UPDATE
	public Boolean alterar(MVeiculo v, Integer wIDVeiculo) {
		for(MVeiculo mv : TableVeiculos) {
			if (mv.getwIDVeiculo() == wIDVeiculo) {
				mv.setwIDVeiculo	(v.getwIDVeiculo());
				mv.setwPlaca		(v.getwPlaca());
				mv.setwTipoVeiculo	(v.getwTipoVeiculo());
				mv.setwCor			(v.getwCor());
				mv.setwMarca		(v.getwMarca());
				mv.setwCombustivel	(v.getwCombustivel());
				mv.setwNacional		(v.getwNacional());
				mv.setwAnoModelo	(v.getwAnoModelo());
				mv.setwDonoVeiculo  (v.getwDonoVeiculo());
				return true;
			}
		}
		return false;
	}

	//DELETE
	public Boolean deletar(MVeiculo v, Integer wIDVeiculo) {
		for (MVeiculo mv : TableVeiculos) {
			if (mv.getwIDVeiculo() == wIDVeiculo) {
				TableVeiculos.remove(mv);
				return true;
			}
		}
		return false;
	}
	//SELECT
	public ArrayList<MVeiculo> listaVeiculos(){
		return TableVeiculos; 
	}	
}
