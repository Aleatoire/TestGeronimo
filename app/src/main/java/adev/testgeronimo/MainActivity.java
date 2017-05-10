package adev.testgeronimo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import adev.testgeronimo.adapter.MockAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.fab)
    FloatingActionButton mFloatingButton;
    @BindView(R.id.recycler_list)
    RecyclerView mRecycler;
    @BindView(R.id.placeholder_ctn)
    LinearLayout mPlaceholder;

    MockAdapter mMockAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        setupViews();
    }

    private void setupViews() {

        GridLayoutManager glm = new GridLayoutManager(this, 1);
        glm.setInitialPrefetchItemCount(8);
        mRecycler.setLayoutManager(glm);
        mRecycler.setItemAnimator(new DefaultItemAnimator());
        mMockAdapter = new MockAdapter(7);
        mRecycler.setAdapter(mMockAdapter);
        mMockAdapter.notifyDataSetChanged();
        mRecycler.invalidate();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_remove:
                mMockAdapter.removeFirstItem();
                checkPlaceholder();
                break;

            case R.id.action_remove_all:
                mMockAdapter.removeAllItems();
                checkPlaceholder();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void checkPlaceholder() {
        if (mMockAdapter.getItemCount() == 0)
            mPlaceholder.setVisibility(View.VISIBLE);
        else
            mPlaceholder.setVisibility(View.GONE);

    }

    @OnClick(R.id.fab)
    public void onViewClicked() {
        mMockAdapter.addItem();
        checkPlaceholder();
    }
}
