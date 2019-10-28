import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Controller {


    void randomList(List<Integer> list) {
        int start = (int) (Math.random() * 99);
        int end = (int) (Math.random() * 99 + 1);
        int length = (int) (Math.random() * 99 + 1);

        while (start > end || (end - start > length)) {
            start = (int) (Math.random() * 99);
            end = (int) (Math.random() * 99 + 1);
            length = (int) (Math.random() * 99 + 1);

        }
        System.out.println("start:" + start + "; end:" + end + "; length:" + length + ";");

        for (int i = 0; i < length; i++) {
            list.add((int) (Math.random() * ((end - start) + 1) + start)); // storing random integers in an array

        }
        System.out.println(list);
        System.out.println("-------------------------------------------------------");

    }

    List<Integer> getMode(List<Integer> list) {
        final Map<Integer, Long> countFrequencies = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        final long maxFrequency = countFrequencies.values().stream()
                .mapToLong(count -> count)
                .max().orElse(-1);

        System.out.println(countFrequencies.entrySet());

        return countFrequencies.entrySet().stream()
                .filter(tuple -> tuple.getValue() == maxFrequency)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

    }

    double getDispersion(List<Integer> list) {
        double res1 = 0.0, res2 = 0.0;
        final Map<Integer, Long> map = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map.entrySet());

        for (Map.Entry<Integer,Long> entry : map.entrySet()) {
            res1 += Math.pow(entry.getKey(), 2) * entry.getValue();
            res2 += entry.getKey() * entry.getValue();
        }
        
        return res1 - Math.pow(res2,2);
    }

    double getMean(List<Integer> list) {
        return list.stream()
                .mapToInt(i -> i)
                .average()
                .getAsDouble();
    }

    double getMedian(List<Integer> list) {

        int middle = list.size() / 2;
        if (list.size() % 2 == 1) {
            return list.get(middle);
        } else {
            return (list.get(middle - 1) + list.get(middle)) / 2.0;
        }
    }

    List<Integer> getSortedList(List<Integer> list) {
        List<Integer> newList = list.subList(0, list.size());
        return newList
                .stream()
                .sorted((o1, o2) -> o1.compareTo(o2)).collect(Collectors.toList());

    }


    //lab3
    double[] getQuartile(List<Integer> list) {
        double[] q = new double[4];
        System.out.println(list);
        q[1] = getMedian(list);
        q[0] = getMedian(list.subList(0, list.size() / 2));
        q[2] = getMedian(list.subList(list.size() / 2, list.size()));
        double IQR = q[2] - q[0];
        q[3] = IQR;
        System.out.println("q1:" + q[0] + "; q2:" + q[1] + "; q3:" + q[2]);
        return q;
    }

    //lab3
    int getScope(List<Integer> list) {
        int max = list.stream().max(Integer::compare).get();
        int min = list.stream().min(Integer::compare).get();
        System.out.println("max:" + max + "; min:" + min);
        return max - min;

    }


}
