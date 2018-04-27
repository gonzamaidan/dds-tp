package funcional;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import dominio.clientes.Cliente;

public class RepositorioUsuarios {
	
	private List<Cliente> clientes;
	private static RepositorioUsuarios repositorio = null;

	private RepositorioUsuarios() {
		// para evitar otras instanciaciones
	}
	
	public static RepositorioUsuarios getRepositorio() {
		if (repositorio == null) {
			repositorio = new RepositorioUsuarios();
		}
		return repositorio;
	}
	
	public void cargarClientes(Path archivoClientes) throws FileNotFoundException {
		Gson gson = new GsonBuilder()
				.registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
					@Override
					public LocalDate deserialize(JsonElement json, Type type,
					JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
						String date = json.getAsString();
						return LocalDate.parse(date);
					}
				})
				.create();

		JsonReader reader = new JsonReader(new FileReader(archivoClientes.toFile()));
		Type listType = new TypeToken<List<Cliente>>() {}.getType();

		this.clientes = gson.fromJson(reader, listType);
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}
}
