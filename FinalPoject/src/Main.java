
/*
 * Kubernetes Java Client Demo
 * Main class and dependencies created by AI (Cursor Agent) on September 1, 2025
 * 
 * This AI generated code is proof of concept only and will likely be removed/replaced in the future with code I write myself.
 * 
 * This program demonstrates basic Kubernetes cluster interaction using the official
 * Kubernetes Java client library. It connects to a local Minikube cluster and
 * performs simple operations to verify connectivity.
 */

// Kubernetes Java Client API imports
import io.kubernetes.client.openapi.ApiClient;        // Main client for K8s API communication
import io.kubernetes.client.openapi.ApiException;     // Exception type for K8s API errors
import io.kubernetes.client.openapi.Configuration;    // Global client configuration
import io.kubernetes.client.openapi.apis.CoreV1Api;   // Core Kubernetes API (pods, namespaces, etc.)
import io.kubernetes.client.openapi.models.V1Namespace; // Kubernetes Namespace object model
import io.kubernetes.client.openapi.models.V1PodList;   // Kubernetes Pod list object model
import io.kubernetes.client.util.ClientBuilder;       // Helper to build API clients
import io.kubernetes.client.util.KubeConfig;          // Kubeconfig file parser

// Standard Java imports for file handling
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
	public static void main(String[] args) {
		// Create cluster
		Cluster cluster = new Cluster("MattsCluster");
		
		// Create nodes and add to cluster
		Node node1 = new Node("MattsNode", "AMD");
		Node node2 = new Node("MattsNode2", "ARM");
		cluster.addNode(node1);
		cluster.addNode(node2);

		// Create pods and add to nodes
		Pod nginxPod = new Pod("EnginxPod", "apps");
		nginxPod.addContainer(new Container("nginx", "nginx"));
		node1.addPod(nginxPod);

		Pod nginxPod2 = new Pod("EnginxPod2", "apps");
		nginxPod2.addContainer(new Container("nginx", "nginx"));
		node2.addPod(nginxPod2);

		// Create deployment and add to cluster
		Deployment nginxDeployment = new Deployment("EnginxDeployment", "nginx", 2);
		nginxDeployment.addManagedPod(nginxPod);
		nginxDeployment.addManagedPod(nginxPod2);
		cluster.addDeployment(nginxDeployment);

		// Create dashboard with cluster relationship
		Dashboard dashboard = new Dashboard("MattsDashboard", cluster);
		
		// Display cluster information
		System.out.println(cluster);
		dashboard.displayDashboard();









		// AI generated concept code. May never use this.
	// 	try {
	// 		// Step 1: Locate and load the kubeconfig file
	// 		// This file contains cluster connection details, authentication, and context info
	// 		Path kubeConfigPath = getDefaultKubeconfigPath();
	// 		System.out.println("Using kubeconfig: " + kubeConfigPath);
			
	// 		// Step 2: Parse kubeconfig and create authenticated API client
	// 		// Use try-with-resources to ensure FileReader is properly closed
	// 		try (FileReader fileReader = new FileReader(kubeConfigPath.toFile())) {
	// 			KubeConfig kubeConfig = KubeConfig.loadKubeConfig(fileReader);
	// 			ApiClient client = ClientBuilder.kubeconfig(kubeConfig).build();
	// 			Configuration.setDefaultApiClient(client); // Set as global default client
	// 		}

	// 		// Step 3: Create CoreV1Api instance to interact with core Kubernetes resources
	// 		CoreV1Api api = new CoreV1Api();
			
	// 		// Step 4: Test connectivity by reading the 'default' namespace
	// 		// This verifies we can authenticate and communicate with the cluster
	// 		V1Namespace defaultNs = api.readNamespace("default").execute();
	// 		System.out.println("Found namespace: " + defaultNs.getMetadata().getName());

	// 		// Step 5: List all pods in the 'default' namespace (limit to 30 results)
	// 		// This demonstrates querying cluster resources
	// 		V1PodList pods = api.listNamespacedPod("default").limit(30).execute();
	// 		System.out.println("Pods in 'default': " + pods.getItems().size());
			
	// 		// Step 6: Print each pod's name
	// 		pods.getItems().forEach(p -> System.out.println("- " + p.getMetadata().getName()));
			
	// 	} catch (ApiException e) {
	// 		// Handle Kubernetes API-specific errors (authentication, authorization, etc.)
	// 		System.err.println("Kubernetes API error: " + e.getCode() + " - " + e.getResponseBody());
	// 	} catch (Exception e) {
	// 		// Handle any other errors (file I/O, network issues, etc.)
	// 		e.printStackTrace();
	// 	}
	// }

	// /**
	//  * Locates the default kubeconfig file on the system.
	//  * 
	//  * On Windows, this is typically: C:\Users\{username}\.kube\config
	//  * On Unix/Linux/Mac, this is typically: ~/.kube/config
	//  * 
	//  * @return Path to the kubeconfig file
	//  * @throws IllegalStateException if kubeconfig file doesn't exist
	//  */
	// private static Path getDefaultKubeconfigPath() {
	// 	// Try Windows-style environment variable first (USERPROFILE)
	// 	String home = System.getenv("USERPROFILE");
	// 	if (home == null || home.isEmpty()) {
	// 		// Fall back to cross-platform user.home system property
	// 		home = System.getProperty("user.home");
	// 	}
		
	// 	// Build path to standard kubeconfig location
	// 	Path path = Paths.get(home, ".kube", "config");
		
	// 	// Verify the file exists before returning
	// 	if (!Files.exists(path)) {
	// 		throw new IllegalStateException("kubeconfig not found at " + path + ". Ensure kubectl is configured (minikube)." );
	// 	}
	// 	return path;
	}
}
