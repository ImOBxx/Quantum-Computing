import java.io.*;
import com.qiskit.providers.ibmq.IBMQ;
import com.qiskit.providers.ibmq.runtime.IBMRuntime;
import com.qiskit.providers.ibmq.runtime.QiskitRuntime;
import com.qiskit.providers.ibmq.runtime.RunConfig;
import com.qiskit.providers.ibmq.runtime.RunConfigBuilder;
import com.qiskit.providers.ibmq.runtime.RunResult;
import com.qiskit.providers.ibmq.runtime.RunResultData;
 
class QuantumProgram {
    public static void main (String[] args) {
       // Enter your API token here
        String apiToken = "ENTER API TOKEN HERE";
         
        // Enable IBM Quantum Experience account
        IBMQ.enableAccount(apiToken);
         
        // Get the IBM Quantum provider
        IBMRuntime ibmRuntime = IBMQ.getRuntime();
         
        // Specifies the quantum device
        String backendName = "ibmq_qasm_simulator";
         
        // Print a message
        System.out.println("\n Shor's Algorithm");
        System.out.println("--------------------");
        System.out.println("\nExecuting...\n");
         
        // Function to run Shor's algorithm
        // where 35 is the integer to be factored
        int numberToFactorize = 35;
         
        RunConfig runConfig = new RunConfigBuilder()
                .backend(backendName)
                .shots(1)
                .build();
         
        QiskitRuntime shorRuntime = ibmRuntime.run(
                Shor.class.getName(),
                RunConfig.class.getName(),
                runConfig,
                new int[]{numberToFactorize});
         
        // Wait for the runtime to finish
        shorRuntime.await();
         
        // Get the result from the runtime
        RunResult runResult = shorRuntime.getResult();
        RunResultData resultData = runResult.getData();
         
        // Get factors from results
        Object[] result = (Object[]) resultData.get("factors");
         
        // Print the result
        System.out.println(result[0]);
         
        // Print a message to close
        System.out.println("\nPress any key to close");
    }
}