package th.in.pureapp.animalsworld.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import th.in.pureapp.animalsworld.R;
import th.in.pureapp.animalsworld.model.Animal;

/**
 * Created by pakkapon on 31/10/2560.
 */

public class AnimalAdapter extends ArrayAdapter {
    private Context context;
    private int resource;
    private List objects;
    public AnimalAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        LayoutInflater layout = LayoutInflater.from(context);
        View view = layout.inflate(this.resource,null);
        Animal animal = (Animal) this.objects.get(position);
        TextView nameView = (TextView) view.findViewById(R.id.animal_name);
        ImageView picView = (ImageView) view.findViewById(R.id.animal_pic);
        nameView.setText(animal.name);
        picView.setImageResource(animal.picture);
        return view;
    }
}
