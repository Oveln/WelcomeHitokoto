package me.oveln.utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class hitokoto {

    public static String gethitokoto() {
        String string = httpstools.sendGet("https://v1.hitokoto.cn/");
        if (string.isEmpty())  string = httpstools.sendGet("https://v1.hitokoto.cn/");
        JsonObject json = (JsonObject) new JsonParser().parse(string);
        StringBuilder addends = new StringBuilder();
        addends.append(json.get("hitokoto"));
//        if (!json.get("from_who").isJsonNull()) addends.append("--").append(json.get("from_who").toString().replace("\"",""));
//        if (!json.get("from").isJsonNull()) addends.append("--《").append(json.get("from").toString().replace("\"","")).append("》");
        return addends.toString();
    }
}
