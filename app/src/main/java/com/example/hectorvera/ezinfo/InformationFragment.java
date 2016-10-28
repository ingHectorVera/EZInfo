package com.example.hectorvera.ezinfo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hectorvera.ezinfo.POJO.Information;
import com.example.hectorvera.ezinfo.db.InformationDao;
import com.example.hectorvera.ezinfo.lib.Library;

public class InformationFragment extends Fragment {

    private CheckBox cEditable;
    private Button bSaveModif;
    private static CheckBox cSave;
    //private static EditText eTitle;
    private static EditText eInformation;
    private ScrollView scInformation;
    private static String content = null;
    private static long id = 0L;
    public InformationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_information, container, false);
        cEditable = ((CheckBox) view.findViewById(R.id.cEditable));
        cSave = ((CheckBox) view.findViewById(R.id.cSave));
        scInformation = ((ScrollView) view.findViewById(R.id.scInformation));
        //eTitle = ((EditText) view.findViewById(R.id.eTitle));
        eInformation = ((EditText) view.findViewById(R.id.eInformation));
        bSaveModif = ((Button) view.findViewById(R.id.bSaveModif));
        bSaveModif.setEnabled(false);

        eInformation.setEnabled(false);

        cEditable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    eInformation.setEnabled(true);
                    bSaveModif.setEnabled(true);
                }else {
                    eInformation.setEnabled(false);
                    bSaveModif.setEnabled(false);
                }
            }
        });

        cSave.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    cSave.setText("Information saved");
                }else {
                    cSave.setText("Save information");
                }
            }
        });

        bSaveModif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(content != null && id != 0) {
                    content = eInformation.getText().toString();
                    eInformation.setEnabled(false);
                    cEditable.setChecked(false);
                    InformationDao informationDao = new InformationDao(getContext());
                    informationDao.updateContent(id, content);
                    //Toast.makeText(v.getContext(), "Saved", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    public static class InformationReceiver extends BroadcastReceiver{


        public InformationReceiver() {
        }

        @Override

        public void onReceive(Context context, Intent intent) {
            //Info info = FBConnection.readInfo(Library.TITLE);
            content = intent.getStringExtra(Library.CONTENT);
            id = intent.getLongExtra(Library.PARENT_ID, 0L);
            String title = intent.getStringExtra(Library.TITLE);
            boolean connection_flag = intent.getBooleanExtra(Library.CONNECTION_FLAG_KEY, false);
            if(connection_flag){
                cSave.setText("Save information");
                cSave.setChecked(false);
            }else {
                cSave.setText("Information saved");
                cSave.setChecked(true);
            }
            //eTitle.setText(title);
            eInformation.setText(content);
            Log.d("DEBUG", "BR: "+ content);
        }
    }
}
