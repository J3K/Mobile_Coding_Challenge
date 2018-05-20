package ninja.j3k.mobile_coding_challenge_github_best_starred_30d.Fragments;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.pwittchen.infinitescroll.library.InfiniteScrollListener;

import ninja.j3k.mobile_coding_challenge_github_best_starred_30d.Activities.SplashActivity;
import ninja.j3k.mobile_coding_challenge_github_best_starred_30d.Adapters.githubListAdapter;
import ninja.j3k.mobile_coding_challenge_github_best_starred_30d.Models.api.Client;
import ninja.j3k.mobile_coding_challenge_github_best_starred_30d.Models.api.Service;
import ninja.j3k.mobile_coding_challenge_github_best_starred_30d.Models.gitResponse;
import ninja.j3k.mobile_coding_challenge_github_best_starred_30d.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by J3K on 16.05.2018.
 */

public class NewsFragment extends Fragment {


    private static final int MAX_ITEMS_PER_REQUEST = 30;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager mLayoutManager;

    private Context mContext;
    private View view;
    private int arraySize;

    private int page = 1;

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

        view = inflater.inflate(R.layout.fragment_news_main, container, false);
        mContext = getContext();


        mLayoutManager = new LinearLayoutManager(mContext);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter
        mAdapter = new githubListAdapter(getContext(), SplashActivity.gitReposElements);
        mRecyclerView.setAdapter(mAdapter);

        // ADDING SEPARATOR TO THE RECYCLER VIEW.
        SeparatorDecoration decoration = new SeparatorDecoration(mContext, Color.LTGRAY, 1.5f);
        mRecyclerView.addItemDecoration(decoration);

        // PAGINATION OR INFINITE SCROLL. USING addOnScrollListener, AS setOnScrollListener IN DEPRECATED
        mRecyclerView.addOnScrollListener(new InfiniteScrollListener(MAX_ITEMS_PER_REQUEST, mLayoutManager) {
                @Override public void onScrolledToEnd(final int firstVisibleItemPosition) {

                    // COUNTING IF THE NEXT PAGE SHOULD BE LOADED OT NOT.
                    // TO AVOID MULTIPLE PAGE LOADING AT THE SAME TIME.
                    // SOMETIMES THE onScrolledToEnd IS CALLED WHEN MULTIPLE SCROLL DOWN IS MADE AT THE BOTTOM OF THE LIST.
                    int counter = page;
                    int start =  counter * MAX_ITEMS_PER_REQUEST;
                    arraySize = SplashActivity.gitReposElements.size();

                    final boolean allItemsLoaded = start == arraySize;

                    Log.v("JSON-D-NewsFragment","## allItemsLoaded : " + allItemsLoaded);
                    Log.v("JSON-D-NewsFragment","## arraySize : " + arraySize);
                    Log.v("JSON-D-NewsFragment","## start : " + start);

                    if (allItemsLoaded)
                    {
                        page++;
                        LoadNextJSON();
                    }
                }
            });

        return view; // inflater.inflate(R.layout.fragment_news_main, container, false);
    }

    // FUNCTION TO LOAD JSON INTO ARRAYLIST. USING RETROFIT IN CLIENT/SERVICE CLASSES/INTERFACE.
    private void LoadNextJSON(){
        try{

//            Toast.makeText(mContext, "loading JSON...", Toast.LENGTH_SHORT).show();
            Client Client = new Client();
            Service apiService =
                    Client.getClient().create(Service.class);
            Call<gitResponse> call = apiService.getItems("created:>" + SplashActivity.TIMESTAMP,"stars","desc",page);

            call.enqueue(new Callback<gitResponse>() {
                @Override
                public void onResponse(Call<gitResponse> call, Response<gitResponse> response) {
                    SplashActivity.gitReposElements.addAll(response.body().getItems());
                    mAdapter.notifyDataSetChanged();

                    Log.v("JSON-D-NewsFragment", "" + response.raw().request().url());
                }

                @Override
                public void onFailure(Call<gitResponse> call, Throwable t) {
                    Log.v("JSON-E-NewsFragment", t.getMessage());
                }
            });

        }catch (Exception e){
            Log.v("JSON-E-NewsFragment", e.getMessage());
        }
    }
}
class SeparatorDecoration extends RecyclerView.ItemDecoration {

    private final Paint mPaint;

    /**
     * Create a decoration that draws a line in the given color and width between the items in the view.
     *
     * @param context  a context to access the resources.
     * @param color    the color of the separator to draw.
     * @param heightDp the height of the separator in dp.
     */
    public SeparatorDecoration(@NonNull Context context, @ColorInt int color,
                               @FloatRange(from = 0, fromInclusive = false) float heightDp) {
        mPaint = new Paint();
        mPaint.setColor(color);
        final float thickness = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                heightDp, context.getResources().getDisplayMetrics());
        mPaint.setStrokeWidth(thickness);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) view.getLayoutParams();

        // we want to retrieve the position in the list
        final int position = params.getViewAdapterPosition();

        // and add a separator to any view but the last one
        if (position < state.getItemCount()) {
            outRect.set(0, 0, 0, (int) mPaint.getStrokeWidth()); // left, top, right, bottom
        } else {
            outRect.setEmpty(); // 0, 0, 0, 0
        }
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        // we set the stroke width before, so as to correctly draw the line we have to offset by width / 2
        final int offset = (int) (mPaint.getStrokeWidth() / 2);

        // this will iterate over every visible view
        for (int i = 0; i < parent.getChildCount(); i++) {
            // get the view
            final View view = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) view.getLayoutParams();

            // get the position
            final int position = params.getViewAdapterPosition();

            // and finally draw the separator
            if (position < state.getItemCount()) {
                c.drawLine(view.getLeft(), view.getBottom() + offset, view.getRight(), view.getBottom() + offset, mPaint);
            }
        }
    }
}