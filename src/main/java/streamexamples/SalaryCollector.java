package streamexamples;

public class SalaryCollector {

    private int total=0;
    private int count=0;

    public int getTotal() {
        return total;
    }
    public int getCount() {
        return count;
    }

    public void accept(int salary) {
        total += salary;
        count++;
    }

    public void combine(SalaryCollector other) {
        total += other.total;
        count += other.count;
    }
}
