package th.in.pureapp.animalsworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import th.in.pureapp.animalsworld.adapter.AnimalAdapter;
import th.in.pureapp.animalsworld.model.Animal;
import th.in.pureapp.animalsworld.model.AnimalList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = this.findViewById(R.id.mainList);
        String[] nameList = {
                "แมว (Cat)",
                "สุนัข (Dog)",
                "โลมา (Dolphin)",
                "โคอล่า (Koala)",
                "นกฮูก (Owl)",
                "กระต่าย (Rabbit)",
                "เพนกวิน (Penguin)",
                "เสือ (Tiger)",
                "สิงโต (Lion)",
                "หมู (Pig)"
        };
        int[] imageList = {
                R.drawable.cat,
                R.drawable.dog,
                R.drawable.dolphin,
                R.drawable.koala,
                R.drawable.owl,
                R.drawable.rabbit,
                R.drawable.penguin,
                R.drawable.tiger,
                R.drawable.lion,
                R.drawable.pig
        };
        int[] descriptionList = {
                R.string.details_cat,
                R.string.details_dog,
                R.string.details_dolphin,
                R.string.details_koala,
                R.string.details_owl,
                R.string.details_rabbit,
                R.string.details_penguin,
                R.string.details_tiger,
                R.string.details_lion,
                R.string.details_pig
        };
        ArrayList<Animal> animalList = AnimalList.getContext();
        for(int i = 0;i<nameList.length;i++){
            animalList.add(new Animal(nameList[i],descriptionList[i],imageList[i]));
        }
        AnimalAdapter animalAdapter = new AnimalAdapter(this,R.layout.item_animal,animalList);
        ListView titleListView = (ListView) this.findViewById(R.id.mainList);
        titleListView.setAdapter(animalAdapter);
        titleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                intent.putExtra("animalId",i);
                startActivity(intent);
            }
        });
    }
}
