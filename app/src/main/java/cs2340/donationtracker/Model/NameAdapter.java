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

/**
 * This class displays name of items based on data derived from database.
 */
public class NameAdapter extends ArrayAdapter<LocationData> {
    private Context context;
    private List list;
    private ListView listView;

    class LocationViewHolder {
        public TextView location_name;
        public TextView location_phone;
    }

    /**
     * This method displays name of items
     * @param context an object of Context class
     * @param list an object of List class
     * @param listView an object of ListView class
     */
    public NameAdapter(Context context, List<LocationData> list, ListView listView) {
        super(context, 0, list);
        this.context = context;
        this.list = list;
        this.listView = listView;
    }

    /**
     * This method obtains position of item from item list.
     * @param position an integer that indicates a certain item
     * @param convertView an object of View class
     * @param parent an object of ViewGroup
     * @return View view of nameAdapter
     */
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
