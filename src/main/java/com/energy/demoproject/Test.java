package com.energy.demoproject;

import java.io.FileNotFoundException;


public class Test {

/*
    @SuppressWarnings({"rawtypes", "unchecked"})
    private static ColumnPositionMappingStrategy setColumMapping() {
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(User.class);
        String[] columns = new String[]{"id", "firstName", "lastName", "country", "age"};
        strategy.setColumnMapping(columns);
        return strategy;
    }
*/

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void main(String[] args) throws FileNotFoundException {
/*        List<User> userList = List.of(new User("rod", "rod"),
                new User("nyor", "nyor"));






        var input = "rod";
        var password = "nyor";
        Optional<User> userOptional = userList.stream().filter(x -> x.getUsername().equals(input)).findFirst();
        if (userOptional.isPresent()) {
            if (password.equals(userOptional.get().getPassword())) {
                System.out.println("Authenticated");
            } else {
                System.out.println("password is not match");
            }
        }*/

/*        File file = new File("./account.csv");
        CSVReader reader = new CSVReader(new FileReader(file));
        CsvToBean<User> csvReader = new CsvToBeanBuilder(reader)
                .withType(User.class)
                .withSeparator(',')
                .withIgnoreLeadingWhiteSpace(true)
                .withIgnoreEmptyLine(true)
                .build();

        List<User> users = csvReader.parse();

        users.forEach(System.out::println);*/


/*        File file = new File("./account.csv");
        try {
            // create FileWriter object with file as parameter

            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);

            // adding header to csv
            String[] header = { "name", "class", "marks" };
            writer.writeNext(header);

            // add data to csv
            String[] data1 = { "Aman", "10", "620" };
            writer.writeNext(data1);
            String[] data2 = { "Suraj", "10", "630" };
            writer.writeNext(data2);

            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
    }
}
