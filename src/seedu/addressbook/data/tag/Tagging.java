package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

public class Tagging {
	public static final String ADD_TAGGING = "+";
    public static final String DELETE_TAGGING = "-";

    private final Person person;
    private final Tag tag;
    private boolean isTagged;
    
    public Tagging(Person person, Tag tag) {
        this.person = person;
        this.tag = tag;
        isTagged = true;
    }
    
    public void deleteTagging() {
        isTagged = false;
    }
    
    public String printTagging() {
        String result = (isTagged) ? ADD_TAGGING : DELETE_TAGGING;
        result += " " + person.getName() + " " + tag.toString();
        return result;
    }    
}
