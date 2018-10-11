import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * A todoLabel is a label/box arranged in the "todoList".
 * The todoLabel contains data about an issue the user might want to solve.
 * The user is able to describe the issue, set a due date for it to be completed
 */
public class ToDoLabel {
    private String headtext;
    private ArrayList<String> description;
    private Date duedate;
    private boolean completed;

    public ToDoLabel(String headtext, Date duedate, String... description){
        this.headtext = headtext;
        this.duedate = duedate;
        this.completed = false;
        this.description = new ArrayList<>();
        Collections.addAll(this.description, description);
    }

    public String getHeadtext() {
        return headtext;
    }

    public void setHeadtext(String headtext) {
        this.headtext = headtext;
    }

    public ArrayList<String> getDescription() {
        return description;
    }

    public void setDescription(ArrayList<String> description) {
        this.description = description;
    }

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }

    public boolean isCompleted() {
        return completed;
    }

    /**
     * Toggles the completed status of the label
     * @return true if the label was toggled from false to true
     */
    public boolean toggleCompleted() {
        return completed = !completed;
    }
}