import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphConnections {
	
	public void traceAllConnections(char vertices[], int matrix[][]) {
		Map<Character, List<Character>> connections = new HashMap<>();
		if ( vertices == null || vertices.length <= 1 ) {
			System.out.println("Not enough vertices to connect");
			return;
		}
		if ( matrix == null || matrix.length <= 1 ) {
			System.out.println("Not enough connections to trace");
			return;
		}
		int nodes = vertices.length;
		//final List<Character> connectedNodes;
		for ( int i = 0; i < nodes; i++ ) {
			final List<Character> connectedNodes = new ArrayList<>();
			Character currChar = vertices[i];
			int pathIndices[] = matrix[i];
			System.out.println(Arrays.toString(pathIndices));
			for ( int j = 0; j < pathIndices.length; j++ ) {
				if ( pathIndices[j] == 1 ) {
					connectedNodes.add(vertices[j]);
				}
			}
			connections.put(currChar, connectedNodes);
		}
		for (Map.Entry<Character, List<Character>> connection : connections.entrySet() ) {
			System.out.println("Connection: " + connection.getKey() + ": " + connection.getValue());
		}
	}

	public static void main(String[] args) {
		GraphConnections connections = new GraphConnections();
		char vertexData[] = {'A', 'B', 'C', 'D'};
		
		int adjacency_matrix[][] = {
				    {0, 1, 1, 1},  // Edges for A
				    {1, 0, 1, 0},  // Edges for B
				    {1, 1, 0, 0},  // Edges for C
				    {1, 0, 0, 0}   // Edges for D
		};
		connections.traceAllConnections(vertexData, adjacency_matrix);
	}

}
