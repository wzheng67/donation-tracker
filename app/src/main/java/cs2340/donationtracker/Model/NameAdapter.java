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
 * This class displays name of items based on data derived from database.
 */
@SuppressWarnings({"unused", "FieldCanBeLocal"})
public class NameAdapter extends ArrayAdapter<LocationData> {
    private final Context context;
    private final List list;
    private final ListView listView;

    @SuppressWarnings("PublicField")
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
    @SuppressWarnings("AssignmentOrReturnOfFieldWithMutableType")
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
    @SuppressWarnings("ChainedMethodCall")
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
            viewHolder.location_name = rowView.findViewById(R.id.textView_name_value_basic);
            viewHolder.location_phone = rowView.findViewById(R.id.textView_phone_value_basic);

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
