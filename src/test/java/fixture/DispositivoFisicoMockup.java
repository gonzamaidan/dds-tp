package fixture;

import dominio.dispositivo.fisicos.DispositivoFisico;
import dominio.dispositivo.fisicos.TipoConcreto;
import dominio.dispositivo.fisicos.TipoGenerico;

public class DispositivoFisicoMockup extends DispositivoFisico {
	
	public DispositivoFisicoMockup() {
		super(TipoGenerico.AireAcondicionado, TipoConcreto.De2200Frigorias);
	}

	@Override
	public void apagar() {
	}

	@Override
	public void encender() {
	}

}
