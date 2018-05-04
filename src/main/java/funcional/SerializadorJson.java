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


public class SerializadorJson {

	private Gson deserializador;
	
	public SerializadorJson() {
		this.deserializador = new GsonBuilder()
				.registerTypeAdapter(LocalDate.class, this.localDateDeserializer())
				.create();
	}
	
	public List<Cliente> deserializarClientes(Path archivoClientes) throws FileNotFoundException {
		JsonReader jsonReader = new JsonReader(new FileReader(archivoClientes.toFile()));
		Type tipoLista = new TypeToken<List<Cliente>>() {}.getType();

		return deserializador.fromJson(jsonReader, tipoLista);
	}

	private JsonDeserializer<LocalDate> localDateDeserializer() {
		return new JsonDeserializer<LocalDate> () {
			@Override
			public LocalDate deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
				String date = json.getAsString();
				return LocalDate.parse(date);
			}
		};
	}

}
