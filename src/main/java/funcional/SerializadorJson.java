package funcional;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import dominio.excepciones.FalloTraduccionException;

public class SerializadorJson implements InterpreteAlmacenamiento {

	private Gson deserializador;
	private Path archivoClientes;

	public SerializadorJson(String formaAlmacenamiento) throws FalloTraduccionException {
		this.deserializador = new GsonBuilder()
								.registerTypeAdapter(LocalDate.class, this.localDateDeserializer())
								.create();
		this.validarFormaAlmacenamiento(formaAlmacenamiento);
	}

	public List<Cliente> traducirAClientes() throws FalloTraduccionException {
		try {
			return this.deserializarClientes();
		} catch (FileNotFoundException e) {
			throw new FalloTraduccionException("No se pudo traducir la forma de almacenamiento", e);
		}
	}

	public void validarFormaAlmacenamiento(String formaAlmacenamiento) throws FalloTraduccionException {
		try {
			this.archivoClientes = Paths.get(formaAlmacenamiento);
		} catch (InvalidPathException e) {
			throw new FalloTraduccionException(
					"La forma de almacenamiento: " + formaAlmacenamiento + " no es un archivo Json valido", e);
		}
	}

	public List<Cliente> deserializarClientes() throws FileNotFoundException {
		JsonReader jsonReader = new JsonReader(new FileReader(archivoClientes.toFile()));
		Type tipoLista = new TypeToken<List<Cliente>>() {
		}.getType();

		return deserializador.fromJson(jsonReader, tipoLista);
	}

	private JsonDeserializer<LocalDate> localDateDeserializer() {
		return new JsonDeserializer<LocalDate>() {
			@Override
			public LocalDate deserialize(JsonElement json, Type type,
					JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
				String date = json.getAsString();
				return LocalDate.parse(date);
			}
		};
	}
}
