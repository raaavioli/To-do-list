import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * A todoLabel is a label/box arranged in the "todoList".
 * The todoLabel contains data about an issue the user might want to solve.
 * The user is able to describe the issue, set a due date for it to be completed
 */
public class ToDoLabel implements Comparable<ToDoLabel>{
    private String headtext;
    private ArrayList<String> description;
    private Date duedate;
    private boolean completed;
    private int priority;

    public ToDoLabel(String headtext, int priority, Date duedate, String... description){
        this.headtext = headtext;
        this.duedate = duedate;
        this.priority = priority;
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

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * Toggles the completed status of the label
     * @return true if the label was toggled from false to true
     */
    public boolean toggleCompleted() {
        return completed = !completed;
    }

    /**
     * Compares labels by completed and priority to enable sorting
     * @param o the object to compare
     * @return
     */
    @Override
    public int compareTo(ToDoLabel o) {
        if(this.completed && !o.isCompleted()){
            return -1;
        }else if(this.completed && o.isCompleted()){
            return this.duedate.compareTo(o.duedate);
        }else if((!this.completed && o.isCompleted())) {
            return 1;
        }
        return Integer.compare(this.priority, o.priority);
    }
}