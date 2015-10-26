package com.kb.demorecycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private String[] mDataset = new String[]{
            "http://space-facts.com/wp-content/uploads/mercury-transparent.png",
            "http://space-facts.com/wp-content/uploads/venus-transparent.png",
            "http://orig00.deviantart.net/bd70/f/2010/084/5/6/diamond_transparent_png_by_absurdwordpreferred.png",
            "http://cdn.mysitemyway.com/etc-mysitemyway/icons/legacy-previews/icons-256/3d-transparent-glass-icons-business/076072-3d-transparent-glass-icon-business-light-bulb.png",
            "https://upload.wikimedia.org/wikipedia/commons/b/be/Blender3D_Lisc_lipy-Transparent.png",
            "http://www.mathunion.org/fileadmin/IMU/Logo/IMU-logo-wt.png",
            "http://cdn.mysitemyway.com/etc-mysitemyway/icons/legacy-previews/icons-256/3d-transparent-glass-icons-arrows/006752-3d-transparent-glass-icon-arrows-arrow2-right-load.png",
            "https://upload.wikimedia.org/wikipedia/commons/4/43/The_Earth_seen_from_Apollo_17_with_transparent_background.png",
            "http://40.media.tumblr.com/8551b4e36ef038302b7c57a792600aa6/tumblr_mtbp8hJaqI1rm6jd7o1_500.png",
            "https://upload.wikimedia.org/wikipedia/commons/e/e1/Jupiter_(transparent).png",
            "http://shaeallison.webfactional.com/apps/coachella/photos/twitter.png",
            "https://upload.wikimedia.org/wikipedia/commons/2/2d/Spectacles-SG2001-transparent.png",
            "http://vignette2.wikia.nocookie.net/roblox/images/3/38/Transparent_Troll_Face.png/revision/latest?cb=20120713214853"
    };
    private Context mContext;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public ImageView mImageView;

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.tv_test);
            mImageView = (ImageView) v.findViewById(R.id.imv_test);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(Context context) {
        mContext = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(position+"");
        Log.e("url",mDataset[position]);
        Picasso.with(mContext).load(mDataset[position]).placeholder(R.drawable.holder).error(R.drawable.not_available).into(holder.mImageView);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}