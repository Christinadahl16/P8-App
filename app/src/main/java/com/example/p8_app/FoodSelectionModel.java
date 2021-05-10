package com.example.p8_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class FoodSelectionModel extends AppCompatActivity {

    private Integer id;
    private String name;
    private Double price;
    private String origin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_selection_model);
    }


        public FoodSelectionModel(Integer id, String name, Double price, String origin) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.origin = origin;
        }

        /*Constructor*/
        public FoodSelectionModel() {

        }

        /*toString method*/
        @Override
        public String toString() {
            return "FoodSelectionModel{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    ", origin='" + origin + '\'' +
                    '}';
        }

        /*Getters and setters*/
        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }
    }