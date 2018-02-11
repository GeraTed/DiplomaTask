import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Asus on 24.04.2017.
 */
class Marks {
    private static int quantilyMarks = 11;

    static Object[][] getMarks(Object[][] mass) throws IOException {
        System.out.println();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Double> marks = new ArrayList<Double>();
        List<Integer> arr = new ArrayList<Integer>();
        String[] nameColumn = {"Мин.дист.", "Макс.дист.", "Мин.выс.", "Макс.выс", "Мин.скор.", "Макс.скор.", "Время полета", "АСОРС", "Мин.ЭПР", "Макс.ЭПР", "Стоимость"};
        for (int i = 0; i < quantilyMarks; i++) {
            boolean b = true;
            while (b) {
                int mark;
                try {
                    System.out.println("Введите оценку важности от 0 до 10 для критерия " + nameColumn[i]);
                    mark = Integer.parseInt(reader.readLine());
                    while (mark < 0 || mark > 10) {
                        System.out.println("Некорректный ввод!!");
                        mark = Integer.parseInt(reader.readLine());
                    }
                    arr.add(mark);
                    b = false;
                } catch (NumberFormatException ex) {
                    System.out.println("Некорректный ввод!!");
                    b = true;
                }
            }
        }
        int mnDest = arr.get(0);
        int mxDest = arr.get(1);
        int mnHig = arr.get(2);
        int mxHig = arr.get(3);
        int mnSp = arr.get(4);
        int mxSp = arr.get(5);
        int tl = arr.get(6);
        int regap = arr.get(7);
        int mnAP = arr.get(8);
        int mxAP = arr.get(9);
        int cost = arr.get(10);
        reader.close();
        int summ = mnDest + mxDest + mnHig + mxHig + mnSp + mxSp + tl + regap + mxAP + mnAP + cost;
        double mnDestMark = (double) mnDest / summ;
        double mxDestMark = (double) mxDest / summ;
        double mnHigMark = (double) mnHig / summ;
        double mxHigMark = (double) mxHig / summ;
        double mnSpMark = (double) mnSp / summ;
        double mxSpMark = (double) mxSp / summ;
        double tMark = (double) tl / summ;
        double regapMark = (double) regap / summ;
        double mnAPMark = (double) mnAP / summ;
        double mxAPMark = (double) mxAP / summ;
        double costMark = (double) cost / summ;
        marks.add(mnDestMark);
        marks.add(mxDestMark);
        marks.add(mnHigMark);
        marks.add(mxHigMark);
        marks.add(mnSpMark);
        marks.add(mxSpMark);
        marks.add(tMark);
        marks.add(regapMark);
        marks.add(mnAPMark);
        marks.add(mxAPMark);
        marks.add(costMark);
        System.out.println(">>>>ВЕСА КРИТЕРИЕВ: ");
        for (int i = 0; i < marks.size(); i++) {
            System.out.print(String.format(Locale.ENGLISH, "%.3f", marks.get(i)) + "\t");
        }
        for (int j = 2; j < mass[mass.length - 1].length; j++) {
            for (int i = 0; i < mass.length; i++) {
                Double tmp = (Double) mass[i][j];
                double marS = (double) tmp * marks.get(j - 2);
                mass[i][j] = Math.rint(1000.0 * marS) / 1000.0;
            }
        }
        System.out.println();
        System.out.println("\n" + ">>>>>ТАБЛИЦА ПОСЛЕ ПОЛУЧЕНИЯ ОЦЕНОК<<<<<");
        toString(mass);
        return mass;
    }

    public static void toString(Object[][] mass) {
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass[mass.length - 1].length; j++) {
                if (j == 0) System.out.print(mass[i][j] + "\t");
                else if (j == 1) System.out.print(mass[i][j] + "\t");
                else System.out.printf("%.3f" + "\t", (Double) mass[i][j]);
            }
            System.out.println();
        }
    }
}

