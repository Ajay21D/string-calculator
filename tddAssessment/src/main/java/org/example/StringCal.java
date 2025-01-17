package org.example;

public class StringCal {

    // Method to add numbers
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n";

        if (numbers.startsWith("//")) {
            String[] parts = numbers.split("\n", 2);
            delimiter = extractDelimiter(parts[0]);  // Here try to Extract the custom delimiter
            numbers = parts[1];
        }

        System.out.println("Delimiter: " + delimiter);

        String[] numberArray = numbers.split(delimiter);

        int sum = 0;
        for (String number : numberArray) {

            if (!number.isEmpty()) {
                sum += Integer.parseInt(number);
            }
        }

        return sum;
    }


    private String extractDelimiter(String firstLine) {
        if (firstLine.startsWith("//")) {
            return firstLine.substring(2);  // The delimiter follows "//"
        }
        return ",";
    }

    public static void main(String[] args) {
        StringCal calculator = new StringCal();

        System.out.println(" : TDD Assessment :");
        System.out.println("OutPut are as Follow :");

        // Test case to see the results
        System.out.println(calculator.add("1,2,3"));
        System.out.println(calculator.add("//;\n1;2;3"));
        System.out.println(calculator.add(""));
        System.out.println(calculator.add("1\n2\n3"));
    }
}
