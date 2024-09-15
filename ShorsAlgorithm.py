from qiskit import IBMQ
from qiskit.aqua import QuantumInstance
from qiskit.aqua.algorithms import Shor
 
# Enter your API token here
IBMQ.enable_account('ENTER API TOKEN HERE')  
provider = IBMQ.get_provider(hub='ibm-q')
 
# Specifies the quantum device
backend = provider.get_backend('ibmq_qasm_simulator')
 
print('\n Shors Algorithm')
print('--------------------')
print('\nExecuting...\n')
 
# Function to run Shor's algorithm 
# where 35 is the integer to be factored
factors = Shor(35)
 
result_dict = factors.run(QuantumInstance(
    backend, shots=1, skip_qobj_validation=False))
 
 # Get factors from results
result = result_dict['factors'] 
 
print(result)
print('\nPress any key to close')
input()