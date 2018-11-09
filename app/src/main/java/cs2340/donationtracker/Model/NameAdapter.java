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


@SuppressWarnings({"ChainedMethodCall", "RedundantCast"})
public class NameAdapter extends ArrayAdapter<LocationData> {
    private final Context context;
    private final List list;

    class LocationViewHolder {
        public TextView location_name;
        public TextView location_phone;
    }

    public NameAdapter(Context context, List<LocationData> list, ListView listView) {
        super(context, 0, list);
        this.context = context;
        this.list = list;
        ListView listView1 = listView;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View rowView = convertView;
        LocationViewHolder viewHolder;
        String Status;

        if (rowView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            rowView = layoutInflater.inflate(R.layout.layout_location_basic, parent,false);
            viewHolder = new LocationViewHolder();
            viewHolder.location_name = (TextView) rowView.findViewById(R.id.textView_name_value_basic);
            viewHolder.location_phone = (TextView) rowView.findViewById(R.id.textView_phone_value_basic);

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

        viewHolder.location_name.setText(locationData.getLocation_name());
        viewHolder.location_phone.setText(locationData.getPhone_number());
        Log.d("@@@", "row view is " + Status + ", tag = " + tag);
        return rowView;
    }
}
