package uz.pdp.home_task.db;

import uz.pdp.home_task.country.Countries;
import uz.pdp.home_task.district.Districts;
import uz.pdp.home_task.region.Regions;
import uz.pdp.home_task.user.User;

import java.util.ArrayList;
import java.util.List;

public interface DB {
    List<User> USERS = new ArrayList<>() {{
            add(new User(1,"Eshmat","Eshmatov","7777", "123"));
            add(new User(2,"Toshmat","Toshmatov","4444", "123"));
        }};

    List<Countries> COUNTRY = new ArrayList<Countries>() {{
        add(new Countries(1,"Uzbekistan"));
        add(new Countries(2,"Tajikistan"));
        add(new Countries(3,"Kazakhstan"));
        add(new Countries(4,"Kyrgyzstan"));
        add(new Countries(5,"Afghanistan"));
    }};

    List<Regions> REGION = new ArrayList<Regions>() {{
        add(new Regions(1,"Fergana Region",1));
        add(new Regions(2,"Dushanbe Region",2));
        add(new Regions(3,"Astana Region",3));
        add(new Regions(4,"Osh Region", 4));
        add(new Regions(5,"Kabul Region", 5));
    }};

    List<Districts> DISTRICT = new ArrayList<>() {{
        add(new Districts(1,"Bag'dod District",1));
        add(new Districts(2,"Beshariq District",1));
        add(new Districts(3,"Buvayda District",1));
        add(new Districts(4,"Dang'ara District",1));
    }};
}
