package cs2340.donationtracker.Model;

import android.content.Context;
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

import java.util.List;

import cs2340.donationtracker.R;

public class ItemInfoAdapter extends ArrayAdapter<ItemInfo> {

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
    public ItemInfoAdapter(Context context, List<ItemInfo> list, ListView listView) {
        super(context, 0, list);
        this.context = context;
        this.list = list;
        this.listView = listView;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View rowView = convertView;
        ItemViewHolder ViewHolder;
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

        Log.d("@@", "row view is " + Status + ", tag = " + tag);
        return rowView;
    }
}
