package it.polito.mad_lab3.reservation;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

import it.polito.mad_lab3.R;
import it.polito.mad_lab3.bl.RestaurantBL;
import it.polito.mad_lab3.data.reservation.Reservation;
import it.polito.mad_lab3.data.restaurant.Restaurant;
import it.polito.mad_lab3.restaurant.RestaurantActivity;
import it.polito.mad_lab3.restaurant.reviews.add_review.AddReviewActivity;

/**
 * Created by Giovanna on 12/05/2016.
 */
public class ReservationsHistoryAdapter extends ArrayAdapter<Reservation> {

    private Context context;
    ArrayList<Reservation> data;

    public ReservationsHistoryAdapter(Context context, ArrayList<Reservation> objects) {
        super(context, 0, objects);
        this.context= context;
        this.data= objects;
    }
    private static class ViewHolder {

        TextView restaurant, date, time, address, status;
        Button info, restaurantPage, review;

    }
    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {

        Reservation r = getItem(position);
        final Restaurant restaurant = RestaurantBL.getRestaurantById(context, r.getRestaurantId());

        final ViewHolder viewHolder; // view lookup cache stored in tag

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.reservations_history_item, parent, false);

            viewHolder.restaurant = (TextView)  convertView.findViewById(R.id.restaurant_name);
            viewHolder.address = (TextView)  convertView.findViewById(R.id.address);
            viewHolder.time = (TextView)  convertView.findViewById(R.id.time);
            viewHolder.date = (TextView)  convertView.findViewById(R.id.date);
            viewHolder.status = (TextView)  convertView.findViewById(R.id.status);

            viewHolder.info = (Button)  convertView.findViewById(R.id.info);
            viewHolder.restaurantPage = (Button)  convertView.findViewById(R.id.restaurant);
            viewHolder.review = (Button)  convertView.findViewById(R.id.review);

            // Get the data item for this position
            convertView.setTag(viewHolder);


        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.restaurant.setText(restaurant.getRestaurantName());
        viewHolder.address.setText(restaurant.getBasicInfo().getAddress()+" - "+restaurant.getBasicInfo().getCity());
        viewHolder.date.setText(r.getDate());
        viewHolder.time.setText(r.getTime());
        viewHolder.status.setText(r.getStatus());

        viewHolder.info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        viewHolder.review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i= new Intent(context, AddReviewActivity.class);
                i.putExtra("restaurantId", restaurant.getRestaurantId());
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);

            }
        });
        viewHolder.restaurantPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(context, RestaurantActivity.class);
                i.putExtra("idRestaurant", restaurant.getRestaurantId());
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });


        return convertView;
    }



}
