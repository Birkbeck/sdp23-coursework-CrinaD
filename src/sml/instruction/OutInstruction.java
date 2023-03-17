package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;

import java.util.Objects;

// TODO: write a JavaDoc for the class

/**
 * @author
 * Code to excute the out instruction
 */

public class OutInstruction extends Instruction {

    private final RegisterName source;

    public static final String OP_CODE = "out";

    public OutInstruction(String label,  RegisterName source) {
        super(label, OP_CODE);

        this.source = source;
    }

    @Override
    public int execute(Machine m) {

        int value=  m.getRegisters().get(source);
        System.out.println(value);
        return NORMAL_PROGRAM_COUNTER_UPDATE;
    }

    @Override
    public String toString() {
        return getLabelString() + getOpcode() + " " + source;
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
}

