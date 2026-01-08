package Seventh;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable {

    private static final long serialVersionUID = 7818922415418977129L;

    // Свойства полного доступа
    private String lastName;     // фамилия
    private String firstName;    // имя
    private String middleName;   // отчество
    private int recordBookNumber; // номер зачетки

    //индексированные свойства полного доступа
    private List<Integer> grades = new ArrayList<>();

    public Student() {
    }

    public String getLastName(){
        return lastName;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getMiddleName(){
        return middleName;
    }

    public int getRecordBookNumber(){
        return recordBookNumber;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName){
        this.middleName = middleName;
    }

    public void setRecordBookNumber(int recordBookNumber){
        this.recordBookNumber = recordBookNumber;
    }

    public int getGrade(int index) {
        if (index < 0 || index >= grades.size()) {
            throw new IndexOutOfBoundsException("Индекс оценки вне диапазона: " + index);
        }
        return grades.get(index);
    }

    // Установка оценки по индексу
    public void setGrade(int index, int grade) {
        if (index < 0 || index >= grades.size()) {
            throw new IndexOutOfBoundsException("Индекс оценки вне диапазона: " + index);
        }
        grades.set(index, grade);
    }

    // Получение всех оценок
    public List<Integer> getGrades() {
        return new ArrayList<>(grades); // Возвращаем копию для защиты инкапсуляции
    }

    // Добавление новой оценки
    public void addGrade(int grade) {
        grades.add(grade);
    }

    // Удаление оценки по индексу
    public void removeGrade(int index) {
        if (index < 0 || index >= grades.size()) {
            throw new IndexOutOfBoundsException("Индекс оценки вне диапазона: " + index);
        }
        grades.remove(index);
    }

    public void setGrades(List<Integer> grades) {
        this.grades = grades != null ? new ArrayList<>(grades) : new ArrayList<>();
    }

    // Полное имя студента
    public String getFullName() {
        return lastName + " " + firstName + " " + middleName;
    }

    // Средний балл
    public double getAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    @Override
    public String toString() {
        return "Student{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", recordBookNumber=" + recordBookNumber +
                ", grades=" + grades +
                ", averageGrade=" + String.format("%.2f", getAverageGrade()) +
                '}';
    }

    // Пример equals и hashCode (необязательно, но правильно для JavaBean)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (!lastName.equals(student.lastName)) return false;
        if (!firstName.equals(student.firstName)) return false;
        if (!middleName.equals(student.middleName)) return false;
        return recordBookNumber == student.recordBookNumber;
    }

    @Override
    public int hashCode() {
        int result = lastName.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + middleName.hashCode();
        result = 31 * result + Integer.hashCode(recordBookNumber);
        return result;
    }
}
