import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class phonegenerator {

    public static void main(String[] args) {

        Random r = new Random();
        Set<Integer> uniqNumb = new HashSet<Integer>();
       do {
            int radomnumb = r.nextInt(99999999);
            if (Integer.toString(radomnumb).length()==8){
                uniqNumb.add(radomnumb);
            }
        }while (uniqNumb.size() < 50000);
        System.out.println(uniqNumb.size());
        List<String> phones = new ArrayList<>();
        for (Integer numb: uniqNumb) {
            String phone = "185" + numb;
            phones.add(phone);
        }
        File file = new File("c:\\Users\\jingquanwang\\Desktop\\phones.txt");
        FileOutputStream out = null;
            try {
                out = new FileOutputStream(file, true);
            }
            catch (FileNotFoundException e) {
                System.out.println("创建重试文件出错");
                return;
            }
        try {
            for (int i = 0; i < phones.size(); i++) {
                out.write(phones.get(i).toString().getBytes());
                out.write("\r\n".getBytes());
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

