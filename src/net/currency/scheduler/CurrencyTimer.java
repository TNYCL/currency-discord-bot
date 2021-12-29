package net.currency.scheduler;

import net.currency.util.UtilPresence;
import net.currency.util.UtilWeb;
import net.dv8tion.jda.api.entities.Activity;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.TimerTask;

public class CurrencyTimer extends TimerTask {

    private ArrayList<Modules> modules = new ArrayList<>();
    private int queue = 0;

    @Override
    public void run() {
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) new JSONParser().parse(UtilWeb.getURLResponse("https://tlkur.com/refresh/doviz.php"));
        } catch (ParseException e) {
            System.exit(0);
        }
        modules.clear();
        modules.add(new Modules(Type.USD, jsonObject.get("USDTRY").toString()));
        modules.add(new Modules(Type.EUR, jsonObject.get("EURTRY").toString()));
        modules.add(new Modules(Type.GBP, jsonObject.get("GBPTRY").toString()));
        modules.add(new Modules(Type.CHF, jsonObject.get("CHFTRY").toString()));
        modules.add(new Modules(Type.SAR, jsonObject.get("SARTRY").toString()));
        modules.add(new Modules(Type.BTC, jsonObject.get("BTCUSD").toString()));
        modules.add(new Modules(Type.ETH, jsonObject.get("ETHUSD").toString()));
        modules.add(new Modules(Type.XRP, jsonObject.get("XRPUSD").toString()));
        modules.add(new Modules(Type.BCH, jsonObject.get("BCHUSD").toString()));
        modules.add(new Modules(Type.LTC, jsonObject.get("LTCUSD").toString()));
        modules.add(new Modules(Type.DOGE, jsonObject.get("DOGEUSD").toString()));
        executeActivity(jsonObject);
    }

    public void executeActivity(JSONObject jsonObject) {
        if(queue == 0) {
            UtilPresence.setActivity(Activity.playing("Dolar: " + jsonObject.get("USDTRY").toString()));
            this.queue++;
            return;
        }
        if(queue == 1) {
            UtilPresence.setActivity(Activity.playing("Euro: " + jsonObject.get("EURTRY").toString()));
            this.queue++;
            return;
        }
        if(queue == 2) {
            UtilPresence.setActivity(Activity.playing("Sterlin: " + jsonObject.get("GBPTRY").toString()));
            this.queue = 0;
            return;
        }
    }

    public ArrayList<Modules> getModules() {
        return this.modules;
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
        GBP,
        CHF,
        SAR,
        BTC,
        ETH,
        XRP,
        BCH,
        LTC,
        DOGE
    }

}
