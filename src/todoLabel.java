import java.util.ArrayList;
import java.util.Collections;

public class todoLabel {
	private String headtext;
	private ArrayList<String> description;
	private int duedate;
	private boolean completed;
	private int priorityIndex;
	
	public todoLabel(String headtext, int duedate, String... description){
		this.headtext = headtext;
		this.duedate = duedate;
		this.completed = false;
		Collections.addAll(this.description, description);
	}
}
