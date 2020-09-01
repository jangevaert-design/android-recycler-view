package edu.cnm.deepdive.recyclerview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.LongDef;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

  private static final String TAG = "RecyclerViewAdapter";

  private ArrayList<String> mImageNames = new ArrayList<>();
  private ArrayList<String> mImages = new ArrayList<>();
  private Context mContext;

  public RecyclerViewAdapter(Context context, ArrayList<String> imageNames,
      ArrayList<String> images) {
    mImageNames = imageNames;
    mImages = images;
    mContext = context;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_item, parent,false);
    ViewHolder holder = new ViewHolder(view);
    return holder;
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, final int position) {
    Log.d(TAG, "onBindViewHolder: called.");

    Glide.with(mContext)
        .asBitmap()
        .load(mImages.get(position))
        .into(holder.image);

    holder.imageName.setText(mImageNames.get(position));

    holder.parentLayout.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        Log.d(TAG, "onClick: clicked on: " + mImageNames.get(position));

        Toast.makeText(mContext, mImageNames.get(position), Toast.LENGTH_SHORT).show();
      }
    });
  }

  @Override
  public int getItemCount() {
    return mImageNames.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    CircleImageView image;
    TextView imageName;
    ConstraintLayout parentLayout;

    public ViewHolder(View itemView) {
      super(itemView);

      image = itemView.findViewById(R.id.image);
      imageName = itemView.findViewById(R.id.image_name);
      parentLayout = itemView.findViewById(R.id.parent_layout);
    }
  }
}
