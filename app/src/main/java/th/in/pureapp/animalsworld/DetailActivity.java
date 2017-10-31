package th.in.pureapp.animalsworld;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import th.in.pureapp.animalsworld.model.Animal;
import th.in.pureapp.animalsworld.model.AnimalList;

public class DetailActivity extends AppCompatActivity {
    private int animalId;
    private Animal animal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ArrayList<Animal> animalList = AnimalList.getContext();
        Intent intent = this.getIntent();
        this.animalId = intent.getIntExtra("animalId",0);
        this.animal = animalList.get(animalId);
        ActionBar actionBar = this.getSupportActionBar();
        actionBar.setTitle(this.animal.name);
        actionBar.setDisplayHomeAsUpEnabled(true); //แถมให้ ขาดปุ่ม up เหมือนจาดใจ <3
        TextView descriptionTextView = (TextView) this.findViewById(R.id.detail_description);
        ImageView pictureView = (ImageView) this.findViewById(R.id.detail_picture);
        descriptionTextView.setText(this.getString(this.animal.description));
        pictureView.setImageResource(this.animal.picture);
    }
    public boolean onOptionsItemSelected(final MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
