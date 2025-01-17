package org.example;

public class StringCal {


    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        String delimiter = ",|\n";


        if (numbers.startsWith("//")) {
            String[] parts = numbers.split("\n", 2);
            numbers = parts[1];
        }

        System.out.println("Delimiter: " + delimiter);



        return Integer.parseInt(numbers);
    }


    public static void main(String[] args) {
        StringCal calculator = new StringCal();

        System.out.println(" : TDD Assessment :");
        System.out.println("OutPut are as Follow :");
        System.out.println(calculator.add("-4"));

    }
}


