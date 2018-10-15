package se.kth.olieri.todolist.ListGUI;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class GUIViewCreator extends AppCompatActivity {




    /**
     * Enter information and return a view for a list-element
     * @param name  The name of the list (table name from DB)
     * @param width The width of the view in DP
     * @param height The height of the view in DP
     * @param hexcolor The hexcolor-value on the form "#RRGGBB"
     * @return A view containing above information.
     */
    public static TextView createListView(Context context, String name, int width, int height, int marginBottom, String hexcolor) {
        TextView view = new TextView(context);
        view.setText(name);
        if (hexcolor.matches("^#[\\da-fA-F]{6}$")) {
            view.setBackgroundColor(Color.parseColor(hexcolor));
            view.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            Toast.makeText(context, "hej", Toast.LENGTH_SHORT).show();
        } else {
            throw new IllegalArgumentException("No valid regex on form #RRGGBB was added");
        }


        ViewGroup.MarginLayoutParams params = new ViewGroup.MarginLayoutParams(
                        width,
                        height
                );
        params.setMargins(0, 0, 0, marginBottom);
        view.setLayoutParams(params);

        return view;
    }

}