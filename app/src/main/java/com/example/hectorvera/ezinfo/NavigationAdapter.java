package com.example.hectorvera.ezinfo;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hectorvera.ezinfo.POJO.Information;
import com.example.hectorvera.ezinfo.db.InformationDao;
import com.example.hectorvera.ezinfo.lib.Library;

import java.util.ArrayList;
import java.util.List;

public class NavigationAdapter extends RecyclerView.Adapter<NavigationAdapter.InformationHolder>{

    private ArrayList<Information> informations;
    private ArrayList<ArrayList<Information>> backups;
    private ArrayList<Information> backup;
    private List<Info> infos;
    //private List<Info> backup2;
    //private InformationHolder holder;
    private TextView txtBreadCrumbs;
    private boolean connectionflag;
    private InformationDao informationDao;
    private ImageButton onSearch;
    private ImageButton bhome;
    private EditText infoSearch;
    private boolean isOtherAction = false;
    public NavigationAdapter(){}

    public NavigationAdapter(ArrayList<Information> informations){
        this.informations = informations;
        backup = new ArrayList<Information>();
        backups = new ArrayList<ArrayList<Information>>();
    }

    public NavigationAdapter(List<Info> infos){
        this.infos = infos;
    }

    @Override
    public InformationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_layout,parent,false);

        onSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = infoSearch.getText().toString();
                if(!temp.equals("")) {
                    informations = informationDao.search(temp);
                    if (informations == null) {
                        Toast.makeText(v.getContext(),temp+" is not in the data base",Toast.LENGTH_SHORT).show();
                    } else {
                        isOtherAction = true;
                        //connectionflag = true;
                        notifyDataSetChanged();
                        txtBreadCrumbs.setText("");
                        Intent iSender = new Intent();
                        iSender.setAction(Library.BROADCAST_NAME);
                        iSender.putExtra(Library.CONTENT, "");
                        iSender.putExtra(Library.TITLE, "");
                        iSender.putExtra(Library.PARENT_ID, 0L);
                        iSender.putExtra(Library.CONNECTION_FLAG_KEY, connectionflag);
                        iSender.putExtra(Library.IS_OTHER_FLAG, isOtherAction);
                        v.getContext().sendBroadcast(iSender);
                    }
                } else {
                    Toast.makeText(v.getContext(),"Put information to search",Toast.LENGTH_SHORT).show();
                }
            }
        });

        bhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                informations = informationDao.getMSCategories(Library.MAIN_CATEGORY);
                txtBreadCrumbs.setText("");
                infoSearch.setText("");
                backups = null;
                backup = null;
                backups = new ArrayList<ArrayList<Information>>();
                backup = new ArrayList<Information>();
                notifyDataSetChanged();
                isOtherAction = true;
                Intent iSender = new Intent();
                iSender.setAction(Library.BROADCAST_NAME);
                iSender.putExtra(Library.CONTENT, "");
                iSender.putExtra(Library.TITLE, "");
                iSender.putExtra(Library.PARENT_ID, 0L);
                iSender.putExtra(Library.CONNECTION_FLAG_KEY, connectionflag);
                iSender.putExtra(Library.IS_OTHER_FLAG, isOtherAction);
                v.getContext().sendBroadcast(iSender);
            }
        });
        return new InformationHolder(v);
    }

    @Override
    public void onBindViewHolder(InformationHolder holder, int position) {
        Information i = informations.get(position);
        holder.tMenuId.setText(i.getName().toString());
    }

    @Override
    public int getItemCount() {
        if(informations == null)
            return 0;
        else
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

    public void setOnSearch(ImageButton onSearch) {
        this.onSearch = onSearch;
    }

    public void setInfoSearch(EditText infoSearch) {
        this.infoSearch = infoSearch;
    }

    public void setBhome(ImageButton bhome) {
        this.bhome = bhome;
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
                    int pos = getAdapterPosition();//ArrayList<Information> cat = Test.getSubCategories();
                    //int item = getItemCount();
                    Information information = informations.get(pos);
                    backup = (ArrayList<Information>) informations.clone();
                    backups.add(backup);
                    informations = null;
                    //notifyItemRangeRemoved(0, item);
                    //informations = Test.getSubCategories();
                    informations = informationDao.getInformation(information.getId());
                    notifyDataSetChanged();
                    //if(Test.isContent()) {
                    if(informations.size() == 1 && informations.get(0).getIsTopLevel() == Library.CONTENT_FLAG){
                        Intent iSender = new Intent();
                        iSender.setAction(Library.BROADCAST_NAME);
                        iSender.putExtra(Library.CONTENT, informations.get(0).getContent());
                        iSender.putExtra(Library.TITLE, informations.get(0).getName());
                        iSender.putExtra(Library.PARENT_ID, informations.get(0).getId());
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
