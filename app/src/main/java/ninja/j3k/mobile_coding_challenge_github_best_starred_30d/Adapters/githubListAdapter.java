package ninja.j3k.mobile_coding_challenge_github_best_starred_30d.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import ninja.j3k.mobile_coding_challenge_github_best_starred_30d.Models.gitRepo;
import ninja.j3k.mobile_coding_challenge_github_best_starred_30d.R;

/**
 * Created by J3K on 17.05.2018.
 */

public class githubListAdapter extends RecyclerView.Adapter<githubListAdapter.ViewHolder>
{
    private List<gitRepo> mDataset;
    private Context mContext;


    public githubListAdapter(Context context, List<gitRepo> itemsList) {
        this.mContext = context;
        this.mDataset = itemsList;
    }

    @Override
    public githubListAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.github_list_items, viewGroup, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(githubListAdapter.ViewHolder viewHolder, int i) {
        viewHolder.repoName.setText(mDataset.get(i).getName());
        viewHolder.repoDescription.setText(mDataset.get(i).getDescription());
        viewHolder.repoOwner.setText(mDataset.get(i).getOwner().getLogin());
        viewHolder.repoStars.setText(mDataset.get(i).getStargazers_count());

        Picasso.get().load(mDataset.get(i).getOwner().getAvatar_url()).into(viewHolder.repoOwnerPic);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView repoName, repoDescription, repoOwner, repoStars;
        private ImageView repoOwnerPic;



        public ViewHolder(View view) {
            super(view);
            repoName = (TextView) view.findViewById(R.id.repoName);
            repoDescription = (TextView) view.findViewById(R.id.repoDescription);
            repoOwner = (TextView) view.findViewById(R.id.repoOwner);
            repoStars = (TextView) view.findViewById(R.id.repoStars);
            repoOwnerPic = (ImageView) view.findViewById(R.id.repoOwnerPic);


            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    gitRepo clickedDataItem = mDataset.get(pos);
                    Toast.makeText(mContext, " Clicked " + clickedDataItem.getName(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
