package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "BLOCK, STREET, UNIT, POSTAL_CODE";
    public static final String ADDRESS_VALIDATION_REGEX = ".+,.+,.+,.+";

    private boolean isPrivate;
    
    private final int BLOCK_INDEX = 0;
    private final int STREET_INDEX = 1;
    private final int UNIT_INDEX = 2;
    private final int POSTAL_INDEX = 3;
    
    private Block block;
    private Street street;
    private Unit unit;
    private Postal postal;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        
        splitAddress(address);
    }

    /*
     * Splits the address into different array elements
     */
	private void splitAddress(String address) throws IllegalValueException{
		String[] splitAddress = address.split(", ");
		block = new Block(splitAddress[BLOCK_INDEX]);
		street = new Street(splitAddress[STREET_INDEX]);
		unit = new Unit(splitAddress[UNIT_INDEX]);
		postal = new Postal(splitAddress[POSTAL_INDEX]);       
	}

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return block.getBlock() + ", " +
    			street.getStreet() + ", " +
    			unit.getUnit() + ", " +
    			postal.getPostal();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.toString().equals(((Address) other).toString())); // state check
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}