package com.example.mylistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class HeroAdapter extends BaseAdapter {
    private Context context;
    private ArrayList <Hero> heroes = new ArrayList<>();

    public HeroAdapter(Context context) {
        this.context = context;
    }

    public void setHeroes(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }

    @Override
    public int getCount() {
        return heroes.size();
    }

    @Override
    public Object getItem(int position) {
        return heroes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View itemView = convertView;
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_hero, parent, false);
        }

        ViewHolder viewHolder = new ViewHolder (itemView);

        Hero hero = (Hero) getItem(position);
        viewHolder.bind(hero);
        return itemView;

    }

    private class ViewHolder {
        private TextView txtName;
        private TextView txtDescription;
        private ImageView imageView;

        ViewHolder (View view) {
            txtName = view.findViewById(R.id.txt_name);
            txtDescription = view.findViewById(R.id.txt_description);
            imageView = view.findViewById(R.id.img_photo);
        }

        void bind (Hero hero) {
            txtName.setText(hero.getName());
            txtDescription.setText(hero.getDescription());
            imageView.setImageResource(hero.getPhoto());
        }

    }
}
