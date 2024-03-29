package sml;

// TODO: write a JavaDoc for the class

/**
 * Represents an abstract instruction.
 * Abstract methods need to be implemented in the subclasses and used by class Machine.
 * @author ...
 */
public abstract class Instruction {
	protected final String label;
	protected final String opcode;

	/**
	 * Constructor: an instruction with a label and an opcode
	 * (opcode must be an operation of the language)
	 *
	 * @param label optional label (can be null)
	 * @param opcode operation name
	 */
	public Instruction(String label, String opcode) {
		this.label = label;
		this.opcode = opcode;
	}

	public String getLabel() {
		return label;
	}

	public String getOpcode() {
		return opcode;
	}

	public static int NORMAL_PROGRAM_COUNTER_UPDATE = -1;

	/**
	 * Executes the instruction in the given machine.
	 *
	 * @param machine the machine the instruction runs on
	 * @return the new program counter (for jump instructions)
	 *          or NORMAL_PROGRAM_COUNTER_UPDATE to indicate that
	 *          the instruction with the next address is to be executed
	 */

	public abstract int execute(Machine machine);

	protected String getLabelString() {
		return (getLabel() == null) ? "" : getLabel() + ": ";
	}

	// TODO: What does abstract in the declaration below mean?
	//       (Abstract in the declaration below means the method has to be implemented by the subclasses of Instruction.
	//       However they don't need  to have an implementation here in the Instruction class. )
	@Override
	public abstract String toString();

	// TODO: Make sure that subclasses also implement equals and hashCode (needed in class Machine).

	@Override
	public abstract boolean equals(Object o);

	@Override
	public abstract int hashCode();

}
