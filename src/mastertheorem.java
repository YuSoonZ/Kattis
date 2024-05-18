import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class mastertheorem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        int a = Integer.parseInt(inputArr[0]);
        float b = Float.parseFloat(inputArr[1]);
        float c = Float.parseFloat(inputArr[2]);
        float d = Float.parseFloat(inputArr[3]);
        int k = Integer.parseInt(inputArr[4]);

        // Log value
        float logVar = logFunction(b, a);
        // Test if it has found the theorem to use
        while (true) {
            if (checkTheoremOne(logVar, a, d)) {
                // int value
                if (logVar % 1 == 0) {
                    int value = (int) logVar;
                    if (value == 1) {
                        System.out.println("n");
                    } else {
                        System.out.println("n^" + value);
                    }
                } else {
                    String formattedValue = String.format("%.1f", logVar);
                    System.out.println("n^" + formattedValue);
                }
                break;
            }
            if (checkTheoremTwo(logVar, d)) {
                int logPower = k + 1;
                if (logVar % 1 == 0) {
                    int value = (int) logVar;
                    if (value == 1) {
                        if (k >= 0) {
                            if (logPower == 1) {
                                System.out.println("n log n");
                            } else {
                                System.out.println("n log^" + logPower + " n");
                            }
                        } else if (k == -1) {
                            System.out.println("n log log n");
                        } else {
                            System.out.println("n");
                        }
                    } else {
                        if (value == 0) {
                            if (k >= 0) {
                                if (logPower == 1) {
                                    System.out.println("log n");
                                } else {
                                    System.out.println("log^" + logPower + " n");
                                }
                            } else if (k == -1) {
                                System.out.println("log log n");
                            }
                        } else {
                            if (k >= 0) {
                                if (logPower == 1) {
                                    System.out.println("n^" + value + " log n");
                                } else {
                                    System.out.println("n^" + value + " log^" + logPower + " n");
                                }
                            } else if (k == -1) {
                                System.out.println("n^" + value + " log log n");
                            } else {
                                System.out.println("n^" + value);
                            }
                        }
                    }
                } else {
                    String formattedValue = String.format("%.1f", logVar);
                    if (k >= 0) {
                        if (logPower == 1) {
                            System.out.println("n^" + formattedValue + " log n");
                        } else {
                            System.out.println("n^" + formattedValue + " log^" + logPower + " n");
                        }
                    } else if (k == -1) {
                        System.out.println("n^" + formattedValue + " log log n");
                    } else {
                        System.out.println("n^" + formattedValue);
                    }
                }
                break;
            }
            if (checkTheoremThree(logVar, a, b, d)) {
                int value = (int) d;
                if (k == 0) {
                    if (d % 1 == 0) {
                        if (value == 1) {
                            System.out.println("n");
                        } else {
                            System.out.println("n^" + value);
                        }
                    } else {
                        String formattedValue = String.format("%.1f", d);
                        System.out.println("n^" + formattedValue);
                    }
                } else if (k == 1) {
                    if (d % 1 == 0) {
                        if (value == 1) {
                            System.out.println("n" + " log n");
                        } else {
                            System.out.println("n^" + value + " log n");
                        }
                    } else {
                        String formattedValue = String.format("%.1f", d);
                        System.out.println("n^" + formattedValue + " log n");
                    }
                } else {
                    if (d % 1 == 0) {
                        if (value == 1) {
                            System.out.println("n" + " log^" + k + " n");
                        } else {
                            System.out.println("n^" + value + " log^" + k + " n");
                        }
                    } else {
                        String formattedValue = String.format("%.1f", d);
                        System.out.println("n^" + formattedValue + " log^" + k + " n");
                    }
                }
            }
            break;
        }
    }

    public static float logFunction(float base, float a) {
        return (float) (Math.log(a) / Math.log(base));
    }

    public static boolean checkTheoremOne(float logValue, float a, float d) {
        if (logValue <= 0 || a == 1) {
            return false;
        }
        return logValue > d;
    }

    public static boolean checkTheoremTwo(float logValue, float d) {
        return logValue == d;
    }

    public static boolean checkTheoremThree(float logValue, float a, float b, float d) {
        double temp = a * Math.pow(1 / b, d);
        return logValue < d && temp < 1;
    }
}
