import com.suning.epps.merchantsignature.common.RSAUtil;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<String,Object> parameters = new TreeMap<String, Object>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 升序排序
                return o1.compareTo(o2);
            }
        });

        parameters.put("goodsNo", "AB9116695280000");
        parameters.put("goodsNum", "15");
        parameters.put("contractType", "1");
        parameters.put("partnerNo", "OTT_Partner");
//        parameters.put("batch", "TB20170926298374");
        parameters.put("notifyUrl", "www.baidu.com");
        parameters.put("comment", "wjq");
        parameters.put("format", "json");
//        parameters.put("cb", "ww");

        String key = "MIICeQIBADANBgkqhkiG9w0BAQEFAASCAmMwggJfAgEAAoGBAK2j6Zx7Xmt+NobNnoxvoRvPqe2s\n" +
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

        //查询合作商秘钥
//        PartnerDTO partnerDto= partnerBusiness.getPartnerByPartnerNo(trustContractDto.getPartnerNo());
        String sign = getSign(parameters,key);

        System.out.println("签名:"+sign);
    }

    /**
     * 获取加密后的签名sign
     * @param paramMap
     * @param priKey
     * @return
     */
    private static String getSign(Map<String,Object> paramMap, String priKey){
        String sign = "";
        try {
            String parameterStr = "";
            Iterator it = paramMap.keySet().iterator();
            while (it.hasNext()) {
                //it.next()得到的是key，tm.get(key)得到obj
                parameterStr += paramMap.get(it.next())+"&";
            }
            parameterStr = parameterStr.substring(0,parameterStr.length()-1);
            System.out.println("parameterStr------>" + parameterStr.toString());
//            sign = RSAUtil.encrypt(RSAUtil.getPublicKey(publicKey), parameterStr);
//            sign = RSAUtil.encrypt(RSAUtil.getPublicKey(publicKey), parameterStr);
            sign = RSAUtil.sign(parameterStr, RSAUtil.getPrivateKey(priKey));
        }catch (Exception e){
            e.printStackTrace();
        }
        return sign;
    }
}
