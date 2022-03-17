package com.example.assignmenttops.other_stuff;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.assignmenttops.Adapter.ArrayAdapter;
import com.example.assignmenttops.Adapter.SimpleAdapterFragment;
import com.example.assignmenttops.AdapterAssignment.ArrayAdapterListViewFragment;
import com.example.assignmenttops.AdapterAssignment.ArrayListSpinnerFragment;
import com.example.assignmenttops.AdapterAssignment.EmployeeSimpleAdapterFragment;
import com.example.assignmenttops.AdapterAssignment.SearchViewListViewFragment;
import com.example.assignmenttops.intent_action.DifferentActionsActivity;
import com.example.assignmenttops.ListOfButtonsAdapter.Buttons;
import com.example.assignmenttops.ListOfButtonsAdapter.ButtonsAdapter;
import com.example.assignmenttops.R;

import com.example.assignmenttops.toolbar.ToolBarActivity;
import com.example.assignmenttops.bottom_navigation.BottomNavigationActivity;
import com.example.assignmenttops.dialog_assignment.ContextualMenuFragement;
import com.example.assignmenttops.dialog_assignment.CustomDialogFragment;
import com.example.assignmenttops.dialog_assignment.CustomToastAssignment;
import com.example.assignmenttops.dialog_assignment.DatePickerAssignmentFragment;
import com.example.assignmenttops.dialog_assignment.DialogActivity;
import com.example.assignmenttops.dialog_assignment.GmailRecyclerViewFragment;
import com.example.assignmenttops.dialog_assignment.MultiChoiceDialogFragment;
import com.example.assignmenttops.dialog_assignment.SingleChoiceDialogFragment;
import com.example.assignmenttops.dialog_assignment.TotalDaysFragment;
import com.example.assignmenttops.dialog_assignment.TotalTimeFragment;
import com.example.assignmenttops.external_storage.ExternalStorageActivity;
import com.example.assignmenttops.file_storage.OneTimeLoginActivity;
import com.example.assignmenttops.file_storage.ReadWriteMessageActivity;
import com.example.assignmenttops.menu_assignment.MenuDemoFragment;
import com.example.assignmenttops.recyclerview.EmployeeRecyclerViewFragment;
import com.example.assignmenttops.recyclerview.ImageRecyclerViewFragment;
import com.example.assignmenttops.recyclerview.LastProgramRecyclerView;
import com.example.assignmenttops.recyclerview.ProductRecyclerViewFragment;
import com.example.assignmenttops.recyclerview.UserRecyclerViewFragment;
import com.example.assignmenttops.UIcontrol.AsmdUIRadioFragment;
import com.example.assignmenttops.UIcontrol.BetweenNumberFragment;
import com.example.assignmenttops.UIcontrol.ChangeBackgroundFragment;
import com.example.assignmenttops.UIcontrol.FontSizeFragment;
import com.example.assignmenttops.UIcontrol.FourImageFragment;
import com.example.assignmenttops.UIcontrol.HideShowTextViewFragment;
import com.example.assignmenttops.UIcontrol.InternetFragment;
import com.example.assignmenttops.UIcontrol.ListViewFragment;
import com.example.assignmenttops.UIcontrol.ReverseNumberFragment;
import com.example.assignmenttops.UIcontrol.TextViewInTableLayoutFragment;
import com.example.assignmenttops.WebViewAssignment.LoadHtmlWebViewActivity;
import com.example.assignmenttops.WebViewAssignment.NewWebViewActivity;
import com.example.assignmenttops.databinding.FragmentListOfbuttonsBinding;
import com.example.assignmenttops.recyclerview_crud_operation.RecyclerViewMain;
import com.example.assignmenttops.sqllite_crud_operations.PersonActivity;
import com.example.assignmenttops.sqllite_crud_operations.PersonListActivity;
import com.example.assignmenttops.viewpager_assignment.ViewPagerHostActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListOfbuttonsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListOfbuttonsFragment extends Fragment implements View.OnClickListener, ButtonsAdapter.ButtonsClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListOfbuttonsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListOfbuttonsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListOfbuttonsFragment newInstance(String param1, String param2) {
        ListOfbuttonsFragment fragment = new ListOfbuttonsFragment();
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
    private FragmentListOfbuttonsBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentListOfbuttonsBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.recyclerviewinbuttons.setLayoutManager(new GridLayoutManager(getContext(),2));
        ArrayList<Buttons> buttons= new ArrayList<>();

//        buttons.add(new Buttons("Online Json",null, OnlineActivity.class));
//        buttons.add(new Buttons("Realm DataBase",null, RealmPracticeActivity.class));
        buttons.add(new Buttons("External Storage",null, ExternalStorageActivity.class));
        buttons.add(new Buttons("IntentActions",null, DifferentActionsActivity.class));
        buttons.add(new Buttons("PersonDataSqlList",null, PersonListActivity.class));
        buttons.add(new Buttons("PersonDatabase",null, PersonActivity.class));
        buttons.add(new Buttons("LoginActivity",null, OneTimeLoginActivity.class));
        buttons.add(new Buttons("ReadWriteMessage",null,ReadWriteMessageActivity.class));
        buttons.add(new Buttons("EditText",new EditTextFragment(),null));
        buttons.add(new Buttons("RadioButton",new RadioButtonFragment(),null));
        buttons.add(new Buttons("CheckBox",new CheckBoxFragment(),null));
        buttons.add(new Buttons("WebView",null,WebViewActivity.class));
        buttons.add(new Buttons("SeekBar",new SeekBarFragment(),null));
        buttons.add(new Buttons("Spinner",new SpinnerFragment(),null));
        buttons.add(new Buttons("Adapter",new ArrayAdapter(),null));
        buttons.add(new Buttons("Simple Adapter",new SimpleAdapterFragment(),null));
        buttons.add(new Buttons("RecyclerView",new UserRecyclerViewFragment(),null));
        buttons.add(new Buttons("ToastDialogDateTime",new ToastDialogDateTimeFragment(),null));
        buttons.add(new Buttons("Menu",new MenuFragment(),null));
        buttons.add(new Buttons("Registration Fragment",new RegistrationFragment(),null));
        buttons.add(new Buttons("ReverseFragment",new ReverseNumberFragment(),null));
        buttons.add(new Buttons("BetweenNumberFragment",new BetweenNumberFragment(),null));
        buttons.add(new Buttons("AsmdRadio",new AsmdUIRadioFragment(),null));
        buttons.add(new Buttons("InternetFragment",new InternetFragment(),null));
        buttons.add(new Buttons("HideShowTextView",new HideShowTextViewFragment(),null));
        buttons.add(new Buttons("TextViewInTableLayout",new TextViewInTableLayoutFragment(),null));
        buttons.add(new Buttons("ChangeBackGroundColor",new ChangeBackgroundFragment(),null));
        buttons.add(new Buttons("ChangeFontSize",new FontSizeFragment(),null));
        buttons.add(new Buttons("FourImage",new FourImageFragment(),null));
        buttons.add(new Buttons("ListViewFragment",new ListViewFragment(),null));
        buttons.add(new Buttons("RadioChangeColor",new DisplayColorRadioFragment(),null ));
        buttons.add(new Buttons("ArrayListSpinner",new ArrayListSpinnerFragment(),null));
        buttons.add(new Buttons("ArrayAdapterListView",new ArrayAdapterListViewFragment(),null));
        buttons.add(new Buttons("SearchViewInListView",new SearchViewListViewFragment(),null));
        buttons.add(new Buttons("NewWebViewActivity",null, NewWebViewActivity.class));
        buttons.add(new Buttons("LoadHtml",null, LoadHtmlWebViewActivity.class));
        buttons.add(new Buttons("EmployeeSimpleAdapter",new EmployeeSimpleAdapterFragment(),null));
        buttons.add(new Buttons("EmployeeRecyclerView",new EmployeeRecyclerViewFragment(),null));
        buttons.add(new Buttons("ImageRecyclerView",new ImageRecyclerViewFragment(),null));
        buttons.add(new Buttons("ToolBar",null, ToolBarActivity.class));
        buttons.add(new Buttons("ViewPagerHost",null, ViewPagerHostActivity.class));
        buttons.add(new Buttons("RecyclerViewCrud",null, RecyclerViewMain.class));
        buttons.add(new Buttons("ProductRecycler",new ProductRecyclerViewFragment(),null));
        buttons.add(new Buttons("LastProgramRecyclerView",null, LastProgramRecyclerView.class));
        buttons.add(new Buttons("Dialog",null, DialogActivity.class));
        buttons.add(new Buttons("SingleChoiceDialog",new SingleChoiceDialogFragment(),null));
        buttons.add(new Buttons("DatePicker",new DatePickerAssignmentFragment(),null));
        buttons.add(new Buttons("MultiChoiceDialog",new MultiChoiceDialogFragment(),null));
        buttons.add(new Buttons("TotalDays",new TotalDaysFragment(),null));
        buttons.add(new Buttons("Custom Toast",new CustomToastAssignment(),null));
        buttons.add(new Buttons("Total Time",new TotalTimeFragment(),null));
        buttons.add(new Buttons("Custom Dialog",new CustomDialogFragment(),null));
        buttons.add(new Buttons("Menu Demo",new MenuDemoFragment(),null));
        buttons.add(new Buttons("ContextMenu \nAssignment",new ContextualMenuFragement(),null));
        buttons.add(new Buttons("GmailDataFragment",new GmailRecyclerViewFragment(),null));
        buttons.add(new Buttons("BottomNavigation",null, BottomNavigationActivity.class));


        ButtonsAdapter adapter=new ButtonsAdapter(this);

        adapter.setItem(buttons);

        binding.recyclerviewinbuttons.setAdapter(adapter);

//        binding.btnedittext.setOnClickListener(this);
//        binding.btnradiobutton.setOnClickListener(this);
//        binding.btncheckbox.setOnClickListener(this);
//        binding.btnwebview.setOnClickListener(this);
//        binding.btnSeekBar.setOnClickListener(this);
//        binding.btnspinner.setOnClickListener(this);
//        binding.btnadapter.setOnClickListener(this);
//        binding.btnsimpleadapter.setOnClickListener(this);
//        binding.btnrecyclerview.setOnClickListener(this);
//        binding.btntoastdialogdatetime.setOnClickListener(this);
//        binding.btnmenu.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
//        switch(v.getId()){
//            case R.id.btnedittext:
//                switchFrgament(new EditTextFragment());
//                break;
//            case R.id.btnradiobutton:
//                switchFrgament(new RadioButtonFragment());
//                break;
//            case R.id.btncheckbox:
//                switchFrgament(new CheckBoxFragment());
//                break;
//            case R.id.btnwebview:
//                switchActivity(WebViewActivity.class);
//                break;
//            case R.id.btnSeekBar:
//                switchFrgament(new SeekBarFragment());
//                break;
//            case R.id.btnspinner:
//                switchFrgament(new SpinnerFragment());
//                break;
//            case R.id.btnadapter:
//                switchFrgament(new ArrayAdapter());
//                break;
//            case R.id.btnsimpleadapter:
//                switchFrgament(new SimpleAdapterFragment());
//                break;
//            case R.id.btnrecyclerview:
//                switchFrgament(new RecyclerViewFragment());
//                break;
//            case R.id.btntoastdialogdatetime:
//                switchFrgament(new ToastDialogDateTimeFragment());
//                break;
//            case R.id.btnmenu:
//                switchFrgament(new MenuFragment());
//        }


    }

    private void switchActivity(Class<?extends Activity> TheClass) {
        Intent intent=new Intent(getContext(),TheClass);
        startActivity(intent);
    }

    private void switchFrgament(Fragment fragment){
            FragmentManager manager=getFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.otherstufflinear,fragment);
        transaction.addToBackStack(ListOfbuttonsFragment.class.getName());
        transaction.commit();

        }

    @Override
    public void onButtonsClick(Buttons button) {
        if(button.getFragment()==null){
            switchActivity(button.getActivityClass());
        }
        else{
        switchFrgament(button.getFragment());
        }
    }
}