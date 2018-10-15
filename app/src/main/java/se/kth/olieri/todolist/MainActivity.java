package se.kth.olieri.todolist;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import se.kth.olieri.todolist.ListGUI.GUIViewCreator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testAddSomeDynamicListsAndElements();
    }


    private void testAddSomeDynamicListsAndElements(){
        LinearLayout layout =
                findViewById(R.id.content_container)
                .findViewById(R.id.scroll1)
                .findViewById(R.id.list_container)
                .findViewById(R.id.listlayout);
        layout.addView(GUIViewCreator.createListView(this, "Mat", getDPScale(40), getDPScale(30), getDPScale(10), "#111111"));
        layout.addView(GUIViewCreator.createListView(this, "Hus", getDPScale(60), getDPScale(30), getDPScale(10), "#0000FF"));
        layout.addView(GUIViewCreator.createListView(this, "Bra", getDPScale(40), getDPScale(30), getDPScale(10), "#00FF00"));
        layout.addView(GUIViewCreator.createListView(this, "Mat", getDPScale(40), getDPScale(30), getDPScale(10), "#00FFFF"));
        layout.addView(GUIViewCreator.createListView(this, "Mat", getDPScale(40), getDPScale(30), getDPScale(10), "#FF0000"));
        layout.addView(GUIViewCreator.createListView(this, "Mat", getDPScale(40), getDPScale(30), getDPScale(10), "#FF00FF"));
        layout.addView(GUIViewCreator.createListView(this, "Mat", getDPScale(40), getDPScale(30), getDPScale(10), "#FFFF00"));
        layout.addView(GUIViewCreator.createListView(this, "Mat", getDPScale(40), getDPScale(30), getDPScale(10), "#DDDDDD"));


    }

    public int getDPScale(int dps){
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dps * scale + 0.5f);
    }
}

/**

 <TextView
 android:id="@+id/textView5"
 android:layout_width="60dp"
 android:layout_height="30dp"
 android:layout_marginBottom="10dp"
 android:background="@android:color/holo_purple"
 android:text="Food"
 android:textAlignment="center" />

 <TextView
 android:id="@+id/textView4"
 android:layout_width="40dp"
 android:layout_height="30dp"
 android:layout_marginBottom="10dp"
 android:background="@android:color/holo_orange_dark"
 android:text="Food"
 android:textAlignment="center" />

 */