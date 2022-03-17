package com.example.assignmenttops.UIcontrol;

import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.assignmenttops.R;
import com.example.assignmenttops.databinding.FragmentTextViewInTableLayoutBinding;

import org.jetbrains.annotations.NotNull;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TextViewInTableLayoutFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TextViewInTableLayoutFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TextViewInTableLayoutFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TextViewInTableLayoutFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TextViewInTableLayoutFragment newInstance(String param1, String param2) {
        TextViewInTableLayoutFragment fragment = new TextViewInTableLayoutFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private FragmentTextViewInTableLayoutBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        TableLayout table=new TableLayout(getContext());
//
//        table.setShrinkAllColumns(true);
//        table.setStretchAllColumns(true);
//
//        TableRow rowid=new TableRow(getContext());
//        TableRow rowname=new TableRow(getContext());
//        TableRow rowphone=new TableRow(getContext());
//
//
//        //CREATE ROW TITTLES
//        TextView label1=new TextView(getContext());
//        label1.setText("Id");
//        TextView label2=new TextView(getContext());
//        label1.setText("Name");
//        TextView label3=new TextView(getContext());
//        label1.setText("Phone");
//
//        rowid.addView(label1);
//        rowname.addView(label2);
//        rowphone.addView(label3);
//
//        //ADD DATA ROW 1
//        TextView tv1=new TextView(getContext());
//        tv1.setText("1");
//        TextView tv2=new TextView(getContext());
//        tv2.setText("Arpit");
//        TextView tv3=new TextView(getContext());
//        tv3.setText("4774");
//                                                   AA CODE MA ROW IN FIRST 2 ITEM DISPLAY THATI NATHI
//        rowid.addView(tv1);
//        rowname.addView(tv2);
//        rowphone.addView(tv3);
//
//        //ADD DATA ROW 2
//        TextView tv4=new TextView(getContext());
//        tv4.setText("1");
//        TextView tv5=new TextView(getContext());
//        tv5.setText("Arpit");
//        TextView tv6=new TextView(getContext());
//        tv6.setText("4774");
//
//        rowid.addView(tv4);
//        rowname.addView(tv5);
//        rowphone.addView(tv6);
//
//        //ADD ROWS TO TABLE
//        table.addView(rowid);
//        table.addView(rowname);
//        table.addView(rowphone);

//        TableLayout.LayoutParams tableParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT);
//        TableRow.LayoutParams rowParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
//
//        TableLayout tableLayout = new TableLayout(getContext());
//        tableLayout.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));// assuming the parent view is a LinearLayout
//
//        TableRow tableRow = new TableRow(getContext());
//        tableRow.setLayoutParams(tableParams);// TableLayout is the parent view
//
//        TextView textView = new TextView(getContext());
//        textView.setText("this is row");
//        textView.setLayoutParams(rowParams);// TableRow is the parent view
//
//        tableRow.addView(textView);


        // CODE COPY KAIRO ONLINE GITHUB https://gist.github.com/muhrifqii/41217be62daddd63efcd EASY CHE


        TableLayout table = new TableLayout(getContext());

        table.setStretchAllColumns(true);
        table.setShrinkAllColumns(true);

//        TableRow rowTitle = new TableRow(getContext());
//        rowTitle.setGravity(Gravity.CENTER_HORIZONTAL); //TITLE MATE TITLE NAI LAKHR TO PAN CHALE

        TableRow rowDayLabels = new TableRow(getContext());
        TableRow rowHighs = new TableRow(getContext());
        TableRow rowLows = new TableRow(getContext());      //table ma row add karo

        TextView empty = new TextView(getContext());

        // title column/row

//        TextView title = new TextView(getContext());
//        title.setText("Java Weather Table");
//
//        title.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
//        title.setGravity(Gravity.CENTER);
//
//        TableRow.LayoutParams params = new TableRow.LayoutParams();
//        params.span = 4;
//
//        rowTitle.addView(title, params);

        // labels column
        TextView highsLabel = new TextView(getContext());
        highsLabel.setText("Day High");
        highsLabel.setTypeface(Typeface.DEFAULT_BOLD);

        TextView lowsLabel = new TextView(getContext());
        lowsLabel.setText("Day Low");
        lowsLabel.setTypeface(Typeface.DEFAULT_BOLD);


        rowDayLabels.addView(empty); // <======
        rowHighs.addView(highsLabel);
        rowLows.addView(lowsLabel);


        // day 1 column
        TextView day1Label = new TextView(getContext());
        day1Label.setText("Feb 7");
        day1Label.setTypeface(Typeface.SERIF, Typeface.BOLD);

        TextView day1High = new TextView(getContext());
        day1High.setText("28°F");
        day1High.setGravity(Gravity.CENTER_HORIZONTAL);

        TextView day1Low = new TextView(getContext());
        day1Low.setText("15°F");
        day1Low.setGravity(Gravity.CENTER_HORIZONTAL);


        rowDayLabels.addView(day1Label);
        rowHighs.addView(day1High);
        rowLows.addView(day1Low);


        // day2 column
        TextView day2Label = new TextView(getContext());
        day2Label.setText("Feb 8");
        day2Label.setTypeface(Typeface.SERIF, Typeface.BOLD);

        TextView day2High = new TextView(getContext());
        day2High.setText("26°F");
        day2High.setGravity(Gravity.CENTER_HORIZONTAL);

        TextView day2Low = new TextView(getContext());
        day2Low.setText("14°F");
        day2Low.setGravity(Gravity.CENTER_HORIZONTAL);


        rowDayLabels.addView(day2Label);
        rowHighs.addView(day2High);
        rowLows.addView(day2Low);


        // day3 column
        TextView day3Label = new TextView(getContext());
        day3Label.setText("Feb 9");
        day3Label.setTypeface(Typeface.SERIF, Typeface.BOLD);

        TextView day3High = new TextView(getContext());
        day3High.setText("23°F");
        day3High.setGravity(Gravity.CENTER_HORIZONTAL);

        TextView day3Low = new TextView(getContext());
        day3Low.setText("3°F");
        day3Low.setGravity(Gravity.CENTER_HORIZONTAL);


        rowDayLabels.addView(day3Label);
        rowHighs.addView(day3High);
        rowLows.addView(day3Low);


        //table.addView(rowTitle);
        table.addView(rowDayLabels);
        table.addView(rowHighs);            //Last ma Row Table ma add karo
        table.addView(rowLows);


        return table;


    }


}