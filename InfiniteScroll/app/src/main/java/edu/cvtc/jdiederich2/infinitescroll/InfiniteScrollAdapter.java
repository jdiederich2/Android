package edu.cvtc.jdiederich2.infinitescroll;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class InfiniteScrollAdapter extends RecyclerView.Adapter<InfiniteScrollAdapter.ViewHolder>{

    private final List<String> items;

    public InfiniteScrollAdapter(final List<String> items) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Need to create new view holder
        Context ctx = parent.getContext();
        View view = LayoutInflater.from(ctx).inflate(R.layout.item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // When recycler view wants to render something, we need to tell it where to render it
        final String itemText = this.items.get(position);

        // Set the text to the holder
        holder.itemView.setText(itemText);
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public List<String> getItems() {
        return this.items;
    }

    // Stores a view in a property to render later
    // Way to render our view
    public class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView itemView;

        public ViewHolder(final View itemView) {
            super(itemView);
            this.itemView = itemView.findViewById(R.id.item);
        }
    }
}
