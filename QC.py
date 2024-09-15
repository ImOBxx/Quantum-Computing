from qiskit import QuantumCircuit

qc = QuantumCircuit(2, 2) #Quantum And Classical

qc.h(0) # Hadamard gate - Superposition placer 

qc.cx(0, 1) # Control Not Gate: Control Qubit and Target Qubits

qc.draw(output = 'mpl')

#Output of the program 0 or 1 || 1 or 0




