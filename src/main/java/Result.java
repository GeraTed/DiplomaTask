/**
 * Created by Asus on 03.05.2017.
 */
public class Result {
    static void result(Object[][] mass) {
        System.out.println();
        System.out.println(">>>>ИТОГОВЫЕ ЗНАЧЕНИЯ<<<<");
//        List<Integer> index = new ArrayList<Integer>();
        int index = 0;
        Double maxsumm = 0.0;

        for (int i = 0; i < mass.length; i++) {
            Double summ = 0.0;
            for (int j = 2; j < mass[mass.length - 1].length; j++) {
                Double tmp = (Double) mass[i][j];
                summ += tmp;
                summ = Math.rint(1000.0 * summ) / 1000.0;
            }
            System.out.println("ДЛЯ " + mass[i][1] + " = " + summ);
            if (maxsumm <= summ) {
                maxsumm = summ;
                index = i;

            }

        }
        System.out.println();
        System.out.println("Лучший вариант - " + mass[index][1] + " с результатом " + maxsumm);
    }
}
