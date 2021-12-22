package net.currency.handler;

import net.currency.Start;
import net.currency.util.UtilWeb;
import net.dv8tion.jda.api.entities.Activity;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class ActivityHandler {

    public static ArrayList<Modules> modules = new ArrayList<>();

    public void getData() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                JSONObject jsonObject = null;
                try {
                    jsonObject = (JSONObject) new JSONParser().parse(UtilWeb.getURLResponse("https://tlkur.com/refresh/doviz.php"));
                } catch (ParseException e) {
                    e.printStackTrace();
                    getData();
                }
                ArrayList<Modules> newModules = new ArrayList<>();
                newModules.add(new Modules(Type.USD, jsonObject.get("USDTRY").toString()));
                newModules.add(new Modules(Type.EUR, jsonObject.get("EURTRY").toString()));
                newModules.add(new Modules(Type.GBP, jsonObject.get("GBPTRY").toString()));
                setData(newModules);
                Start.getJda().getPresence().setActivity(Activity.playing("Dolar: " + jsonObject.get("USDTRY").toString()));
            }
        }, 0, 5_000);
    }

    public void setData(ArrayList<Modules> newModules) {
        modules = newModules;
    }

    public Modules getValueWithType(Type type) {
        return modules.stream().filter(var -> var.getType().equals(type)).findFirst().orElse(null);
    }

    public class Modules {

        private Type type;
        private String value;

        public Modules(Type type, String value) {
            this.type = type;
            this.value = value;
        }

        public Type getType() { return this.type; }

        public String getValue() { return this.value; }

        public void setValue(String value) {
            this.value = value;
        }

    }

    public enum Type {
        USD,
        EUR,
        GBP
    }

}
