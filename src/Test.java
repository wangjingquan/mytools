import com.suning.epps.merchantsignature.common.RSAUtil;

import java.net.URLEncoder;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Test {

    public static void main(String[] args) {
        Map<String, Object> parameters = new TreeMap<String, Object>(new Comparator<String>() {
            @Override
            public int compare (String o1, String o2) {
// 升序排序
                return o1.compareTo(o2);
            }
        });

        /*parameters.put("goodsNo", "AB9596358360947");
        parameters.put("goodsNum", "2");
        parameters.put("userName", "wjq1009001");
        parameters.put("partnerNo", "OTT_Partner");
        parameters.put("batch", "TB20171009258476");
        parameters.put("transactionNo", "2017100900010");
        parameters.put("appplt", "ott");
        parameters.put("appid", "pptv.iphone.sports");
        parameters.put("format", "json");*/
//        parameters.put("appver", "3.0");
//        parameters.put("uid", "12.abc.ab.cb.ac");
//        parameters.put("comment", "wjq");
//        parameters.put("cb", "ww");
        /********************************************************/
        parameters.put("goodsNo", "AB9596358360947");
        parameters.put("goodsNum", "60");
        //合同类型，1代表新申请，2代表解绑
        parameters.put("contractType", "1");
        parameters.put("partnerNo", "OTT_Partner");
//        parameters.put("batch", "TB20171013205137");
        parameters.put("comment", "信任审批api");
        parameters.put("notifyUrl", "http://10.200.114.30:8081/ddpos-web/test1.htm");
        parameters.put("format", "json");



        StringBuilder paramStingBuilder = new StringBuilder();
        for (String key : parameters.keySet()) {
            paramStingBuilder.append(key).append("=").append(parameters.get(key)).append("&");
        }
        paramStingBuilder.deleteCharAt(paramStingBuilder.length() - 1);
        System.out.println("parameterStr------>" + paramStingBuilder.toString());
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCto+mce15rfjaGzZ6Mb6Ebz6ntrJ0tUNpqJgD8\n" +
                "T6M7jPbRambAf3B/XHcyjY6tJOT1ohq9DGBTQ5i+g2qpFeyqmR0q+6b7MOge6wcUCM8jiGa9Shq2\n" +
                "tgupptrnkDopPlhkdEmGnw4voEPg5LC6frJWZ9QnVxJDa5mkUSP8M4i8BQIDAQAB";
        String priKey = "MIICeQIBADANBgkqhkiG9w0BAQEFAASCAmMwggJfAgEAAoGBAK2j6Zx7Xmt+NobNnoxvoRvPqe2s\n" +
                "nS1Q2momAPxPozuM9tFqZsB/cH9cdzKNjq0k5PWiGr0MYFNDmL6DaqkV7KqZHSr7pvsw6B7rBxQI\n" +
                "zyOIZr1KGra2C6mm2ueQOik+WGR0SYafDi+gQ+DksLp+slZn1CdXEkNrmaRRI/wziLwFAgMBAAEC\n" +
                "gYEAlpDXdTUUvqkGpwWNQcFaNj9v3gQblrvRaNHjcOWtaWnma9iTmL/o0MdhJJjS6xhe4Q/bl6ov\n" +
                "rIOk4y4ZQt0cBbPoIbq2jBuxr8uR14onzVzkUyjXQisaB5vnOz7ldG1q3sx8kVM0MakSDmDwjRmN\n" +
                "Q/BADlkdmQcSNmt2QKmZB1ECQQDenby91OaVsoNh91pO1d1dUoL35bBCRa2yr2Qj3pQZecySJXcq\n" +
                "aErXAmy3+GM4OhyXD2yrgjHyRa3/0rULY8ijAkEAx638L0KCFNTdQ5uTwoSQupzwnfMGZ9Ng2mO8\n" +
                "xOIiugSvYicY8+3uUAqNMKKVG6Uowy6UriPH3LUwAgL3MBnrNwJBAJHG8WXOGQFGWMq6U6T0X3VR\n" +
                "Jvp2qql7P3eXaxgiFRFptRCvAA4BJaEOsWr3eOHFDBvPufXF2DcycfLoZC4FNckCQQCQGj+k25qE\n" +
                "7hnAcMZx2rmX8yqy0nAM/b8n3FKew5PMKxVnAFBBubQCj5rVPn/dM5P3R+aExc22ugurZ/h7/jiB\n" +
                "AkEAn0xs2KrMwzz0di+8xSRMlad9pcOZUGlGSsRymNbPubLRCvd7fLc6jCIaBjAhP99ZV5X852nG\n" +
                "tE++eAUErPmILw==";
        String sign = "";
        boolean flag = false;
        try {
            sign = RSAUtil.sign(paramStingBuilder.toString(), RSAUtil.getPrivateKey(priKey));
            flag = RSAUtil.vertiy(paramStingBuilder.toString(), sign, RSAUtil.getPublicKey(publicKey));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("私钥签名sign--------------->" + sign);
        System.out.println("flag-------------->" + flag);

    }
}
