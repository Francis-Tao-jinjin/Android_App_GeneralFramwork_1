package app.com.jemmyender.generalframework_1.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import app.com.jemmyender.generalframework_1.R;

/**
 * Created by Jemmy Ender on 2016/10/5.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ClickListener mClickListener;

    private List<String> mItemList;

    public RecyclerAdapter(List<String> itemList) {
        mItemList = itemList;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        final View view = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false);
        RecyclerItemViewHolder vh = new RecyclerItemViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        RecyclerItemViewHolder holder = (RecyclerItemViewHolder) viewHolder;
        String itemText = mItemList.get(position);
        holder.setItemText(itemText);
    }

    private int getBaseItemCount(){
        return mItemList == null ? 0 : mItemList.size();
    }

    @Override
    public int getItemCount() {
        return getBaseItemCount();
    }


    class RecyclerItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView mItemTextView;

        public RecyclerItemViewHolder(View parent){
            super(parent);
            parent.setOnClickListener(this);
            TextView itemTextView = (TextView) parent.findViewById(R.id.itemTextView);
            mItemTextView = itemTextView;
        }

        public void setItemText(CharSequence text) {
            mItemTextView.setText(text);
        }

        @Override
        public void onClick(View v){
            if(mClickListener != null){
                mClickListener.itemClick(v,getPosition());
            }
        }
    }

    public void setClickListener(ClickListener clicklistener){
        this.mClickListener = clicklistener;
    }

    public interface ClickListener{
        public void itemClick(View view, int position);
    }

}
