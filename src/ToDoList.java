import java.util.ArrayList;
import java.util.Collections;

public class ToDoList{
    private ArrayList<ToDoLabel> labelList;
    public ToDoList(){
        labelList = new ArrayList<>();
    }

    public ToDoList(ToDoLabel... labels){
        labelList = new ArrayList<>();
        Collections.addAll(labelList, labels);
    }

    public void addLabel(ToDoLabel label){
        labelList.add(0, label);
        prioritizeByOrder();
    }

    public void changeLabelPosition(int from, int to){
        if(from < 0 || from >= labelList.size()){
            throw new IndexOutOfBoundsException("Index '"+from+"' is not a valid position index");
        }else if(to < 0 || to >= labelList.size()){
            throw new IndexOutOfBoundsException("Index '"+to+"' is not a valid position index");
        }else if(from == to){
            return;
        }
        ToDoLabel label = labelList.get(from);
        if(!label.isCompleted()){
            int c = getFirstCompletedLabel();
            if(to <= c) {
                if(from > to) {
                    label = labelList.remove(from);
                    labelList.add(to, label);
                }else{
                    labelList.add(to, label);
                    labelList.remove(from);
                }
            }else{
                labelList.add(c, label);
                labelList.remove(from);
            }
        }
        prioritizeByOrder();
    }

    private int getFirstCompletedLabel(){
        sortByPriority();
        for (int i = 0; i < labelList.size(); i++) {
            if(labelList.get(i).isCompleted())
                return i;
        }
        return -1;
    }

    private void prioritizeByOrder(){
        for (int i = 0; i < labelList.size(); i++) {
            labelList.get(i).setPriority(i);
        }
    }


    public void sortByPriority(){
        Collections.sort(labelList);
    }
}
