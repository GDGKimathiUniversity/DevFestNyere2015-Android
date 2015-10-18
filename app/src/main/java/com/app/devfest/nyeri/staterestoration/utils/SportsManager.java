package com.app.devfest.nyeri.staterestoration.utils;

import com.app.devfest.nyeri.staterestoration.model.SportActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mac on 10/17/2015.
 */
public class SportsManager {

    private static final String[] names = new String[]{"SkyDiving Show",
            "PaintBall Tournament","Nairobi Swimming Finals",
            "World Skate Tournament - Nyeri"
            };

    private static final String[] venues = new String[]{"KCC Tower",
            "City Center Stadium","Assassin Wales Club (AWC)",
            "USIU Yard"
    };

    private static final String[] images = new String[]{"http://www.xtremedivers.com/pictures/google_pic1.jpg",
            "http://www.sebraemercados.com.br/wp-content/uploads/2015/07/paintball.jpg",
            "http://www.atlanticsupplements.com/media/catalog/category/swimming_1.jpg)",
            "http://goo.gl/EoVebv"
    };


    public static List<SportActivity> getNearstActivities(){

        List<SportActivity> activities = new ArrayList<>();
        for(int i = 0 ;i<names.length;i++){
            SportActivity sportActivity = new SportActivity(names[i],venues[i],images[i],false);
            activities.add(sportActivity);
        }
        return activities;
    }
}
