package adev.testgeronimo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import adev.testgeronimo.R;

/**
 * Created by Aldric ANDRE
 * on 10/05/2017.
 */

public class MockViewHolder extends RecyclerView.ViewHolder {

    private ImageView mCoverView;
    private TextView mTitleEvent;

    public MockViewHolder(final View itemView) {
        super(itemView);

        mCoverView = (ImageView) itemView.findViewById(R.id.img_event_grid);
        mTitleEvent = (TextView) itemView.findViewById(R.id.txt_event_title);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(itemView.getContext(), mTitleEvent.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        mTitleEvent.setText(mTitleEvent.getResources().getText(R.string.text_title_mock));
        mCoverView.setImageResource(R.drawable.img_background);

    }
}
