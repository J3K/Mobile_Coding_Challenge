package ninja.j3k.mobile_coding_challenge_github_best_starred_30d.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by J3K on 17.05.2018.
 */

public class githubListAdapter extends RecyclerView.Adapter<githubListAdapter.ViewHolder>
{
    private String[] mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;
        public ViewHolder(TextView v) {
            super(v);
            mTextView = v;
        }
    }

    public githubListAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    @Override
    public githubListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {

        ViewHolder vh= null; // = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(mDataset[position]);

    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
