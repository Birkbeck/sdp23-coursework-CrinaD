package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;

import java.util.Objects;

// TODO: write a JavaDoc for the class

/**
 * @author
 */

public class JnzInstruction extends Instruction {

    private final String lb;
    private final RegisterName source;
    public static final String OP_CODE = "jnz";
    public JnzInstruction(String label, RegisterName source, String lb) {
        super(label, OP_CODE);
        this.source = source;
        this.lb=lb;
    }

    @Override
    public int execute(Machine m) {

        int value = m.getRegisters().get(source);
        if(value!=0) {
            return m.getLabels().getAddress(lb);
        }
        return NORMAL_PROGRAM_COUNTER_UPDATE;

    }
    @Override
    public boolean equals(Object i) {
        if(i instanceof Instruction other){
            return Objects.equals(i, other);
        }
        return false;
    }

    @Override
    public int hashCode(){
        return source.hashCode();
    };
    @Override
    public String toString() {
        return getLabelString() + getOpcode() + " " + source + " " + lb ;
    }
}

