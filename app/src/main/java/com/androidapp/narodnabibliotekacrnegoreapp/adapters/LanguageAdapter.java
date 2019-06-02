package com.androidapp.narodnabibliotekacrnegoreapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidapp.narodnabibliotekacrnegoreapp.R;
import com.androidapp.narodnabibliotekacrnegoreapp.models.Languages;

import java.util.ArrayList;

public class LanguageAdapter extends RecyclerView.Adapter<LanguageAdapter.AdapterViewHolder>{

    private Context ctx;
    private ArrayList<Languages> mArrayList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public LanguageAdapter(Context ctx, ArrayList<Languages> mArrayList) {
        this.ctx = ctx;
        this.mArrayList = mArrayList;
    }

    @Override
    public AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.language_layout, parent, false);

        return new AdapterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdapterViewHolder holder, int position) {
        Languages variables = mArrayList.get(position);

        String lang_code = String.valueOf(variables.getLang_code());
        String lang = variables.getLang();
        String lang_short = variables.getLang_short();
        String lang_three = String.valueOf(variables.getLang_three());
        String active = String.valueOf(variables.getActive());

        holder.lang_code.setText(lang_code);
        holder.lang.setText(lang);
        holder.lang_short.setText(lang_short);
        holder.lang_three.setText(lang_three);
        holder.active.setText(active);
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder{

        TextView lang_code, lang, lang_short, lang_three, active;

        public AdapterViewHolder(View itemView) {
            super(itemView);

            lang_code = (TextView) itemView.findViewById(R.id.print_lang_code);
            lang = (TextView) itemView.findViewById(R.id.print_lang);
            lang_short = (TextView) itemView.findViewById(R.id.print_lang_short);
            lang_three = (TextView) itemView.findViewById(R.id.print_lang_three);
            active = (TextView) itemView.findViewById(R.id.print_active);

            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    if(mListener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
