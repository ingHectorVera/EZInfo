package com.example.hectorvera.ezinfo;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hectorvera.ezinfo.POJO.Information;
import com.example.hectorvera.ezinfo.db.InformationDao;
import com.example.hectorvera.ezinfo.lib.Library;
import com.example.hectorvera.ezinfo.lib.Test;

import java.util.ArrayList;

/**
 * Created by User on 10/23/2016.
 */

public class NavigationAdapter extends RecyclerView.Adapter<NavigationAdapter.InformationHolder>{

    private ArrayList<Information> informations;
    private ArrayList<Information> backup;
    //private InformationHolder holder;
    private TextView txtBreadCrumbs;
    private boolean connectionflag;
    private InformationDao informationDao;
    public NavigationAdapter(){}

    public NavigationAdapter(ArrayList<Information> informations){
        this.informations = informations;
        //backup = new ArrayList<Information>();
    }

    @Override
    public InformationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_layout,parent,false);
        return new InformationHolder(v);
    }

    @Override
    public void onBindViewHolder(InformationHolder holder, int position) {
        Information i = informations.get(position);
        holder.tMenuId.setText(i.getName().toString());
        //this.holder = holder;

    }

    @Override
    public int getItemCount() {
        return informations.size();
    }

    public ArrayList<Information> getInformations(){
        return informations;
    }

    public ArrayList<Information> getBackup(){
        return backup;
    }

    public void setTxtBreadCrumbs(TextView txtBreadCrumbs) {
        this.txtBreadCrumbs = txtBreadCrumbs;
    }

    public void setConnectionflag(boolean connectionflag) {
        this.connectionflag = connectionflag;
    }

    public void setInformationDao(InformationDao informationDao) {
        this.informationDao = informationDao;
    }


    public class InformationHolder extends RecyclerView.ViewHolder{

        public TextView tMenuId;
        public CardView menuCardView;
        public InformationHolder(View itemView) {
            super(itemView);
            tMenuId = ((TextView) itemView.findViewById(R.id.tMenuId));
            menuCardView = ((CardView) itemView.findViewById(R.id.menuCardView));
            menuCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    //ArrayList<Information> cat = Test.getSubCategories();
                    //int item = getItemCount();
                    backup = (ArrayList<Information>) informations.clone();
                    informations = null;
                    //notifyItemRangeRemoved(0, item);
                    informations = Test.getSubCategories();
                    notifyDataSetChanged();
                    if(Test.isContent()) {
                        Intent iSender = new Intent();
                        iSender.setAction(Library.BROADCAST_NAME);
                        iSender.putExtra(Library.CONTENT, informations.get(pos).getContent());
                        iSender.putExtra(Library.TITLE, informations.get(pos).getName());
                        iSender.putExtra(Library.CONNECTION_FLAG_KEY, connectionflag);
                        v.getContext().sendBroadcast(iSender);
                    }
                    if(backup.get(pos).getIsTopLevel()==Library.MAIN_CATEGORY){
                        txtBreadCrumbs.setText(backup.get(pos).getName());
                    }else{
                        txtBreadCrumbs.setText(txtBreadCrumbs.getText().toString()+">"+backup.get(pos).getName());
                    }
                }
            });
        }

    }
}
