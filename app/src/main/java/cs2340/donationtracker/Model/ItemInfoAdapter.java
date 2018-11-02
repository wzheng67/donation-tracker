package cs2340.donationtracker.Model;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import cs2340.donationtracker.R;

public class ItemInfoAdapter extends ArrayAdapter<ItemInfo> {

    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageReference = storage.getReferenceFromUrl("gs://donation-tracker-56b.appspot.com").child("images");
    StorageReference pathReference;

    private Context context;
    private List<ItemInfo> list;
    private ListView listView;

    class ItemViewHolder {
        public TextView Item_shortDescription;
        public TextView Item_category;
        public TextView Item_value;
        public TextView Item_timeStamp;
        public TextView Item_fullDescription;
        public TextView Item_comments;
        public ImageView Item_image;
    }
    public ItemInfoAdapter(final Context context, List<ItemInfo> list, ListView listView) {
        super(context, 0, list);
        this.context = context;
        this.list = list;
        this.listView = listView;

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View rowView = convertView;
        final ItemViewHolder ViewHolder;
        String Status;
        if (rowView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            rowView = layoutInflater.inflate(R.layout.layout_donation_item, parent,false);
            ViewHolder = new ItemInfoAdapter.ItemViewHolder();

            ViewHolder.Item_shortDescription = (TextView) rowView.findViewById(R.id.shortDescriptionView_value);
            ViewHolder.Item_category = (TextView) rowView.findViewById(R.id.categoryView_value);
            ViewHolder.Item_value = (TextView) rowView.findViewById(R.id.valueView_value);
            ViewHolder.Item_timeStamp = (TextView) rowView.findViewById(R.id.timeStampView_value);
            ViewHolder.Item_fullDescription = (TextView) rowView.findViewById(R.id.fullDescription_value);
            ViewHolder.Item_comments = (TextView) rowView.findViewById(R.id.comments_value);
            ViewHolder.Item_image = (ImageView) rowView.findViewById(R.id.imageView);
            Log.d("viewHolder", "View Holder is created");
            rowView.setTag(ViewHolder);
            Status = "created";
        } else {
            ViewHolder = (ItemInfoAdapter.ItemViewHolder) rowView.getTag();
            Status = "reused";
        }
        String Tag = rowView.getTag().toString();
        int idx = Tag.indexOf("@");
        String tag = Tag.substring(idx + 1);

        ItemInfo itemInfo = (ItemInfo) list.get(position);
        ViewHolder.Item_shortDescription.setText(itemInfo.getShortDescription());
        ViewHolder.Item_category.setText(itemInfo.getCategory().toString());
        ViewHolder.Item_value.setText("" + itemInfo.getValue());
        ViewHolder.Item_timeStamp.setText(itemInfo.getTimeStamp().substring(0,16));
        ViewHolder.Item_fullDescription.setText(itemInfo.getFullDescription());
        ViewHolder.Item_comments.setText(itemInfo.getComments());
        if (!itemInfo.getImageName().equals("")) {
            pathReference = storageReference.child(itemInfo.getImageName());
            pathReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    Bitmap bitmap = loadBitmap(uri.toString());
                    ViewHolder.Item_image.setImageBitmap(bitmap);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    e.printStackTrace();
                }
            });
        }
        Log.d("@@", "row view is " + Status + ", tag = " + tag);
        return rowView;
    }

    public Bitmap loadBitmap(String url)
    {
        Bitmap bm = null;
        InputStream is = null;
        BufferedInputStream bis = null;
        try {
            URLConnection conn = new URL(url).openConnection();
            conn.connect();
            is = conn.getInputStream();
            bis = new BufferedInputStream(is, 8192);
            bm = BitmapFactory.decodeStream(bis);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return bm;
    }
}
