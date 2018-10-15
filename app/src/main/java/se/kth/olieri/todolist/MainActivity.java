package se.kth.olieri.todolist;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

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
        layout.addView(createListView("Mat", 60, 30));
        layout.addView(createListView("Plugg", 40, 30));
        layout.addView(createListView("Övrigt", 40, 30));
        layout.addView(createListView("Plugg", 40, 30));
        layout.addView(createListView("Övrigt", 40, 30));
        layout.addView(createListView("Plugg", 40, 30));
        layout.addView(createListView("Övrigt", 40, 30));
    }

    private TextView createListView(String name, int width, int height){
        TextView view = new TextView(this);
        view.setText(name);
        view.setBackgroundColor(Color.parseColor("#00FF00"));
        view.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        ViewGroup.MarginLayoutParams params =  (ViewGroup.MarginLayoutParams)
                new ViewGroup.MarginLayoutParams(
                        getDPScale(width),
                        getDPScale(height)
                );
        params.setMargins(0, 0, 0, getDPScale(10));
        view.setLayoutParams(params);

        return view;
    }

    private int getDPScale(int dps){
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