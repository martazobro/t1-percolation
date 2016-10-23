
public class PercolationStats {
    public PercolationStats(int n, int trials) {
        // perform trials independent experiments on an n-by-n grid
        if (n <= 0 || trials <= 0){
            throw new IllegalArgumentException("n and trials should be greater than zero.");
        }
    }

    public double mean() {
        // sample mean of percolation threshold
        return 0;
    }

    public double stddev() {
        // sample standard deviation of percolation threshold
        return 0;
    }

    public double confidenceLo() {
        // low  endpoint of 95% confidence interval
        return 0;
    }

    public double confidenceHi() {
        // high endpoint of 95% confidence interval
        return 0;
    }

    public static void main(String[] args){
        // test client (described below)

    }
}
