import com.sun.deploy.util.StringUtils;

public class sqlgeneter

{
    public static void main(String[] args) {
      String tableNamePrefix = "t";
      String tableNamestem = "order";
      String tableNamesuffix = "master";
      String tableFullName = "";
//      列名
      String columnName ="order_no";
//      分割付
      String delimiter = "_";
      String geneterSql="";
      String keyword="4722000128";
//      开始数字；
      int beginNo = 0;
//      结束数字；
      int tablecount = 19;

      for (int i = beginNo; i<= tablecount; i++) {
          tableFullName = tableNamePrefix+ delimiter + tableNamestem + delimiter + tableNamesuffix + Integer.toString(i);
          if (i==19){
              geneterSql = geneterSql+ "select * from " + tableFullName + " where " +columnName + "= '"+ keyword +"';";
          }else
          geneterSql = geneterSql+ "select * from " + tableFullName + " where " +columnName + "= '"+ keyword +"' union all \n";
      }
      System.out.println(geneterSql);
    }
}
