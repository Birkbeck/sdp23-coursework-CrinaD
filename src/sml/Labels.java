package sml;

import javax.print.attribute.standard.JobKOctets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

// TODO: write a JavaDoc for the class

/**
 *
 * @author ...
 */
public final class Labels {
	private final Map<String, Integer> labels = new HashMap<>();

	/**
	 * Adds a label with the associated address to the map.
	 *
	 * @param label the label
	 * @param address the address the label refers to
	 */
	public void addLabel(String label, int address) {
		Objects.requireNonNull(label);
		// TODO: Add a check that there are no label duplicates.
        if(labels.containsKey(label) == false){
			labels.put(label, address);
		}
		else {
			throw new IllegalStateException("Duplicate Labels" );
		}

	}

	/**
	 * Returns the address associated with the label.
	 *
	 * @param label the label
	 * @return the address the label refers to
	 */
	public int getAddress(String label) {
		// TODO: Where can NullPointerException be thrown here?
		//       (the get() method can return null if the value of associated with the label is null or if there is no
		//       such label in the map. So contansKey() can be used to check if the key actually exists and then use get
		//       to return it's value)

		//       Add code to deal with non-existent labels.


		if(labels.containsKey(label)){
			return labels.get(label);
		}
		else{
			throw new NullPointerException("No instruction associated with the label.");
		}

	}

	/**
	 * representation of this instance,
	 * in the form "[label -> address, label -> address, ..., label -> address]"
	 *
	 * @return the string representation of the labels map
	 */
	@Override
	public String toString() {
		// TODO: Implement the method using the Stream API (see also class Registers).
		return labels.entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.map(e -> e.getKey() + " = " + e.getValue())
				.collect(Collectors.joining(", ", "[", "]")) ;

	}

	// TODO: Implement equals and hashCode (needed in class Machine).
	@Override
	public boolean equals(Object l){
		if(l instanceof Labels){
			Labels l1 = (Labels) l;
			return Objects.equals(this.labels, l1);
		}
		return false;
	}
	@Override
	public int hashCode(){
		return (int) labels.hashCode();
	}
	/**
	 * Removes the labels
	 */
	public void reset() {
		labels.clear();
	}
}
