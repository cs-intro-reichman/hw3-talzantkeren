// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
    public static void main(String args[]) {
        // Tests some of the operations
        System.out.println(plus(2, 3)); // 2 + 3
        System.out.println(minus(7, 2)); // 7 - 2
        System.out.println(minus(2, 7)); // 2 - 7
        System.out.println(times(3, 4)); // 3 * 4
        System.out.println(plus(2, times(4, 2))); // 2 + 4 * 2
        System.out.println(pow(5, 3)); // 5^3
        System.out.println(pow(3, 5)); // 3^5
        System.out.println(div(12, 3)); // 12 / 3
        System.out.println(div(5, 5)); // 5 / 5
        System.out.println(div(25, 7)); // 25 / 7
        System.out.println(mod(25, 7)); // 25 % 7
        System.out.println(mod(120, 6)); // 120 % 6
        System.out.println(sqrt(16));
        System.out.println(sqrt(263169));
        System.out.println(sqrt(76123));
    }

    public static int abs(int x1) {
        int i = 0;
        int total = x1;
        if (x1 < 0) {
            for (i = 0; i > x1; i--) {
                total++;
                total++;
            }
        }
        return total;
    }

    public static int Oppabs(int x1) {
        int i = 0;
        int total = x1;
        if (x1 > 0) {
            for (i = 0; i < x1; i++) {
                total--;
                total--;
            }
        }
        return total;
    }

    // Returns x1 + x2
    public static int plus(int x1, int x2) {
        int i = 0;
        int total = 0;
        if (x1 >= 0 && x2 >= 0) {
            for (i = 0; i < x1; i++) {
                total++;
            }
            for (i = 0; i < x2; i++) {
                total++;
            }
        } else {
            if (x1 < 0 && x2 < 0) {
                for (i = 0; i > x1; i--) {
                    total--;
                }
                for (i = 0; i > x2; i--) {
                    total--;
                }
            } else {
                if (x1 < 0) {
                    for (i = 0; i > x1; i--) {
                        total--;
                    }
                    for (i = 0; i < x2; i++) {
                        total++;
                    }
                } else {
                    if (x2 < 0) {
                        for (i = 0; i < x1; i++) {
                            total++;
                        }
                        for (i = 0; i > x2; i--) {
                            total--;
                        }
                    }
                }
            }
        }
        return total;
    }

    // Returns x1 - x2
    public static int minus(int x1, int x2) {
        int total = 0;
        int i = 0;
        if (x1 >= 0 && x2 >= 0) {
            total = x1;
            for (i = 0; i < x2; i++) {
                total--;
            }
        } else {
            if (x1 < 0 && x2 < 0) {
                for (i = 0; i > x1; i--) {
                    total--;
                }
                for (i = 0; i > x2; i--) {
                    total++;
                }
            } else {
                if (x2 < 0) {
                    for (i = 0; i < x1; i++) {
                        total--;
                    }
                    for (i = 0; i < x2; i++) {
                        total++;
                    }
                } else {
                    for (i = 0; i > x1; i--) {
                        total--;
                    }
                    for (i = 0; i < x2; i++) {
                        total--;
                    }
                }
            }
        }
        return total;
    }

    // Returns x1 * x2
    public static int times(int x1, int x2) {
        int i = 0;
        int b = 0;
        int total = 0;
        if (x1 >= 0 && x2 >= 0) {
            for (i = 0; i < x1; i++) {
                for (b = 0; b < x2; b++) {
                    total++;
                }
            }
        } else {
            if (x1 < 0 && x2 < 0) {
                x1 = abs(x1);
                x2 = abs(x2);
                for (i = 0; i < x1; i++) {
                    for (b = 0; b < x2; b++) {
                        total++;
                    }
                }
            } else {
                if (x1 < 0) {
                    for (i = 0; i > x1; i--) {
                        for (b = 0; b < x2; b++) {
                            total--;
                        }
                    }
                } else {
                    for (i = 0; i > x2; i--) {
                        for (b = 0; b < x1; b++) {
                            total--;
                        }
                    }
                }
            }
        }
        return total;
    }

    // Returns x^n (for n >= 0)
    public static int pow(int x, int n) {
        int total = x;
        int i = 1;
        if (n != 0) {
            for (i = 1; i < n; i++) {
                total = times(total, x);
            }
        } else {
            total = 1;
        }
        return total;
    }

    // Returns the integer part of x1 / x2
    public static int div(int x1, int x2) {
        int counter = 1;
        int total = 0;
        if (x1 == 0) {
            counter = 0;
        } else {
            if (x1 > 0 && x2 > 0) {
                total = x2;
                while (total < x1 && plus(total, x2) <= x1) {
                    total = plus(total, x2);
                    counter++;
                }
            } else {
                if (x1 < 0 && x2 < 0) {
                    x1 = abs(x1);
                    x2 = abs(x2);
                    total = x2;
                    while (total < x1 && plus(total, x2) <= x1) {
                        total = plus(total, x2);
                        counter++;
                    }
                } else {
                    if (x1 < 0) {
                        total = x2;
                        x1 = abs(x1);
                        while (total < x1 && plus(total, x2) <= x1) {
                            total = plus(total, x2);
                            counter++;
                        }
                        counter = Oppabs(counter);
                    } else {
                        x2 = abs(x2);
                        total = x2;
                        while (total < x1 && plus(total, x2) <= x1) {
                            total = plus(total, x2);
                            counter++;
                        }
                        counter = Oppabs(counter);
                    }
                }
            }
        }
        return counter;
    }

    // Returns x1 % x2
    public static int mod(int x1, int x2) {
        int mod = 0;
        int total = x2;
        while (plus(total, x2) <= x1) {
            total = plus(total, x2);
            mod = minus(x1, total);
        }
        return mod;
    }

    public static int sqrt(int x) {
        int r = 0;
        while (times(r, r) < x) {
            r++;
        }
        if (times(r, r) > x) {
            r--;
        }
        return r;
    }
}
