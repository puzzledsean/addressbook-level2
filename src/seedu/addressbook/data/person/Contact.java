package seedu.addressbook.data.person;

public class Contact {
    protected String value;
    protected boolean isPrivate;
    
    public String toString() {
        return value;
    }
    
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
    
    public String getValue(){
    	return this.value;
    }
}
