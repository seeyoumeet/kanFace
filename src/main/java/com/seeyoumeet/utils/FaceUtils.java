package com.seeyoumeet.utils;

import com.baidu.aip.face.AipFace;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class FaceUtils {
    public static final String APP_ID = "24148007";
    public static final String API_KEY = "UvxrbW1gBVUYtGpkuESbQrft";
    public static final String SECRET_KEY = "jEwYjwYU3ObE2OA7LdGeNIbKVft5fGV9";

    public static void main(String[] args) {
        //   compare("D:\\bs\\xyabxt\\doc\\user.png", "D:\\bs\\xyabxt\\doc\\user1.png");
        String img = "D:\\work\\dev-install\\apache\\tomcat\\apache-tomcat-9.0.7\\webapps\\ROOT\\/cdn/ad946518-8e2d-4d80-83ae-36156d8e77ea.png";
        System.out.println(img.replaceAll("\\\\", "/"));
    }

    public static void reg(String img, String id, String user) {
        AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);

        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        HashMap<String, String> options = new HashMap<String, String>();
        options.put("action_type", "replace");
        String groupId = "nuist";

        JSONObject res = client.addUser(id, user, groupId, img, options);
        System.out.println(res.toString(2));
    }

    public static int compare(String img, String img2) {
        AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);

        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        HashMap<String, String> options = new HashMap<String, String>();
        options.put("ext_fields", "qualities");
        options.put("image_liveness", ",faceliveness");
        options.put("types", "7,13");

        ArrayList<String> path = new ArrayList<String>();
        path.add(img.replaceAll("\\\\", "/"));
        path.add(img2.replaceAll("\\\\", "/"));

        JSONObject res = client.match(path, options);
        JSONArray result = res.getJSONArray("result");
        if (result.length() == 0) {
            return 0;
        } else {
            JSONObject obj = (JSONObject) res.getJSONArray("result").get(0);
            return obj.getInt("score");
        }
    }
}
