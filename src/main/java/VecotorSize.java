import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Asus on 02.05.2017.
 */
public class VecotorSize {

    static Object[][] toVectorSize(Object[][] mass) throws IOException {

        System.out.println();
        System.out.println("Для минимизации критерия введите \"min\"");
        System.out.println("Для максимизации критерия введите \"max\"");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int j = 2; j < mass[mass.length - 1].length; j++) {
            int max = 0;
            int min = 1000000;
            int delta = 0;
            for (int i = 0; i < mass.length; i++) {

                if (max < (Integer) mass[i][j]) {
                    max = (Integer) mass[i][j];
                }
                if (min > (Integer) mass[i][j]) {
                    min = (Integer) mass[i][j];
                }
            }
            delta = max - min;

            boolean b = true;

            for (int i = 0; i < mass.length; i++) {
                String param = null;
                String[] nameColumn = {"Мин.дист.", "Макс.дист.", "Мин.выс.", "Макс.выс", "Мин.скор.", "Макс.скор.", "Время полета", "АСОРС", "Мин.ЭПР", "Макс.ЭПР", "Стоимость"};

                while (b) {
                    try {
                        System.out.println("Введите тип значение для " + nameColumn[j - 2]);
                        param = reader.readLine().toUpperCase();
                        while (!(param.equals("MAX") || param.equals("MIN"))) {
                            System.out.println("Некорректный ввод!!");
                            param = reader.readLine().toUpperCase();
                        }
                        b = false;
                    } catch (NumberFormatException ex) {
                        System.out.println("Некорректный ввод!!");
                        b = true;
                    }
                    for (; i < mass.length; i++) {
                        if (param.equals("MAX")) {
                            int tmb = (Integer) mass[i][j];
                            double vector = (double) (tmb - min) / delta;
                            mass[i][j] = Math.rint(1000.0 * vector) / 1000.0;
                        }
                        if (param.equals("MIN")) {
                            int tmb = (Integer) mass[i][j];
                            double vector = (double) (tmb - max) / delta;
                            if (vector < 0) vector *= -1;
                            mass[i][j] = Math.rint(1000.0 * vector) / 1000.0;
                        }
                    }
                }
            }
        }
        System.out.println();
        System.out.println(">>>>БЕЗРАЗМЕРНАЯ МНОГОКРИТЕРИАЛЬНАЯ ТАБЛИЦА<<<<");

        Marks.toString(mass);

        return mass;
    }
}
