package cs2340.donationtracker.Model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import cs2340.donationtracker.R;

public class ItemInfoAdapter extends ArrayAdapter<ItemInfo> {

    private Context context;
    private List list;
    private ListView listView;

    class ItemViewHolder {
        public TextView Item_shortDescription;
        public TextView Item_category;
        public TextView Item_value;
        public TextView Item_time_hourMin;
        public TextView Item_time_yearMonthDay;
        public TextView Item_fullDescription;
        public TextView Item_comments;
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
        ItemInfoAdapter.ItemViewHolder viewHolder;
        String Status;

        if (rowView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            rowView = layoutInflater.inflate(R.layout.layout_donation_item, parent,false);
            viewHolder = new ItemInfoAdapter.ItemViewHolder();
            viewHolder.location_key = (TextView) rowView.findViewById(R.id.textView_key_value);
            viewHolder.location_name = (TextView) rowView.findViewById(R.id.textView_name_value);
            viewHolder.location_Type = (TextView) rowView.findViewById(R.id.textView_type_value);
            viewHolder.location_Longitude = (TextView) rowView.findViewById(R.id.textView_longitude_value);
            viewHolder.location_Latiude = (TextView) rowView.findViewById(R.id.textView_latitude_value);
            viewHolder.location_address = (TextView) rowView.findViewById(R.id.textView_address_value);
            viewHolder.location_phone = (TextView) rowView.findViewById(R.id.textView_phone_value);

            rowView.setTag(viewHolder);
            Status = "created";
        } else {
            viewHolder = (LocationAdapter.LocationViewHolder) rowView.getTag();
            Status = "reused";
        }
        String Tag = rowView.getTag().toString();
        int idx = Tag.indexOf("@");
        String tag = Tag.substring(idx + 1);

        LocationData locationData = (LocationData) list.get(position);

        viewHolder.location_key.setText(locationData.getKey());
        viewHolder.location_name.setText(locationData.getLocation_name());
        viewHolder.location_Type.setText(locationData.getLocation_type());
        viewHolder.location_Longitude.setText(locationData.getLongitude());
        viewHolder.location_Latiude.setText(locationData.getLatitude());
        viewHolder.location_address.setText(locationData.getAddress());
        viewHolder.location_phone.setText(locationData.getPhone_number());
        Log.d("@@@", "row view is " + Status + ", tag = " + tag);
        return rowView;
    }
}
