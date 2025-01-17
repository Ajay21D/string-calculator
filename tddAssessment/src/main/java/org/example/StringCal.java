package org.example;

import java.util.*;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCal {

    // Method to add numbers
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n";

        // Check for custom delimiter
        if (numbers.startsWith("//")) {
            String[] parts = numbers.split("\n", 2);
            delimiter = extractDelimiter(parts[0]);
            numbers = parts[1];
        }

        System.out.println("Delimiter: " + delimiter);  // Print the delimiter

        String[] numberArray = numbers.split(delimiter);


        List<Integer> numList = Arrays.stream(numberArray)
                .filter(n -> !n.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        List<Integer> negatives = numList.stream()
                .filter(n -> n < 0)
                .collect(Collectors.toList());


        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + negatives);
        }

        // Calculate the total sum using Streams
        return numList.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    // Method to extract the custom delimiter from the first line
    private String extractDelimiter(String firstLine) {
        if (firstLine.startsWith("//")) {
            return Pattern.quote(firstLine.substring(2));
        }
        return ",";
    }

}
