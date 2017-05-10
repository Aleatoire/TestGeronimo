package adev.testgeronimo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import adev.testgeronimo.R;

/**
 * Created by Aldric ANDRE
 * on 10/05/2017.
 */

public class MockAdapter extends RecyclerView.Adapter<MockViewHolder> {

    private int mCountList;

    public MockAdapter(int count) {
        this.mCountList = count;
    }

    @Override
    public MockViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_mock, viewGroup, false);

        return new MockViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MockViewHolder myViewHolder, int position) {

    }

    @Override
    public int getItemCount() {
        return mCountList;
    }

    public void removeFirstItem() {
        mCountList--;
        notifyItemRemoved(0);
        notifyItemRangeChanged(0, mCountList);
    }

    public void removeAllItems() {
        mCountList = 0;
        notifyDataSetChanged();
    }

    public void addItem() {
        mCountList++;
        notifyItemInserted(0);
        notifyDataSetChanged();
    }

}
