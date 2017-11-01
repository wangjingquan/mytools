import com.suning.epps.merchantsignature.common.RSAUtil;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author jingquanwang
 */
public class GenerateSignByPriviteKey {

    public static void main(String[] args) {
        Map<String, Object> parameters = new TreeMap<String, Object>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
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
        parameters.put("format", "json");
        parameters.put("appver", "3.0");
        parameters.put("uid", "12.abc.ab.cb.ac");
        parameters.put("comment", "wjq");
        parameters.put("cb", "ww");
        parameters.put("orderToken", "2017103118");
        parameters.put("payChannel", "ALI");
        parameters.put("goodsNo", "DA7137786425309");
        parameters.put("userName", "luguo3000");
        parameters.put("appplt", "web");
        parameters.put("userType", "0");
        parameters.put("format", "json");
        parameters.put("rightsMerchant", "DDP");
        parameters.put("token", "");*/

        parameters.put("goodsNo", "AB9596358360947");
        parameters.put("goodsNum", "60");
        //合同类型，1代表新申请，2代表解绑
        parameters.put("contractType", "1");
        parameters.put("partnerNo", "OTT_Partner");
        parameters.put("batch", "TB20171013205137");
        parameters.put("comment", "信任审批api");
        parameters.put("notifyUrl", "http://10.200.114.30:8081/ddpos-web/test1.htm");
        parameters.put("format", "json");

        StringBuilder paramStingBuilder = new StringBuilder();
        for (String key : parameters.keySet()) {
            paramStingBuilder.append(key).append("=").append(parameters.get(key)).append("&");
        }
        paramStingBuilder.deleteCharAt(paramStingBuilder.length() - 1);
        System.out.println("parameterStr------>" + paramStingBuilder.toString());
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCYQ+IcLnCSpy503PVABcwJWWrHEpxE7LsPIFZc\n" +
                "zf+2gJFnA3CPaEcK9K7yv1/eOj8oswFypRhNaFaEqz4uCmvgJ3oNUTMV3jB+C9/0P2mYDccpatfE\n" +
                "czr98xpqIOONfCtXuSobM/N3shTOVFiahnazTNC7aQAz7y1ZHkb1MZUbCwIDAQAB";
        String priKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAJhD4hwucJKnLnTc9UAFzAlZascS\n" +
                "nETsuw8gVlzN/7aAkWcDcI9oRwr0rvK/X946PyizAXKlGE1oVoSrPi4Ka+Aneg1RMxXeMH4L3/Q/\n" +
                "aZgNxylq18RzOv3zGmog4418K1e5Khsz83eyFM5UWJqGdrNM0LtpADPvLVkeRvUxlRsLAgMBAAEC\n" +
                "gYA9j8yeekQ3dvJ4e1GJBg79hLKANE0MLO5gakGgmgUWQ5sGHETpJk765fzJ1ogrMD+S8/TU5l0S\n" +
                "BupcD2Q/dyUvwnEA4ithTFHJJjuSGFhQp+wGH0Z4xHbifRqMPHGv9PAjpgXGOg5eHsAhAaii0skr\n" +
                "zGxc3dGet8JIvgHfZ6AR8QJBAPqWcY7WINtIqdo2ZSViHO6RnkUa8mGooovelWZWOtNoJnG5Q/ci\n" +
                "Mjz1K120w+nW0CejwvA56s7m1gs5ZyKSbaMCQQCbjcrHqirC0frSBDgU5R/vRaOd9Y1lQMkja2Qf\n" +
                "1X/3KhTc9Sb3NeJZWC2Hwj0CedDA8i2AeFTrSEGCRRXHNiN5AkAPthEGoJxMw2CK4vAyiNVBi/W9\n" +
                "ZXQe9WDDnkAFu5BSouwOI0yEmStHMSP36xaBectxQM4/G5KCSGzRJVc3DrE7AkAKKw6iVqFM8uTu\n" +
                "bZAs7X1U6rxzSuXfRIjhY9e7rP0cbwfGGdBeQIt3Q6hWQ4AxdT0MH8iRqUwDxUli9pkh2IwhAkB6\n" +
                "cAqP8Hlrr5WFZQ/XCEwv2QU/fybzjL/e21g8dV0jfC6yieAAUfiWdpG9JAcHgGDR/pznP9qrpv45\n" +
                "gGNISa0u";
        String sign = "";
        boolean flag = false;
        try {
            sign = RSAUtil.sign(paramStingBuilder.toString(), RSAUtil.getPrivateKey(priKey));
            flag = RSAUtil.vertiy(paramStingBuilder.toString(), sign, RSAUtil.getPublicKey(publicKey));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("私钥签名sign--------------->" + sign);
        System.out.println("flag-------------->" + flag);

    }
}
