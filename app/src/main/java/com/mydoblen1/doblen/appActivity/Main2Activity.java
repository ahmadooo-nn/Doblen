package com.mydoblen1.doblen.appActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.mydoblen1.doblen.R;
import com.mydoblen1.doblen.adapters.RecyclerMasterAdapter;
import com.mydoblen1.doblen.classes.ListMasterRecycle;
import com.mydoblen1.doblen.classes.ListMasterSpiner;
import com.mydoblen1.doblen.mydatabase.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private String tv_1,tv_2,tv_3="";
    private Boolean myChecked=false;
    private Button getData;
    private TextView tv_khadamat_1,tv_khadamat_2,tv_khadamat_3;
    private ImageView delete_tv_1,delete_tv_2,delete_tv_3;
    private AutoCompleteTextView auto_khadamat;
    private RecyclerView recyclerView;
    private RecyclerMasterAdapter recyclerMasterAdapter;
    private List<ListMasterRecycle> list;

    Animation up,down;
    private Spinner spiner_khadamat;
    DatabaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        init();
        recyclerSetUp();
        setUpSpinnerAndAutoComplete();



    }

    private void recyclerSetUp() {

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(Main2Activity.this));
        list=new ArrayList<>();
        for (int i=1; i<=6; i++){
            ListMasterRecycle listMasterRecycle=new ListMasterRecycle(" اوس احمد "+i,2,i,"09169178213","نصاب تلوزیون و ماهواره"+i," خوزستان , سر بندر "+i);
            list.add(listMasterRecycle);
        }

        recyclerMasterAdapter=new RecyclerMasterAdapter(list,Main2Activity.this);
        recyclerView.setAdapter(recyclerMasterAdapter);

    }


    private void init() {
        getData=(Button)findViewById(R.id.getData);
        tv_khadamat_1=(TextView)findViewById(R.id.tv_khadamat_1);
        tv_khadamat_2=(TextView)findViewById(R.id.tv_khadamat_2);
        tv_khadamat_3=(TextView)findViewById(R.id.tv_khadamat_3);
        delete_tv_1=(ImageView)findViewById(R.id.delete_tv_1);
        delete_tv_2=(ImageView)findViewById(R.id.delete_tv_2);
        delete_tv_3=(ImageView)findViewById(R.id.delete_tv_3);
        spiner_khadamat=(Spinner)findViewById(R.id.spinner_khadamat);
        auto_khadamat =(AutoCompleteTextView)findViewById(R.id.autocomplete_search_khadamat);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        mydb=new DatabaseHelper(Main2Activity.this);

        tv_khadamat_1.setOnClickListener(this);
        tv_khadamat_2.setOnClickListener(this);
        tv_khadamat_3.setOnClickListener(this);
        delete_tv_1.setOnClickListener(this);
        delete_tv_2.setOnClickListener(this);
        delete_tv_3.setOnClickListener(this);
        getData.setOnClickListener(this);
    }

    private void setUpSpinnerAndAutoComplete() {

        ////  Sppinner

        final List<ListMasterSpiner> listSpinner=new ArrayList<>();
        listSpinner.add(new ListMasterSpiner("لیست خدمات"));
        listSpinner.add(new ListMasterSpiner("برق کار"));
        listSpinner.add(new ListMasterSpiner("جوشکار"));
        listSpinner.add(new ListMasterSpiner("لوله کش آب"));
        listSpinner.add(new ListMasterSpiner("لوله کش گاز"));
        listSpinner.add(new ListMasterSpiner("رنگ کار"));
        listSpinner.add(new ListMasterSpiner("نقاش"));
        listSpinner.add(new ListMasterSpiner("کارگر"));
        listSpinner.add(new ListMasterSpiner("بنا"));
        listSpinner.add(new ListMasterSpiner("گچ کار"));
        listSpinner.add(new ListMasterSpiner("سنگ کار"));
        listSpinner.add(new ListMasterSpiner("سرامیک کار"));
        listSpinner.add(new ListMasterSpiner("موزاییک کار"));
        listSpinner.add(new ListMasterSpiner("موزاییک ساب"));
        listSpinner.add(new ListMasterSpiner("گرفتگی فاضلاب"));
        listSpinner.add(new ListMasterSpiner("لوله کشی فاضلاب"));
        listSpinner.add(new ListMasterSpiner("کرایه ابزار"));
        listSpinner.add(new ListMasterSpiner("زه کش"));
        listSpinner.add(new ListMasterSpiner("موکت کار"));
        listSpinner.add(new ListMasterSpiner("پلاستر کار"));
        listSpinner.add(new ListMasterSpiner("نصاب کولر"));
        listSpinner.add(new ListMasterSpiner("ام دی اف کار"));
        listSpinner.add(new ListMasterSpiner("پی وی سی کار"));
        listSpinner.add(new ListMasterSpiner("نصاب آیفون"));
        listSpinner.add(new ListMasterSpiner("درب و پنجره UPVC"));
        listSpinner.add(new ListMasterSpiner("کناف کار"));
        listSpinner.add(new ListMasterSpiner("راویز کار"));
        listSpinner.add(new ListMasterSpiner("نصاب بخاری"));
        listSpinner.add(new ListMasterSpiner("کانال کش کولر"));
        listSpinner.add(new ListMasterSpiner("نصاب درب ضد صرقت"));
        listSpinner.add(new ListMasterSpiner("داربست بند"));
        listSpinner.add(new ListMasterSpiner("نصاب ایزوگام"));
        listSpinner.add(new ListMasterSpiner("نصاب تلوزیون و ماهواره"));
        listSpinner.add(new ListMasterSpiner("نجار"));
        listSpinner.add(new ListMasterSpiner("ضایعاتی"));
        listSpinner.add(new ListMasterSpiner("شیشه بر"));
        listSpinner.add(new ListMasterSpiner("باغبان"));
        listSpinner.add(new ListMasterSpiner("حرص کاری درخت"));
        listSpinner.add(new ListMasterSpiner("پیمان کار"));
        listSpinner.add(new ListMasterSpiner("گوود کن"));
        listSpinner.add(new ListMasterSpiner("ماشین جرثقیل"));
        listSpinner.add(new ListMasterSpiner("ماشین لودر"));
        listSpinner.add(new ListMasterSpiner("ماشین تراکتور"));
        listSpinner.add(new ListMasterSpiner("ماشین بیل مکانیکی"));
        listSpinner.add(new ListMasterSpiner("ماشین میکسر"));
        listSpinner.add(new ListMasterSpiner("ماشین بتن ریز"));
        listSpinner.add(new ListMasterSpiner("طراح ساختمان"));
        listSpinner.add(new ListMasterSpiner("هوشمند ساز ساختمان"));
        listSpinner.add(new ListMasterSpiner("آلمتر بند"));
        listSpinner.add(new ListMasterSpiner("بتن آماده"));

        ArrayAdapter<ListMasterSpiner> adapter=new ArrayAdapter<ListMasterSpiner>(
                Main2Activity.this,
                android.R.layout.simple_spinner_item,
                listSpinner
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiner_khadamat.setAdapter(adapter);
        spiner_khadamat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                closeKeyboard();
                if(position!=0){
                if (tv_khadamat_1.getText()=="" ){
                    if (spiner_khadamat.getItemAtPosition(position).toString()!=tv_khadamat_2.getText() &&
                            spiner_khadamat.getItemAtPosition(position).toString()!=tv_khadamat_3.getText()) {
                    tv_khadamat_1.setText( spiner_khadamat.getItemAtPosition(position).toString());
                    delete_tv_1.setVisibility(View.VISIBLE);
                    }else {
                        Toast.makeText(Main2Activity.this, " شما قبلا "+spiner_khadamat.getItemAtPosition(position).toString()+" را انتخاب کرده بودید ", Toast.LENGTH_SHORT).show();
                    }
                }else if (tv_khadamat_2.getText()==""){
                    if (spiner_khadamat.getItemAtPosition(position).toString()!=tv_khadamat_1.getText() &&
                            spiner_khadamat.getItemAtPosition(position).toString()!=tv_khadamat_3.getText()) {
                        tv_khadamat_2.setText(spiner_khadamat.getItemAtPosition(position).toString());
                        delete_tv_2.setVisibility(View.VISIBLE);
                    }else {
                        Toast.makeText(Main2Activity.this, " شما قبلا "+spiner_khadamat.getItemAtPosition(position).toString()+" را انتخاب کرده بودید ", Toast.LENGTH_SHORT).show();
                    }
                }else if (tv_khadamat_3.getText()==""){
                    if (spiner_khadamat.getItemAtPosition(position).toString()!=tv_khadamat_1.getText() &&
                            spiner_khadamat.getItemAtPosition(position).toString()!=tv_khadamat_2.getText()) {
                    tv_khadamat_3.setText( spiner_khadamat.getItemAtPosition(position).toString());
                    delete_tv_3.setVisibility(View.VISIBLE);
                }else {
                    Toast.makeText(Main2Activity.this, " شما قبلا "+spiner_khadamat.getItemAtPosition(position).toString()+" را انتخاب کرده بودید ", Toast.LENGTH_SHORT).show();
                }
                }else {
                    Toast.makeText(Main2Activity.this, " سه نوع از خدمات را میتوانید ارسال کنید", Toast.LENGTH_LONG).show();
                }}
                spiner_khadamat.setSelection(0);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        ////  AutoComplete


        ArrayAdapter<ListMasterSpiner> adapter2=new ArrayAdapter<ListMasterSpiner>(
                Main2Activity.this,
                android.R.layout.simple_list_item_1,
                listSpinner);
        auto_khadamat.setAdapter(adapter2);
        auto_khadamat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                    if (tv_khadamat_1.getText() == "") {

                        tv_khadamat_1.setText(auto_khadamat.getText().toString());
                        delete_tv_1.setVisibility(View.VISIBLE);
                        auto_khadamat.setText("");

                    } else if (tv_khadamat_2.getText() == "") {
                        tv_khadamat_2.setText(auto_khadamat.getText().toString());
                        delete_tv_2.setVisibility(View.VISIBLE);
                        auto_khadamat.setText("");

                    } else if (tv_khadamat_3.getText() == "") {

                        tv_khadamat_3.setText(auto_khadamat.getText().toString());
                        delete_tv_3.setVisibility(View.VISIBLE);
                        auto_khadamat.setText("");

                    } else {

                        Toast.makeText(Main2Activity.this, " سه نوع از خدمات را فقط میتوانید ارسال کنید", Toast.LENGTH_LONG).show();
                        auto_khadamat.setText("");

                    }
                    closeKeyboard();

            }
        });

    }
    private void closeKeyboard(){
        View view=this.getCurrentFocus();
        if (view!=null){
            InputMethodManager imm=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }
    @Override
    public void onClick(View v) {

        if (v==tv_khadamat_1){
            tv_khadamat_1.setText("");
            delete_tv_1.setVisibility(View.INVISIBLE);
            tv_1="";
        }else if (v==tv_khadamat_2){
            tv_khadamat_2.setText("");
            delete_tv_2.setVisibility(View.INVISIBLE);
            tv_2="";
        }else if (v==tv_khadamat_3){
            tv_khadamat_3.setText("");
            delete_tv_3.setVisibility(View.INVISIBLE);
            tv_3="";
        }else  if (v==delete_tv_1){
            tv_khadamat_1.setText("");
            delete_tv_1.setVisibility(View.INVISIBLE);
            tv_1="";
        }else if (v==delete_tv_2){
            tv_khadamat_2.setText("");
            delete_tv_2.setVisibility(View.INVISIBLE);
            tv_2="";
        }else if (v==delete_tv_3){
            tv_khadamat_3.setText("");
            delete_tv_3.setVisibility(View.INVISIBLE);
            tv_3="";
        }else if(v==getData){
            if(!myChecked){
                recyclerView.setVisibility(View.VISIBLE);
                up= AnimationUtils.loadAnimation(Main2Activity.this,R.anim.coming_up);
                recyclerView.setAnimation(up);
                myChecked=true;
            }else {
                down=AnimationUtils.loadAnimation(Main2Activity.this,R.anim.coming_down);
                recyclerView.setAnimation(down);
                recyclerView.setVisibility(View.GONE);
                myChecked=false;
            }
        }
    }

    public void  getAllData(){
        Cursor cursor=mydb.getAllData();
        if (cursor.getCount()==0){
            // show message
            return;
        }
        StringBuffer buffer=new StringBuffer();
        while (cursor.moveToNext()){
            buffer.append("id= "+cursor.getString(0)+"\n");
            buffer.append("name_master= "+cursor.getString(0)+"\n");
            buffer.append("pic_master= "+cursor.getString(0)+"\n");
            buffer.append("star= "+cursor.getString(0)+"\n");
            buffer.append("phone_master= "+cursor.getString(0)+"\n");
            buffer.append("work_master= "+cursor.getString(0)+"\n");
            buffer.append("location_master= "+cursor.getString(0)+"\n");
            buffer.append("number_master= "+cursor.getString(0)+"\n\n");
        }
        buffer.toString();
    }



}
