package com.literature.android.test;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

public class SnapAdapter extends RecyclerView.Adapter<SnapAdapter.SnapViewHolder> {

    private final int ITEM_COUNT = 10;
    private final Integer[] textExamples = generateExamples();

    private Integer[] generateExamples() {
        Integer[] examples = new Integer[ITEM_COUNT];
        for (int i = 0; i < ITEM_COUNT; i++) {
            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            examples[i] = color;
        }
        return examples;
    }

    @Override
    public SnapViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SnapViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.snap_item, parent, false));
    }

    @Override
    public void onBindViewHolder(SnapViewHolder holder, int position) {
        int adapterPosition = holder.getAdapterPosition();
        int textColor = textExamples[adapterPosition];
        String textByPosition = "Example Text No " + adapterPosition;
        holder.itemText.setText(textByPosition);
        holder.itemText.setTextColor(textColor);
    }

    @Override
    public int getItemCount() {
        return ITEM_COUNT;
    }

    class SnapViewHolder extends RecyclerView.ViewHolder {

        TextView itemText;

        public SnapViewHolder(View itemView) {
            super(itemView);

            itemText = (TextView) itemView.findViewById(R.id.snap_item_text);
        }
    }
}
