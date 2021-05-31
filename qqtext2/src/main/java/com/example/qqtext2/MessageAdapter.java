package com.example.qqtext2;

import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MessageAdapter extends BaseAdapter{
    private List<Message> mMessage;
    private LayoutInflater minfInflater;

    public MessageAdapter(List<Message> mMessage, LayoutInflater minfInflater) {
        super();
        this.mMessage = mMessage;
        this.minfInflater = minfInflater;
    }

    @Override
    public int getCount() {
        return mMessage.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //  mMessage
        ViewHolder vh;
        if(convertView==null){
            convertView=minfInflater.inflate(R.layout.message_layout, null);
            vh=new ViewHolder();
            vh.textview_left=(TextView) convertView.findViewById(R.id.textview_left);
            vh.textview_right=(TextView) convertView.findViewById(R.id.textview_right);
            vh.img_you=(ImageView) convertView.findViewById(R.id.img_you);
            vh.img_my=(ImageView) convertView.findViewById(R.id.img_my);
            vh.left_linear=(LinearLayout) convertView.findViewById(R.id.left_linear);
            vh.right_linear=(LinearLayout) convertView.findViewById(R.id.right_linear);
            convertView.setTag(vh);
        }else{
            vh=(ViewHolder) convertView.getTag();
        }
        Message message=mMessage.get(position);
        if(message.getType()==Message.TYPE_YOU){
            vh.left_linear.setVisibility(View.VISIBLE);
            vh.right_linear.setVisibility(View.GONE);
            vh.textview_left.setText(message.getWords());
        }
        if(message.getType()==Message.TYPE_MY){

            vh.left_linear.setVisibility(View.GONE);
            vh.right_linear.setVisibility(View.VISIBLE);
            vh.textview_right.setText(message.getWords());
        }

        return convertView;
    }
    class ViewHolder{
        TextView textview_left;
        TextView textview_right;
        ImageView img_you;
        ImageView img_my;
        LinearLayout left_linear;
        LinearLayout right_linear;

    }

}