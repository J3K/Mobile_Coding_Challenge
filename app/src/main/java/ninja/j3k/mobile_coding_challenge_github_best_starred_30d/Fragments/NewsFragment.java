package ninja.j3k.mobile_coding_challenge_github_best_starred_30d.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ninja.j3k.mobile_coding_challenge_github_best_starred_30d.Activities.SplashActivity;
import ninja.j3k.mobile_coding_challenge_github_best_starred_30d.Adapters.githubListAdapter;
import ninja.j3k.mobile_coding_challenge_github_best_starred_30d.R;

/**
 * Created by J3K on 16.05.2018.
 */

public class NewsFragment extends Fragment {


    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    public static NewsFragment newInstance() {
        NewsFragment fragment = new NewsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_news_main, container, false);


        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new githubListAdapter(getContext(), SplashActivity.gitReposElements);
        mRecyclerView.setAdapter(mAdapter);

        return view; // inflater.inflate(R.layout.fragment_news_main, container, false);
    }
}
