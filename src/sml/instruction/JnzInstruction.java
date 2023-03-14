package sml.instruction;

import sml.Instruction;
import sml.Labels;
import sml.Machine;
import sml.RegisterName;

// TODO: write a JavaDoc for the class

/**
 * @author
 */

public class JnzInstruction extends Instruction {

    private final RegisterName source;
    private final Labels newLabel;

    public static final String OP_CODE = "jnz";

    public JnzInstruction(String label, RegisterName source, Labels newLabel) {
        super(label, OP_CODE);
        this.newLabel = newLabel;
        this.source = source;
    }

    @Override
    public int execute(Machine m) {

        int value = m.getRegisters().get(source);
        if(value!=0) {
            return newLabel.getAddress(label);
        }
        return NORMAL_PROGRAM_COUNTER_UPDATE;

    }

    @Override
    public String toString() {
        return getLabelString() + getOpcode() + " " + source + " " + newLabel ;
    }
}

