package fiap.scj.client;

import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import fiap.scj.rest.Aluno;

public class RestClient {
	
	public static void main(String[] args) {
		
		String REST_URI = "http://localhost:8080/rest/aluno";
		
		Client client = Client.create();
		
		WebResource webResource = client.resource(REST_URI);
		
		ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		if (response.getStatus() != 200) {
			System.out.println("Failed : HTTP error code : " + response.getStatus());
		}
		
		List<Aluno> alunos = response.getEntity(new GenericType<List<Aluno>>() {});
		
		System.out.println("Output from Server ...");
		System.out.println(alunos);
		
	}

}
