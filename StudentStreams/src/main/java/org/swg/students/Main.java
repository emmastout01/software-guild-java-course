package org.swg.students;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        StudentDataStore ds = new StudentDataStore();
        List<Student> students = ds.all();
//        for (Student s : students) {
//            println(s);
//        }

        //TODO: Print students from Argentina
        System.out.println("Students from Argentina: ");
        System.out.println("===============");
        students.stream() 
                .filter(s -> s.getCountry().equals("Argentina"))
                .forEach(Main::println);
    
        System.out.println("");
        
        //TODO: Print students from Argentina, ordered by GPA
        System.out.println("Students from Argentina, ordered by GPA (lowest to highest): ");
        System.out.println("===============");
        students.stream()
                .filter(s -> s.getCountry().equals("Argentina"))
                .sorted((a, b) -> a.getGpa().compareTo(b.getGpa()))
                .forEach(Main::println);
        
        System.out.println("");
        
        //TODO: Print the 4th - 6th ranked students by GPA from Argentina
        System.out.println("4th-6th ranked students by GPA from Argentina: ");
        System.out.println("===============");
        
        students.stream()
                .filter(s -> s.getCountry().equals("Argentina"))
                .sorted((a, b) -> a.getGpa().compareTo(b.getGpa()))
                .skip(3)
                .limit(3)
                .forEach(Main::println);
        
        System.out.println("");
        
        //TODO: Is anyone from Maldives?
        boolean areStudentsFromMaldives = students.stream()
                .anyMatch(p -> p.getCountry().contains("Maldives"));
        
        System.out.println("From Maldives? " + areStudentsFromMaldives);
        System.out.println("===============");
        System.out.println("");
                        
        
        //TODO: Print students who aren't currently registered for a class.
        System.out.println("Students who aren't currently registered for a class: ");
        System.out.println("===============");
        
        students.stream()
                .filter(s -> s.getRegistrations().isEmpty())
                .forEach(Main::println);
      
        
        System.out.println("");
        
        
        //TODO: Print students who are registered for the class "Literary Genres".
        System.out.println("Students who are registered for the class \"Literary Genres\": ");
        System.out.println("===============");
        
        //COME BACK TO THIS ONE
        students.stream()
                .filter(s -> s.getRegistrations().stream()
                       .anyMatch(reg -> reg.getCourse().contains("Literary Genres")))
                .forEach(Main::println);
                        
              
        
        System.out.println("");
        //TODO: Who has the highest GPA?
        System.out.println("Student with highest GPA: ");
        System.out.println("===============");
        
        students.stream()
                .sorted((a, b) -> -a.getGpa().compareTo(b.getGpa()))
                .limit(1)
                .forEach(Main::println);
        
        System.out.println("");
        
        //TODO: Print every class a student is registered for including repeats.
        System.out.println("All classes students are registered for, including repeats: ");
        System.out.println("===============");
        
        
        students.stream()
                .flatMap(s -> s.getRegistrations().stream()
                    .map(reg -> reg.getCourse()))
                    .forEach(System.out::println);
        
                    
        
        System.out.println("");
        //TODO: Print a distinct list of classes students are registered for.
        System.out.println("All classes students are registered for, distinct list: ");
        System.out.println("===============");
        
        students.stream()
                .flatMap(s -> s.getRegistrations().stream()
                    .map(reg -> reg.getCourse()))
                    .distinct()
                    .forEach(System.out::println);
                
        
        System.out.println("");
        //TODO: Print a distinct list of classes students are registered for, ordered by name.
        System.out.println("All classes students are registered for, alphabetically: ");
        System.out.println("===============");
        
         students.stream()
                .flatMap(s -> s.getRegistrations().stream()
                    .map(reg -> reg.getCourse()))
                    .distinct()
                    .sorted((a, b) -> a.substring(0).compareTo(b.substring(0)))
                    .forEach(System.out::println);
        
        System.out.println("");
        
        //TODO: Create a new type, StudentSummary with fields for Country, Major, and IQ.
        //      Map Students to StudentSummary, then filter by IQ (low, high, or whatever seems fun).
        System.out.println("New Student Summaries: ");
        System.out.println("===============");
        
        students.stream()
                .map(s -> new StudentSummary(s))
                .forEach(System.out::println);
              
        
         System.out.println("");
        
        
        //TODO: What is the average GPA per country (remember, it's random fictional data).
          System.out.println("Average GPA by country: ");
        System.out.println("===============");

        Map<String, Double> avgGpaByCountry = students.stream()
                .collect(Collectors.groupingBy(s -> s.getCountry(), 
                        Collectors.averagingDouble(s -> s.getGpa().floatValue())));
                
        System.out.println(avgGpaByCountry);

        
        System.out.println("");
        
        
        //TODO: What is the maximum GPA per country?
          System.out.println("Maximum GPA by country: ");
        System.out.println("===============");
        
        Map<String, Optional<Student>> maxGpaByCountry = students.stream()
                .collect(Collectors.groupingBy(s -> s.getCountry(),
                        Collectors.maxBy((a, b) -> a.getGpa().compareTo(b.getGpa()))));
        
        for (String country : maxGpaByCountry.keySet()) {
            Optional<Student> maxStudent = maxGpaByCountry.get(country);
            
        }
        
        
        
        System.out.println("");
        
        
        //TODO: Print average IQ per Major ordered by IQ ascending.
          System.out.println("Average IQ by major: ");
        System.out.println("===============");
        
        Map<String, Double> avgIqByMajor = students.stream()
                .collect(Collectors.groupingBy(s -> s.getMajor(), 
                        Collectors.averagingDouble(s -> s.getIq())));
       
        Set<String> majors = avgIqByMajor.keySet();
        
        for (String major : majors) {
            System.out.print("Major: " + major + ", ");
            System.out.print("Average IQ: " + avgIqByMajor.get(major));
            System.out.println("");
        }
        
        System.out.println("");
        
    }

    static void println(Student s) {
        System.out.println(s);
    }
    

}
