package com.melcoc.bluewhale.serviceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.util.UUID;

import com.qiniu.util.*;
import okhttp3.*;
public class PutBase64 {
    String ak = "KYz-15Ci2roaDFzoh7bj_vPN_4VJLVqGpsKmWApF";
    String sk = "ypDlKaC4U6iev_Vg3asXRUsa1QUHdGPmLoeHlymG";    // 密钥配置
    Auth auth = Auth.create(ak, sk);    // TODO Auto-generated constructor stub
    String bucketname = "bluewhale-2020";    //空间名
    String key = UUID.randomUUID().toString();    //上传的图片名
    public String getUpToken() {
        return auth.uploadToken(bucketname, null, 3600, new StringMap().put("insertOnly", 1));
    }
    public void put64image() throws Exception {
        String file = "D:\\1.jpg";//图片路径
        FileInputStream fis = null;
        int l = (int) (new File(file).length());
        byte[] src = new byte[l];
        fis = new FileInputStream(new File(file));
        fis.read(src);
        String file64 = Base64.encodeToString(src, 0);
        String url = "http://upload-z2.qiniup.com/putb64/" + l+"/key/"+ UrlSafeBase64.encodeToString(key);
        //非华东空间需要根据注意事项 1 修改上传域名
        RequestBody rb = RequestBody.create(null, file64);
        Request request = new Request.Builder().
                url(url).
                addHeader("Content-Type", "application/octet-stream")
                .addHeader("Authorization", "UpToken " + getUpToken())
                .post(rb).build();
        System.out.println(request.headers());
        OkHttpClient client = new OkHttpClient();
        okhttp3.Response response = client.newCall(request).execute();
        System.out.println(response);
    }
    public static void main(String[] args) throws Exception {
        new PutBase64().put64image();
    }
}
