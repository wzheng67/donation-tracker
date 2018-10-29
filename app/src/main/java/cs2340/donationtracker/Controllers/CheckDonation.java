package cs2340.donationtracker.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.LinkedList;
import java.util.List;

import cs2340.donationtracker.Model.CurrentItems;
import cs2340.donationtracker.Model.CurrentUser;
import cs2340.donationtracker.Model.ItemInfo;
import cs2340.donationtracker.Model.ItemInfoAdapter;
import cs2340.donationtracker.Model.User_type;
import cs2340.donationtracker.R;

public class CheckDonation extends Activity {
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_donation);
        init();
        display();
    }
    private void init() {
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child("item").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<ItemInfo> list = CurrentItems.getInstance().getItemList();
                list.clear();
                for (DataSnapshot i : dataSnapshot.getChildren()) {
                    ItemInfo mItemInfo = i.getValue(ItemInfo.class);
                    list.add(mItemInfo);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(CheckDonation.this, "Data loading failed.",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void display() {
        ListView itemListview = (ListView) findViewById(R.id.listview_location);
        ItemInfoAdapter itemInfoAdapter = new ItemInfoAdapter(this, CurrentItems.getInstance().getItemList(), itemListview);
        itemListview.setAdapter(itemInfoAdapter);
    }
    public void goBack(View v) {
        if (CurrentUser.getInstance().getUserType() == User_type.USER) {
            Intent intent = new Intent(this, MainApplication_user.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, MainApplication.class);
            startActivity(intent);
        }
    }
}
