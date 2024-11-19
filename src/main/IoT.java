package main;

import java.util.Scanner;

public class IoT {
    private Scanner scanner = new Scanner(System.in);

    public Integer inputInteger() {
        return Integer.parseInt(inputString());
    }

    public Double inputDouble() {
        return Double.parseDouble(inputString());
    }

    public String inputString() {
        return scanner.nextLine();
    }
}
