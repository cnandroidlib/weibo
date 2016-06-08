package me.pkhope.jianwei;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sina.weibo.sdk.openapi.models.Status;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pkhope on 2016/6/8.
 */
public class TimelineAdapter extends RecyclerView.Adapter<TimelineAdapter.TimelineViewHolder>{

    private List<Status> statusList = new ArrayList<>();

    private Context context;

    public TimelineAdapter(Context context, List<Status> list){
        this.context = context;
        statusList = list;
    }


    @Override
    public TimelineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.timeline_item,parent,false);
        return new TimelineViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TimelineViewHolder holder, int position) {
        Status status = statusList.get(position);
        holder.text.setText(status.text);
    }

    @Override
    public int getItemCount() {
        return statusList.size();
    }

    public class TimelineViewHolder extends RecyclerView.ViewHolder{

        ImageView avatar;
        TextView text;

        public TimelineViewHolder(View itemView) {
            super(itemView);

            avatar = (ImageView) itemView.findViewById(R.id.avatar);
            text = (TextView) itemView.findViewById(R.id.text);
        }
    }
}