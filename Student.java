import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;

class Student {
    String studentName;
    int courseDuration;
    String[] startDate;
    HashMap<String, Integer> disciplines;
    String curriculum;

    Student(String studentName, String[] startDate, String curriculum, HashMap<String, Integer> disciplines) {
        this.studentName = studentName;
        this.startDate = startDate;
        this.curriculum = curriculum;
        this.disciplines = disciplines;
        for (String key : disciplines.keySet()) {
            this.courseDuration += disciplines.get(key);
        }
    }


    LocalDate getStartDate() {
        return LocalDate.of(Integer.parseInt(startDate[0]), Integer.parseInt(startDate[1]), Integer.parseInt(startDate[2]));
    }

    LocalDate getEndDate() {
        return LocalDate.now();
    }

    public static void makeReport(Student st, boolean isShort) {
        int numOfHours = st.courseDuration % 8;
        int totalNumOfDays = st.courseDuration / 8;
        String message = "Training is not started yet.";

        LocalDate startDate = st.getStartDate();
        LocalDate endDate = st.getEndDate();
        int workdays = st.getWorkdays();


        if (endDate.isBefore(startDate)) {
            if (isShort) {
                System.out.println(message);
            } else {
                System.out.println(
                    st.prepareFullReportMsg(st, message)
                );
            }
        } else {

            if (totalNumOfDays > workdays) {
                message = "Training is not finished. " + (totalNumOfDays - workdays) + " d and " + numOfHours + " hour(s) are left until the end.";
                if (isShort) {
                    System.out.println(message);
                } else {
                    System.out.println(
                            st.prepareFullReportMsg(st, message)
                    );
                }
            } else {
                if (numOfHours != 0) {
                    message = "Training completed. " + (workdays - totalNumOfDays - 1) + "d, " + (8 - numOfHours) + " hour(s) have passed since the end.";
                    if (isShort) {
                        System.out.println(message);
                    } else {
                        System.out.println(
                                st.prepareFullReportMsg(st, message)
                        );
                    }
                } else {
                    message = "Training completed. " + (workdays - totalNumOfDays) + "d have passed since the end.";
                    if (isShort) {
                        System.out.println("3if" + message);
                    } else {
                        System.out.println(
                                st.prepareFullReportMsg(st, message)
                        );
                    }
                }
            }

        }
    }

    private int getWorkdays() {

        LocalDate startDate = this.getStartDate();
        LocalDate endDate = LocalDate.now();
        int workdays = 0;

        while (!startDate.isAfter(endDate)) {
            if (startDate.getDayOfWeek() != DayOfWeek.SATURDAY && startDate.getDayOfWeek() != DayOfWeek.SUNDAY) {
                workdays++;
            }
            startDate = startDate.plusDays(1);
        }
        return workdays;
    }

    private String prepareFullReportMsg(Student st, String message){
        return "Student name: " + st.studentName
                + "\nWorking time (from 10 to 18)"
                + "\nProgram name: " + st.curriculum
                + "\nProgram duration (hours): " + st.courseDuration
                + "\nStart date: " + st.getStartDate()
                + "\nEnd date: " + st.getEndDate()
                + "\n" + message;
    }
}
