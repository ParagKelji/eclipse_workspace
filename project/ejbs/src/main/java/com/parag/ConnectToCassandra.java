package com.parag;

import com.datastax.astra.client.DataAPIClient;
import com.datastax.astra.client.Database;

public class ConnectToCassandra {

	public static void main(String[] args) {
		DataAPIClient client = new DataAPIClient("AstraCS:wtxxUAnGjXCrbeObADeCYwcv:e1b3465ab169a8c0101101ef6d572a67133f7e547064dad9398c69b074901f47");
		Database db = client
				.getDatabase("https://990d536e-0e90-4057-b8fb-5271a5323bea-us-east1.apps.astra.datastax.com");
		System.out.println("Connected to AstraDB " + db.listCollectionNames());
	}

}
