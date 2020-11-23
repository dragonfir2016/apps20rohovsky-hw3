package ua.edu.ucu;


class Student {

    private double GPA;
    private int year;
    private String name;
    private String surname;

    public Student(String name, String surname, double GPA, int year) {
        this.GPA = GPA;
        this.year = year;
        this.name = name;
        this.surname = surname;
    }

    public double getGPA() {
        return GPA;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Student{name=" + name + ", surname=" + surname + ", " + "GPA="
                + GPA + ", year=" + year + '}';
    }

    @Override
    public boolean equals(Object oTwo) {
        if (!(oTwo instanceof Student)) {
            return false;
        }
        Student other = (Student) oTwo;
        return GPA == other.GPA && year == other.year
                && name.equals(other.name) && surname.equals(other.surname);
    }

    @Override
    public int hashCode() {
        return (int) (this.getYear()*228 + this.getGPA()*1984
                + getName().length());
    }

}
