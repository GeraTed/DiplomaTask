import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Asus on 24.04.2017.
 */
public class Memory {
    public static Object[][] memoryAir() throws SQLException {
        String a = "id:";
        String b = "Название:";
        String c = "Мин.дист.км:";
        String d = "Макс.дист.км:";
        String e = "Мин.выс.м:";
        String f = "Макс.выс.м:";
        String g = "Мин.скор.м/c:";
        String h = "Макс.скор.м/c:";
        String j = "Время полета:";
        String k = "АСОРС:0-нет 1-да:";
        String l = "Мин.ЭПР кв.см:";
        String m = "Макс.ЭПР кв.см:";
        String n = "Стоимость руб/ед:";

        List<String> shap = new ArrayList<String>();
        shap.add(a);
        shap.add(b);
        shap.add(c);
        shap.add(d);
        shap.add(e);
        shap.add(f);
        shap.add(g);
        shap.add(h);
        shap.add(j);
        shap.add(k);
        shap.add(l);
        shap.add(m);
        shap.add(n);
        List<Integer> t_id = new ArrayList<Integer>();
        List<String> t_name = new ArrayList<String>();
        List<Integer> t_mxDest = new ArrayList<Integer>();
        List<Integer> t_mnDest = new ArrayList<Integer>();
        List<Integer> t_mxHig = new ArrayList<Integer>();
        List<Integer> t_minHig = new ArrayList<Integer>();
        List<Integer> t_mxSp = new ArrayList<Integer>();
        List<Integer> t_mnSp = new ArrayList<Integer>();
        List<Integer> t_lTm = new ArrayList<Integer>();
        List<Integer> t_regapp = new ArrayList<Integer>();
        List<Integer> t_mxAP = new ArrayList<Integer>();
        List<Integer> t_mnAP = new ArrayList<Integer>();
        List<Integer> t_cost = new ArrayList<Integer>();
        DBProcessor db = new DBProcessor();
        Connection conn = db.getConnection(Main.URL, Main.USERNAME, Main.PASSWORD);
        String query = "select * from targets.airtargets";
        Statement statement = conn.createStatement();
        ResultSet resSet = statement.executeQuery(query);
        while (resSet.next()) {
            int target_id;
            String airtarget_name;
            int min_destination;
            int max_destination;
            int min_hight;
            int max_hight;
            int min_speed;
            int max_speed;
            int life_time;
            int registr_app;
            int min_APR;
            int max_APR;
            int cost;
            target_id = resSet.getInt("target_id");
            airtarget_name = resSet.getString("airtarget_name");
            min_destination = resSet.getInt("min_destination");
            max_destination = resSet.getInt("max_destination");
            min_hight = resSet.getInt("min_hight");
            max_hight = resSet.getInt("max_hight");
            min_speed = resSet.getInt("min_speed");
            max_speed = resSet.getInt("max_speed");
            life_time = resSet.getInt("life_time");
            registr_app = resSet.getInt("registr_app");
            min_APR = resSet.getInt("min_APR");
            max_APR = resSet.getInt("max_APR");
            cost = resSet.getInt("cost");
            AirTargets airTargets = new AirTargets(target_id, airtarget_name, min_destination, max_destination, min_hight, max_hight, min_speed, max_speed, life_time, registr_app, min_APR, max_APR, cost);
            t_id.add(target_id);
            t_name.add(airtarget_name);
            t_mnDest.add(min_destination);
            t_mxDest.add(max_destination);
            t_minHig.add(min_hight);
            t_mxHig.add(max_hight);
            t_mnSp.add(min_speed);
            t_mxSp.add(max_speed);
            t_lTm.add(life_time);
            t_regapp.add(registr_app);
            t_mnAP.add(min_APR);
            t_mxAP.add(max_APR);
            t_cost.add(cost);
        }
        statement.close();
        conn.close();
        int line = t_id.size();
        int column = 13;
        Object[][] table = new Object[line][column];
        for (int i = 0; i < line; i++) {
            table[i][0] = t_id.get(i);
            table[i][1] = t_name.get(i);
            table[i][2] = t_mnDest.get(i);
            table[i][3] = t_mxDest.get(i);
            table[i][4] = t_minHig.get(i);
            table[i][5] = t_mxHig.get(i);
            table[i][6] = t_mnSp.get(i);
            table[i][7] = t_mxSp.get(i);
            table[i][8] = t_lTm.get(i);
            table[i][9] = t_regapp.get(i);
            table[i][10] = t_mnAP.get(i);
            table[i][11] = t_mxAP.get(i);
            table[i][12] = t_cost.get(i);
        }

        System.out.println(">>>>ЗАДАННАЯ ТАБЛИЦА<<<<");
        System.out.println();
        for (int i = 0; i < table.length; i++) {
            for (int o = 0; o < column; o++) {
                System.out.print(shap.get(o) + "\t");
                if (o == 0) {
                    System.out.print(table[i][0] + "\t" + "\t");
                } else if (o == 2) {
                    System.out.printf("%02d" + "\t" + "\t", (Integer) table[i][o]);
                } else if (o == 3) {
                    System.out.printf("%03d" + "\t" + "\t", (Integer) table[i][o]);
                } else if (o == 5 | o == 11) {
                    System.out.printf("%05d" + "\t" + "\t", (Integer) table[i][o]);
                } else if (o == 9) {
                    System.out.printf("%01d" + "\t" + "\t", (Integer) table[i][o]);
                } else if (o != 1) {
                    System.out.printf("%04d" + "\t" + "\t", (Integer) table[i][o]);
                } else {
                    System.out.printf("%s", table[i][o] + "\t" + "\t");
                }
            }
            System.out.println();
        }

        return table;
    }
}
