package se.kth.olieri.todolist.ListBackend;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class ToDoList{
    private ArrayList<ToDoLabel> labelList;
    public ToDoList(){
        labelList = new ArrayList<>();
    }

    public ToDoList(ToDoLabel... labels){
        labelList = new ArrayList<>();
        Collections.addAll(labelList, labels);
        sortByPriority();
    }

    public static void main(String[] args) {
        ToDoLabel l1 = new ToDoLabel(
                "Envarre Lab1",
                new Date(2018, 7, 10),
                "uppgift 1-5", "fixa LateX"
        );

        l1.toggleCompleted();

        ToDoLabel l4 = new ToDoLabel(
                "Envarre Lab1",
                new Date(2018, 7, 10),
                "uppgift 1-5", "fixa LateX"
        );

        l4.toggleCompleted();

        ToDoLabel l5 = new ToDoLabel(
                "Envarre Lab1",
                new Date(2018, 7, 10),
                "uppgift 1-5", "fixa LateX"
        );

        l5.toggleCompleted();

        ToDoLabel l2 = new ToDoLabel(
                "Db inl",
                new Date(2018, 2, 41),
                "do it quick", "now!!!!"
        );

        ToDoLabel l3 = new ToDoLabel(
                "Nuwuwu Lab",
                new Date(2020, 2, 29)
        );

        ToDoLabel l6 = new ToDoLabel(
                "Envarre Lab1",
                new Date(2018, 2, 29),
                "uppgift 1-5", "fixa LateX"
        );

        ToDoList list = new ToDoList(l1, l2, l3, l4, l5, l6);

                                        // A, B, C
        list.changeLabelPosition(0,5);  // B, C, A
        list.changeLabelPosition(2,1);  // B, A, C
        list.changeLabelPosition(2,0);  // C, B, A

        System.out.println(list.toString());
    }

    public ToDoLabel removeLabel(int index){
        ToDoLabel label = labelList.remove(index);
        prioritizeByOrder();
        return label;
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
            if(to < c){
                label = labelList.remove(from);
                labelList.add(to, label);
            }else{
                labelList.add(c, label);
                labelList.remove(from);
            }
        } else {
            throw new IllegalArgumentException("Cannot move completed task");
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
        prioritizeByOrder();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (ToDoLabel label: labelList) {
            sb.append(label.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
