package com.melcoc.bluewhale.serviceImpl;

import com.melcoc.bluewhale.domain.Img;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;

@Service
public class QiniuServiceImpl {
    @Autowired
    Qiniu qiniu;


    // 设置好账号的ACCESS_KEY和SECRET_KEY
    private String ACCESS_KEY ="KYz-15Ci2roaDFzoh7bj_vPN_4VJLVqGpsKmWApF";
    private String SECRET_KEY ="ypDlKaC4U6iev_Vg3asXRUsa1QUHdGPmLoeHlymG";
    // 要上传的空间
    private String BUCKET_NAME ="bluewhale-2020";
    // 密钥配置
    private Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    // 创建上传对象
    Zone z = Zone.autoZone();
    Configuration c = new Configuration(z);
    private UploadManager uploadManager = new UploadManager(c);
    // 简单上传，使用默认策略，只需要设置上传的空间名就可以了
    public String getUpToken() {
        System.out.println("*******************************************");
        System.out.println(auth.uploadToken(BUCKET_NAME));
        System.out.println("*******************************************");
        return auth.uploadToken(BUCKET_NAME);
    }

    /**
     * 上传图片
     * @param localData
     * @param remoteFileName
     * @throws IOException
     */
    public void upload(String localData, UUID remoteFileName) throws IOException {
        System.out.println("*******************************************");
        System.out.println(localData);
        System.out.println(remoteFileName);
        System.out.println("*******************************************");
        Response res = uploadManager.put(localData, String.valueOf(remoteFileName), getUpToken());
        // 打印返回的信息
//        System.out.println(qiniu.getUploadToken(0,String.valueOf(remoteFileName)));
        System.out.println(res.bodyString());
    }

    /**
     * 获取上传图片后返回的url
     * @param localData
     * @param remoteFileName
     * @return
     * @throws QiniuException
     */
    public String getUrl(String localData,UUID remoteFileName) throws QiniuException {
        Response res = uploadManager.put(localData, String.valueOf(remoteFileName), getUpToken());//上传图片
       String url=  qiniu.getUrl(0,String.valueOf(remoteFileName));//获取图片地址
        return url;//获取图片地址
    }
}
