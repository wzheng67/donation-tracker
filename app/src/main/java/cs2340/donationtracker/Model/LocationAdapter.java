package cs2340.donationtracker.Model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import java.util.List;
import android.widget.ListView;
import android.widget.TextView;

import cs2340.donationtracker.R;

/**
 * This class displays location list view with data derived from database.
 */
public class LocationAdapter extends ArrayAdapter<LocationData> {
    private final Context context;
    private final List list;

    class LocationViewHolder {
        private TextView location_key;
        private TextView location_name;
        private TextView location_Type;
        private TextView location_Longitude;
        private TextView location_Latitude;
        private TextView location_address;
        private TextView location_phone;
    }

    /**
     * This method displays context, list, and list view of items;
     * @param context an object of Context class
     * @param list an object of List class with LocationData data type
     * @param listView an object of ListView class
     */
    @SuppressWarnings({"unused", "AssignmentOrReturnOfFieldWithMutableType"})
    public LocationAdapter(Context context, List<LocationData> list, ListView listView) {
        super(context, 0, list);
        this.context = context;
        this.list = list;
    }

    /**
     * This method displays every information of an item.
     * @param position an integer that indicates location of an item
     * @param convertView an object of View class
     * @param parent an object of ViewGroup class
     * @return an object of view class
     */
    @SuppressWarnings({"FeatureEnvy", "OverlyLongMethod", "ChainedMethodCall"})
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View rowView = convertView;
        LocationViewHolder viewHolder;
        String Status;

        if (rowView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            rowView = layoutInflater.inflate(R.layout.layout_location_row, parent,false);
            viewHolder = new LocationViewHolder();
            viewHolder.location_key = rowView.findViewById(R.id.textView_key_value);
            viewHolder.location_name = rowView.findViewById(R.id.textView_name_value);
            viewHolder.location_Type = rowView.findViewById(R.id.textView_type_value);
            viewHolder.location_Longitude = rowView.findViewById(R.id.textView_longitude_value);
            viewHolder.location_Latitude = rowView.findViewById(R.id.textView_latitude_value);
            viewHolder.location_address = rowView.findViewById(R.id.textView_address_value);
            viewHolder.location_phone = rowView.findViewById(R.id.textView_phone_value);

            rowView.setTag(viewHolder);
            Status = "created";
        } else {
            viewHolder = (LocationViewHolder) rowView.getTag();
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
        viewHolder.location_Latitude.setText(locationData.getLatitude());
        viewHolder.location_address.setText(locationData.getAddress());
        viewHolder.location_phone.setText(locationData.getPhone_number());
        Log.d("@@@", "row view is " + Status + ", tag = " + tag);
        return rowView;
    }
}
