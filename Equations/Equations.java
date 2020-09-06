public class Equations {
    public static void loan() {
        //Cost of a loan, amount of interest paid over the life of loan
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        final int MONTH = 12;
        final int PERCENT = 100;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Starting principle: ");
        int principle = scanner.nextInt();

        System.out.print("Annual Percentage Rate: ");
        double monthly_rate = scanner.nextDouble() / MONTH / PERCENT;
        if (0 < monthly_rate && monthly_rate < 1) {
            System.out.print("Number of years: ");
            int years = scanner.nextInt();

            double cost = (principle * monthly_rate * Math.pow(1 + monthly_rate, 12 * years))
                    / (Math.pow(1 + monthly_rate, 12 * years) - 1)
                    * 12 * years - principle;

            System.out.printf("The total cost is: %s \n", currency.format(cost));
        } else
            System.out.println("Rate invalid, monthly rate exceeds 100%");
    }

    public static void appreciation() {
        //Annulaized appreciation of an asset
        final int PERCENT = 100;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Purchase price: ");
        int purchase_price = scanner.nextInt();

        System.out.print("Sales price: ");
        int sale_price = scanner.nextInt();

        System.out.print("Num of years asset was held: ");
        int year = scanner.nextInt();

        int difference = sale_price - purchase_price;
        double appreciation_rate = (double) difference / purchase_price;
        double annual_apr = Math.pow(1 + appreciation_rate, (double) 1 / year) - 1;
        System.out.printf("Annualized appreciation rate: %.2f percent\n", annual_apr * PERCENT);
    }

    public static String percentage_yield(double percent) {
        //A more accurate measure of the true cost of a loan
        final byte PERCENT = 100;
        NumberFormat percent_converter = NumberFormat.getPercentInstance();
        return "~" + percent_converter.format(Math.exp(percent/PERCENT) - 1);
    }
    public static String speed_of_sound(double temperature) {
        return "~" + Math.round(1086 * (Math.sqrt((5*temperature + 297)/247))) + "feet per second";
    }
    public static double radian_degree(double radian) {
        return 180 * radian / Math.PI;
    }
    public static double degree_radian(double degree){
        return degree * Math.PI/180;
    }
    public static double distance_formula(int x1, int y1, int x2, int y2){
        return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
    }
    public static double sin_x_taylor(double x, int der){
        assert der >= 2: "the derivative iteration value must be strictly positive and greater than two (for this function to work)";
        double sin_x = x;
        int fact = 1;
        for(int pow = 1; pow <= der; pow++) {
            fact = fact * 2*pow * (2*pow + 1);
            sin_x += Math.pow(-1, pow) * Math.pow(x, 2*pow + 1) / fact;
        }
        return sin_x;
    }
    public static double factorial(double num){
        int i,fact = 1;
        for(i = 1; i <= num; i++){
            fact = fact * i;
        }
        return fact;
    }
    public static double[] prime_factorization(int number) {
        double[] arr = {};
        if (Prime(number)){
            arr = append(arr.length, arr, number);
            Arrays.sort(arr);
            return arr;
        }
        else {
            if(number == 1) {
                arr = append(arr.length,arr,number);
                return arr;
            }
            else
                while (!Prime(number))
                    for (int i = 1; i < number; i++)
                        if (Prime(i) && number % i == 0) {
                            number = number / i;
                            arr = append(arr.length, arr, i);
                        }
                arr = append(arr.length, arr, number);
                Arrays.sort(arr);
                return arr;
        }
    }
    public static String prime_factor_string(int number){
        if (number > 0){
            if (number == 1){
                return "One has no prime factors and is not prime";
            }
            else
                return Arrays.toString(Equations.prime_factorization(number));
        }
        else
            return "Number must be strictly positive";
    }
    public static double[] append(int n, double[] arr, double x)
    {
        int i;
        double[] newarray = new double[n + 1];
        for (i = 0; i < n; i++)
            newarray[i] = arr[i];
        newarray[n] = x;
        return newarray;
    }
    static public int[] lowPrimes = {2, 3,5,7,11,13,17,19,23,29,31,37,41,43,
            47,53,59,61,67,71,73,79,83,89,97,101,103,107,109,113,127,131,137,139,
            149,151,157,163,167,173,179,181,191,193,197,199,211,223,227,229,233,
            239,241,251,257,263,269,271,277,281,283,293,307,311,313,317,331,337,
            347,349,353,359,367,373,379,383,389,397,401,409,419,421,431,433,439,
            443,449,457,461,463,467,479,487,491,499,503,509,521,523,541,547,557,
            563,569,571,577,587,593,599,601,607,613,617,619,631,641,643,647,653,
            659,661,673,677,683,691,701,709,719,727,733,739,743,751,757,761,769,
            773,787,797,809,811,821,823,827,829,839,853,857,859,863,877,881,883,
            887,907,911,919,929,937,941,947,953,967,971,977,983,991,997};
    public static boolean Prime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 0; i < Equations.lowPrimes.length; ++i) {
            if (n < Math.pow(lowPrimes[i], 2)) {
                return true;
            } else if (n % Equations.lowPrimes[i] == 0) {
                return false;
            }
        }
        if (n > 1018081) {
            for (int i = 1009; i <= Math.sqrt(n); ++i) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
    public static int amount_of_primes(double n) {
        if (n < 2) {
            return 0;
        }
        ArrayList<Integer> primes = new ArrayList<Integer>();
        for (Integer i : Equations.lowPrimes) {
            if (i > n) {
                break;
            }
            primes.add(i);
        }
        for (int p = 1009; p <= n; ++p) {
            boolean currentPrime = true;
            for (Integer i : primes) {
                if (p % i == 0) {
                    currentPrime = false;
                    break;
                }
            }
            if (currentPrime) {
                primes.add(p);
            }
        }
        return primes.size();
    }
}

