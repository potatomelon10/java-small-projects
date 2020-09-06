public class Polynomial {
    private final double[] coef;
    public Polynomial(double[] coefficient){
        coef = coefficient;
    }
    public double func(double x, double[] polynomial){
        int counter = polynomial.length;
        int power = counter-1;
        double output = 0;
        for(int i = 0; i <= counter-1; i++){
            output += polynomial[i] * (Math.pow(x,power));
            power -= 1;
        }
        return output;
    }
    public double[] derivative(int n){
        double[] coef_saved = coef.clone();
        double [] coef_final = new double[coef.length];
        int counter = coef.length;
        int power = counter-1;
        if(n < power) {
            for (int i = 0; i <= (counter - 1); i++) {
                power = counter - 1 - i;
                for (int j = 1; j <= n; j++) {
                    coef_saved[i] *= power;
                    power -= 1;
                }
                if (power >= 0) {
                    coef_final[i + n] = coef_saved[i];
                }
            }
        }
        else{
            return coef_final;
            }
        return coef_final;
    }
    public double newton_method(double x){
        boolean not_to_epsilon = true;
        if(coef.length == 1){
            x = coef[0];
        }
        while(not_to_epsilon) {
            final double epsilon = 0.000000000001;
            x = x - (func(x, coef)/func(x, derivative(1)));
            if((func(x, coef)/func(x, derivative(1)) <= epsilon)){
                break;
            }
        }
        return x;
    }
}
