package Helper;

import Actors.Student;
import Operations.Main;
import java.util.ArrayList;
import java.util.HashMap;

public class RankCalculator {
    static HashMap<String, Student> studentList;

    public RankCalculator() {
        studentList = Main.studentList;
    }

    public void updateRanks(){
        for(String key : Main.curriculumList.keySet()){
            updateRanksOfStudents(key);
        }
    }

    public void updateRanksOfStudents(String department) {
        ArrayList<Student> departmentStudents = new ArrayList<>();
        for (Student student : studentList.values()) {
            if (student.getDepartment().equals(department)) {
                departmentStudents.add(student);
            }
        }

        bubbleSort(departmentStudents);

        for(int i = 0; i<departmentStudents.size(); i++){
            Student x = Main.studentList.get(departmentStudents.get(i).getID());
            x.setRank(departmentStudents.size()-i);
            Main.studentList.put(x.getID(),x);
        }
    }

    static void bubbleSort(ArrayList<Student> studentArrayList) {
        int n = studentArrayList.size();
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (studentArrayList.get(j).getGPA() > studentArrayList.get(j + 1).getGPA()) {
                    Student temp = studentArrayList.get(j);
                    studentArrayList.set(j, studentArrayList.get(j + 1));
                    studentArrayList.set(j + 1, temp);
                }
    }
}
