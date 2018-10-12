package cs2340.donationtracker.Model;

import android.content.Context;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import java.util.List;
import android.widget.ListView;
import android.widget.TextView;

import cs2340.donationtracker.R;

public class LocationAdapter extends ArrayAdapter<LocationData> {
    private Context context;
    private List list;
    private ListView listView;

    class LocationViewHolder {
        public TextView location_key;
        public TextView location_name;
        public TextView location_Type;
        public TextView location_Longitude;
        public TextView location_Latiude;
        public TextView location_address;
        public TextView location_phone;
    }

    public LocationAdapter(Context context, List<LocationData> list, ListView listView) {
        super(context, 0, list);
        this.context = context;
        this.list = list;
        this.listView = listView;
    }

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
        viewHolder.location_Latiude.setText(locationData.getLatitude());
        viewHolder.location_address.setText(locationData.getAddress());
        viewHolder.location_phone.setText(locationData.getPhone_number());
        Log.d("@@@", "row view is " + Status + ", tag = " + tag);
        return rowView;
    }
}