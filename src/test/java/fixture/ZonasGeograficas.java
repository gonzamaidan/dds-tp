package fixture;

import java.util.ArrayList;
import java.util.List;

import dominio.Transformador;
import dominio.ZonaGeografica;

public class ZonasGeograficas {
	
	Transformadores transformadores = new Transformadores();
	
	public ZonaGeografica zonaCon2Transformadores() {
		
		List<Transformador> listaTransformadores = new ArrayList<>();
		listaTransformadores.add(transformadores.transformadorCon3Clientes());
		listaTransformadores.add(transformadores.transformadorCon1Cliente());
		
		ZonaGeografica zona1 = new ZonaGeografica(200.7, listaTransformadores);
		
		return zona1;
		
	}
	
public ZonaGeografica zonaCon3Transformadores() {
		
		List<Transformador> listaTransformadores = new ArrayList<>();
		listaTransformadores.add(transformadores.transformadorCon3Clientes());
		listaTransformadores.add(transformadores.transformadorCon1Cliente());
		listaTransformadores.add(transformadores.transformadorCon4Clientes());
		
		ZonaGeografica zona2 = new ZonaGeografica(344.7, listaTransformadores);
		
		return zona2;
		
	}
	
	

}
